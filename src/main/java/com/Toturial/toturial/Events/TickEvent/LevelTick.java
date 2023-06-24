package com.Toturial.toturial.Events.TickEvent;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class LevelTick {
    @SubscribeEvent
    public static void levelTickEvent(TickEvent.LevelTickEvent event)
    {
        if(event.side.isServer())
        {
            if(event.phase.equals(TickEvent.Phase.START) && event.level.getServer().getTickCount() % 200 == 0)
            {
                Level level = event.level;
                if(level.equals(level.getServer().getLevel(Level.OVERWORLD)))
                {
                    Zombie zombie = new Zombie(EntityType.ZOMBIE,level);
                    zombie.setItemInHand(InteractionHand.MAIN_HAND, Items.DIAMOND_AXE.getDefaultInstance());
                    zombie.moveTo(0.5,-59,0.5);
                    level.addFreshEntity(zombie);
                }
            }
        }
    }
}
