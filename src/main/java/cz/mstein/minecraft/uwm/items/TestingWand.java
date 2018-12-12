package cz.mstein.minecraft.uwm.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestingWand extends UWMItem {
	public TestingWand() {
		super("testing_wand");
		this.maxStackSize = 1;
		this.setMaxDamage(500);
	}
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(!world.isRemote) {
			world.destroyBlock(pos, true);
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
		{
	}
}
