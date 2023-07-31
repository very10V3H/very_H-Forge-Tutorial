package com.Toturial.toturial.Events.ToolTipEvent;

import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ToolTipEvent {
    @SubscribeEvent
    public static void ToolTipAdd(ItemTooltipEvent event)
    {
        event.getToolTip();
        event.getFlags();
        event.getItemStack();
        event.getEntity();
    }
}
