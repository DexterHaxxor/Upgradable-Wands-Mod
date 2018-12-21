package cz.mstein.minecraft.uwm.items.wand;

import cz.mstein.minecraft.uwm.items.UWMItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class UWMWand extends UWMItem {
	public UWMWand() {
		super("wand");
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand) {
		ItemStack itemstack = player.getHeldItem(hand);
		NBTTagCompound tag = itemstack.getOrCreateSubCompound("upgrades");
		String selected_string = tag.getTag("selected").toString();
		String mode = tag.getTag("mode").toString();
		WandGadget selected = WandGadget.getByName(selected_string);
		selected.exec(world, player, hand, mode);
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemstack);
	}
}