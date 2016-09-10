package net.bvanseghi.starcraft.blocks;

import java.util.ArrayList;
import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.bvanseghi.starcraft.CreativeTab;
import net.bvanseghi.starcraft.lib.REFERENCE;
import net.bvanseghi.starcraft.model.ModelWarpGateWormholeChar;
import net.bvanseghi.starcraft.tileentity.TileEntityBlockWarpGateWormholeChar;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockWarpGateWormholeChar extends BlockContainer {

	public static final String name = "warpGateWormholeChar";

	public BlockWarpGateWormholeChar(Material material) {
		super(material);

		setStepSound(soundTypeStone);
		setHardness(5.0F);
		setResistance(0.0F);
		this.setLightLevel(1.0F);
		this.setCreativeTab(null);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(REFERENCE.MODID + ":" + "mineralField");
	}

	public int getRenderType() {
		return -1;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World par1, int par2) {
		return new TileEntityBlockWarpGateWormholeChar();
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		
		
		world.setBlock(x + 1, y, z, ModBlocks.dimPortalChar);
		world.setBlock(x + 1, y, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x, y, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y, z, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y, z - 1, ModBlocks.dimPortalChar);
		world.setBlock(x, y, z - 1, ModBlocks.dimPortalChar);
		world.setBlock(x + 1, y, z - 1, ModBlocks.dimPortalChar);

		world.setBlock(x + 1, y + 1, z, ModBlocks.dimPortalChar);
		world.setBlock(x + 1, y + 1, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x, y + 1, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y + 1, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y + 1, z, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y + 1, z - 1, ModBlocks.dimPortalChar);
		world.setBlock(x, y + 1, z - 1, ModBlocks.dimPortalChar);
		world.setBlock(x + 1, y + 1, z - 1, ModBlocks.dimPortalChar);
		world.setBlock(x, y + 1, z, ModBlocks.dimPortalChar);

		world.setBlock(x + 1, y + 2, z, ModBlocks.dimPortalChar);
		world.setBlock(x + 1, y + 2, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x, y + 2, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y + 2, z + 1, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y + 2, z, ModBlocks.dimPortalChar);
		world.setBlock(x - 1, y + 2, z - 1, ModBlocks.dimPortalChar);
		world.setBlock(x, y + 2, z - 1, ModBlocks.dimPortalChar);
		world.setBlock(x + 1, y + 2, z - 1, ModBlocks.dimPortalChar);
		world.setBlock(x, y + 2, z, ModBlocks.dimPortalChar);
		
	}

}
