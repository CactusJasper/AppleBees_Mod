package tk.unnamed.applebees.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class BlockManager {

	public static Block appleChest;
	public static final int guiIDAppleChest = 1;
	
	public static Block goldenAppleChest;
	public static final int guiIDGoldenAppleChest = 2;
	
	public static Block appleTable;
	public static final int guiIDAppleTable = 3;
	
	public static Block appleFurnaceIdle;
	public static Block appleFurnaceActive;
	public static final int guiIDAppleFurnace = 4;
	
	public static Block goldenAppleFurnaceIdle;
	public static Block goldenAppleFurnaceActive;
	public static final int guiIDGoldenAppleFurnace = 5;
	
	public static Block appleCrusherIdle;
	public static Block appleCrusherActive;
	public static final int guiIDAppleCrusher = 6;
	
	public static Block goldenAppleTable;
	public static final int guiIDGoldenAppleTable = 7;
	
	public static Block appleOre;
	public static Block goldenAppleOre;
	public static Block appleBlock;
	public static Block goldenAppleBlock;
	
	public static void registerBlocks() {
		appleTable = new AppleTable();
		goldenAppleTable = new GoldenAppleTable();
		
		appleFurnaceIdle = new AppleFurnace(false).setBlockName("apple_furnace_idle").setCreativeTab(AppleBeesTabs.appleBeesTab);
		appleFurnaceActive = new AppleFurnace(true).setBlockName("apple_furnace_active").setLightLevel(0.625F);
		
		appleCrusherIdle = new AppleCrusher(false).setBlockName("apple_crusher_idle").setCreativeTab(AppleBeesTabs.appleBeesTab);
		appleCrusherActive = new AppleCrusher(true).setBlockName("apple_crusher_active").setLightLevel(0.625F);
		
		goldenAppleFurnaceIdle = new GoldenAppleFurnace(false).setBlockName("golden_apple_furnace_idle").setCreativeTab(AppleBeesTabs.appleBeesTab);
		goldenAppleFurnaceActive = new GoldenAppleFurnace(true).setBlockName("golden_apple_furnace_active").setLightLevel(1.0F);
		
		appleChest = new AppleChest();
		goldenAppleChest = new GoldenAppleChest();
		
		appleOre = new BaseBlock(Material.rock, "pickaxe", 3).setBlockName("apple_ore").setBlockTextureName("applebees:apple_ore");
		goldenAppleOre = new BaseBlock(Material.rock, "pickaxe", 3).setBlockName("golden_apple_ore").setBlockTextureName("applebees:golden_apple_ore");
		appleBlock = new BaseBlock(Material.rock).setBlockName("apple_block").setBlockTextureName("applebees:apple_block");
		goldenAppleBlock = new BaseBlock(Material.rock).setBlockName("golden_apple_block").setBlockTextureName("applebees:golden_apple_block");
		
		// Machine Blocks
		GameRegistry.registerBlock(appleTable, appleTable.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(appleFurnaceIdle, appleFurnaceIdle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(appleFurnaceActive, appleFurnaceActive.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(appleCrusherIdle, appleCrusherIdle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(appleCrusherActive, appleCrusherActive.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(goldenAppleFurnaceIdle, goldenAppleFurnaceIdle.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(goldenAppleFurnaceActive, goldenAppleFurnaceActive.getUnlocalizedName().substring(5));
		
		GameRegistry.registerBlock(goldenAppleTable, goldenAppleTable.getUnlocalizedName().substring(5));
		
		// Ore Blocks
		GameRegistry.registerBlock(appleChest, appleChest.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(goldenAppleChest, goldenAppleChest.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(appleOre, appleOre.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(goldenAppleOre, goldenAppleOre.getUnlocalizedName().substring(5));
		
		// Combined Blocks
		GameRegistry.registerBlock(appleBlock, appleBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(goldenAppleBlock, goldenAppleBlock.getUnlocalizedName().substring(5));
	}
}
