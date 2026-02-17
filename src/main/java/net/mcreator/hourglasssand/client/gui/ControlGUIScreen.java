package net.mcreator.hourglasssand.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.hourglasssand.world.inventory.ControlGUIMenu;
import net.mcreator.hourglasssand.procedures.GetStopStatusProcedure;
import net.mcreator.hourglasssand.procedures.GetNowStatusProcedure;
import net.mcreator.hourglasssand.network.ControlGUIButtonMessage;
import net.mcreator.hourglasssand.init.HourglassSandModScreens;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class ControlGUIScreen extends AbstractContainerScreen<ControlGUIMenu> implements HourglassSandModScreens.FabricScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_change_to_05x_speed;
	private Button button_change_to_1x_speed;
	private Button button_change_to_2x_speed;
	private Button button_change;

	public ControlGUIScreen(ControlGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 120;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("hourglass_sand:textures/screens/control_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, GetNowStatusProcedure.execute(world), 69, 7, -12829636, false);
		guiGraphics.drawString(this.font, GetStopStatusProcedure.execute(world), 206, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.hourglass_sand.control_gui.label_click_esc_to_close_this_window"), 79, 102, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_change_to_05x_speed = Button.builder(Component.translatable("gui.hourglass_sand.control_gui.button_change_to_05x_speed"), e -> {
			int x = ControlGUIScreen.this.x;
			int y = ControlGUIScreen.this.y;
			if (true) {
				ClientPlayNetworking.send(new ControlGUIButtonMessage(0, x, y, z));
				ControlGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 29, this.topPos + 26, 129, 20).build();
		this.addRenderableWidget(button_change_to_05x_speed);
		button_change_to_1x_speed = Button.builder(Component.translatable("gui.hourglass_sand.control_gui.button_change_to_1x_speed"), e -> {
			int x = ControlGUIScreen.this.x;
			int y = ControlGUIScreen.this.y;
			if (true) {
				ClientPlayNetworking.send(new ControlGUIButtonMessage(1, x, y, z));
				ControlGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 29, this.topPos + 50, 129, 20).build();
		this.addRenderableWidget(button_change_to_1x_speed);
		button_change_to_2x_speed = Button.builder(Component.translatable("gui.hourglass_sand.control_gui.button_change_to_2x_speed"), e -> {
			int x = ControlGUIScreen.this.x;
			int y = ControlGUIScreen.this.y;
			if (true) {
				ClientPlayNetworking.send(new ControlGUIButtonMessage(2, x, y, z));
				ControlGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 29, this.topPos + 75, 129, 20).build();
		this.addRenderableWidget(button_change_to_2x_speed);
		button_change = Button.builder(Component.translatable("gui.hourglass_sand.control_gui.button_change"), e -> {
			int x = ControlGUIScreen.this.x;
			int y = ControlGUIScreen.this.y;
			if (true) {
				ClientPlayNetworking.send(new ControlGUIButtonMessage(3, x, y, z));
				ControlGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 203, this.topPos + 27, 76, 20).build();
		this.addRenderableWidget(button_change);
	}
}