package cz.mstein.minecraft.uwm.items.wand.gatgets;

import cz.mstein.minecraft.uwm.items.wand.WandGadget;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class BasicGadget extends WandGadget {
	public BasicGadget() {
		super("basic");
	}
	@Override
	public void exec(World world, EntityPlayer player, EnumHand hand, String mode) {
		 if(world.isRemote) {player.displayGui(new BlockWorkbench.InterfaceCraftingTable(world, player.getPosition()));}
	}
}
