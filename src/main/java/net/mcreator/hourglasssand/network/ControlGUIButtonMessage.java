package net.mcreator.hourglasssand.network;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.hourglasssand.procedures.To2Procedure;
import net.mcreator.hourglasssand.procedures.To1Procedure;
import net.mcreator.hourglasssand.procedures.To0Procedure;
import net.mcreator.hourglasssand.procedures.ChangeStopProcedure;
import net.mcreator.hourglasssand.HourglassSandMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public record ControlGUIButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<ControlGUIButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(HourglassSandMod.MODID, "control_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ControlGUIButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ControlGUIButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ControlGUIButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<ControlGUIButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ControlGUIButtonMessage message, final ServerPlayNetworking.Context context) {
		context.server().execute(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z));
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			To0Procedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			To1Procedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			To2Procedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			ChangeStopProcedure.execute(world, x, y, z);
		}
	}
}