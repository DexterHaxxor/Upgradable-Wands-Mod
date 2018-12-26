package cz.mstein.minecraft.uwm.items;

import cz.mstein.minecraft.uwm.init.UWMReference;
import cz.mstein.minecraft.uwm.items.wand.ItemWand;
import cz.mstein.minecraft.uwm.materials.javium.ItemJaviumDust;
import cz.mstein.minecraft.uwm.materials.javium.ItemJaviumIngot;
import cz.mstein.minecraft.uwm.materials.perpium.ItemPerpiumDust;
import cz.mstein.minecraft.uwm.materials.perpium.ItemPerpiumIngot;
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
	public static Item javium_ingot, javium_dust, perpium_ingot, perpium_dust, testing_wand, wand;
	// END OF ITEMS HERE //
	public static void init() {
		javium_ingot = new ItemJaviumIngot();
		javium_dust = new ItemJaviumDust();
		perpium_ingot = new ItemPerpiumIngot();
		perpium_dust = new ItemPerpiumDust();
		testing_wand = new ItemTestingWand();
		wand = new ItemWand();
	}
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(javium_ingot);
		event.getRegistry().registerAll(javium_dust);
		event.getRegistry().registerAll(perpium_ingot);
		event.getRegistry().registerAll(perpium_dust);
		event.getRegistry().registerAll(testing_wand);
		event.getRegistry().registerAll(wand);
	}
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(javium_ingot);
		registerRender(javium_dust);
		registerRender(perpium_ingot);
		registerRender(perpium_dust);
		registerRender(testing_wand);
		registerRender(wand);
	}
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
