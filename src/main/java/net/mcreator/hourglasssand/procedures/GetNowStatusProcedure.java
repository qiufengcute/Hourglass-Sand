package net.mcreator.hourglasssand.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.network.chat.Component;

import net.mcreator.hourglasssand.network.HourglassSandModVariables;

public class GetNowStatusProcedure {
	public static boolean eventResult = true;

	public static String execute(LevelAccessor world) {
		return Component.translatable("getnowstatus.statusstart").getString() + "" + HourglassSandModVariables.MapVariables.get(world).Status + Component.translatable("getnowstatus.statusend").getString();
	}
}