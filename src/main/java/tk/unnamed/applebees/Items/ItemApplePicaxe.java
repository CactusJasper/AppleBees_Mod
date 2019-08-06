package tk.unnamed.applebees.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemApplePicaxe extends ItemPickaxe {

	public ItemApplePicaxe(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("apple_pickaxe");
		this.setTextureName(AppleBees.MODID + ":" + "apple_pickaxe");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}

}
