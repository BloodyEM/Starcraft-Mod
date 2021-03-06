package net.bvanseghi.starcraft.lib;

import net.minecraft.block.Block;
import net.minecraft.world.World;

/**
 * Copyright 2016 the Starcraft Minecraft mod team
 * @author wundrweapon
 */
public class Library {
	
	/**
	 * Makes a cube out of {@code block}.
	 * Anchor: bottom-middle
	 * @param world the world
	 * @param block the block to make a
	 * cube of
	 * @param x the X coordinate of the
	 * anchor position
	 * @param y the Y coordinate of the
	 * anchor position
	 * @param z the Z coordinate of the
	 * anchor position
	 */
	public static void blockCube(World world, Block block, int x, int y, int z) {
		boolean killLoop = false;
		int yOffsetIndex = 0;
		int zOffsetIndex = 0;
		int[] xzOffsets = {-1, 0, 1};
		int[] yOffsets = {0, 1, 2};
		
		for(int xOffsetIndex = 0; xOffsetIndex < 3; xOffsetIndex++) {
			
			//Don't place block at anchor
			if(xzOffsets[xOffsetIndex] != 0 || xzOffsets[zOffsetIndex] != 0) {
				world.setBlock(x + xzOffsets[xOffsetIndex], y + yOffsets[yOffsetIndex], z + xzOffsets[zOffsetIndex], block);
			} else if(yOffsets[yOffsetIndex] != 0) {
				world.setBlock(x + xzOffsets[xOffsetIndex], y + yOffsets[yOffsetIndex], z + xzOffsets[zOffsetIndex], block);
			}
			
			//Reset X index to 0 after going past the final column
			if(xOffsetIndex + 1 == 3) {
				xOffsetIndex = -1;
				zOffsetIndex++;
				
				//Reset Z index and raise Y index after going past the final row
				if(zOffsetIndex == 3) {
					zOffsetIndex = 0;
					yOffsetIndex++;
					
					if(yOffsetIndex == 3) {
						killLoop = true;
					}
				}
			}
			
			if(killLoop) {
				break;
			}
		}
	}
	
	/**
	 * Checks a 3x3x3 area for any instances
	 * of {@code block}. The center is in
	 * the absolute center of the cube
	 * @param world the world
	 * @param block the {@link Block} to check for
	 * @param x center X coord
	 * @param y center Y coord
	 * @param z center Z coord
	 * @return true if at least one instance
	 * of {@code block} is found
	 */
	public static boolean checkCube(World world, Block block, int x, int y, int z) {
		int yOffsetIndex = 0;
		int zOffsetIndex = 0;
		int[] offsets = {-1, 0, 1};
		
		for(int xOffsetIndex = 0; xOffsetIndex < 3; xOffsetIndex++) {
			if(world.getBlock(x + offsets[xOffsetIndex], y + offsets[yOffsetIndex], z + offsets[zOffsetIndex]) == block) {
				return true;
			} else {
				if(xOffsetIndex == 2) {
					xOffsetIndex = -1;
					zOffsetIndex++;
				}
				
				if(zOffsetIndex == 3) {
					zOffsetIndex = 0;
					yOffsetIndex++;
				}
				
				if(yOffsetIndex == 3) {
					return false;
				}
			}
		}
		
		return false; //Won't run
	}
}
