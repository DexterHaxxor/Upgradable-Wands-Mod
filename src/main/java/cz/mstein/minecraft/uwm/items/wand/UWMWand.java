package cz.mstein.minecraft.uwm.items.wand;

import cz.mstein.minecraft.uwm.items.UWMItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class UWMWand extends UWMItem {
	public UWMWand() {
		super("wand");
		this.setMaxStackSize(1);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		NBTTagCompound tag = UWMWand.setupTags(itemstack);
		String selectedString = tag.getString("selected");
		String mode = tag.getString("mode");
		WandGadget selected = WandGadget.getByName(selectedString);
		if(selected == null) {return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);}
		selected.exec(world, player, hand, mode);
		UWMWand.updateName(itemstack);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
	}
	public static void updateName(ItemStack itemstack) {
		NBTTagCompound tag = UWMWand.setupTags(itemstack);
		String selected = tag.getString("selected");
		NBTTagCompound display = itemstack.getOrCreateSubCompound("display");
		String name;
		if(!tag.hasKey("customname", Constants.NBT.TAG_STRING)) {
			name = new TextComponentTranslation("item.wand.name").getUnformattedText();
		} else {
			name = tag.getString("customname");
		}
		display.setString("Name", "§r" +  name + " ｜ " + new TextComponentTranslation("gadget." + selected + ".name").getUnformattedText());
		NBTTagList lore = new NBTTagList();
		lore.appendTag(new NBTTagString("§r§4§l§o" + new TextComponentTranslation("wand.description").getUnformattedText()));
		lore.appendTag(new NBTTagString("§r" + new TextComponentTranslation("gadget.description").getUnformattedText() + new TextComponentTranslation("gadget." + selected + ".description").getUnformattedText()));
		display.setTag("Lore", lore);
	}
	public static NBTTagCompound setupTags(ItemStack itemstack) {
		NBTTagCompound tag = itemstack.getOrCreateSubCompound("upgrades");
		String defaultGadget;
		if(!tag.hasKey("list", Constants.NBT.TAG_COMPOUND)) {
			NBTTagCompound enabled = new NBTTagCompound();
			enabled.setString("basic", "");
			tag.setTag("list", enabled);
			defaultGadget = "basic";
		} else {
			String[] gadgetArray = (String[]) tag.getCompoundTag("list").getKeySet().toArray(new String[1]);
			defaultGadget = gadgetArray[0];
		}
		if(!tag.hasKey("selected", Constants.NBT.TAG_STRING)) {
			tag.setString("selected", defaultGadget);
		}
		if (!tag.hasKey("mode", Constants.NBT.TAG_STRING)) {
			tag.setString("mode", "");
		}
		return tag;
	}
	public static void changeMode(ItemStack itemstack, boolean isUp) {
		NBTTagCompound tag = UWMWand.setupTags(itemstack);
		String currentMode = tag.getString("mode");
		String selectedString = tag.getString("selected");
		WandGadget selected = WandGadget.getByName(selectedString);
		String newMode = selected.getNewMode(currentMode, isUp);
		tag.setString("mode", newMode);
	}
}