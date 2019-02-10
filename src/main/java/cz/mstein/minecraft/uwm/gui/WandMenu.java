package cz.mstein.minecraft.uwm.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

public class WandMenu extends GuiScreen {
	public static void displayNew() {
		Minecraft.getMinecraft().displayGuiScreen(new WandMenu());
	}
	@Override
	public void initGui() {
		buttonList.clear();
		Keyboard.enableRepeatEvents(true);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}
}
