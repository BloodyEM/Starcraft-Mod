package net.bvanseghi.starcraft.handlers;

import net.bvanseghi.starcraft.items.ModItems;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {

		if (fuel.getItem() == ModItems.vespene)
			return 3200;

		return 0;
	}

	public static void preInit() {
		GameRegistry.registerFuelHandler(new FuelHandler());
	}

}
