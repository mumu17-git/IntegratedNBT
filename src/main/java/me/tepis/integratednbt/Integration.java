package me.tepis.integratednbt;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.resources.ResourceLocation;

public abstract class Integration {
    public static boolean isVariable(ItemStack itemStack) {
        if (itemStack == null) {
            return false;
        }
        return isVariable(itemStack.getItem());
    }

    public static boolean isVariable(Item item) {
        if (item == null) {
            return false;
        }
        ResourceLocation resourceLocation = ForgeRegistries.ITEMS.getKey(item);
        if (resourceLocation == null) {
            return false;
        }
        return resourceLocation.toString().equals("integrateddynamics:variable");
    }
}
