package cz.mstein.minecraft.uwm.items.wand.gatgets;

import cz.mstein.minecraft.uwm.init.UWMReference;
import cz.mstein.minecraft.uwm.items.wand.WandGadget;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=UWMReference.MODID)
public class UWMGadgets {
	static WandGadget basic = new BasicGadget();
	@SubscribeEvent
	public static void registerUpgrades(RegistryEvent.Register<WandGadget> event) {
		event.getRegistry().registerAll(basic);
	}
}