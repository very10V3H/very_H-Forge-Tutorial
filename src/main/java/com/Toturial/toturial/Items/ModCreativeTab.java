package com.Toturial.toturial.Items;

import com.Toturial.toturial.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.
            create(Registries.CREATIVE_MODE_TAB, Utils.MOD_ID);

    public static RegistryObject<CreativeModeTab> FIRST_TAB = CREATIVE_MODE_TAB.register("moditem1",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MyFirstItem.get())).
                    title(Component.literal("very_H教程物品栏1")).build());
    //每个物品栏的注册都将使用一个这一格式的语句，与物品类似。
    public static RegistryObject<CreativeModeTab> SECOND_TAB = CREATIVE_MODE_TAB.register("moditem2",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MyFirstItem.get())).
                    title(Component.literal("very_H教程物品栏2")).build());
    //第二个物品栏的注册
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
