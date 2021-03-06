package net.bvanseghi.starcraft.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemZergStructureCarapaceBlocks extends ItemBlock {

	public ItemZergStructureCarapaceBlocks(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public static final String[] names = new String[] { "T1", "T2", "T3" };
	
	public String getUnlocalizedName(ItemStack itemstack) {
		int i = itemstack.getItemDamage();
		if (i < 0 || i >= names.length) {
			i = 0;
		}
		
		return super.getUnlocalizedName() + "." + names[i];
	}
	
	public int getMetadata(int meta) {
		return meta;
	}
}


