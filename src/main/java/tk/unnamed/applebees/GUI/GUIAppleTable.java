package tk.unnamed.applebees.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Container.ContainerAppleTable;
import tk.unnamed.applebees.TileEntity.TileEntityAppleTable;

public class GUIAppleTable extends GuiContainer {

private ResourceLocation texture = new ResourceLocation(AppleBees.MODID + ":" + "textures/gui/apple_table_gui.png");
	
	private TileEntityAppleTable te;
	private IInventory playerInv;

	public GUIAppleTable(InventoryPlayer playerInv, TileEntityAppleTable te, World world, int x, int y, int z) {
		super(new ContainerAppleTable(playerInv, te, world, x, y, z));
		
		this.te = te;
		this.playerInv = playerInv;
		
		this.xSize = 175;
		this.ySize = 231;
	}
	
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString("Apple Table", 7, 5, 0x000000);
		this.fontRendererObj.drawString("Inventory", 7, 139, 0x000000);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float red, int green, int blue) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.25F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}

}
