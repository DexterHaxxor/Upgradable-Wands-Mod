package cz.mstein.minecraft.uwm.items.wand.gatgets;

import cz.mstein.minecraft.uwm.items.wand.WandGadget;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class GadgetBasic extends WandGadget {
	public GadgetBasic() {
		super("basic");
	}
	@Override
	public void exec(World world, EntityPlayer player, EnumHand hand, String mode) {
		 player.dropItem(player.getHeldItem(hand), false);
		 player.setHeldItem(hand, ItemStack.EMPTY);
	}
}