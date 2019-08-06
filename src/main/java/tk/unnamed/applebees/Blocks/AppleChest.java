package tk.unnamed.applebees.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;
import tk.unnamed.applebees.TileEntity.TileEntityAppleChest;

public class AppleChest extends BlockContainer implements ITileEntityProvider {
	
	private final Random random = new Random();
	
	public AppleChest() {
		super(Material.wood);
		this.setBlockName("apple_chest");
		this.setBlockTextureName(AppleBees.MODID + ":" + "apple_chest");
		this.setHardness(3.5F);
		this.setResistance(100.0F);
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
		if(!world.isRemote && !player.isSneaking()) {
			player.openGui(AppleBees.instance, BlockManager.guiIDAppleChest, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityAppleChest();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metaData)
    {
        TileEntityAppleChest  tileentitychest = (TileEntityAppleChest)world.getTileEntity(x, y, z);
        
        if(tileentitychest != null)
        {
            for(int i1 = 0; i1 < tileentitychest.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = tileentitychest.getStackInSlot(i1);

                if(itemstack != null)
                {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for(float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int j1 = this.random.nextInt(21) + 10;

                        if(j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);

                        if(itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }                
            }
            
            EntityItem blockDrop;
            blockDrop = new EntityItem(world, x, y, z, new ItemStack(BlockManager.appleChest));
            world.spawnEntityInWorld(blockDrop);
            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, metaData);
    }
}
