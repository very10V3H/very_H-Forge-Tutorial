package com.Toturial.toturial.ModNetwork.Packets;

import com.Toturial.toturial.Utils;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class UtilsS2CPacket {
    private final int Num;
    public UtilsS2CPacket(int num)
    {
        Num = num;
    }
    public UtilsS2CPacket(FriendlyByteBuf buf)
    {
        Num = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf)
    {
        buf.writeInt(Num);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier)
    {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork( ()->{
            Utils.Num = Num;
        });
        return true;
    }
}
