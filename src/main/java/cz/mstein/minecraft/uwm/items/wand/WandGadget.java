package cz.mstein.minecraft.uwm.items.wand;

import javax.annotation.Nullable;
import cz.mstein.minecraft.uwm.init.UWMReference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class WandGadget extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<WandGadget> {
	private static IForgeRegistry<WandGadget> REGISTRY;
	
	public WandGadget(String id) {
		this.setRegistryName(new ResourceLocation(UWMReference.MODID, id));
	}
	
	@Nullable
	public static WandGadget getByName(String id)
	{
		return getByName(new ResourceLocation(UWMReference.MODID, id));
	}

	@Nullable
	public static WandGadget getByName(ResourceLocation id)
	{
		if(REGISTRY == null) {
			IForgeRegistry<WandGadget> registry = GameRegistry.findRegistry(WandGadget.class);

			if(registry==null) {
				return null;
			}

			REGISTRY = registry;
		}
		return REGISTRY.getValue(id);
	}
	public void exec(World world, EntityPlayer player, EnumHand hand, String mode) {}
	public String getNewMode(String mode, boolean isUp) {return "";}
	public boolean isBlockDestroyed(String mode) {return true;}
}
