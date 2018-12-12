package cz.mstein.minecraft.uwm.items;

import cz.mstein.minecraft.uwm.creativetabs.UWMTab;
import net.minecraft.item.Item;

public class UWMItem extends Item {
	public UWMItem(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(UWMTab.tab);
	}
}
