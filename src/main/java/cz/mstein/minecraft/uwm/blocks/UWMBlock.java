package cz.mstein.minecraft.uwm.blocks;

import cz.mstein.minecraft.uwm.creativetabs.UWMTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UWMBlock extends Block {
	public UWMBlock(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(UWMTab.tab);
	}
}
