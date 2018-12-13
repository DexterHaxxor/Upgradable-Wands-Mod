package cz.mstein.minecraft.uwm.materials.perpium;

import cz.mstein.minecraft.uwm.blocks.UWMOre;
import cz.mstein.minecraft.uwm.items.UWMItems;
import net.minecraft.block.material.Material;

public class PerpiumOre extends UWMOre {
	public PerpiumOre() {
		super("perpium_ore", Material.IRON, UWMItems.perpium_dust, 1, 2);
	}
}