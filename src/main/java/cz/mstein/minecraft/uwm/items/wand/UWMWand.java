package cz.mstein.minecraft.uwm.items.wand;

import cz.mstein.minecraft.uwm.items.UWMItem;

public class UWMWand extends UWMItem {
	protected UWMWand(int type) {
		super("wand");
		String itemname;
		switch(type) {
			case 0: itemname = "basic_wand";
				break;
			case 1: itemname = "advanced_wand";
				break;
			case 2: itemname = "extreme_wand";
				break;
			case 3: itemname = "ultimate_wand";
				break;
			default: itemname = "basic_wand";
		}
		this.setUnlocalizedName(itemname);
		this.setRegistryName(itemname);
	}
}

