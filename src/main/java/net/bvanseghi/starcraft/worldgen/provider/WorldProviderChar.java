package net.bvanseghi.starcraft.worldgen.provider;

import net.bvanseghi.starcraft.lib.StarcraftConfig;
import net.bvanseghi.starcraft.worldgen.chunk.ChunkProviderChar;
import net.bvanseghi.starcraft.worldgen.manager.WorldChunkManagerChar;
import net.minecraft.entity.Entity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderChar extends WorldProvider {
	World world;
	
	@Override
	public String getDimensionName() {
		return "Char";
	}

	@Override
	public void registerWorldChunkManager() {
		this.worldChunkMgr = new WorldChunkManagerChar(this.getSeed(), terrainType);
		this.dimensionId = StarcraftConfig.dimChar;
		this.hasNoSky = false;

	}

	/**
	 * Returns a new chunk provider which generates chunks for this world
	 */
	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderChar(this.worldObj, this.worldObj.getSeed(), true);
	}

	@Override
	public boolean canRespawnHere() {
		return true; // I'm assuming you should be able to respawn on Char
	}
	 
	@Override
	public float calculateCelestialAngle(long par1, float par2) {
		int j = (int) (par1 % 24000L);
		float f1 = ((float) j + par2) / 24000.0F - 0.25F;

		if (f1 < 0.0F) {
			++f1;
		}

		if (f1 > 1.0F) {
			--f1;
		}

		float f2 = f1;
		f1 = 1.0F - (float) ((Math.cos((double) f1 * Math.PI) + 1.0D) / 2.0D);
		f1 = f2 + (f1 - f2) / 3.0F;
		return f1;
	}

	/**
	 * Returns 'true' if in the "main surface world", but 'false' if in the
	 * Nether or End dimensions.
	 */
	@Override
	public boolean isSurfaceWorld() {
		return true; // Needed to make sun/sky work
	}

	@Override
	public boolean doesXZShowFog(int par1, int par2) {
		return false;
	}

	@Override
	public boolean isSkyColored() {
		return true;
	}

	@Override
	public Vec3 getSkyColor(Entity cameraEntity, float partialTicks) {
		return Vec3.createVectorHelper(0, 0, 0);
	}
}
