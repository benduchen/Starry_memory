package com.bendu.starry.client;

import com.bendu.starry.StarryMod;
import net.minecraft.resources.ResourceLocation;

public enum NarratorLine {
    MEMORANDUM_FIRST_EQUIP(0, "memorandum_first_equip", "starry_narrator_equip");

    public static final NarratorLine[] BY_ID = values();

    public final int id;
    public final String soundKey;
    public final String persistentTag;

    NarratorLine(int id, String soundKey, String persistentTag) {
        this.id = id;
        this.soundKey = soundKey;
        this.persistentTag = persistentTag;
    }

    public ResourceLocation getSoundLocation() {
        return ResourceLocation.parse(StarryMod.MOD_ID + ":narrator." + soundKey);
    }

    public String getSubtitleKey() {
        return "subtitles.starry_mod.narrator." + soundKey;
    }

    public static NarratorLine byId(int id) {
        return id >= 0 && id < BY_ID.length ? BY_ID[id] : null;
    }
}