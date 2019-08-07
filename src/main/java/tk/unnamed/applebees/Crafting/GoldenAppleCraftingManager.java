package tk.unnamed.applebees.Crafting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.world.World;

public class GoldenAppleCraftingManager {

	public static final GoldenAppleCraftingManager instance = new GoldenAppleCraftingManager();
	private List recipes = new ArrayList();
	
	public static final GoldenAppleCraftingManager getInstance() {
		return instance;
	}
	
	private GoldenAppleCraftingManager() {
		this.addRecipe(new ItemStack(Blocks.anvil), new Object[] {"#", "#", "#", "#", "#", '#', new ItemStack(Items.apple)});
		
		Collections.sort(this.recipes, new GoldenAppleSorter(this));
		
		System.out.println(recipes);
	}
	
	public GoldenAppleShapedRecipes addRecipe(ItemStack stack, Object ... parms)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if(parms[i] instanceof String[])
        {
            String[] astring = (String[])((String[])parms[i++]);

            for (int o = 0; o < astring.length; ++o)
            {
                String so = astring[o];
                ++k;
                j = so.length();
                s = s + so;
            }
        }
        else
        {
            while (parms[i] instanceof String)
            {
                String s2 = (String)parms[i++];
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }

        HashMap hashmap;

        for (hashmap = new HashMap(); i < parms.length; i += 2)
        {
            Character character = (Character)parms[i];
            ItemStack itemstack1 = null;

            if (parms[i + 1] instanceof Item)
            {
                itemstack1 = new ItemStack((Item)parms[i + 1]);
            }
            else if (parms[i + 1] instanceof Block)
            {
                itemstack1 = new ItemStack((Block)parms[i + 1], 1, 32767);
            }
            else if (parms[i + 1] instanceof ItemStack)
            {
                itemstack1 = (ItemStack)parms[i + 1];
            }

            hashmap.put(character, itemstack1);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int i1 = 0; i1 < j * k; ++i1)
        {
            char c0 = s.charAt(i1);

            if (hashmap.containsKey(Character.valueOf(c0)))
            {
                aitemstack[i1] = ((ItemStack)hashmap.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[i1] = null;
            }
        }

        GoldenAppleShapedRecipes shapedrecipes = new GoldenAppleShapedRecipes(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }
	
	public void addShapelessRecipe(ItemStack stack, Object ... parms)
    {
        ArrayList arraylist = new ArrayList();
        Object[] aobject = parms;
        int i = parms.length;

        for (int j = 0; j < i; ++j)
        {
            Object object1 = aobject[j];

            if (object1 instanceof ItemStack)
            {
                arraylist.add(((ItemStack)object1).copy());
            }
            else if (object1 instanceof Item)
            {
                arraylist.add(new ItemStack((Item)object1));
            }
            else
            {
                if (!(object1 instanceof Block))
                {
                    throw new RuntimeException("Invalid shapeless recipy!");
                }

                arraylist.add(new ItemStack((Block)object1));
            }
        }

        this.recipes.add(new GoldenAppleShaplessRecipes(stack, arraylist));
    }
	
	public ItemStack findMatchingRecipe(InventoryCrafting inv, World world)
    {
        int i = 0;
        ItemStack itemstack = null;
        ItemStack itemstack1 = null;
        int j;

        for (j = 0; j < inv.getSizeInventory(); ++j)
        {
            ItemStack itemstack2 = inv.getStackInSlot(j);

            if (itemstack2 != null)
            {
                if (i == 0)
                {
                    itemstack = itemstack2;
                }

                if (i == 1)
                {
                    itemstack1 = itemstack2;
                }

                ++i;
            }
        }
        
        if (i == 2 && itemstack.getItem() == itemstack1.getItem() && itemstack.stackSize == 1 && itemstack1.stackSize == 1 && itemstack.getItem().isRepairable())
        {
            Item item = itemstack.getItem();
            int j1 = item.getMaxDamage() - itemstack.getItemDamageForDisplay();
            int k = item.getMaxDamage() - itemstack1.getItemDamageForDisplay();
            int l = j1 + k + item.getMaxDamage() * 5 / 100;
            int i1 = item.getMaxDamage() - l;

            if (i1 < 0)
            {
                i1 = 0;
            }

            return new ItemStack(itemstack.getItem(), 1, i1);
        }
        else
        {
            for (j = 0; j < this.recipes.size(); ++j)
            {
                IRecipe irecipe = (IRecipe)this.recipes.get(j);

                if (irecipe.matches(inv, world))
                {
                    return irecipe.getCraftingResult(inv);
                }
            }

            return null;
        }
    }
	
	public List getRecipeList()
    {
        return this.recipes;
    }
}
