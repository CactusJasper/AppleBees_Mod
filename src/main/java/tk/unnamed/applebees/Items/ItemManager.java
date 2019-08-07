package tk.unnamed.applebees.Items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemManager {
	
	// Recipe Items
	public static Item obsidianStick;
	public static Item armorFoamPadding;
	public static Item ironDust;
	public static Item goldDust;
	public static Item diamondDust;
	public static Item emeraldDust;
	
	// Food Items
	public static Item tttttiiiiiimApple;
	
	// Apple Items
	public static Item appleIngot;
	public static Item appleChainmailPiece;
	public static Item appleCraftingCore;
	
	public static Item applePickaxeHead;
	public static Item applePickaxe;
	
	public static Item appleAxeHead;
	public static Item appleAxe;
	
	public static Item appleShovelHead;
	public static Item appleShovel;
	
	public static Item appleHoeHead;
	public static Item appleHoe;
	
	public static Item appleSwordBlade;
	public static Item appleSwordHilt;
	public static Item appleSword;
	
	public static Item appleHelmet;
	
	public static Item appleChestplateChainmail;
	public static Item appleChestplateInnerArmor;
	public static Item appleChestplateOuterArmor;
	public static Item appleChestplate;
	
	public static Item appleLeggingsLeftLeg;
	public static Item appleLeggingsRightLeg;
	public static Item appleLeggings;
	
	public static Item appleBootLeft;
	public static Item appleBootRight;
	public static Item appleBoots;
	
	// Golden Apple Items
	public static Item goldenAppleIngot;
	public static Item goldenAppleChainmailPiece;
	public static Item goldenAppleCraftingCore;
	
	public static Item goldenApplePickaxeHead;
	public static Item goldenAppleBlastCore;
	public static Item goldenApplePickaxe;
	
	public static Item goldenAppleAxeHead;
	public static Item goldenAppleAxe;
	
	public static Item goldenAppleShovelHead;
	public static Item goldenAppleShovel;
	
	public static Item goldenAppleHoeHead;
	public static Item goldenAppleHoe;
	
	public static Item goldenAppleSwordBlade;
	public static Item goldenAppleSwordHilt;
	public static Item goldenAppleSword;
	
	public static Item goldenAppleHelmet;
	
	public static Item goldenAppleChestplateChainmail;
	public static Item goldenAppleChestplateInnerArmor;
	public static Item goldenAppleChestplateOuterArmor;
	public static Item goldenAppleChestplate;
	
	public static Item goldenAppleLeggingsLeftLeg;
	public static Item goldenAppleLeggingsRightLeg;
	public static Item goldenAppleLeggings;
	
	public static Item goldenAppleBootLeft;
	public static Item goldenAppleBootRight;
	public static Item goldenAppleBoots;
	
	// Tool Materials
	public static final Item.ToolMaterial appleToolMaterial = EnumHelper.addToolMaterial("Apple", 4, 2250, 12.5F, 75.0F, 30);
	public static final Item.ToolMaterial goldenAppleToolMaterial = EnumHelper.addToolMaterial("GoldenApple", 4, 5000, 50.0F, 275.0F, 30);
	
	/*
	 * The helmet starts out with 11 durability and multiplies it by the amount you put in.
	 * The chestplate starts out with 16 durability and multiplies it by the amount you put in.
	 * The leggings starts out with 15 durability and multiplies it by the amount you put in.
	 * The boots starts out with 13 durability and multiplies it by the amount you put in.
	 */
	
	// Armor Materials
	public static final ItemArmor.ArmorMaterial appleArmorMaterial = EnumHelper.addArmorMaterial("appleArmorMaterial", 1750 / 16, new int[]{5, 12, 7, 5}, 30);
	public static final ItemArmor.ArmorMaterial goldenAppleArmorMaterial = EnumHelper.addArmorMaterial("appleArmorMaterial", 5000 / 16, new int[]{15, 45, 35, 22}, 30);
	
	public static void registerItems() {
		// Recipe Items
		obsidianStick = new BaseItem("obsidian_stick", "obsidian_stick");
		armorFoamPadding = new BaseItem("armor_foam_padding", "armor_foam_padding");
		appleCraftingCore = new BaseItem("apple_crafting_core", "apple_crafting_core");
		
		// Dusts
		ironDust = new BaseItem("iron_dust", "iron_dust");
		goldDust = new BaseItem("gold_dust", "gold_dust");
		diamondDust = new BaseItem("diamond_dust", "diamond_dust");
		emeraldDust = new BaseItem("emerald_dust", "emerald_dust");
		
		// Food Items
		tttttiiiiiimApple = new TttttiiiiiimApple(10, 0.5F, false);
		
		// Apple Items
		appleIngot = new BaseItem("apple_ingot", "apple_ingot");
		appleChainmailPiece = new BaseItem("apple_chainmail_piece", "apple_chainmail_piece");
		appleCraftingCore = new BaseItem("apple_crafting_core", "apple_crafting_core");
		
		applePickaxeHead = new BaseItem("apple_pickaxe_head", "apple_pickaxe_head");
		applePickaxe = new ItemApplePicaxe(appleToolMaterial);
		
		appleAxeHead = new BaseItem("apple_axe_head", "apple_axe_head");
		appleAxe = new ItemAppleAxe(appleToolMaterial);
		
		appleShovelHead = new BaseItem("apple_shovel_head", "apple_shovel_head");
		appleShovel = new ItemAppleShovel(appleToolMaterial);
		
		appleHoeHead = new BaseItem("apple_hoe_head", "apple_hoe_head");
		appleHoe = new ItemAppleHoe(appleToolMaterial);
		
		appleSwordBlade = new BaseItem("apple_sword_blade", "apple_sword_blade");
		appleSwordHilt = new BaseItem("apple_sword_hilt", "apple_sword_hilt");
		appleSword = new ItemAppleSword(appleToolMaterial);
		
		appleHelmet = new ItemAppleArmor(appleArmorMaterial, 0, 0).setUnlocalizedName("apple_helmet").setTextureName(AppleBees.MODID + ":" + "apple_helmet").setCreativeTab(AppleBeesTabs.appleBeesTab);
		
		appleChestplateChainmail = new BaseItem("apple_chestplate_chainmail", "apple_chestplate_chainmail");
		appleChestplateInnerArmor = new BaseItem("apple_chestplate_inner_armor", "apple_chestplate_inner_armor");
		appleChestplateOuterArmor = new BaseItem("apple_chestplate_outer_armor", "apple_chestplate_outer_armor");
		appleChestplate = new ItemAppleArmor(appleArmorMaterial, 0, 1).setUnlocalizedName("apple_chestplate").setTextureName(AppleBees.MODID + ":" + "apple_chestplate").setCreativeTab(AppleBeesTabs.appleBeesTab);
		
		appleLeggingsLeftLeg = new BaseItem("apple_leggings_left_leg", "apple_leggings_left_leg");
		appleLeggingsRightLeg = new BaseItem("apple_leggings_right_leg", "apple_leggings_right_leg");
		appleLeggings = new ItemAppleArmor(appleArmorMaterial, 0, 2).setUnlocalizedName("apple_leggings").setTextureName(AppleBees.MODID + ":" + "apple_leggings").setCreativeTab(AppleBeesTabs.appleBeesTab);
		
		appleBootLeft = new BaseItem("apple_boot_left", "apple_boot_left");
		appleBootRight = new BaseItem("apple_boot_right", "apple_boot_right");
		appleBoots = new ItemAppleArmor(appleArmorMaterial, 0, 3).setUnlocalizedName("apple_boots").setTextureName(AppleBees.MODID + ":" + "apple_boots").setCreativeTab(AppleBeesTabs.appleBeesTab);
		
		// Golden Apple Items
		goldenAppleIngot = new BaseItem("golden_apple_ingot", "golden_apple_ingot");
		goldenAppleChainmailPiece = new BaseItem("golden_apple_chainmail_piece", "golden_apple_chainmail_piece");
		goldenAppleCraftingCore = new BaseItem("golden_apple_crafting_core", "golden_apple_crafting_core");
		
		goldenApplePickaxeHead = new BaseItem("golden_apple_pickaxe_head", "golden_apple_pickaxe_head");
		goldenAppleBlastCore = new BaseItem("golden_apple_blast_core", "golden_apple_blast_core");
		goldenApplePickaxe = new ItemGoldenApplePickaxe(goldenAppleToolMaterial);
		
		goldenAppleAxeHead = new BaseItem("golden_apple_axe_head", "golden_apple_axe_head");
		goldenAppleAxe = new ItemGoldenAppleAxe(goldenAppleToolMaterial);
		
		goldenAppleShovelHead= new BaseItem("golden_apple_shovel_head", "golden_apple_shovel_head");
		goldenAppleShovel = new ItemGoldenAppleShovel(goldenAppleToolMaterial);
		
		goldenAppleHoeHead = new BaseItem("golden_apple_hoe_head", "golden_apple_hoe_head");
		goldenAppleHoe = new ItemGoldenAppleHoe(goldenAppleToolMaterial);
		
		goldenAppleSwordBlade = new BaseItem("golden_apple_sword_blade", "golden_apple_sword_blade");
		goldenAppleSwordHilt = new BaseItem("golden_apple_sword_hilt", "golden_apple_sword_hilt");
		goldenAppleSword = new ItemGoldenAppleSword(goldenAppleToolMaterial);
		
		goldenAppleHelmet = new ItemGoldenAppleArmor(goldenAppleArmorMaterial, 0, 0).setUnlocalizedName("golden_apple_helmet").setTextureName(AppleBees.MODID + ":" + "golden_apple_helmet").setCreativeTab(AppleBeesTabs.appleBeesTab);
		
		goldenAppleChestplateChainmail = new BaseItem("golden_apple_chestplate_chainmail", "golden_apple_chestplate_chainmail");
		goldenAppleChestplateInnerArmor = new BaseItem("golden_apple_chestplate_inner_armor", "golden_apple_chestplate_inner_armor");
		goldenAppleChestplateOuterArmor = new BaseItem("golden_apple_chestplate_outer_armor", "golden_apple_chestplate_outer_armor");
		goldenAppleChestplate = new ItemGoldenAppleArmor(goldenAppleArmorMaterial, 0, 1).setUnlocalizedName("golden_apple_chestplate").setTextureName(AppleBees.MODID + ":" + "golden_apple_chestplate").setCreativeTab(AppleBeesTabs.appleBeesTab);
		
		goldenAppleLeggingsLeftLeg = new BaseItem("golden_apple_leggings_left_leg", "golden_apple_leggings_left_leg");
		goldenAppleLeggingsRightLeg = new BaseItem("golden_apple_leggings_right_leg", "golden_apple_leggings_right_leg");
		goldenAppleLeggings = new ItemGoldenAppleArmor(goldenAppleArmorMaterial, 0, 2).setUnlocalizedName("golden_apple_leggings").setTextureName(AppleBees.MODID + ":" + "golden_apple_leggings").setCreativeTab(AppleBeesTabs.appleBeesTab);
		
		goldenAppleBootLeft = new BaseItem("golden_apple_boot_left", "golden_apple_boot_left");
		goldenAppleBootRight = new BaseItem("golden_apple_boot_right", "golden_apple_boot_right");
		goldenAppleBoots = new ItemGoldenAppleArmor(goldenAppleArmorMaterial, 0, 3).setUnlocalizedName("golden_apple_boots").setTextureName(AppleBees.MODID + ":" + "golden_apple_boots").setCreativeTab(AppleBeesTabs.appleBeesTab);
		
		// Crafting Items
		GameRegistry.registerItem(obsidianStick, obsidianStick.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleIngot, appleIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleIngot, goldenAppleIngot.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(armorFoamPadding, armorFoamPadding.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleCraftingCore, appleCraftingCore.getUnlocalizedName().substring(5));
		
		// Dusts
		GameRegistry.registerItem(ironDust, ironDust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldDust, goldDust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(diamondDust, diamondDust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(emeraldDust, emeraldDust.getUnlocalizedName().substring(5));
		
		// Food
		GameRegistry.registerItem(tttttiiiiiimApple, tttttiiiiiimApple.getUnlocalizedName().substring(5));
		
		// Apple Tools
		GameRegistry.registerItem(applePickaxeHead, applePickaxeHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(applePickaxe, applePickaxe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(appleAxeHead, appleAxeHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleAxe, appleAxe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(appleShovelHead, appleShovelHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleShovel, appleShovel.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(appleHoeHead, appleHoeHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleHoe, appleHoe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(appleSwordBlade, appleSwordBlade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleSwordHilt, appleSwordHilt.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleSword, appleSword.getUnlocalizedName().substring(5));
		
		// Apple Armour
		GameRegistry.registerItem(appleHelmet, appleHelmet.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(appleChainmailPiece, appleChainmailPiece.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleChestplateChainmail, appleChestplateChainmail.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleChestplateInnerArmor, appleChestplateInnerArmor.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleChestplateOuterArmor, appleChestplateOuterArmor.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleChestplate, appleChestplate.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(appleLeggingsLeftLeg, appleLeggingsLeftLeg.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleLeggingsRightLeg, appleLeggingsRightLeg.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleLeggings, appleLeggings.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(appleBootLeft, appleBootLeft.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleBootRight, appleBootRight.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(appleBoots, appleBoots.getUnlocalizedName().substring(5));
		
		// Golden Apple Tools
		GameRegistry.registerItem(goldenApplePickaxeHead, goldenApplePickaxeHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleBlastCore, goldenAppleBlastCore.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenApplePickaxe, goldenApplePickaxe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(goldenAppleAxeHead, goldenAppleAxeHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleAxe, goldenAppleAxe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(goldenAppleShovelHead, goldenAppleShovelHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleShovel, goldenAppleShovel.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(goldenAppleHoeHead, goldenAppleHoeHead.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleHoe, goldenAppleHoe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(goldenAppleSwordBlade, goldenAppleSwordBlade.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleSwordHilt, goldenAppleSwordHilt.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleSword, goldenAppleSword.getUnlocalizedName().substring(5));
		
		
		// Golden Apple Armour
		GameRegistry.registerItem(goldenAppleHelmet, goldenAppleHelmet.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(goldenAppleChainmailPiece, goldenAppleChainmailPiece.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleChestplateChainmail, goldenAppleChestplateChainmail.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleChestplateInnerArmor, goldenAppleChestplateInnerArmor.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleChestplateOuterArmor, goldenAppleChestplateOuterArmor.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleChestplate, goldenAppleChestplate.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(goldenAppleLeggingsLeftLeg, goldenAppleLeggingsLeftLeg.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleLeggingsRightLeg, goldenAppleLeggingsRightLeg.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleLeggings, goldenAppleLeggings.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(goldenAppleBootLeft, goldenAppleBootLeft.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleBootRight, goldenAppleBootRight.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenAppleBoots, goldenAppleBoots.getUnlocalizedName().substring(5));
	}
}
