package com.Toturial.toturial.Events.HurtEvent;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class HurtEvent {
    @SubscribeEvent
    public static void HurtEvent(LivingHurtEvent event)
    {

    }
}
