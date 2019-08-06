package tk.unnamed.applebees.Blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Inventroy.AppleBeesTabs;
import tk.unnamed.applebees.TileEntity.TileEntityAppleChest;
import tk.unnamed.applebees.TileEntity.TileEntityAppleTable;

public class AppleTable extends BlockContainer implements ITileEntityProvider {

	private final Random random = new Random();
	
	@SideOnly(Side.CLIENT)
	private IIcon appleTableTop;
	
	protected AppleTable() {
		super(Material.wood);
		this.setBlockName("apple_table");
		this.setHardness(3.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(AppleBeesTabs.appleBeesTab);
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon (int side, int metadata) {
		return side == 1 ? this.appleTableTop : this.blockIcon;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons (IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(AppleBees.MODID + ":" + "apple_table_side");
		this.appleTableTop = iconRegister.registerIcon(AppleBees.MODID + ":" + "apple_table_top");
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int q, float a, float b, float c) {
		if(!world.isRemote && !player.isSneaking()) {
			player.openGui(AppleBees.instance, BlockManager.guiIDAppleTable, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityAppleTable();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metaData)
    {
		TileEntityAppleTable  tileentitychest = (TileEntityAppleTable)world.getTileEntity(x, y, z);
        
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
            blockDrop = new EntityItem(world, x, y, z, new ItemStack(BlockManager.appleTable));
            world.spawnEntityInWorld(blockDrop);
            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, metaData);
    }
}
