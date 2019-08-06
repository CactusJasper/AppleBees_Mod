package tk.unnamed.applebees.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import tk.unnamed.applebees.Blocks.BlockManager;
import tk.unnamed.applebees.TileEntity.TileEntityAppleChest;

public class ContainerAppleChest extends Container {

	private TileEntityAppleChest te;
	private int numRows = 72 / 9;
	
	public ContainerAppleChest(InventoryPlayer playerInv, TileEntityAppleChest te) {
		this.te = te;
		
		// Chest Inventory
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 9; x++) {
				this.addSlotToContainer(new Slot(te, x + y * 9, 8 + x * 18, 18 + y * 18));
			}
		}
		
		//Player Inventory
		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 173 + y * 18));
			}
		}
		//Player Hotbar	
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 231));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.isUseableByPlayer(player);
	}
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(fromSlot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (fromSlot < this.numRows * 9)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false))
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
        }

        return itemstack;
	}
}
