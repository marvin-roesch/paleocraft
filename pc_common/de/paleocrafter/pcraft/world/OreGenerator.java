package de.paleocrafter.pcraft.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import de.paleocrafter.pcraft.lib.BlockIds;

/**
 * PaleoCraft
 * 
 * OreGenerator
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class OreGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
            IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.isSurfaceWorld()) {
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSurface(World world, Random random, int x, int z) {
        for (int i = 0; i < 3; i++) {
            int fosX = x + random.nextInt(16);
            int fosY = random.nextInt(32);
            int fosZ = z + random.nextInt(16);

            WorldGenMinable block = new WorldGenMinable(BlockIds.FOSSILE, 2);
            block.generate(world, random, fosX, fosY, fosZ);
        }
        
        for (int i = 0; i < 3; i++) {
            int fosX = x + random.nextInt(16);
            int fosY = random.nextInt(96);
            if(fosY < 55) {
                fosY = 55 + random.nextInt(16);
            }
            int fosZ = z + random.nextInt(16);

            WorldGenMinable block = new WorldGenMinable(BlockIds.AMMONITE, 2);
            block.generate(world, random, fosX, fosY, fosZ);
        }
    }

}
