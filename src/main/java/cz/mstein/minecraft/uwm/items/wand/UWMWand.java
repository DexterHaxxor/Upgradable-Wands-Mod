package cz.mstein.minecraft.uwm.items.wand;

import cz.mstein.minecraft.uwm.items.UWMItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
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
		NBTTagCompound tag = itemstack.getOrCreateSubCompound("upgrades");
		String defaultGadget;
		if(!tag.hasKey("enabled", Constants.NBT.TAG_COMPOUND)) {
			NBTTagCompound subTag = new NBTTagCompound();
			subTag.setString("basic", "");
			tag.setTag("enabled", subTag);
			defaultGadget = "basic";
		} else {
			String[] gadgetArray = (String[]) tag.getCompoundTag("enabled").getKeySet().toArray(new String[1]);
			defaultGadget = gadgetArray[0];
		}
		if(!tag.hasKey("selected", Constants.NBT.TAG_STRING)) {
			tag.setString("selected", defaultGadget);
		}
		if (!tag.hasKey("mode", Constants.NBT.TAG_STRING)) {
			tag.setString("mode", "");
		}
		String selectedString = tag.getString("selected");
		String mode = tag.getString("mode");
		WandGadget selected = WandGadget.getByName(selectedString);
		if(selected == null) {
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);
		}
		selected.exec(world, player, hand, mode);
		return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
	}
}