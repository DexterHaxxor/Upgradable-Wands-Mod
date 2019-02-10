package cz.mstein.minecraft.uwm.items;

import cz.mstein.minecraft.uwm.creativetabs.UWMTab;
import net.minecraft.item.Item;

public class UWMItem extends Item {
	public UWMItem(String name) {
		this.setTranslationKey(name);
		this.setRegistryName(name);
		this.setCreativeTab(UWMTab.tab);
	}
}
