package com.Toturial.toturial.ModNetwork;

import com.Toturial.toturial.ModNetwork.Packets.UtilsC2SPacket;
import com.Toturial.toturial.ModNetwork.Packets.UtilsS2CPacket;
import com.Toturial.toturial.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModNetworking {
    private static SimpleChannel INSTANCE;
    private static int packetID = 0;
    private static int id()
    {
        return packetID++;
    }
    public static void register()
    {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(new ResourceLocation(Utils.MOD_ID,"messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(UtilsC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(UtilsC2SPacket::new)
                .encoder(UtilsC2SPacket::toBytes)
                .consumerMainThread(UtilsC2SPacket::handle)
                .add();

        net.messageBuilder(UtilsS2CPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(UtilsS2CPacket::new)
                .encoder(UtilsS2CPacket::toBytes)
                .consumerMainThread(UtilsS2CPacket::handle)
                .add();
    }
    public static <MSG> void sendToServer(MSG message)
    {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToClient(MSG message , ServerPlayer player)
    {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}
