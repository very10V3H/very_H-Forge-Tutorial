package com.Toturial.toturial.Events.TickEvent;

import com.Toturial.toturial.Items.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PlayerTick {
    @SubscribeEvent
    public static void playerTickEvent(TickEvent.PlayerTickEvent event)
    {
        if(event.side.isServer())
        {
            Player player = event.player;
            if(event.phase.equals(TickEvent.Phase.START) && player.tickCount % 10 == 0)
            {
                if(player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.MyFirstItem.get()))
                {
                    player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30);
                }
                else player.getAttribute(Attributes.MAX_HEALTH).setBaseValue(20);
            }
        }
    }
}
