package adahel.plugins.SimpleOresBiomesOPlenty;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class Recipes {
	public static void initialize() {
		addRecipes();
	}
	
	private static void addRecipes() {
		addToolRecipes();
	}
	
	private static void addToolRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Content.copper_scythe), new Object [] {" XX", "X Y", "  Y", 'X', "ingotCopper", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Content.tin_scythe), new Object [] {" XX", "X Y", "  Y", 'X', "ingotTin", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Content.mythril_scythe), new Object [] {" XX", "X Y", "  Y", 'X', "ingotMythril", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Content.adamantium_scythe), new Object [] {" XX", "X Y", "  Y", 'X', "ingotAdamantium", 'Y', "stickWood" }));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Content.onyx_scythe), new Object [] {" XX", "X Y", "  Y", 'X', "gemOnyx", 'Y', "stickWood" }));
		}
}
