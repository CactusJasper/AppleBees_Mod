package tk.unnamed.applebees.Items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import tk.unnamed.applebees.AppleBees;

public class ItemGoldenAppleArmor extends ItemArmor {

	public ItemGoldenAppleArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		super(armorMaterial, renderIndex, armorType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if(this.armorType == 2) {
			return AppleBees.MODID + ":" + "textures/models/armor/golden_apple_layer_2.png";
		} else {
			return AppleBees.MODID + ":" + "textures/models/armor/golden_apple_layer_1.png";
		}
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if (player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ItemManager.goldenAppleHelmet) && player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ItemManager.goldenAppleChestplate) && player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ItemManager.goldenAppleLeggings) && player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ItemManager.goldenAppleBoots)) {		
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 20, 1));
			player.addPotionEffect(new PotionEffect(13, 20, 5));
			player.setHealth(40.0F);
			player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0F);
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20, 5));
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20, 5));
			player.capabilities.allowFlying = true;
			player.setSprinting(true);
		}
		
		if(player.getCurrentArmor(3) == null || player.getCurrentArmor(2) == null || player.getCurrentArmor(1) == null || player.getCurrentArmor(0) == null || player.getCurrentArmor(3).equals(new ItemStack(ItemManager.goldenAppleHelmet)) || player.getCurrentArmor(2).equals(new ItemStack(ItemManager.goldenAppleChestplate)) || player.getCurrentArmor(1).equals(new ItemStack(ItemManager.goldenAppleLeggings)) || player.getCurrentArmor(0).equals(new ItemStack(ItemManager.goldenAppleBoots))) {			
			player.setHealth(20.0F);
			player.capabilities.allowFlying = false;
			player.capabilities.isFlying = false;
			player.setSprinting(false);
			player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0F);
		}
	}

}
