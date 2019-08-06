package tk.unnamed.applebees.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemAppleSword extends ItemSword {

	public ItemAppleSword(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("apple_sword");
		this.setTextureName(AppleBees.MODID + ":" + "apple_sword");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}
}
