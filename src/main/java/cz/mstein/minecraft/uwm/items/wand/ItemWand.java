package cz.mstein.minecraft.uwm.items.wand;

import cz.mstein.minecraft.uwm.etc.WandInfo;
import cz.mstein.minecraft.uwm.items.UWMItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class ItemWand extends UWMItem {
	public ItemWand() {
		super("wand");
		this.setMaxStackSize(1);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		WandInfo wandInfo = new WandInfo(itemstack);
		if(wandInfo.getSelected() == null) {return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);}
		wandInfo.getSelected().exec(world, player, hand, wandInfo.getMode());
		ItemWand.updateName(itemstack);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
	}
	@Override
	public boolean onBlockStartBreak(ItemStack itemstack, BlockPos blockpos, EntityPlayer player) {
		WandInfo wandInfo = new WandInfo(itemstack);
		return wandInfo.getSelected().isBlockDestroyed(wandInfo.getMode());
	}
	public static void updateName(ItemStack itemstack) {
		WandInfo wandInfo = new WandInfo(itemstack);
		wandInfo.getDisplay().setString("Name", "§r" +  wandInfo.getCustomName() + " ｜ " + new TextComponentTranslation("gadget." + wandInfo.getSelectedString() + ".name").getUnformattedText());
		NBTTagList lore = new NBTTagList();
		lore.appendTag(new NBTTagString("§r§4§l§o" + new TextComponentTranslation("wand.description").getUnformattedText()));
		lore.appendTag(new NBTTagString("§r" + new TextComponentTranslation("gadget.description").getUnformattedText() + new TextComponentTranslation("gadget." + wandInfo.getSelectedString() + ".description").getUnformattedText()));
		wandInfo.setLore(lore);
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
		if(!tag.hasKey("customname", Constants.NBT.TAG_STRING)) {
			tag.setString("customname", new TextComponentTranslation("item.wand.name").getUnformattedText());
		}
		return tag;
	}
	public static void changeMode(ItemStack itemstack, boolean isUp) {
		WandInfo wandInfo = new WandInfo(itemstack);
		wandInfo.setCustomName(wandInfo.getSelected().getNewMode(wandInfo.getMode(), isUp));
	}
}