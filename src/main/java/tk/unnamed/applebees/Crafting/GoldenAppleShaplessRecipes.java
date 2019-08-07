package tk.unnamed.applebees.Crafting;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class GoldenAppleShaplessRecipes implements IRecipe {

	/** Is the ItemStack that you get when craft the recipe. */
    private final ItemStack recipeOutput;
    /** Is a List of ItemStack that composes the recipe. */
    public final List recipeItems;
    
    public GoldenAppleShaplessRecipes(ItemStack stack, List items)
    {
        this.recipeOutput = stack;
        this.recipeItems = items;
    }

    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }
    
    public boolean matches(InventoryCrafting inv, World world)
    {
        ArrayList arraylist = new ArrayList(this.recipeItems);

        for (int i = 0; i < 5; ++i)
        {
            for (int j = 0; j < 1; ++j)
            {
                ItemStack itemstack = inv.getStackInRowAndColumn(j, i);

                if (itemstack != null)
                {
                    boolean flag = false;
                    Iterator iterator = arraylist.iterator();

                    while (iterator.hasNext())
                    {
                        ItemStack itemstack1 = (ItemStack)iterator.next();

                        if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getItemDamage() == 32767 || itemstack.getItemDamage() == itemstack1.getItemDamage()))
                        {
                            flag = true;
                            arraylist.remove(itemstack1);
                            break;
                        }
                    }

                    if (!flag)
                    {
                        return false;
                    }
                }
            }
        }

        return arraylist.isEmpty();
    }
    
    public ItemStack getCraftingResult(InventoryCrafting inv)
    {
        return this.recipeOutput.copy();
    }

    public int getRecipeSize()
    {
        return this.recipeItems.size();
    }
}
