package cz.mstein.minecraft.uwm.blocks;

import cz.mstein.minecraft.uwm.init.UWMReference;
import cz.mstein.minecraft.uwm.materials.javium.JaviumBlock;
import cz.mstein.minecraft.uwm.materials.perpium.PerpiumBlock;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=UWMReference.MODID)
public class UWMBlocks {

	public static Block javium_block;
	public static Block perpium_block;
	
	public static void init() {
		javium_block = new JaviumBlock();
		perpium_block = new PerpiumBlock();
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(javium_block);
		event.getRegistry().registerAll(perpium_block);
	}
	
	@SubscribeEvent
	public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(new ItemBlock(javium_block).setRegistryName(javium_block.getRegistryName()));
		event.getRegistry().registerAll(new ItemBlock(perpium_block).setRegistryName(perpium_block.getRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(Item.getItemFromBlock(javium_block));
		registerRender(Item.getItemFromBlock(perpium_block));
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}