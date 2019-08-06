package tk.unnamed.applebees.Items;

import net.minecraft.item.ItemSword;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemGoldenAppleSword extends ItemSword {

	public ItemGoldenAppleSword(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("golden_apple_sword");
		this.setTextureName(AppleBees.MODID + ":" + "golden_apple_sword");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}

}
