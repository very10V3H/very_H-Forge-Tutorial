package com.Toturial.toturial.Events.AttackEntityEvent;

import com.Toturial.toturial.Items.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AttackEvent {
    @SubscribeEvent
    public static void Attack(AttackEntityEvent event)
    {
        if(!event.getEntity().level().isClientSide){
            Player player = event.getEntity();
            Entity entity = event.getTarget();
            ItemStack itemStack = player.getItemInHand(InteractionHand.MAIN_HAND);
            if(entity instanceof Zombie && itemStack.is(ModItems.MyFirstItem.get())){
                entity.hurt(entity.damageSources().playerAttack(player),40);
                player.heal(5);
                player.sendSystemMessage(Component.literal("为你治疗了5点生命值。"));
            }
            event.setCanceled(true);
        }
    }
}
