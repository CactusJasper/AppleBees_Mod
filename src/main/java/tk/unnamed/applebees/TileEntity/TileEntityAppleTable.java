package tk.unnamed.applebees.TileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAppleTable extends TileEntity implements IInventory {

	private ItemStack[] inventory;
	private String customName;
	
	public TileEntityAppleTable() {
		this.inventory = new ItemStack[this.getSizeInventory()];
	}
	
	public String getCustomName() {
		return customName;
	}
	
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	
	@Override
	public int getSizeInventory() {
		return 27;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) {
	    if (index < 0 || index >= this.getSizeInventory())
	        return null;
	    return this.inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
	    if (this.getStackInSlot(index) != null) {
	        ItemStack itemstack;

	        if (this.getStackInSlot(index).stackSize <= count) {
	            itemstack = this.getStackInSlot(index);
	            this.setInventorySlotContents(index, null);
	            this.markDirty();
	            return itemstack;
	        } else {
	            itemstack = this.getStackInSlot(index).splitStack(count);

	            if (this.getStackInSlot(index).stackSize <= 0) {
	                this.setInventorySlotContents(index, null);
	            } else {
	                //Just to show that changes happened
	                this.setInventorySlotContents(index, this.getStackInSlot(index));
	            }

	            this.markDirty();
	            return itemstack;
	        }
	    } else {
	        return null;
	    }
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
	    if (index < 0 || index >= this.getSizeInventory())
	        return;

	    if (stack != null && stack.stackSize > this.getInventoryStackLimit())
	        stack.stackSize = this.getInventoryStackLimit();
	        
	    if (stack != null && stack.stackSize == 0)
	        stack = null;

	    this.inventory[index] = stack;
	    this.markDirty();
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}
	
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
	    NBTTagList list = new NBTTagList();
	    for (int i = 0; i < this.getSizeInventory(); ++i) {
	        if (this.getStackInSlot(i) != null) {
	            NBTTagCompound stackTag = new NBTTagCompound();
	            stackTag.setByte("Slot", (byte) i);
	            this.getStackInSlot(i).writeToNBT(stackTag);
	            list.appendTag(stackTag);
	        }
	    }
	    nbt.setTag("Items", list);

	    if (this.hasCustomInventoryName()) {
	        nbt.setString("CustomName", this.getCustomName());
	    }
	    
	    super.writeToNBT(nbt);
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
	    super.readFromNBT(nbt);

	    NBTTagList list = nbt.getTagList("Items", 10);
	    for (int i = 0; i < list.tagCount(); ++i) {
	        NBTTagCompound stackTag = list.getCompoundTagAt(i);
	        int slot = stackTag.getByte("Slot") & 255;
	        this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
	    }

	    if (nbt.hasKey("CustomName", 8)) {
	        this.setCustomName(nbt.getString("CustomName"));
	    }
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		ItemStack stack = this.getStackInSlot(index);
	    this.setInventorySlotContents(index, null);
	    return stack;
	}

	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName : "container.apple_table";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return this.customName !=null && !this.customName.equals("");
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}
}
