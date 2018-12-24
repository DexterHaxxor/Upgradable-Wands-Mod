package cz.mstein.minecraft.uwm.etc;

import cz.mstein.minecraft.uwm.items.wand.UWMWand;
import cz.mstein.minecraft.uwm.items.wand.WandGadget;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class WandInfo {
	private String selectedString;
	private WandGadget selected;
	private String mode;
	private NBTTagCompound upgrades;
	private NBTTagCompound list;
	private NBTTagCompound display;
	private ItemStack itemStack;
	private String customName;
	private NBTTagList lore;
	
	public WandInfo(ItemStack itemStackParam) {
		this.itemStack = itemStackParam;
		this.upgrades = UWMWand.setupTags(itemStack);
		this.display = itemStack.getOrCreateSubCompound("display");
		this.selectedString = this.upgrades.getString("selected");
		this.mode = this.upgrades.getString("mode");
		this.selected = WandGadget.getByName(this.selectedString);
		this.list = this.upgrades.getCompoundTag("list");
		this.lore = this.display.getTagList("Lore", Constants.NBT.TAG_STRING);
		this.customName = this.display.getString("Name");
	}

	public String getSelectedString() {
		return selectedString;
	}

	public WandGadget getSelected() {
		return selected;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.display.setString("Name", customName);
		this.customName = customName;
	}

	public void setSelected(WandGadget selected) {
		this.selectedString = selected.getRegistryName().toString();
		this.upgrades.setString("selected", this.selectedString);
		this.selected = selected;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.upgrades.setString("mode", mode);
		this.mode = mode;
	}

	public NBTTagCompound getList() {
		return list;
	}

	public void setList(NBTTagCompound list) {
		this.upgrades.setTag("list", list);
		this.list = list;
	}

	public ItemStack getItemStack() {
		return itemStack;
	}

	public NBTTagCompound getDisplay() {
		return display;
	}

	public void setDisplay(NBTTagCompound display) {
		this.itemStack.setTagCompound(display);
		this.display = display;
	}

	public NBTTagList getLore() {
		return lore;
	}

	public void setLore(NBTTagList lore) {
		this.display.setTag("Lore", lore);
		this.lore = lore;
	}
}
