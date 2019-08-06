package tk.unnamed.applebees.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;

public class EnchantmentHealthBoost extends Enchantment {

	public EnchantmentHealthBoost(int id, int rarity) {
		super(id, rarity, EnumEnchantmentType.armor);
		this.setName("health_boost");
	}
	
	@Override
	public int getMinEnchantability(int par1){
		return 5 + (par1 - 1) * 10;
	}
	
	@Override
	public int getMaxEnchantability(int par1){
		return this.getMinEnchantability(par1) + 20;
	}
	
	@Override
	public int getMaxLevel(){
		return 3;
	}
}
