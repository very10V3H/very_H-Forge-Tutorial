package com.Toturial.toturial.Items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MyFirstItem extends Item {

    public MyFirstItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        components.add(Component.literal("我的第一个物品"));
        components.add(Component.literal("来自very_H").withStyle(ChatFormatting.AQUA).withStyle(ChatFormatting.BOLD).
                append(Component.literal("的mod基础教程").withStyle(ChatFormatting.RESET).withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.ITALIC)));
        super.appendHoverText(itemStack, level, components, flag);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if(!level.isClientSide() && interactionHand.equals(InteractionHand.MAIN_HAND))
        {
            Inventory inventory = player.getInventory();
            player.sendSystemMessage(Component.literal(String.valueOf(inventory.getContainerSize())));
            player.sendSystemMessage(Component.literal("very_H的教程-物品使用"));
        }
        if(level.isClientSide() && interactionHand.equals(InteractionHand.MAIN_HAND))
        {
            player.setDeltaMovement(2 * player.getViewVector(5).x,
                    2 * player.getViewVector(5).y, 2 * player.getViewVector(5).z);
            player.getCooldowns().addCooldown(this,100);
        }
        return super.use(level, player, interactionHand);
    }
}
