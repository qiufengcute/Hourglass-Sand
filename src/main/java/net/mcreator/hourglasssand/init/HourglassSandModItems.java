/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.hourglasssand.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.hourglasssand.item.HourglassSandItem;
import net.mcreator.hourglasssand.HourglassSandMod;

import java.util.function.Function;

public class HourglassSandModItems {
	public static Item HOURGLASS_SAND;

	public static void load() {
		HOURGLASS_SAND = register("hourglass_sand", HourglassSandItem::new);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> I register(String name, Function<Item.Properties, ? extends I> supplier) {
		return (I) Items.registerItem(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(HourglassSandMod.MODID, name)), (Function<Item.Properties, Item>) supplier);
	}
}