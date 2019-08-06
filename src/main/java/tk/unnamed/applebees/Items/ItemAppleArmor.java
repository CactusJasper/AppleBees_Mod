package tk.unnamed.applebees.Items;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tk.unnamed.applebees.AppleBees;

public class ItemAppleArmor extends ItemArmor {

	public ItemAppleArmor(ArmorMaterial armorMaterial, int renderIndex, int armorType) {
		super(armorMaterial, renderIndex, armorType);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if(this.armorType == 2) {
			return AppleBees.MODID + ":" + "textures/models/armor/apple_layer_2.png";
		} else {
			return AppleBees.MODID + ":" + "textures/models/armor/apple_layer_1.png";
		}
	}
}
