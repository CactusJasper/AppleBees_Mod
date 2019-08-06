package tk.unnamed.applebees.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemAppleHoe extends ItemHoe {

	public ItemAppleHoe(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("apple_hoe");
		this.setTextureName(AppleBees.MODID + ":" + "apple_hoe");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}
}
