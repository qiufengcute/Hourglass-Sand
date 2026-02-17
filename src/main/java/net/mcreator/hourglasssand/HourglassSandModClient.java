package net.mcreator.hourglasssand;

import net.mcreator.hourglasssand.network.HourglassSandModVariables;
import net.mcreator.hourglasssand.init.HourglassSandModScreens;
import net.mcreator.hourglasssand.init.HourglassSandModMenus;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.ClientModInitializer;

@Environment(EnvType.CLIENT)
public class HourglassSandModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		HourglassSandModScreens.clientLoad();
		HourglassSandModMenus.clientLoad();
		ClientPlayNetworking.registerGlobalReceiver(HourglassSandModVariables.SavedDataSyncMessage.TYPE, HourglassSandModVariables.SavedDataSyncMessage::handleData);
		// Start of user code block mod init
		// End of user code block mod init
	}
	// Start of user code block mod methods
	// End of user code block mod methods
}