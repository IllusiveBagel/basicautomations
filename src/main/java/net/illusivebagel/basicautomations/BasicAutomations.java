package net.illusivebagel.basicautomations;

import net.illusivebagel.basicautomations.item.ModItems;
import net.illusivebagel.basicautomations.item.ModCreativeModeTabs;
import net.illusivebagel.basicautomations.block.ModBlocks;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(BasicAutomations.MODID)
public class BasicAutomations {
    public static final String MODID = "basicautomations";
    private static final Logger LOGGER = LogUtils.getLogger();

    public BasicAutomations() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BLACK_OPAL);
            event.accept(ModItems.RAW_BLACK_OPAL);
        }

        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.BLACK_OPAL_BLOCK);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.NETHERRACK_BLACK_OPAL_ORE);
            event.accept(ModBlocks.ENDSTONE_BLACK_OPAL_ORE);
            event.accept(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE);
            event.accept(ModBlocks.BLACK_OPAL_ORE);
        }

        if(event.getTab() == ModCreativeModeTabs.BASICAUTOMATIONS_TAB) {
            event.accept(ModItems.BLACK_OPAL);
            event.accept(ModItems.RAW_BLACK_OPAL);

            event.accept(ModBlocks.BLACK_OPAL_BLOCK);
            event.accept(ModBlocks.NETHERRACK_BLACK_OPAL_ORE);
            event.accept(ModBlocks.ENDSTONE_BLACK_OPAL_ORE);
            event.accept(ModBlocks.DEEPSLATE_BLACK_OPAL_ORE);
            event.accept(ModBlocks.BLACK_OPAL_ORE);
        }
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
