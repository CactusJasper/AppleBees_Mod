package tk.unnamed.applebees.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemAppleShovel extends ItemSpade {

	public ItemAppleShovel(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("apple_shovel");
		this.setTextureName(AppleBees.MODID + ":" + "apple_shovel");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}
}
