package tk.unnamed.applebees.Inventroy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tk.unnamed.applebees.Items.ItemManager;

public class AppleBeesTabs {

	public static CreativeTabs appleBeesTab = new CreativeTabs("appleBeesTab") {
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return new ItemStack(ItemManager.appleIngot).getItem();
		}
	};
}
