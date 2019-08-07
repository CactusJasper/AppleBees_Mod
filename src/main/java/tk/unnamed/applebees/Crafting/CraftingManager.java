package tk.unnamed.applebees.Crafting;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import tk.unnamed.applebees.Blocks.BlockManager;
import tk.unnamed.applebees.Items.ItemManager;

public class CraftingManager {
	
	// Machine Blocks
	public static ItemStack appleChest = new ItemStack(BlockManager.appleChest);
	public static ItemStack appleTable = new ItemStack(BlockManager.appleTable);
	public static ItemStack appleFurnace = new ItemStack(BlockManager.appleFurnaceIdle);
	public static ItemStack appleCrusher = new ItemStack(BlockManager.appleCrusherIdle);
	
	public static ItemStack goldenAppleChest = new ItemStack(BlockManager.goldenAppleChest);
	public static ItemStack goldenAppleFurnace = new ItemStack(BlockManager.goldenAppleFurnaceIdle);
	
	// Base Items
	public static ItemStack obsidianStick = new ItemStack(ItemManager.obsidianStick);
	public static ItemStack appleBlock = new ItemStack(BlockManager.appleBlock);
	public static ItemStack appleCraftingCore = new ItemStack(ItemManager.appleCraftingCore);
	public static ItemStack goldenAppleBlock = new ItemStack(BlockManager.goldenAppleBlock);
	public static ItemStack armorFoamPadding = new ItemStack(ItemManager.armorFoamPadding);
	
	// Dusts
	public static ItemStack ironDust = new ItemStack(ItemManager.ironDust);
	public static ItemStack goldDust = new ItemStack(ItemManager.goldDust);
	public static ItemStack diamondDust = new ItemStack(ItemManager.diamondDust);
	public static ItemStack emeraldDust = new ItemStack(ItemManager.emeraldDust);
	
	// Tool Parts
	public static ItemStack applePickaxeHead = new ItemStack(ItemManager.applePickaxeHead);
	public static ItemStack appleAxeHead = new ItemStack(ItemManager.appleAxeHead);
	public static ItemStack appleShovelHead = new ItemStack(ItemManager.appleShovelHead);
	public static ItemStack appleHoeHead = new ItemStack(ItemManager.appleHoeHead);
	public static ItemStack appleSwordBlade = new ItemStack(ItemManager.appleSwordBlade);
	public static ItemStack appleSwordHilt = new ItemStack(ItemManager.appleSwordHilt);
	
	public static ItemStack goldenApplePickaxeHead = new ItemStack(ItemManager.goldenApplePickaxeHead);
	public static ItemStack goldenAppleBlastCore = new ItemStack(ItemManager.goldenAppleBlastCore);
	public static ItemStack goldenAppleAxeHead = new ItemStack(ItemManager.goldenAppleAxeHead);
	public static ItemStack goldenAppleShovelHead = new ItemStack(ItemManager.goldenAppleShovelHead);
	public static ItemStack goldenAppleHoeHead = new ItemStack(ItemManager.goldenAppleHoeHead);
	public static ItemStack goldenAppleSwordBlade = new ItemStack(ItemManager.goldenAppleSwordBlade);
	public static ItemStack goldenAppleSwordHilt = new ItemStack(ItemManager.goldenAppleSwordHilt);
	
	// Tools
	public static ItemStack applePickaxe = new ItemStack(ItemManager.applePickaxe);
	public static ItemStack appleAxe = new ItemStack(ItemManager.appleAxe);
	public static ItemStack appleShovel = new ItemStack(ItemManager.appleShovel);
	public static ItemStack appleHoe = new ItemStack(ItemManager.appleHoe);
	public static ItemStack appleSword = new ItemStack(ItemManager.appleSword);
	
	public static ItemStack goldenApplePickaxe = new ItemStack(ItemManager.goldenApplePickaxe);
	public static ItemStack goldenAppleAxe = new ItemStack(ItemManager.goldenAppleAxe);
	public static ItemStack goldenAppleShovel = new ItemStack(ItemManager.goldenAppleShovel);
	public static ItemStack goldenAppleHoe = new ItemStack(ItemManager.goldenAppleHoe);
	public static ItemStack goldenAppleSword = new ItemStack(ItemManager.goldenAppleSword);
			
	// Armour Parts
	public static ItemStack appleChainmailPiece = new ItemStack(ItemManager.appleChainmailPiece);
	public static ItemStack appleChestplateChainmail = new ItemStack(ItemManager.appleChestplateChainmail);
	public static ItemStack appleChestplateInnerArmor = new ItemStack(ItemManager.appleChestplateInnerArmor);
	public static ItemStack appleChestplateOuterArmor = new ItemStack(ItemManager.appleChestplateOuterArmor);
	
	public static ItemStack appleLeggingsLeftLeg = new ItemStack(ItemManager.goldenAppleLeggingsLeftLeg);
	public static ItemStack appleLeggingsRightLeg = new ItemStack(ItemManager.goldenAppleLeggingsRightLeg);
	
	public static ItemStack appleBootLeft = new ItemStack(ItemManager.appleBootLeft);
	public static ItemStack appleBootRight = new ItemStack(ItemManager.appleBootRight);
	
	public static ItemStack goldenAppleChainmailPiece = new ItemStack(ItemManager.goldenAppleChainmailPiece);
	public static ItemStack goldenAppleChestplateChainmail = new ItemStack(ItemManager.goldenAppleChestplateChainmail);
	public static ItemStack goldenAppleChestplateInnerArmor = new ItemStack(ItemManager.goldenAppleChestplateInnerArmor);
	public static ItemStack goldenAppleChestplateOuterArmor = new ItemStack(ItemManager.goldenAppleChestplateOuterArmor);
	
	public static ItemStack goldenAppleLeggingsLeftLeg = new ItemStack(ItemManager.goldenAppleLeggingsLeftLeg);
	public static ItemStack goldenAppleLeggingsRightLeg = new ItemStack(ItemManager.goldenAppleLeggingsRightLeg);
	
	public static ItemStack goldenAppleBootLeft = new ItemStack(ItemManager.goldenAppleBootLeft);
	public static ItemStack goldenAppleBootRight = new ItemStack(ItemManager.goldenAppleBootRight);
	
	// Armour
	public static ItemStack appleHelmet = new ItemStack(ItemManager.appleHelmet);
	public static ItemStack appleChestplate = new ItemStack(ItemManager.appleChestplate);
	public static ItemStack appleLeggings = new ItemStack(ItemManager.appleLeggings);
	public static ItemStack appleBoots = new ItemStack(ItemManager.appleBoots);
	
	public static ItemStack goldenAppleHelmet = new ItemStack(ItemManager.goldenAppleHelmet);
	public static ItemStack goldenAppleChestplate = new ItemStack(ItemManager.goldenAppleChestplate);
	public static ItemStack goldenAppleLeggings = new ItemStack(ItemManager.goldenAppleLeggings);
	public static ItemStack goldenAppleBoots = new ItemStack(ItemManager.goldenAppleBoots);
	
	public static void registerCrafting() {
		// Machine Blocks
		GameRegistry.addRecipe(appleChest, new Object[]{"AAA", "ACA", "AAA", 'A', Items.apple, 'C', Blocks.chest});
		GameRegistry.addRecipe(appleTable, new Object[]{"AAA", "ATA", "ACA", 'A', Items.apple, 'T', Blocks.crafting_table, 'C', appleCraftingCore});
		GameRegistry.addRecipe(appleFurnace, new Object[]{"AAA", "AFA", "AAA", 'A', Items.apple, 'C', Blocks.furnace});
		GameRegistry.addRecipe(appleCrusher, new Object[]{"ADA", "AFA", "ADA", 'A', Items.apple, 'C', Blocks.furnace, 'D', Items.diamond});
		
		GameRegistry.addRecipe(goldenAppleChest, new Object[]{"AAA", "ACA", "AAA", 'A', ItemManager.goldenAppleIngot, 'C', appleChest});
		GameRegistry.addRecipe(goldenAppleFurnace, new Object[]{"III", "IAI", "III", 'A', appleFurnace, 'I', ItemManager.goldenAppleIngot});
		
		// Base Items
		GameRegistry.addRecipe(appleBlock, new Object[]{"III", "III", "III", 'I', ItemManager.appleIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.appleIngot, 9), new Object[]{appleBlock});
		GameRegistry.addRecipe(appleCraftingCore, new Object[]{" I ", "ICI", " I ", 'I', ItemManager.appleIngot, 'C', Blocks.chest});
		GameRegistry.addRecipe(goldenAppleBlock, new Object[]{"GGG", "GGG", "GGG", 'G', ItemManager.goldenAppleIngot});
		GameRegistry.addShapelessRecipe(new ItemStack(ItemManager.goldenAppleIngot, 9), new Object[]{goldenAppleBlock});
		GameRegistry.addRecipe(obsidianStick, new Object[]{"  O", " DO", "OD", 'O', Blocks.obsidian, 'D', Blocks.diamond_block});
		GameRegistry.addRecipe(armorFoamPadding, new Object[]{"WWW", "WWW", "WWW", 'W', Blocks.wool});
		
		// Chests
		GameRegistry.addRecipe(appleChest, new Object[]{"AAA", "ACA", "AAA", 'A', Items.apple, 'C', Blocks.chest});
		GameRegistry.addRecipe(goldenAppleChest, new Object[]{"GGG", "GCG", "GGG", 'G', Items.golden_apple, 'C', appleChest});
		
		// Tool Parts
		GameRegistry.addRecipe(applePickaxeHead, new Object[]{"I  ", " I ", "  I", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleAxeHead, new Object[]{"II ", "II ", "  I", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleShovelHead, new Object[]{" II", "iII", " I ", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleHoeHead, new Object[]{"I  ", " I ", "   ", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleSwordBlade, new Object[]{"  I", " I ", "   ", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleSwordHilt, new Object[]{"I  ", " I ", "I I", 'I', ItemManager.appleIngot});
		
		GameRegistry.addRecipe(goldenApplePickaxeHead, new Object[]{"I  ", " I ", "  I", 'I', ItemManager.goldenAppleIngot});
		GameRegistry.addRecipe(goldenAppleBlastCore, new Object[]{"BBB", "BSB", "BBB", 'B', goldenAppleBlock, 'S', Items.nether_star});
		GameRegistry.addRecipe(goldenAppleAxeHead, new Object[]{"II ", "II ", "  I", 'I', ItemManager.goldenAppleIngot});
		GameRegistry.addRecipe(goldenAppleShovelHead, new Object[]{" II", "III", " I ", 'I', ItemManager.goldenAppleIngot});
		GameRegistry.addRecipe(goldenAppleHoeHead, new Object[]{"I  ", " I ", "   ", 'I', ItemManager.goldenAppleIngot});
		GameRegistry.addRecipe(goldenAppleSwordBlade, new Object[]{"  I", " I ", "   ", 'I', goldenAppleBlock});
		GameRegistry.addRecipe(goldenAppleSwordHilt, new Object[]{"I  ", " I ", "I I", 'I', goldenAppleBlock});
		
		// Tools
		GameRegistry.addRecipe(applePickaxe, new Object[]{"IHI", " O ", " O ", 'O', obsidianStick, 'I', ItemManager.appleIngot, 'H', applePickaxeHead});
		GameRegistry.addRecipe(appleAxe, new Object[]{"  H", " O ", "O  ", 'O', obsidianStick, 'H', appleAxeHead});
		GameRegistry.addRecipe(appleShovel, new Object[]{"  H", " O ", "O  ", 'O', obsidianStick, 'H', appleShovelHead});
		GameRegistry.addRecipe(appleHoe, new Object[]{"  H", " O ", "O  ", 'O', obsidianStick, 'H', appleHoeHead});
		GameRegistry.addRecipe(appleSword, new Object[]{"  B", " H ", "O  ", 'B', appleSwordBlade, 'H', appleSwordHilt, 'O', obsidianStick});
		
		GameRegistry.addRecipe(goldenApplePickaxe, new Object[]{"BHB", "COC", " O ", 'B', goldenAppleBlock, 'H', goldenApplePickaxeHead, 'C', goldenAppleBlastCore, 'O', obsidianStick});
		GameRegistry.addRecipe(goldenAppleAxe, new Object[]{"  H", " O ", "O  ", 'O', obsidianStick, 'H', goldenAppleAxeHead});
		GameRegistry.addRecipe(goldenAppleShovel, new Object[]{"  H", " O ", "O  ", 'O', obsidianStick, 'H', goldenAppleShovelHead});
		GameRegistry.addRecipe(goldenAppleHoe, new Object[]{"  H", " O ", "O  ", 'O', obsidianStick, 'H', goldenAppleHoeHead});
		GameRegistry.addRecipe(goldenAppleSword, new Object[]{"  B", " H ", "O  ", 'B', goldenAppleSwordBlade, 'H', goldenAppleSwordHilt, 'O', obsidianStick});
		
		// Armour Parts
		GameRegistry.addRecipe(appleChainmailPiece, new Object[]{"I I", " I ", "I I", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleChestplateChainmail, new Object[]{"C C", "COC", "CCC", 'C', appleChainmailPiece, 'O', appleChestplateOuterArmor});
		GameRegistry.addRecipe(appleChestplateInnerArmor, new Object[]{"P P", "POP", "PPP", 'P', armorFoamPadding, 'O', appleChestplateOuterArmor});
		GameRegistry.addRecipe(appleChestplateOuterArmor, new Object[]{"I I", "III", "III", 'I', ItemManager.appleIngot});
		
		GameRegistry.addRecipe(appleLeggingsLeftLeg, new Object[]{"I  ", "I  ", "I  ", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleLeggingsRightLeg, new Object[]{"  I", "  I", "  I", 'I', ItemManager.appleIngot});
		
		GameRegistry.addRecipe(appleBootLeft, new Object[]{"   ", "I  ", "I  ", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleBootRight, new Object[]{"   ", "  I", "  I", 'I', ItemManager.appleIngot});
		
		GameRegistry.addRecipe(goldenAppleChainmailPiece, new Object[]{"I I", " I ", "I I", 'I', ItemManager.goldenAppleIngot});
		GameRegistry.addRecipe(goldenAppleChestplateChainmail, new Object[]{"C C", "COC", "CCC", 'C', goldenAppleChainmailPiece, 'O', goldenAppleChestplateOuterArmor});
		GameRegistry.addRecipe(goldenAppleChestplateInnerArmor, new Object[]{"P P", "POP", "PPP", 'P', armorFoamPadding, 'O', goldenAppleChestplateOuterArmor});
		GameRegistry.addRecipe(goldenAppleChestplateOuterArmor, new Object[]{"I I", "III", "III", 'I', ItemManager.goldenAppleIngot});
		
		GameRegistry.addRecipe(goldenAppleLeggingsLeftLeg, new Object[]{"I  ", "I  ", "I  ", 'I', ItemManager.goldenAppleIngot});
		GameRegistry.addRecipe(goldenAppleLeggingsRightLeg, new Object[]{"  I", "  I", "  I", 'I', ItemManager.goldenAppleIngot});
		
		GameRegistry.addRecipe(goldenAppleBootLeft, new Object[]{"   ", "I  ", "I  ", 'I', ItemManager.goldenAppleIngot});
		GameRegistry.addRecipe(goldenAppleBootRight, new Object[]{"   ", "  I", "  I", 'I', ItemManager.goldenAppleIngot});
		
		// Armour
		GameRegistry.addRecipe(appleHelmet, new Object[]{"III", "I I", "   ", 'I', ItemManager.appleIngot});
		GameRegistry.addRecipe(appleChestplate, new Object[]{" C ", "IAI", " O ", 'C', appleChestplateChainmail, 'I', ItemManager.appleIngot, 'A', appleChestplateInnerArmor, 'O', appleChestplateOuterArmor});
		GameRegistry.addRecipe(appleLeggings, new Object[]{"III", "L R", "L R", 'I', ItemManager.appleIngot, 'L', appleLeggingsLeftLeg, 'R', appleLeggingsRightLeg});
		GameRegistry.addRecipe(appleBoots,new Object[]{"   ", "I I", "L R", 'I', ItemManager.appleIngot, 'L', appleBootLeft, 'R', appleBootRight});
		
		GameRegistry.addRecipe(goldenAppleHelmet, new Object[]{"III", "I I", "   ", 'I', ItemManager.goldenAppleIngot});
		GameRegistry.addRecipe(goldenAppleChestplate, new Object[]{" C ", "IAI", " O ", 'C', goldenAppleChestplateChainmail, 'I', ItemManager.goldenAppleIngot, 'A', goldenAppleChestplateInnerArmor, 'O', goldenAppleChestplateOuterArmor});
		GameRegistry.addRecipe(goldenAppleLeggings, new Object[]{"III", "L R", "L R", 'I', ItemManager.goldenAppleIngot, 'L', goldenAppleLeggingsLeftLeg, 'R', goldenAppleLeggingsRightLeg});
		GameRegistry.addRecipe(goldenAppleBoots,new Object[]{"   ", "I I", "L R", 'I', ItemManager.goldenAppleIngot, 'L', goldenAppleBootLeft, 'R', goldenAppleBootRight});
		
	}
	
	public static void registerSmelting() {
		// Ore Recipes
		GameRegistry.addSmelting(BlockManager.appleOre, new ItemStack(ItemManager.appleIngot), 500.0F);
		GameRegistry.addSmelting(BlockManager.goldenAppleOre, new ItemStack(ItemManager.goldenAppleIngot), 50000.0F);
		
		// Dust Recipes
		GameRegistry.addSmelting(ironDust, new ItemStack(Items.iron_ingot), 1.0F);
		GameRegistry.addSmelting(goldDust, new ItemStack(Items.gold_ingot), 1.0F);
		GameRegistry.addSmelting(diamondDust, new ItemStack(Items.diamond), 1.0F);
		GameRegistry.addSmelting(emeraldDust, new ItemStack(Items.emerald), 1.0F);
	}
}
