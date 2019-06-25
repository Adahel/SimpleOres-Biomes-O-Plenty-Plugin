package adahel.plugins.SimpleOresBiomesOPlenty;

import alexndr.api.helpers.game.RenderItemHelper;
import alexndr.api.logger.LogHelper;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import alexndr.plugins.SimpleOres.SimpleOres;
import biomesoplenty.api.block.BOPBlocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION, 
dependencies = "required-after:simpleores;required-after:BiomesOPlenty")
public class SimpleOresBiomesOPlenty {
	public static Plugin plugin = new Plugin(ModInfo.ID, ModInfo.NAME);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LogHelper.info("SimpleOresBiomesOPlenty", "Loading...");
		//Configuration
		ContentRegistry.registerPlugin(plugin);
		//Content
		Content.preInitialize();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		if(event.getSide() == Side.CLIENT) 
		{
			RenderItemHelper.renderItemsAndBlocks(plugin);
		}
		//Content
		Recipes.initialize();
		setBucketVariants();
	}
	
	private static void setBucketVariants() {
		LogHelper.verbose("SimpleOresBiomesOPlenty", "Setting bucket variants");
		SimpleOres.copperBucketType.addVariant("honey", Content.copper_bucket_honey, BOPBlocks.honey);
		SimpleOres.copperBucketType.addVariant("blood", Content.copper_bucket_blood, BOPBlocks.blood);
		SimpleOres.copperBucketType.addVariant("poison", Content.copper_bucket_poison, BOPBlocks.poison);
		SimpleOres.copperBucketType.addVariant("hot_spring_water", Content.copper_bucket_hot_spring_water, BOPBlocks.hot_spring_water);
	}
}
