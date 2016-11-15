package net.bvanseghi.starcraft.events;

import net.bvanseghi.starcraft.items.ModItems;
import net.bvanseghi.starcraft.tools.ModTools;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class Registry {
	private static Item[] items = {ModItems.acidBucket, ModItems.bloodBucket, ModItems.C14GaussRifle, ModItems.C14GaussRifleBullet, ModItems.c14Parts, ModItems.coord, ModItems.creepResin, ModItems.darkPsiBladeFocuserUncharged, ModItems.dust, ModItems.energy, ModItems.essence, ModItems.ingot, ModItems.mineralShard, ModItems.organicTissue, ModItems.protossArtifact, ModItems.protossModule, ModItems.psiBladeFocuserUncharged, ModItems.richMineralShard, ModItems.uraj, ModItems.vespene, ModItems.zergCarapace};
	private static Item[] tools = {ModTools.copperAxe, ModTools.copperHoe, ModTools.copperPickaxe, ModTools.copperShovel}; //TODO: add the other tools
	
	@SubscribeEvent
	public static void register(Register<Item> registry) {
		registry.getRegistry().registerAll(items); //Register ModItems
		registry.getRegistry().registerAll(tools); //Register ModTools
	}
}