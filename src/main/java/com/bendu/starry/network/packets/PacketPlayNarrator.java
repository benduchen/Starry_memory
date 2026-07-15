package com.bendu.starry.network.packets;

import com.bendu.starry.client.NarratorLine;
import com.bendu.starry.client.NarratorClientHandler;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import java.util.function.Supplier;

public class PacketPlayNarrator {
    private final int lineId;
    private final int delayTicks;

    public PacketPlayNarrator(int lineId, int delayTicks) {
        this.lineId = lineId;
        this.delayTicks = delayTicks;
    }

    public int getLineId() { return lineId; }
    public int getDelayTicks() { return delayTicks; }

    public static void encode(PacketPlayNarrator msg, FriendlyByteBuf buf) {
        buf.writeInt(msg.lineId);
        buf.writeInt(msg.delayTicks);
    }

    public static PacketPlayNarrator decode(FriendlyByteBuf buf) {
        return new PacketPlayNarrator(buf.readInt(), buf.readInt());
    }

    public static void handle(PacketPlayNarrator msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            NarratorLine line = NarratorLine.byId(msg.lineId);
            if (line != null) {
                NarratorClientHandler.scheduleNarrator(line, msg.delayTicks);
            }
        });
        ctx.get().setPacketHandled(true);
    }
}