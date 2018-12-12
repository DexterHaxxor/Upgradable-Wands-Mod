package cz.mstein.minecraft.uwm.creativetabs;

import cz.mstein.minecraft.uwm.items.UWMItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class UWMTab {
	public static final CreativeTabs tab = (new CreativeTabs("uwmtab") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(UWMItems.javium_dust);
		}
		@Override
		public boolean hasSearchBar() {
			return true;
		}
	});
}
