package tk.unnamed.applebees.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemGoldenAppleAxe extends ItemAxe {

	public ItemGoldenAppleAxe(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("golden_apple_axe");
		this.setTextureName(AppleBees.MODID + ":" + "golden_apple_axe");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}
}
