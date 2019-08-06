package tk.unnamed.applebees.Handlers;

import com.pahimar.ee3.api.exchange.EnergyValueRegistryProxy;
import com.pahimar.ee3.api.knowledge.AbilityRegistryProxy;
import com.pahimar.ee3.exchange.EnergyValueRegistry;

import net.minecraft.item.ItemStack;
import tk.unnamed.applebees.Items.ItemManager;

public class EMCHandler {

	
	public static void registerEMCData() {
		EnergyValueRegistryProxy.setEnergyValue(new ItemStack(ItemManager.appleIngot), 512.0F);
		EnergyValueRegistryProxy.setEnergyValue(new ItemStack(ItemManager.goldenAppleIngot), 8194.0F);
		
		AbilityRegistryProxy.setAsNotLearnable(new ItemStack(ItemManager.appleIngot));
    	AbilityRegistryProxy.setAsNotLearnable(new ItemStack(ItemManager.goldenAppleIngot));
    	EnergyValueRegistry.INSTANCE.save();
	}
}
