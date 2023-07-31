package com.Toturial.toturial.Events.Interact;

import net.minecraft.world.InteractionHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Interact {
    @SubscribeEvent
    public static void interactEvent(PlayerInteractEvent event){
/*        event.getItemStack();
        event.getFace();
        event.getHand();
        event.getEntity();
        event.getCancellationResult();
        event.getPos();
        event.getSide();
        event.getLevel();
        event.setCanceled(true);*/
    }
}
