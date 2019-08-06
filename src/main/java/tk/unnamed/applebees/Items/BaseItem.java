package tk.unnamed.applebees.Items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class BaseItem extends Item {

	public BaseItem(String unlocalisedName, String textureName) {
		this.setUnlocalizedName(unlocalisedName);
		this.setTextureName(AppleBees.MODID + ":" + textureName);
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
	}
}
