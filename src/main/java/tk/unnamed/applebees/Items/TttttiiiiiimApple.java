package tk.unnamed.applebees.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class TttttiiiiiimApple extends ItemFood {

	public TttttiiiiiimApple(int foodAmount, float saturationAmount, boolean wolfFood) {
		super(foodAmount, saturationAmount, wolfFood);
		
		this.setUnlocalizedName("tttttiiiiiim_apple");
		this.setTextureName(AppleBees.MODID + ":" + "tttttiiiiiim_apple");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setAlwaysEdible();
	}
	
	protected void onFoodEaten(ItemStack item, World world, EntityPlayer player){
		if (!world.isRemote && item.getItem().equals(ItemManager.tttttiiiiiimApple)){
			player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 300, 5));
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20 * 300, 5));
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20 * 60, 3));
			player.addPotionEffect(new PotionEffect(Potion.jump.id, 20 * 300, 5));
			player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 20 * 120, 5));
			player.addPotionEffect(new PotionEffect(Potion.heal.id, 20 * 300, 5));
			player.addPotionEffect(new PotionEffect(21, 20 * 180, 4));
		}
		super.onFoodEaten(item, world, player);
	}
}
