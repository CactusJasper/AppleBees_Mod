package tk.unnamed.applebees.TerrainGen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import tk.unnamed.applebees.Blocks.BlockManager;

public class AppleBeesOreGenration implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
			// End
			case 1:
				this.generateEnd(world, random, chunkX, chunkZ);
				break;
			// Overworld
			case 0:
				this.generateOverworld(world, random, chunkX, chunkZ);
				break;
			// Neather
			case -1:
				this.generateNether(world, random, chunkX, chunkZ);
				break;
		}
	}

	public void generateEnd(World world, Random rand, int x, int z) {
		this.generateOre(BlockManager.appleOre, world, rand, x, z, 1, 4, 2, 5, 30, Blocks.end_stone);
		this.generateOre(BlockManager.goldenAppleOre, world, rand, x, z, 1, 2, 1, 5, 15, Blocks.end_stone);
	}
	
	public void generateOverworld(World world, Random rand, int x, int z) {
		this.generateOre(BlockManager.appleOre, world, rand, x, z, 1, 4, 2, 20, 100, Blocks.stone);
		this.generateOre(BlockManager.goldenAppleOre, world, rand, x, z, 1, 2, 1, 10, 100, Blocks.stone);
	}
	
	public void generateNether(World world, Random rand, int x, int z) {
		this.generateOre(BlockManager.appleBlock, world, rand, x, z, 1, 4, 2, 5, 40, Blocks.netherrack);
		this.generateOre(BlockManager.goldenAppleBlock, world, rand, x, z, 1, 2, 1, 5, 20, Blocks.netherrack);
	}
	
	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize, int maxVeinSize, int chance, int minY, int maxY, Block generateIn) {
		if(minY < 0 || maxY > 256 || minY > maxY) {
            throw new IllegalArgumentException("Illegal height argument for genration!");
		}
		
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
		for(int i = 0; i < chance; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
}
