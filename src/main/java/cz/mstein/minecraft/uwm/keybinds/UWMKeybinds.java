package cz.mstein.minecraft.uwm.keybinds;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class UWMKeybinds {
	public static KeyBinding wand_menu;
	 
    public static void register()
    {
        wand_menu = new KeyBinding("wand_menu", Keyboard.KEY_V, "key.categories.misc");
        ClientRegistry.registerKeyBinding(wand_menu);
    }
}