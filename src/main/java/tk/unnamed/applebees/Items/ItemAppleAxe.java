package tk.unnamed.applebees.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemAppleAxe extends ItemAxe {

	public ItemAppleAxe(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("apple_axe");
		this.setTextureName(AppleBees.MODID + ":" + "apple_axe");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}
}
