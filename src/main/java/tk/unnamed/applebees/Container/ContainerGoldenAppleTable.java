package tk.unnamed.applebees.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tk.unnamed.applebees.Blocks.BlockManager;
import tk.unnamed.applebees.Crafting.GoldenAppleCraftingManager;
import tk.unnamed.applebees.TileEntity.TileEntityAppleTable;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleTable;

public class ContainerGoldenAppleTable extends Container {

	public InventoryCrafting craftMatrix;
	public IInventory craftResult;
	private TileEntityGoldenAppleTable te;
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;
	private int numRows = 20 / 5;
	
	public ContainerGoldenAppleTable(InventoryPlayer playerInv, TileEntityGoldenAppleTable te, World world, int posX, int posY, int posZ) {
		this.te = te;
		craftMatrix = new InventoryCrafting(this, 1, 5);
		craftResult = new InventoryCraftResult();
		worldObj = world;
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;
		
		this.addSlotToContainer(new SlotCrafting(playerInv.player, craftMatrix, craftResult, 0, 145, 53));
		
		// Crafting Grid
		for(int y = 0; y < 5; y++) {
			for(int x = 0; x < 1; x++) {
				this.addSlotToContainer(new Slot(craftMatrix, x + y, 92 + x * 18, 17 + y * 18));
			}
		}
		
		// TODO: Add the storage section and create the tile entity
		for(int y = 0; y < 5; y++) {
			for(int x = 0; x < 4; x++) {
				this.addSlotToContainer(new Slot(te, x + y * 4, 8 + x * 18, 17 + y * 18));
			}
		}
		
		//Player Inventory
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 121 + y * 18));
			}
		}
		//Player Hotbar	
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 179));
		}
		
		this.onCraftMatrixChanged(this.craftMatrix);
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory iiventory) {
		craftResult.setInventorySlotContents(0, GoldenAppleCraftingManager.getInstance().findMatchingRecipe(craftMatrix, worldObj));
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if(worldObj.getBlock(posX, posY, posZ) != BlockManager.goldenAppleTable) {
			return false;
		}else{
			return player.getDistanceSq((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D) <= 64.0D;
		}

	}
	
	@Override
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        super.onContainerClosed(par1EntityPlayer);

        if (!this.worldObj.isRemote)
        {
            for (int i = 0; i < 5; ++i)
            {
                ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

                if (itemstack != null)
                {
                    par1EntityPlayer.dropPlayerItemWithRandomChoice(itemstack, false);
                }
            }
        }
    }
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int fromSlot)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack())
        {
        	ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (fromSlot == 0)
            {
                if (!this.mergeItemStack(itemstack1, 26, 62, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (fromSlot >= 26 && fromSlot < 53)
            {
                if (!this.mergeItemStack(itemstack1, 53, 62, false))
                {
                    return null;
                }
            }
            else if (fromSlot >= 53 && fromSlot < 62)
            {
                if (!this.mergeItemStack(itemstack1, 26, 53, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 26, 62, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(entityPlayer, itemstack1);
        }

        return itemstack;
    }
}
