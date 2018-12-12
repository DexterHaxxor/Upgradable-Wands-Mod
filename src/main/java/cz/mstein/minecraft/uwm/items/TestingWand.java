package cz.mstein.minecraft.uwm.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestingWand extends UWMItem {
	public TestingWand() {
		super("testing_wand");
		this.maxStackSize = 1;
		this.setMaxDamage(500);
	}
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float px, float py, float pz){
			BlockPos pos = new BlockPos(x,y,z);
			world.destroyBlock(pos, true);
		return true;
	}
}
