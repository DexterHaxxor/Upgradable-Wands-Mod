package cz.mstein.minecraft.uwm.recipies;

import cz.mstein.minecraft.uwm.items.UWMItems;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class UWMSmelting {

	public static void init() {
		GameRegistry.addSmelting(UWMItems.javium_dust, new ItemStack(UWMItems.javium_ingot, 1), 1.5f);
	}	
}