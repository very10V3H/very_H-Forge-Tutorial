package com.Toturial.toturial.Events.LoginAndLoggedout;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerLoginEvent {
    @SubscribeEvent
    public static void Login(PlayerEvent.PlayerLoggedInEvent event)
    {
        Player player = event.getEntity();
        player.sendSystemMessage(Component.literal("欢迎！"));
    }
}

