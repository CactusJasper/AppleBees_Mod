package tk.unnamed.applebees.Events;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import tk.unnamed.applebees.AppleBees;

public class AppleBeesEventHandler {

	// The Event used to disable Armor effects like Flying
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onPlayerTick(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		
		if(player.getCurrentArmor(3) != null) {
			int feastLevel = EnchantmentHelper.getEnchantmentLevel(AppleBees.feast.effectId, player.getCurrentArmor(3));
			if(feastLevel > 0) {
				player.getFoodStats().setFoodSaturationLevel(60.0F);
				player.getFoodStats().setFoodLevel(60);
			} else {
				player.getFoodStats().setFoodSaturationLevel(0.0F);
				player.getFoodStats().setFoodLevel(20);
			}
		}
		
		if(player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
			int healthBoostLevel = EnchantmentHelper.getEnchantmentLevel(AppleBees.healthBoost.effectId, player.getCurrentArmor(2));
			if(healthBoostLevel == 1) {
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0F);
				player.setHealth(24.0F);
			} else if(healthBoostLevel == 2) {
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(28.0F);
				player.setHealth(28.0F);
			} else if(healthBoostLevel == 3) {
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(32.0F);
				player.setHealth(32.0F);
			} else {
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0F);
				player.setHealth(20.0F);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void playerInteract(PlayerInteractEvent event) {
		EntityPlayer player = event.entityPlayer;
		checkArmour(player);
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void playerUseItem(PlayerUseItemEvent event) {
		EntityPlayer player = event.entityPlayer;
		checkArmour(player);
	}
	
	public void checkArmour(EntityPlayer player) {
		if(player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
			int healthBoostLevel = EnchantmentHelper.getEnchantmentLevel(AppleBees.healthBoost.effectId, player.getCurrentArmor(2));
			if(healthBoostLevel == 1) {
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(24.0F);
				player.setHealth(24.0F);
			} else if(healthBoostLevel == 2) {
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(28.0F);
				player.setHealth(28.0F);
			} else if(healthBoostLevel == 3) {
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(32.0F);
				player.setHealth(32.0F);
			} else {
				player.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0F);
				player.setHealth(20.0F);
			}
		}
	}
}
