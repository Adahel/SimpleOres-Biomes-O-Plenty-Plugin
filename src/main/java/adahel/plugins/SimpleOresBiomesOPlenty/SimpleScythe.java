package adahel.plugins.SimpleOresBiomesOPlenty;

import alexndr.api.config.types.ConfigTool;
import alexndr.api.helpers.game.TooltipHelper;
import alexndr.api.registry.ContentCategories;
import alexndr.api.registry.ContentRegistry;
import alexndr.api.registry.Plugin;
import alexndr.plugins.SimpleOres.SimpleOres;
import biomesoplenty.common.item.ItemBOPScythe;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SimpleScythe extends ItemBOPScythe {
	private Plugin plugin;
	private ContentCategories.Item category = ContentCategories.Item.TOOL;
	private ConfigTool entry;
	
	public SimpleScythe(Plugin plugin, ToolMaterial material) {
		super(material);
		this.plugin = plugin;
	}
	
	@Override
	public SimpleScythe setUnlocalizedName(String scytheName) {
		super.setUnlocalizedName(scytheName);
		GameRegistry.registerItem(this, scytheName);
		ContentRegistry.registerItem(this.plugin, this, scytheName, this.category);
		this.setHarvestLevel("axe", entry.getHarvestLevel());
		return this;
	}
	
	/**
	 * Returns the ConfigTool used by this tool.
	 * @return ConfigTool
	 */
	public ConfigTool getConfigEntry() {
		return this.entry;
	}
	
	/**
	 * Sets the ConfigTool to be used for this tool.
	 * @param entry ConfigTool
	 * @return SimpleScythe
	 */
	public SimpleScythe setConfigEntry(ConfigTool entry) {
		this.entry = entry;
		this.setAdditionalProperties();
		return this;
	}
	
	/**
	 * Adds a tooltip to the tool. Must be unlocalised, so needs to be present in a localization file.
	 * @param toolTip Name of the localisation entry for the tooltip, as a String. Normal format is modId.theitem.info
	 * @return SimpleScythe
	 */
	public SimpleScythe addToolTip(String toolTip) {
		TooltipHelper.addTooltipToItem(this, toolTip);
		return this;
	}
	
	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return this.toolMaterial.getRepairItemStack().getItem() == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
	}
	
	public void setAdditionalProperties() {
		if(entry.getValueByName("CreativeTab") != null && entry.getValueByName("CreativeTab").isActive()) {
			this.setCreativeTab(entry.getCreativeTab());
		}
	}
	
    @Override
    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn) {

        if (blockIn == null || worldIn.getBlockState(pos).getBlock() == Blocks.air) {return false;}
                        
        boolean isLeaves = blockIn.isLeaves(worldIn, pos);        
        
        int radius = isLeaves ? 0 : 3;
        int height = isLeaves ? 0 : 4;
        if (toolMaterial == SimpleOres.toolCopper || toolMaterial == SimpleOres.toolTin) {
            radius = 4;
            height = 4;
        }
        else if (toolMaterial == SimpleOres.toolAdamantium || toolMaterial == SimpleOres.toolMythril) {
            radius = 5;
            height = 5;
        }
        else if (toolMaterial == SimpleOres.toolOnyx) {
            radius = 6;
            height = 6;
        }
        
        // automatically damage the item once - for the block originally destroyed
        stack.damageItem(1, playerIn);
        
        int numberTrimmed = 0;
        if (isLeaves) {
            numberTrimmed += trim(stack, playerIn, worldIn, pos, height, radius, TrimType.TRIM_LEAVES, false, 40);
        }
        else {
            // trim once with the corners cut
            numberTrimmed += trim(stack, playerIn, worldIn, pos, height, radius, TrimType.TRIM_GRASS_AND_FLOWERS, true, 70);
            if (worldIn.rand.nextInt(3) == 0) {
                // with one in 3 chance, also do another 'free' trim of a smaller radius, without the corners cut
                // ('free' in the sense that it does not damage the scythe)
                numberTrimmed += trim(stack, playerIn, worldIn, pos, height, radius - 1, TrimType.TRIM_GRASS_AND_FLOWERS, false, 0);
            }
        }
        return numberTrimmed > 0;
    }
}
