package tk.unnamed.applebees.Container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleChest;

public class ContainerGoldenAppleChest extends Container {

	private TileEntityGoldenAppleChest te;
	private int numRows = 104 / 13;
	
	public ContainerGoldenAppleChest(InventoryPlayer playerInv, TileEntityGoldenAppleChest te) {
		this.te = te;
		
		// Chest Inventory
		for(int y = 0; y < 8; y++) {
			for(int x = 0; x < 13; x++) {
				this.addSlotToContainer(new Slot(te, x + y * 13, 8 + x * 18, 18 + y * 18));
			}
		}
		
		//Player Inventory
		for(int y = 0; y < 3; ++y) {
			for(int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 43 + x * 18, 173 + y * 18));
			}
		}
		
		//Player Hotbar	
		for(int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, 43 + x * 18, 231));
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

            if (fromSlot < this.numRows * 13)
            {
                if (!this.mergeItemStack(itemstack1, this.numRows * 13, this.inventorySlots.size(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 13, false))
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
