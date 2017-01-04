package net.bvanseghi.starcraft.items;

import net.bvanseghi.starcraft.CreativeTab;
import net.bvanseghi.starcraft.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBucket;

public class ItemBloodBucket extends ItemBucket {

	public ItemBloodBucket(Block block) {
		super(block);

		setRegistryName(Reference.MODID + ":bloodBucket");
		this.setCreativeTab(CreativeTab.TabStarcraftMisc);

	}

}
