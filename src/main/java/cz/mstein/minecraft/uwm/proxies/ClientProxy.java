package cz.mstein.minecraft.uwm.proxies;

import cz.mstein.minecraft.uwm.keybinds.UWMKeyInputHandler;
import cz.mstein.minecraft.uwm.keybinds.UWMKeybinds;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		UWMKeybinds.register();
		MinecraftForge.EVENT_BUS.register(new UWMKeyInputHandler());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}

}