package net.mcreator.hourglasssand.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.hourglasssand.network.HourglassSandModVariables;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;

public class InitProcedure {
	public static boolean eventResult = true;

	public InitProcedure() {
		ServerWorldEvents.LOAD.register((server, world) -> {
			execute(world);
		});
	}

	public static void execute(LevelAccessor world) {
		ChangeStopProcedure.execute(world);
		ChangeStopProcedure.execute(world);
		if (HourglassSandModVariables.MapVariables.get(world).Status == 0) {
			To0Procedure.execute(world);
		} else if (HourglassSandModVariables.MapVariables.get(world).Status == 1) {
			To1Procedure.execute(world);
		} else {
			To2Procedure.execute(world);
		}
	}
}