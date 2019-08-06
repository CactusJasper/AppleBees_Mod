package tk.unnamed.applebees.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;

public class BaseBlock extends Block {

	public BaseBlock(Material matieral) {
		super(matieral);
		
		this.setHardness(3.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
	}
	
	public BaseBlock(Material matieral, String toolType, int toolLevel) {
		super(matieral);
		
		this.setHardness(3.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
		this.setHarvestLevel(toolType, toolLevel);
	}
	
}
