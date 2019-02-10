package cz.mstein.minecraft.uwm.blocks;

import cz.mstein.minecraft.uwm.creativetabs.UWMTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UWMBlock extends Block {
	public UWMBlock(String name, Material material) {
		super(material);
		this.setTranslationKey(name);
		this.setRegistryName(name);
		this.setCreativeTab(UWMTab.tab);
		this.setHardness(3.0F);
	}
}
