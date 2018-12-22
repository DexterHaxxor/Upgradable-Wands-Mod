package cz.mstein.minecraft.uwm.keybinds;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class UWMKeyInputHandler {
	@SubscribeEvent
	public void onKeyInput(KeyInputEvent event)
	{
		if (UWMKeybinds.wand_menu.isPressed())
		{
			Minecraft.getMinecraft().ingameGUI.setOverlayMessage("They did surgery on a grape", false);
		}
	}
}