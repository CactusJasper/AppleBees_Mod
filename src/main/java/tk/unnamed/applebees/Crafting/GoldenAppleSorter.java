package tk.unnamed.applebees.Crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class GoldenAppleSorter implements Comparator {

	final GoldenAppleCraftingManager workSurface;
	
	public GoldenAppleSorter(GoldenAppleCraftingManager workSurfaceCraftingManager) {
		this.workSurface = workSurfaceCraftingManager;
	}
	
	public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2) {
		return irecipe1 instanceof GoldenAppleShaplessRecipes && irecipe2 instanceof GoldenAppleShapedRecipes ? 1: (irecipe2 instanceof GoldenAppleShaplessRecipes && irecipe1 instanceof GoldenAppleShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
	}
}
