package net.illusivebagel.basicautomations.item;

import net.illusivebagel.basicautomations.BasicAutomations;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BasicAutomations.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab BASICAUTOMATIONS_TAB;

    @SubscribeEvent
    public static void RegisterCreativeModeTab(CreativeModeTabEvent.Register event) {
        BASICAUTOMATIONS_TAB = event.registerCreativeModeTab(new ResourceLocation(BasicAutomations.MODID, "basicautomations_tab"),
            builder -> builder.icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                .title(Component.translatable("creativemodetab.basicautomations_tab")));
    }
}
