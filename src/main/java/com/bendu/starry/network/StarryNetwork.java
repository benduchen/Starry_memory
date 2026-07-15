package com.bendu.starry.network;

import com.bendu.starry.StarryMod;
import com.bendu.starry.client.NarratorLine;
import com.bendu.starry.network.packets.PacketPlayNarrator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class StarryNetwork {
    private static final String PROTOCOL_VERSION = "1";
    private static int packetId = 0;

    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
        ResourceLocation.parse(StarryMod.MOD_ID + ":main"),
        () -> PROTOCOL_VERSION,
        PROTOCOL_VERSION::equals,
        PROTOCOL_VERSION::equals
    );

    public static void init() {
        CHANNEL.registerMessage(packetId++, PacketPlayNarrator.class,
            PacketPlayNarrator::encode, PacketPlayNarrator::decode, PacketPlayNarrator::handle);
    }

    public static void sendNarratorTo(ServerPlayer player, NarratorLine line, int delayTicks) {
        CHANNEL.send(PacketDistributor.PLAYER.with(() -> player),
            new PacketPlayNarrator(line.id, delayTicks));
    }
}