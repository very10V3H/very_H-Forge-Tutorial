package com.Toturial.toturial.Events.Living_Attack_Event;

import com.Toturial.toturial.Items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Living_Attack_Event {
    @SubscribeEvent
    public static void LivingAttack(LivingAttackEvent event)
    {
        if(!event.getEntity().level().isClientSide){
            if(event.getEntity() instanceof Player player && event.getSource().getEntity() instanceof Zombie zombie){
                if(player.getItemInHand(InteractionHand.MAIN_HAND).is(ModItems.MyFirstItem.get())){
                    player.setHealth(player.getHealth()-event.getAmount()*0.5f);
                    player.sendSystemMessage(Component.literal("伤害被减半了！"));
                    event.setCanceled(true);
                }
            }
        }
    }
}
