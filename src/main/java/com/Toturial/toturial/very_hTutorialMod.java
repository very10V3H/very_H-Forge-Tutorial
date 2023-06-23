package com.Toturial.toturial;

import com.Toturial.toturial.Items.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Utils.MOD_ID)
public class very_hTutorialMod {
    public very_hTutorialMod() {
        IEventBus modEvenBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.ITEMS.register(modEvenBus);
    }
}
