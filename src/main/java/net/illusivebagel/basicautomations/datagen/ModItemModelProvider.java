package net.illusivebagel.basicautomations.datagen;

import net.illusivebagel.basicautomations.BasicAutomations;
import net.illusivebagel.basicautomations.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, BasicAutomations.MODID, exFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.BLACK_OPAL);
        simpleItem(ModItems.RAW_BLACK_OPAL);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/generated")).texture("layer0",
            new ResourceLocation(BasicAutomations.MODID, "item/" + item.getId().getPath()));
    }

    // Helper Method for Tools or Anything Held Differently
    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
            new ResourceLocation("item/handheld")).texture("layer0",
            new ResourceLocation(BasicAutomations.MODID, "item/" + item.getId().getPath()));
    }
}
