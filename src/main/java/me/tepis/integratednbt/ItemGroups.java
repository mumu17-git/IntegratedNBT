package me.tepis.integratednbt;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ItemGroups {

    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IntegratedNBT.MODID);

    public static final RegistryObject<CreativeModeTab> INTEGRATED_NBT_MAIN = MOD_TABS.register("integratednbt_tab", () -> {
        return CreativeModeTab.builder()
                .icon(() -> new ItemStack(Additions.NBT_EXTRACTOR_BLOCK_ITEM.get()))
                .title(Component.translatable("itemGroup.integratednbt"))
                .displayItems(((itemDisplayParameters, output) -> {
                    for (Item item : ItemGroupMain.ITEMS) {
                        output.accept(item);
                    }
                })).build();
    });

}
