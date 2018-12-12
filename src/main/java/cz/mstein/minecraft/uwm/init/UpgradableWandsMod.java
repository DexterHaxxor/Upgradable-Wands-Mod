package cz.mstein.minecraft.uwm.init;

import cz.mstein.minecraft.uwm.blocks.UWMBlocks;
import cz.mstein.minecraft.uwm.items.UWMItems;
import cz.mstein.minecraft.uwm.recipies.UWMSmelting;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=UWMReference.MODID, name=UWMReference.MODNAME, version=UWMReference.VERSION, acceptedMinecraftVersions=UWMReference.ACCEPTED_MINECRAFT_VERSIONS)
public class UpgradableWandsMod {
	
	@Instance
	public static UpgradableWandsMod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(UWMReference.MODID + ":preInit");
		UWMBlocks.init();
		UWMItems.init();
		UWMSmelting.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		System.out.println(UWMReference.MODID + ":init");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		System.out.println(UWMReference.MODID + ":postInit");
	}
}