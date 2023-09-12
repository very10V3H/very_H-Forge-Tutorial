package com.Toturial.toturial.ModNetwork.Packets;

import com.Toturial.toturial.ModNetwork.ModNetworking;
import com.Toturial.toturial.Utils;
import net.minecraft.Util;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UtilsC2SPacket {
    public UtilsC2SPacket()
    {

    }
    public UtilsC2SPacket(FriendlyByteBuf buf)
    {

    }

    public void toBytes(FriendlyByteBuf buf)
    {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork( ()->{
            ServerPlayer serverPlayer = context.getSender();
            Utils.Num ++;
            ModNetworking.sendToClient(new UtilsS2CPacket(Utils.Num),serverPlayer);
        });
        return true;
    }
}
