package tk.unnamed.applebees.Container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import tk.unnamed.applebees.TileEntity.TileEntityAppleFurnace;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleFurnace;

public class ContainerGoldenAppleFurnace extends Container {

	private TileEntityGoldenAppleFurnace goldenAppleFurnace;
	
	public int lastBurnTime;
	public int lastCurrentItemBurnTime;
	public int lastCurrentItemBurnTimeSlot2;
	public int lastCookTime;
	public int lastCookTimeSlot2;
	
	public ContainerGoldenAppleFurnace(InventoryPlayer inventory, TileEntityGoldenAppleFurnace te) {
		this.goldenAppleFurnace = te;
		
		this.addSlotToContainer(new Slot(te, 0, 56, 35));
		this.addSlotToContainer(new Slot(te, 1, 8, 62));
		this.addSlotToContainer(new SlotFurnace(inventory.player, te, 2, 116, 35));
		
		// Player Inventory
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}
		
		// Player Hotbar
		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	@Override
	public void addCraftingToCrafters (ICrafting icrafting) {
		super.addCraftingToCrafters(icrafting);
		icrafting.sendProgressBarUpdate(this, 0, this.goldenAppleFurnace.cookTime);
		icrafting.sendProgressBarUpdate(this, 1, this.goldenAppleFurnace.burnTime);
		icrafting.sendProgressBarUpdate(this, 2, this.goldenAppleFurnace.currentItemBurnTime);
	}
	
	@Override
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting icrafting = (ICrafting) this.crafters.get(i);
			
			if(this.lastCookTime != this.goldenAppleFurnace.cookTime) {
				icrafting.sendProgressBarUpdate(this, 0, this.goldenAppleFurnace.cookTime);
			}
			
			if(this.lastBurnTime != this.goldenAppleFurnace.burnTime) {
				icrafting.sendProgressBarUpdate(this, 1, this.goldenAppleFurnace.burnTime);
			}
			
			if(this.lastCurrentItemBurnTime != this.goldenAppleFurnace.currentItemBurnTime) {
				icrafting.sendProgressBarUpdate(this, 2, this.goldenAppleFurnace.currentItemBurnTime);
			}
		}
		
		this.lastCookTime = this.goldenAppleFurnace.cookTime;
		this.lastBurnTime = this.goldenAppleFurnace.burnTime;
		this.lastCurrentItemBurnTime = this.goldenAppleFurnace.currentItemBurnTime;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void updateProgressBar(int par1, int par2)
    {
		if (par1 == 0) {
            this.goldenAppleFurnace.cookTime = par2;
        }

        if (par1 == 1) {
            this.goldenAppleFurnace.burnTime = par2;
        }

        if (par1 == 2) {
            this.goldenAppleFurnace.currentItemBurnTime = par2;
        }
    }
	
	@Override
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
		ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }else if (TileEntityAppleFurnace.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }else if (par2 >= 3 && par2 < 30){
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)){
                        return null;
                    }
                }else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }

	@Override
	public boolean canInteractWith(EntityPlayer var1) {
		return true;
	}
}
