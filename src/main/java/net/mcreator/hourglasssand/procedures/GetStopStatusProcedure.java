package net.mcreator.hourglasssand.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.hourglasssand.network.HourglassSandModVariables;

public class GetStopStatusProcedure {
	public static boolean eventResult = true;

	public static String execute(LevelAccessor world) {
		return Component.translatable("getstopstatus.stopstatusstart").getString() + "" + HourglassSandModVariables.MapVariables.get(world).StopStatus;
	}
}