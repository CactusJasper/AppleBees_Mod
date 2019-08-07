package tk.unnamed.applebees.Handlers;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import tk.unnamed.applebees.Blocks.BlockManager;
import tk.unnamed.applebees.Container.ContainerAppleChest;
import tk.unnamed.applebees.Container.ContainerAppleCrusher;
import tk.unnamed.applebees.Container.ContainerAppleFurnace;
import tk.unnamed.applebees.Container.ContainerAppleTable;
import tk.unnamed.applebees.Container.ContainerGoldenAppleChest;
import tk.unnamed.applebees.Container.ContainerGoldenAppleFurnace;
import tk.unnamed.applebees.Container.ContainerGoldenAppleTable;
import tk.unnamed.applebees.GUI.GUIAppleChest;
import tk.unnamed.applebees.GUI.GUIAppleCrusher;
import tk.unnamed.applebees.GUI.GUIAppleFurnace;
import tk.unnamed.applebees.GUI.GUIAppleTable;
import tk.unnamed.applebees.GUI.GUIGoldenAppleChest;
import tk.unnamed.applebees.GUI.GUIGoldenAppleFurnace;
import tk.unnamed.applebees.GUI.GUIGoldenAppleTable;
import tk.unnamed.applebees.TileEntity.TileEntityAppleChest;
import tk.unnamed.applebees.TileEntity.TileEntityAppleCrusher;
import tk.unnamed.applebees.TileEntity.TileEntityAppleFurnace;
import tk.unnamed.applebees.TileEntity.TileEntityAppleTable;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleChest;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleFurnace;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleTable;

public class GUIHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		  
		if(ID == BlockManager.guiIDAppleChest) {
			return new ContainerAppleChest(player.inventory, (TileEntityAppleChest) world.getTileEntity(x, y, z));
		}
		
		if(ID == BlockManager.guiIDGoldenAppleChest) {
			return new ContainerGoldenAppleChest(player.inventory, (TileEntityGoldenAppleChest) world.getTileEntity(x, y, z));
		}
		
		if(ID == BlockManager.guiIDAppleTable) {
			return ID == BlockManager.guiIDAppleTable && world.getBlock(x, y, z) == BlockManager.appleTable ? new ContainerAppleTable(player.inventory, (TileEntityAppleTable) world.getTileEntity(x, y, z), world, x, y, z) : null;
		}
		
		if(ID == BlockManager.guiIDAppleFurnace) {
			return new ContainerAppleFurnace(player.inventory, (TileEntityAppleFurnace) entity);
		}
		
		if(ID == BlockManager.guiIDGoldenAppleFurnace) {
			return new ContainerGoldenAppleFurnace(player.inventory, (TileEntityGoldenAppleFurnace) entity);
		}
		
		if(ID == BlockManager.guiIDAppleCrusher) {
			return new ContainerAppleCrusher(player.inventory, (TileEntityAppleCrusher) entity);
		}
		
		if(ID == BlockManager.guiIDGoldenAppleTable) {
			return ID == BlockManager.guiIDGoldenAppleTable && world.getBlock(x, y, z) == BlockManager.goldenAppleTable ? new ContainerGoldenAppleTable(player.inventory, (TileEntityGoldenAppleTable) world.getTileEntity(x, y, z), world, x, y, z) : null;
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		  
		if(ID == BlockManager.guiIDAppleChest) {
			return new GUIAppleChest(player.inventory, (TileEntityAppleChest) entity);
		}
		
		if(ID == BlockManager.guiIDGoldenAppleChest) {
			return new GUIGoldenAppleChest(player.inventory, (TileEntityGoldenAppleChest) entity);
		}
		
		if(ID == BlockManager.guiIDAppleTable) {
			return ID == BlockManager.guiIDAppleTable && world.getBlock(x, y, z) == BlockManager.appleTable ? new GUIAppleTable(player.inventory, (TileEntityAppleTable) entity, world, x, y, z) : null;
		}
		
		if(ID == BlockManager.guiIDAppleFurnace) {
			return new GUIAppleFurnace(player.inventory, (TileEntityAppleFurnace) entity);
		}
		
		if(ID == BlockManager.guiIDGoldenAppleFurnace) {
			return new GUIGoldenAppleFurnace(player.inventory, (TileEntityGoldenAppleFurnace) entity);
		}
		
		if(ID == BlockManager.guiIDAppleCrusher) {
			return new GUIAppleCrusher(player.inventory, (TileEntityAppleCrusher) entity);
		}
		
		if(ID == BlockManager.guiIDGoldenAppleTable) {
			return ID == BlockManager.guiIDGoldenAppleTable && world.getBlock(x, y, z) == BlockManager.goldenAppleTable ? new GUIGoldenAppleTable(player.inventory, (TileEntityGoldenAppleTable) entity, world, x, y, z) : null;
		}
			
		return null;
	}
}
