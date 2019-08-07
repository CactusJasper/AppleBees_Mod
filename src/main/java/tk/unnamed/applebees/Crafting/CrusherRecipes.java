package tk.unnamed.applebees.Crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import tk.unnamed.applebees.Items.ItemManager;

public class CrusherRecipes {

	private static final CrusherRecipes crushingBase = new CrusherRecipes();
    /** The list of crushing results. */
    private Map crushingList = new HashMap();
    private Map experienceList = new HashMap();
    
    public static CrusherRecipes crushing()
    {
        return crushingBase;
    }
    
    private CrusherRecipes()
    {
    	this.registerBlockRecipe(Blocks.iron_ore, new ItemStack(ItemManager.ironDust, 4), 1.0F);
    	this.registerBlockRecipe(Blocks.gold_ore, new ItemStack(ItemManager.goldDust, 2), 1.0F);
        this.registerBlockRecipe(Blocks.diamond_ore, new ItemStack(ItemManager.diamondDust, 3), 1.0F);
        this.registerBlockRecipe(Blocks.emerald_ore, new ItemStack(ItemManager.emeraldDust, 2), 1.0F);
    }
    
    public void registerBlockRecipe(Block input, ItemStack output, float exp)
    {
        this.registerItemRecipe(Item.getItemFromBlock(input), output, exp);
    }
    
    public void registerItemRecipe(Item input, ItemStack output, float exp)
    {
        this.registerRecipe(new ItemStack(input, 1, 32767), output, exp);
    }
    
    public void registerRecipe(ItemStack input, ItemStack output, float exp)
    {
        this.crushingList.put(input, output);
        this.experienceList.put(output, Float.valueOf(exp));
    }
    
    public ItemStack getCrushingResult(ItemStack input)
    {
        Iterator iterator = this.crushingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.getResult(input, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }
    
    private boolean getResult(ItemStack input, ItemStack output)
    {
        return output.getItem() == input.getItem() && (output.getItemDamage() == 32767 || output.getItemDamage() == input.getItemDamage());
    }
    
    public Map getCurshingList()
    {
        return this.crushingList;
    }
}
