package tk.unnamed.applebees.Items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemGoldenApplePickaxe extends ItemPickaxe {

	public ItemGoldenApplePickaxe(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("golden_apple_pickaxe");
		this.setTextureName(AppleBees.MODID + ":" + "golden_apple_pickaxe");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack item, World world, Block block, int x, int y, int z, EntityLivingBase player) {
		world.createExplosion(player, x, y, z, 10.0F, true);
		return super.onBlockDestroyed(item, world, block, x, y, z, player);
	}

}
