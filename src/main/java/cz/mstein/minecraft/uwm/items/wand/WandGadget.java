package cz.mstein.minecraft.uwm.items.wand;

import javax.annotation.Nullable;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class WandGadget extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<WandGadget> {
	private static IForgeRegistry<WandGadget> REGISTRY;
	
	public WandGadget(String id) {
		this.setRegistryName(id);
	}
	
	@Nullable
	public static WandGadget getByName(String id)
	{
		return getByName(new ResourceLocation(id));
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

}
