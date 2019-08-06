package tk.unnamed.applebees.Items;

import net.minecraft.item.ItemHoe;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemGoldenAppleHoe extends ItemHoe {

	public ItemGoldenAppleHoe(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("golden_apple_hoe");
		this.setTextureName(AppleBees.MODID + ":" + "golden_apple_hoe");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}

}
