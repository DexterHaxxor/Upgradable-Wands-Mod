package cz.mstein.minecraft.uwm.gui;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiScreen;

public class WandMenu extends GuiScreen {
	public WandMenu() {
	}
	@Override
	public void initGui() {
		buttonList.clear();
		Keyboard.enableRepeatEvents(true);
	}
}
