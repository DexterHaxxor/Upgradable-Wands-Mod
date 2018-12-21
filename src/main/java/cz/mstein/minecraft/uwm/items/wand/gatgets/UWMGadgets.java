package cz.mstein.minecraft.uwm.items.wand.gatgets;

import cz.mstein.minecraft.uwm.items.wand.WandGadget;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class UWMGadgets {
	static WandGadget basic = new BasicGadget();
	@SubscribeEvent
	public static void registerUpgrades(RegistryEvent.Register<WandGadget> event) {
		event.getRegistry().registerAll(basic);
	}
}
