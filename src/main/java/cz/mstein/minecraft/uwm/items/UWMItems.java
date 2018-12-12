package cz.mstein.minecraft.uwm.items;

import cz.mstein.minecraft.uwm.init.UWMReference;
import cz.mstein.minecraft.uwm.materials.javium.JaviumDust;
import cz.mstein.minecraft.uwm.materials.javium.JaviumIngot;
import cz.mstein.minecraft.uwm.materials.perpium.PerpiumDust;
import cz.mstein.minecraft.uwm.materials.perpium.PerpiumIngot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
@Mod.EventBusSubscriber(modid=UWMReference.MODID)

public class UWMItems {
	
	// START OF ITEMS HERE //
	public static Item javium_ingot, javium_dust, perpium_ingot, perpium_dust, testing_wand;
	// END OF ITEMS HERE //
	public static void init() {
		javium_ingot = new JaviumIngot();
		javium_dust = new JaviumDust();
		perpium_ingot = new PerpiumIngot();
		perpium_dust = new PerpiumDust();
		testing_wand = new TestingWand();
	}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(javium_ingot);
		event.getRegistry().registerAll(javium_dust);
		event.getRegistry().registerAll(perpium_ingot);
		event.getRegistry().registerAll(perpium_dust);
		event.getRegistry().registerAll(testing_wand);
	}
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(javium_ingot);
		registerRender(javium_dust);
		registerRender(perpium_ingot);
		registerRender(perpium_dust);
		registerRender(testing_wand);
	}
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
