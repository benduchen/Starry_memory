package com.bendu.starry.datagen;

import com.bendu.starry.StarryMod;
import com.bendu.starry.block.ModBlocks;
import com.bendu.starry.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsLangProvider extends LanguageProvider {
    public ModEnUsLangProvider(PackOutput output) {
        super(output, StarryMod.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.GOLDEN_TEAR_CRYSTAL.get(), "Golden Tears");
        add(ModItems.MEMORANDUM.get(), "Memorandum");
        add(ModItems.ORIGINAL_STAR_INGOT.get(), "Original Star Ingot");
        add(ModItems.SHATTERED_STAR_CRYSTAL.get(), "Shattered Star Crystal");
        add(ModItems.WAIT.get(), "Wait");
        add(ModItems.RAW_ORIGINAL_STAR.get(), "Raw Original Star");
        add(ModItems.CLOUD_LYCHEE.get(),  "Cloud Lychee");
        add(ModItems.HELP.get(), "Help");
        add(ModItems.PERSEVERANCE.get(), "Perseverance");
        add(ModItems.HALF_STAR_SWORD.get(), "Half-Star Sword");

        add(ModBlocks.ORIGINAL_STAR_ORE.get(),  "Original Star Ore");

        add("itemGroup.starry_material", "Starry Material");
        add("itemGroup.starry_blocks",  "Starry Blocks");
        add("itemGroup.starry_curios", "Starry Curios");

        add("curios.identifier.stellar_tome", "Stellar Tome");
        add("curios.identifier.memory_fragment", "Memory Fragment");

                // golden_tear_crystal
        add("tooltip.starry_mod.golden_tear_crystal.shift_hint", "Hold ");
        add("tooltip.starry_mod.golden_tear_crystal.shift_suffix", " to view story");
        add("tooltip.starry_mod.golden_tear_crystal.desc.1", "“Crying won’t solve anything. But after crying, you can sort out your emotions. Occasionally.”");
        add("tooltip.starry_mod.golden_tear_crystal.story.1", "I’m a pessimist. If things are too calm, I suspect I’m trading today’s peace for some future tragedy. If things are too painful, I imagine the breaking point just ahead. But pessimism has its perks—at least I’m never surprised by a bad ending. I take it as normal, feeling that stories are supposed to end badly.");
        add("tooltip.starry_mod.golden_tear_crystal.story.2", "I admit it—it was the light that was too bright that made me cry, not the conversation with you. How long does it take to forget someone? If they weren’t that important, you’d forget quickly. But they are—they used to be a part of you.");

        // original_star_ingot
        add("tooltip.starry_mod.original_star_ingot.shift_hint", "Hold ");
        add("tooltip.starry_mod.original_star_ingot.shift_suffix", " to view story");
        add("tooltip.starry_mod.original_star_ingot.desc.1", "“It looks like the sea...”");
        add("tooltip.starry_mod.original_star_ingot.desc.2", "“But it’s clearly the color of the sky.”");
        add("tooltip.starry_mod.original_star_ingot.story.1", "The evening sky darkens inch by inch, from azure to deep blue, then to purple-gray. But the ingot’s blue never changes.");

        // raw_original_star
        add("tooltip.starry_mod.raw_original_star.shift_hint", "Hold ");
        add("tooltip.starry_mod.raw_original_star.shift_suffix", " to view story");
        add("tooltip.starry_mod.raw_original_star.desc.1", "“Wrapped in a rough blue crust, gold gleams within the ore—that’s right!”");
        add("tooltip.starry_mod.raw_original_star.story.1", "I don't know where this came from, but its flickering light does not belong to this world.");

        // cloud_lychee
        add("tooltip.starry_mod.cloud_lychee.shift_hint", "Hold ");
        add("tooltip.starry_mod.cloud_lychee.shift_suffix", " to view story");
        add("tooltip.starry_mod.cloud_lychee.desc.1", "“To be honest, it looks like a lychee and tastes cool. But my friend says it’s like eating a cloud.”");
        add("tooltip.starry_mod.cloud_lychee.effect", "Grants Regeneration II for 5 seconds");
        add("tooltip.starry_mod.cloud_lychee.story.1", "I wanted to save it—couldn’t bring myself to eat it. Left it too long. It floated away. Ahh...");
        add("tooltip.starry_mod.cloud_lychee.story.2", "“Can you eat clouds?”");

                // half_star_sword effect
        add("tooltip.starry_mod.half_star_sword.effect.bonus", "Stellar Bonus ");
        add("tooltip.starry_mod.half_star_sword.effect.suffix", " Attack Damage");

// half_star_sword
        add("tooltip.starry_mod.half_star_sword.shift_hint", "Hold ");
        add("tooltip.starry_mod.half_star_sword.shift_suffix", " to view story");
        add("tooltip.starry_mod.half_star_sword.desc.1", "Don\u2019t rely too much on the sword in your hand, and forget where its power comes from\u2014");
        add("tooltip.starry_mod.half_star_sword.story.1", "A swordsman\u2019s story is written by themselves.");

// Shattered Star Crystal tooltip
        add("tooltip.starry_mod.shattered_star_crystal.desc.1", "\"Do you still remember that rainy evening?\"");
        add("tooltip.starry_mod.shattered_star_crystal.desc.2", "\"I do. You pressed me against the window to peek outside. Your breath fogged up my face.\"");
        add("tooltip.starry_mod.shattered_star_crystal.story.1", "Three years.");
        add("tooltip.starry_mod.shattered_star_crystal.story.2", "You kept her the closest to your chest \u2014 afraid she\u2019d break, afraid she\u2019d catch cold, afraid someone would touch her.");
        add("tooltip.starry_mod.shattered_star_crystal.story.3", "You even learned to hold things with your left hand, just so your right would always be free \u2014 in case she ever needed something.");
        add("tooltip.starry_mod.shattered_star_crystal.story.4", "But she never needed you. Not because she was cold \u2014 she just never knew someone had been holding her all along.");
        add("tooltip.starry_mod.shattered_star_crystal.story.5", "In the end, you didn\u2019t drop her, and nobody took her away.");
        add("tooltip.starry_mod.shattered_star_crystal.story.6", "You just let go. Because you\u2019d held on for too long.");
        add("tooltip.starry_mod.shattered_star_crystal.story.7", "Your palms grew calluses, your bones ached, even your heartbeat had slowed a beat.");
        add("tooltip.starry_mod.shattered_star_crystal.story.8", "She never knew she was made of glass.");
        add("tooltip.starry_mod.shattered_star_crystal.story.9", "She thought she was just walking, talking, laughing like everyone else.");
        add("tooltip.starry_mod.shattered_star_crystal.story.10", "Only you knew \u2014 for three years, you never dared to hold tight.");
        add("tooltip.starry_mod.shattered_star_crystal.story.11", "Afraid you\u2019d hurt her. Afraid that if you held too tight, she would shatter.");
        add("tooltip.starry_mod.shattered_star_crystal.story.12", "In the end, it was you who broke.");
        add("tooltip.starry_mod.shattered_star_crystal.story.13", "Shattered into countless pieces, every single one reflecting her profile.");
        add("tooltip.starry_mod.shattered_star_crystal.shift_hint", "Hold ");
        add("tooltip.starry_mod.shattered_star_crystal.shift_suffix", " to view story");

        // Memorandum tooltip
        add("tooltip.starry_mod.memorandum.stellar_value", "Stellar Value: ");
        add("tooltip.starry_mod.memorandum.desc.1", "\u201cThe cover is blank.\u201d");
        add("tooltip.starry_mod.memorandum.desc.2", "\u201cInside, too.\u201d");
        add("tooltip.starry_mod.memorandum.desc.3", "\u201cWhen will someone write the first line?\u201d");
        add("tooltip.starry_mod.memorandum.shift_hint", "Hold ");
        add("tooltip.starry_mod.memorandum.shift_suffix", " to view story");
        add("tooltip.starry_mod.memorandum.story.1", "I don\u2019t remember being written.");
        add("tooltip.starry_mod.memorandum.story.2", "Every page is white. Turn it, still white.");
        add("tooltip.starry_mod.memorandum.story.3", "Wind passes through the spine, making a thin sound \u2014 as if asking: What are you doing here?");
        add("tooltip.starry_mod.memorandum.story.4", "I don\u2019t know.");
        add("tooltip.starry_mod.memorandum.story.5", "Maybe I\u2019m waiting for someone to open me.");
        add("tooltip.starry_mod.memorandum.info.share", "Other Life Fragments will share the current Stellar Value");
        add("tooltip.starry_mod.memorandum.info.max_value", "Current max Stellar Value: 100");
        add("tooltip.starry_mod.memorandum.info.fragment_slots", "Unlocks 6 Memory Fragment slots when equipped");

        // Wait & Help shift hint
        add("tooltip.starry_mod.wait.shift_hint", "Hold ");
        add("tooltip.starry_mod.wait.shift_suffix", " to view story");
        add("tooltip.starry_mod.help.shift_hint", "Hold ");
        add("tooltip.starry_mod.help.shift_suffix", " to view story");

        // Wait tooltip
        add("tooltip.starry_mod.wait.shared_value_prefix", "Shared Stellar Value: ");
        add("tooltip.starry_mod.wait.desc.1", "\u201cDon\u2019t wait. Be brave and step out.\u201d");
        add("tooltip.starry_mod.wait.separator", "\u00a77\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        add("tooltip.starry_mod.wait.desc.2", "This return to an old place is not because I miss you. It\u2019s to bring back the \u201cme\u201d I used to be.");
        add("tooltip.starry_mod.wait.story.1", "This return to an old place is not because I miss you.");
        add("tooltip.starry_mod.wait.story.2", "I asked myself over and over: am I warming myself with memories again? Standing here now, the wind still blows from the same direction \u2014 and I know for certain. It\u2019s not for you.");
        add("tooltip.starry_mod.wait.story.3", "I\u2019ve come to bring back the \u201cme\u201d I used to be.");
        add("tooltip.starry_mod.wait.story.4", "The person who would stop for a cloud, who believed tomorrow was worth waiting for and could close their eyes in peace \u2014 he\u2019s been stuck on this road all along. Not because he got lost. Because I chose not to look back.");
        add("tooltip.starry_mod.wait.story.5", "Today I\u2019ve come for him. I crouch under the old tree, press my hand into the bark, and tell him I\u2019m sorry for making him wait so long. I\u2019m not here to miss anyone. I\u2019m here to take him home.");
        add("tooltip.starry_mod.wait.story.6", "The noodle shop changed its sign, but the vinegar tastes the same. When I stand up after eating, I hear a soft click in my bones \u2014 something has fallen back into place.");
        add("tooltip.starry_mod.wait.story.7", "This trip has nothing to do with you. I\u2019ve simply walked out from the rubble, leading that child who dared to laugh, dared to lose sleep, dared to hope for tomorrow.");
        add("tooltip.starry_mod.wait.story.8", "He takes my hand and says: let\u2019s go home. I say yes. This time, I\u2019ll never leave him behind again.");
        add("tooltip.starry_mod.wait.effect.speed_prefix", "Movement Speed ");
        add("tooltip.starry_mod.wait.effect.kb_prefix", "  Knockback Resistance ");

        // Help tooltip
        add("tooltip.starry_mod.help.shared_value_prefix", "Shared Stellar Value: ");
        add("tooltip.starry_mod.help.desc.1", "\u201cTime is a circle.\u201d");
        add("tooltip.starry_mod.help.desc.2", "Mutual aid is simply the same soul reaching out from two coordinates at once.");
        add("tooltip.starry_mod.help.story.1", "It rained all night. I lay in the puddle at the mouth of the alley, half my body numb with cold. Occasionally someone passed by, glanced at me, slowed their pace, then hurried away. I understood \u2014 late night, rain, a person curled on the ground. No one wants trouble.");
        add("tooltip.starry_mod.help.story.2", "Until a dark gray umbrella covered me from above. The young man under it crouched down, hooked his hands under my arms, and dragged me from the water to the dry spot by the wall. His coat was soaked through, cold against my face. When he was done, he stood up, turned, and walked back into the rain. The umbrella stayed in my hand.");
        add("tooltip.starry_mod.help.story.3", "I got up. By the streetlight I saw two words carved into the handle \u2014 \u201cDon\u2019t thank me.\u201d Below it, another line: \u201cIt\u2019s you.\u201d");
        add("tooltip.starry_mod.help.effect.desc_prefix", "At night or in rain, if health is below 30%, gain ");
        add("tooltip.starry_mod.help.effect.desc_suffix", " and clear negative effects. Next heal/buff also affects nearby allies");
        add("tooltip.starry_mod.help.effect.absorption", "Absorption");
        add("tooltip.starry_mod.help.effect.cooldown", "Cooldown 120 seconds");
        add("tooltip.starry_mod.help.separator", "§7─────────────────────");

        // Perseverance tooltip
        add("tooltip.starry_mod.perseverance.shared_value_prefix", "Shared Stellar Value: ");
        add("tooltip.starry_mod.perseverance.shift_hint", "Hold ");
        add("tooltip.starry_mod.perseverance.shift_suffix", " to view story");
        add("tooltip.starry_mod.perseverance.desc.1", "“If things don’t go your way, does perseverance still mean anything?”");
        add("tooltip.starry_mod.perseverance.separator", "§7─────────────────────");
        add("tooltip.starry_mod.perseverance.desc.2", "If the ending doesn’t satisfy you, then it’s not the ending yet.");
        add("tooltip.starry_mod.perseverance.story.1", "“So, my answer is: if things don’t go your way, first stop and ask yourself—are you “stubbornly” banging your head against a wall, or “resiliently” exploring? If the former, changing direction isn’t giving up—it’s wisdom. If the latter, please keep going.”");
        add("tooltip.starry_mod.perseverance.story.2", "“Truly brave men dare to face the bleakness of life, and dare to look directly at the streaming blood. What grievous mourners and happy ones they are! Yet the Creator oft designs for the mediocre, to wash away old traces with the passage of time, leaving only pale red bloodstains and faint sorrow. In this pale red blood and faint sorrow, people steal a moment’s respite, sustaining this world that is human yet inhuman. I know not when such a world will come to an end!” ——In Memory of Liu Hezhen");
        add("tooltip.starry_mod.perseverance.effect.low_prefix", "When Shared Stellar Value is below 100, gain ");
        add("tooltip.starry_mod.perseverance.effect.high_prefix", "When Shared Stellar Value is above 100, gain ");
        add("tooltip.starry_mod.perseverance.effect.suffix", "% max health");
        // Narrator subtitles
        add("subtitles.starry_mod.narrator.memorandum_first_equip", "Test text 1. Triggered on first equipping the Memorandum.");

    }
}