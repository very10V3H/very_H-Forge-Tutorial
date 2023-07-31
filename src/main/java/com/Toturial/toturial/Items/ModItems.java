package com.Toturial.toturial.Items;

import com.Toturial.toturial.Utils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Utils.MOD_ID);

    public static final RegistryObject<Item> MyFirstItem = ITEMS.register("my_first_item",
            ()->new MyFirstItem(new Item.Properties().rarity(Rarity.EPIC)));
}

