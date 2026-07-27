package com.bendu.starry.event;

import com.bendu.starry.StarryMod;
import com.bendu.starry.item.ModItems;
import com.bendu.starry.item.custom.HelpItem;
import com.bendu.starry.item.custom.MemorandumItem;
import com.bendu.starry.item.custom.WaitItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.event.CurioChangeEvent;
import com.bendu.starry.client.NarratorLine;
import com.bendu.starry.network.StarryNetwork;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import java.util.UUID;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.event.RegisterCommandsEvent;

@Mod.EventBusSubscriber(modid = StarryMod.MOD_ID)
public class ModCurioEvents {
    private static final UUID SPEED_MODIFIER_UUID = UUID.fromString("b2c3d4e5-f6a7-8901-bcde-f12345678901");
    private static final UUID KB_MODIFIER_UUID = UUID.fromString("a1b2c3d4-e5f6-7890-abcd-ef1234567890");
    private static final UUID HEALTH_MODIFIER_UUID = UUID.fromString("c1d2e3f4-5678-90ab-cdef-123456789abc");
    private static final UUID CHOICE_ATTACK_UUID = UUID.fromString("f0e1d2c3-b4a5-6789-0abc-def123456789");
    private static final java.util.UUID FRAGMENT_SLOT_UUID = java.util.UUID.fromString("e1d2c3b4-5678-90ab-cdef-123456789abc");

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        Player player = event.player;
        if (player.level().isClientSide) return;
        if (player.tickCount % 20 != 0) return;
        CuriosApi.getCuriosInventory(player).ifPresent(handler -> {
            // ===== Memo Stellar =====
            handler.findFirstCurio(ModItems.MEMORANDUM.get()).ifPresent(slotResult -> {
                ItemStack stack = slotResult.stack();
                if (stack.isEmpty()) return;
                int current = MemorandumItem.getStellarValue(stack);
                int autoMax = MemorandumItem.getMaxCap(stack);
                boolean hasChoice = handler.findFirstCurio(ModItems.CHOICE.get()).isPresent();
                if (hasChoice) {
                    int choiceShared = com.bendu.starry.item.custom.ChoiceItem.getSharedValue(player);
                    if (choiceShared > 100) autoMax = Math.max(autoMax, 200);
                }
                if (current <= 0) {
                    MemorandumItem.setStellarValue(stack, autoMax);
                } else if (current < autoMax) {
                    MemorandumItem.setStellarValue(stack, current + 1);
                }
                handler.getStacksHandler(slotResult.slotContext().identifier())
                    .ifPresent(sh -> sh.getStacks().setStackInSlot(slotResult.slotContext().index(), stack));
                if (player.tickCount > 100) {
                    if (!player.getPersistentData().contains("starry_last_trigger_x")) {
                        player.getPersistentData().putDouble("starry_last_trigger_x", player.getX());
                        player.getPersistentData().putDouble("starry_last_trigger_z", player.getZ());
                    } else {
                        double lastX = player.getPersistentData().getDouble("starry_last_trigger_x");
                        double lastZ = player.getPersistentData().getDouble("starry_last_trigger_z");
                        double dx = player.getX() - lastX;
                        double dz = player.getZ() - lastZ;
                        if (dx * dx + dz * dz >= 4.0) {
                            StarryNetwork.sendNarratorTo((net.minecraft.server.level.ServerPlayer) player, NarratorLine.MEMORANDUM_FIRST_EQUIP, 40);
                            player.getPersistentData().putDouble("starry_last_trigger_x", player.getX());
                            player.getPersistentData().putDouble("starry_last_trigger_z", player.getZ());
                        }
                    }
                }
            });
            // ===== Help Effect =====
            boolean hasHelp = handler.findFirstCurio(ModItems.HELP.get()).isPresent();
            if (hasHelp) {
                int shared = HelpItem.getSharedValue(player);
                if (shared > 0) {
                    long gameTime = player.level().getGameTime();
                    long lastUse = player.getPersistentData().getLong("starry_help_cooldown");
                    if (gameTime - lastUse >= 120 * 20) {
                        boolean isNight = player.level().isNight();
                        boolean isRaining = player.level().isRaining();
                        boolean lowHealth = player.getHealth() / player.getMaxHealth() < 0.3f;
                        if ((isNight || isRaining) && lowHealth) {
                            double ratio = Math.min(shared, 100) / 100.0;
                            player.getActiveEffects().stream()
                                .filter(e -> !e.getEffect().isBeneficial())
                                .toList()
                                .forEach(e -> player.removeEffect(e.getEffect()));
                            int absorptionHealth = (int) (player.getMaxHealth() * 0.4 * ratio);
                            int amp = Math.max(0, absorptionHealth / 4 - 1);
                            player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200, amp, false, true, true));
                            player.getPersistentData().putBoolean("starry_help_next_shared", true);
                            player.getPersistentData().putLong("starry_help_cooldown", gameTime);
                        }
                    }
                }
            }
            // ===== Wait Effect =====
            boolean hasWait = handler.findFirstCurio(ModItems.WAIT.get()).isPresent();
            if (hasWait) {
                int shared = WaitItem.getSharedValue(player);
                if (shared > 0) {
                    double ratio = Math.min(shared, 100) / 100.0;
                    double speedMult = 0.2 * ratio;
                    var speedAttr = player.getAttribute(Attributes.MOVEMENT_SPEED);
                    if (speedAttr != null) {
                        speedAttr.removeModifier(SPEED_MODIFIER_UUID);
                        speedAttr.addTransientModifier(
                            new AttributeModifier(SPEED_MODIFIER_UUID, "stellar_speed", speedMult, AttributeModifier.Operation.MULTIPLY_TOTAL));
                    }
                    double kbResist = 0.3 * ratio;
                    var kbAttr = player.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
                    if (kbAttr != null) {
                        kbAttr.removeModifier(KB_MODIFIER_UUID);
                        kbAttr.addTransientModifier(
                            new AttributeModifier(KB_MODIFIER_UUID, "stellar_kb_resist", kbResist, AttributeModifier.Operation.ADDITION));
                    }
                }
            } else {
                var speedAttr = player.getAttribute(Attributes.MOVEMENT_SPEED);
                if (speedAttr != null) speedAttr.removeModifier(SPEED_MODIFIER_UUID);
                var kbAttr = player.getAttribute(Attributes.KNOCKBACK_RESISTANCE);
                if (kbAttr != null) kbAttr.removeModifier(KB_MODIFIER_UUID);
            }
            // ===== Perseverance Effect =====
            boolean hasPerseverance = handler.findFirstCurio(ModItems.PERSEVERANCE.get()).isPresent();
            if (hasPerseverance) {
                int shared = com.bendu.starry.item.custom.PerseveranceItem.getSharedValue(player);
                if (shared > 0) {
                    double bonusPct;
                    if (shared < 100) {
                        bonusPct = 100 - shared;
                    } else {
                        bonusPct = shared - 100;
                    }
                    double bonus = bonusPct / 100.0;
                    var healthAttr = player.getAttribute(Attributes.MAX_HEALTH);
                    if (healthAttr != null) {
                        healthAttr.removeModifier(HEALTH_MODIFIER_UUID);
                        if (bonus > 0) {
                            healthAttr.addTransientModifier(
                                new net.minecraft.world.entity.ai.attributes.AttributeModifier(
                                    HEALTH_MODIFIER_UUID, "stellar_health", bonus, net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.MULTIPLY_BASE));
                        }
                    }
                }
            } else {
                var healthAttr = player.getAttribute(Attributes.MAX_HEALTH);
                if (healthAttr != null) healthAttr.removeModifier(HEALTH_MODIFIER_UUID);
            }
            // ===== Choice Effect =====
            boolean hasChoice = handler.findFirstCurio(ModItems.CHOICE.get()).isPresent();
            if (hasChoice) {
                int choiceShared = com.bendu.starry.item.custom.ChoiceItem.getSharedValue(player);
                if (choiceShared > 0 && choiceShared < 100) {
                    double bonusPct = 0.2 + (choiceShared / 100.0) * 0.2;
                    var atkAttr = player.getAttribute(Attributes.ATTACK_DAMAGE);
                    if (atkAttr != null) {
                        atkAttr.removeModifier(CHOICE_ATTACK_UUID);
                        atkAttr.addTransientModifier(
                            new AttributeModifier(CHOICE_ATTACK_UUID, "choice_attack", bonusPct, AttributeModifier.Operation.MULTIPLY_TOTAL));
                    }
                }
            } else {
                var atkAttr = player.getAttribute(Attributes.ATTACK_DAMAGE);
                if (atkAttr != null) atkAttr.removeModifier(CHOICE_ATTACK_UUID);
            }
        });
    }

    @SubscribeEvent
    public static void onHeal(LivingHealEvent event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.getPersistentData().getBoolean("starry_help_next_shared")) return;
        float amount = event.getAmount();
        player.level().getEntitiesOfClass(Player.class, player.getBoundingBox().inflate(10))
            .forEach(p -> {
                if (p != player) {
                    p.heal(amount);
                }
            });
    }

    @SubscribeEvent
    public static void onMobEffect(MobEffectEvent.Added event) {
        if (!(event.getEntity() instanceof Player player)) return;
        if (!player.getPersistentData().getBoolean("starry_help_next_shared")) return;
        MobEffectInstance instance = event.getEffectInstance();
        if (instance == null || !instance.getEffect().isBeneficial()) return;
        player.level().getEntitiesOfClass(Player.class, player.getBoundingBox().inflate(10))
            .forEach(p -> {
                if (p != player) {
                    p.addEffect(new MobEffectInstance(
                        instance.getEffect(), instance.getDuration(),
                        instance.getAmplifier(), instance.isAmbient(),
                        instance.isVisible(), instance.showIcon()));
                }
            });
    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        event.getDispatcher().register(Commands.literal("starry")
            .requires(source -> source.hasPermission(2))
            .then(Commands.literal("memorandum")
                .then(Commands.argument("value", IntegerArgumentType.integer(0, 100))
                    .executes(ctx -> {
                        CommandSourceStack source = ctx.getSource();
                        int value = IntegerArgumentType.getInteger(ctx, "value");
                        CuriosApi.getCuriosInventory(source.getPlayerOrException()).resolve().ifPresent(handler -> {
                            handler.findFirstCurio(ModItems.MEMORANDUM.get()).ifPresentOrElse(
                                slot -> {
                                    MemorandumItem.setStellarValue(slot.stack(), value);
                                    source.sendSuccess(() -> Component.literal("\u00a7aStellar value set to " + value), true);
                                },
                                () -> { source.sendFailure(Component.literal("\u00a7cNo memorandum found in curios")); }
                            );
                        });
                        return 1;
                    })
                )
                .then(Commands.literal("ultra")
                    .then(Commands.argument("value", IntegerArgumentType.integer(0, 520299))
                        .executes(ctx -> {
                            CommandSourceStack source = ctx.getSource();
                            int value = IntegerArgumentType.getInteger(ctx, "value");
                            CuriosApi.getCuriosInventory(source.getPlayerOrException()).resolve().ifPresent(handler -> {
                                handler.findFirstCurio(ModItems.MEMORANDUM.get()).ifPresentOrElse(
                                    slot -> {
                                        MemorandumItem.setStellarValue(slot.stack(), value);
                                        MemorandumItem.setMaxCap(slot.stack(), value);
                                        source.sendSuccess(() -> Component.literal("\u00a7aStellar value set to " + value + " (ultra)"), true);
                                    },
                                    () -> { source.sendFailure(Component.literal("\u00a7cNo memorandum found in curios")); }
                                );
                            });
                            return 1;
                        })
                    )
                )
            )
        );
    }

    @SubscribeEvent
    public static void onCurioChange(CurioChangeEvent event) {
        if (!(event.getEntity() instanceof net.minecraft.server.level.ServerPlayer player)) return;
        net.minecraft.world.item.ItemStack to = event.getTo();
        net.minecraft.world.item.ItemStack from = event.getFrom();
        if (to.getItem() == ModItems.MEMORANDUM.get() && from.isEmpty()) {
            top.theillusivec4.curios.api.CuriosApi.getCuriosInventory(player).ifPresent(inv -> {
                inv.addPermanentSlotModifier("memory_fragment", FRAGMENT_SLOT_UUID, "memorandum_slots", 6, net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.ADDITION);
            });
            player.getPersistentData().putDouble("starry_last_trigger_x", player.getX());
            player.getPersistentData().putDouble("starry_last_trigger_z", player.getZ());
            if (player.getPersistentData().contains("starry_narrator_equip")) return;
            player.getPersistentData().putBoolean("starry_narrator_equip", true);
            if (player.tickCount > 100) {
                StarryNetwork.sendNarratorTo(player, NarratorLine.MEMORANDUM_FIRST_EQUIP, 40);
            }
        } else if (from.getItem() == ModItems.MEMORANDUM.get() && to.isEmpty()) {
            top.theillusivec4.curios.api.CuriosApi.getCuriosInventory(player).ifPresent(inv -> {
                inv.removeSlotModifier("memory_fragment", FRAGMENT_SLOT_UUID);
            });
        }
    }
}

