package com.Toturial.toturial.ClassProfile;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ItemStackProfile {
    public static boolean PlayerHasItem(Player player, Item item)
    {
        Inventory inventory = player.getInventory();
        for(int i = 0; i < inventory.getMaxStackSize(); i++)
        {
            if(inventory.getItem(i).is(item)) return true;
        }
        return false;
    }
    public static int ItemStackCount(Player player, Item item)
    {
        int ExistNum = 0;
        Inventory inventory = player.getInventory();
        for(int i = 0; i < inventory.getMaxStackSize(); i++)
        {
            ItemStack itemStack = inventory.getItem(i);
            if(itemStack.is(item)) ExistNum += itemStack.getCount();
        }
        return ExistNum;
    }
    public static int ItemStackCount(Inventory inventory, Item item)
    {
        int ExistNum = 0;
        for(int i = 0; i < inventory.getMaxStackSize(); i++)
        {
            ItemStack itemStack = inventory.getItem(i);
            if(itemStack.is(item)) ExistNum += itemStack.getCount();
        }
        return ExistNum;
    }
    public static boolean ItemStackCheck(Inventory inventory, Item item, int RequirementNum)
    {
        if(ItemStackCount(inventory,item) < RequirementNum) return false;
        else return true;
    }
    public static boolean ItemStackRemove(Inventory inventory, Item item, int RemoveNum)
    {
        int num = RemoveNum;
        if(!ItemStackCheck(inventory,item,RemoveNum)) return false;
        else
        {
            for(int i = 0; i < inventory.getMaxStackSize(); i++)
            {
                if(inventory.getItem(i).is(item))
                {
                    ItemStack itemStack = inventory.getItem(i);
                    if(itemStack.getCount() < num)
                    {
                        num -= itemStack.getCount();
                        itemStack.setCount(0);
                        inventory.setItem(i,itemStack);
                    }
                    else
                    {
                        itemStack.setCount(itemStack.getCount()-num);
                        inventory.setItem(i,itemStack);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
