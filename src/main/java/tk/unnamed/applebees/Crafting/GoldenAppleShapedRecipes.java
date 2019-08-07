package tk.unnamed.applebees.Crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class GoldenAppleShapedRecipes implements IRecipe {

	/** How many horizontal slots this recipe is wide. */
    public final int recipeWidth;
    /** How many vertical slots this recipe uses. */
    public final int recipeHeight;
    /** Is a array of ItemStack that composes the recipe. */
    public final ItemStack[] recipeItems;
    /** Is the ItemStack that you get when craft the recipe. */
    private ItemStack recipeOutput;
    private boolean field_92101_f;
    
    public GoldenAppleShapedRecipes(int width, int height, ItemStack[] items, ItemStack result) {
    	this.recipeWidth = width;
        this.recipeHeight = height;
        this.recipeItems = items;
        this.recipeOutput = result;
    }
    
    public ItemStack getRecipeOutput()
    {
        return this.recipeOutput;
    }
    
    public boolean matches(InventoryCrafting inv, World world)
    {
        for (int i = 0; i <= 1 - this.recipeWidth; ++i)
        {
            for (int j = 0; j <= 5 - this.recipeHeight; ++j)
            {
                if (this.checkMatch(inv, i, j, true))
                {
                    return true;
                }

                if (this.checkMatch(inv, i, j, false))
                {
                    return true;
                }
            }
        }

        return false;
    }
    
    private boolean checkMatch(InventoryCrafting inv, int height, int width, boolean p_77573_4_)
    {
        for (int k = 0; k < 5; ++k)
        {
            for (int l = 0; l < 1; ++l)
            {
                int i1 = k - height;
                int j1 = l - width;
                ItemStack itemstack = null;

                if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
                {
                    if (p_77573_4_)
                    {
                        itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
                    }
                    else
                    {
                        itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
                    }
                }

                ItemStack itemstack1 = inv.getStackInRowAndColumn(k, l);

                if (itemstack1 != null || itemstack != null)
                {
                    if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
                    {
                        return false;
                    }

                    if (itemstack.getItem() != itemstack1.getItem())
                    {
                        return false;
                    }

                    if (itemstack.getItemDamage() != 32767 && itemstack.getItemDamage() != itemstack1.getItemDamage())
                    {
                        return false;
                    }
                }
            }
        }

        return true;
    }
    
    public ItemStack getCraftingResult(InventoryCrafting inv)
    {
        ItemStack itemstack = this.getRecipeOutput().copy();

        if (this.field_92101_f)
        {
            for (int i = 0; i < inv.getSizeInventory(); ++i)
            {
                ItemStack itemstack1 = inv.getStackInSlot(i);

                if (itemstack1 != null && itemstack1.hasTagCompound())
                {
                    itemstack.setTagCompound((NBTTagCompound)itemstack1.stackTagCompound.copy());
                }
            }
        }

        return itemstack;
    }
    
    public int getRecipeSize()
    {
        return this.recipeWidth * this.recipeHeight;
    }

    public GoldenAppleShapedRecipes func_92100_c()
    {
        this.field_92101_f = true;
        return this;
    }
}
