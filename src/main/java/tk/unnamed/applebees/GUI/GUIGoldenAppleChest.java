package tk.unnamed.applebees.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Container.ContainerGoldenAppleChest;
import tk.unnamed.applebees.TileEntity.TileEntityAppleChest;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleChest;

public class GUIGoldenAppleChest extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(AppleBees.MODID + ":" + "textures/gui/golden_apple_chest_gui.png");
	
	private TileEntityGoldenAppleChest te;
	private IInventory playerInv;

	public GUIGoldenAppleChest(InventoryPlayer playerInv, TileEntityGoldenAppleChest te) {
		super(new ContainerGoldenAppleChest(playerInv, te));
		
		this.te = te;
		this.playerInv = playerInv;
		
		this.xSize = 247;
		this.ySize = 254;
	}
	
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString("Golden Apple Chest", 7, 5, 0x000000);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
