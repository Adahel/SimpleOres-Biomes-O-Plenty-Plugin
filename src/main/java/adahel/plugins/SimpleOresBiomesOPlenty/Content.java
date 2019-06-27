package adahel.plugins.SimpleOresBiomesOPlenty;

import alexndr.api.content.items.SimpleBucket;
import alexndr.api.helpers.game.TabHelper;
import alexndr.plugins.SimpleOres.Settings;
import alexndr.plugins.SimpleOres.SimpleOres;
import biomesoplenty.api.block.BOPBlocks;
import net.minecraft.item.Item;

public class Content {
	public static void preInitialize() {
		doItems();
		doTools();
	}
	
	public static void doItems() {
		copper_bucket_honey = new SimpleBucket(SimpleOresBiomesOPlenty.plugin, BOPBlocks.honey, SimpleOres.copperBucketType).setConfigEntry(Settings.copperBucket).setContainerItem(getCopperBucket()).setUnlocalizedName("copper_bucket_honey");
		copper_bucket_blood = new SimpleBucket(SimpleOresBiomesOPlenty.plugin, BOPBlocks.blood, SimpleOres.copperBucketType).setConfigEntry(Settings.copperBucket).setContainerItem(getCopperBucket()).setUnlocalizedName("copper_bucket_blood");
		copper_bucket_poison = new SimpleBucket(SimpleOresBiomesOPlenty.plugin, BOPBlocks.poison, SimpleOres.copperBucketType).setConfigEntry(Settings.copperBucket).setContainerItem(getCopperBucket()).setUnlocalizedName("copper_bucket_poison");
		copper_bucket_hot_spring_water = new SimpleBucket(SimpleOresBiomesOPlenty.plugin, BOPBlocks.hot_spring_water, SimpleOres.copperBucketType).setConfigEntry(Settings.copperBucket).setContainerItem(getCopperBucket()).setUnlocalizedName("copper_bucket_hot_spring_water");
	}
	
	public static void doTools() {
		copper_scythe = new SimpleScythe(SimpleOresBiomesOPlenty.plugin, SimpleOres.toolCopper).setConfigEntry(Settings.copperTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("copper_scythe");
		tin_scythe = new SimpleScythe(SimpleOresBiomesOPlenty.plugin, SimpleOres.toolTin).setConfigEntry(Settings.tinTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("tin_scythe");
		mythril_scythe = new SimpleScythe(SimpleOresBiomesOPlenty.plugin, SimpleOres.toolMythril).setConfigEntry(Settings.mythrilTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("mythril_scythe");
		adamantium_scythe = new SimpleScythe(SimpleOresBiomesOPlenty.plugin, SimpleOres.toolAdamantium).setConfigEntry(Settings.adamantiumTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("adamantium_scythe");
		onyx_scythe = new SimpleScythe(SimpleOresBiomesOPlenty.plugin, SimpleOres.toolOnyx).setConfigEntry(Settings.onyxTools).setCreativeTab(TabHelper.toolsTab()).setUnlocalizedName("onyx_scythe");
	}
	
	public static Item getCopperBucket() {
		return alexndr.plugins.SimpleOres.Content.copper_bucket;
	}
	
	public static Item copper_bucket_honey, copper_bucket_blood, copper_bucket_poison, copper_bucket_hot_spring_water;
	
	public static Item copper_scythe, tin_scythe, mythril_scythe, adamantium_scythe, onyx_scythe;
}
