package com.Toturial.toturial;

import com.Toturial.toturial.Items.ModCreativeTab;
import com.Toturial.toturial.Items.ModItems;
import com.Toturial.toturial.ModNetwork.ModNetworking;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Utils.MOD_ID)
@Mod.EventBusSubscriber
public class very_hTutorialMod {
    public very_hTutorialMod() {
        IEventBus modEvenBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modEvenBus);
        ModCreativeTab.register(modEvenBus);
        modEvenBus.addListener(this::AddItemToTab);
        modEvenBus.addListener(this::SetUp);
    }
    private void AddItemToTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(ModCreativeTab.FIRST_TAB.getKey())) {
            event.accept(ModItems.MyFirstItem.get().getDefaultInstance());
        }
    }
    private void SetUp(FMLCommonSetupEvent event){
        ModNetworking.register();
    }
}
