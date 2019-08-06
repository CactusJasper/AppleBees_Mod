package tk.unnamed.applebees.Items;

import net.minecraft.item.ItemSpade;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class ItemGoldenAppleShovel extends ItemSpade {

	public ItemGoldenAppleShovel(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("golden_apple_shovel");
		this.setTextureName(AppleBees.MODID + ":" + "golden_apple_shovel");
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setNoRepair();
	}

}
