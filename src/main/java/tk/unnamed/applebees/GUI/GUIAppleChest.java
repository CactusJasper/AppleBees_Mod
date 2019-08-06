package tk.unnamed.applebees.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Container.ContainerAppleChest;
import tk.unnamed.applebees.TileEntity.TileEntityAppleChest;

public class GUIAppleChest extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(AppleBees.MODID + ":" + "textures/gui/apple_chest_gui.png");
	
	private TileEntityAppleChest te;
	private IInventory playerInv;

	public GUIAppleChest(InventoryPlayer playerInv, TileEntityAppleChest te) {
		super(new ContainerAppleChest(playerInv, te));
		
		this.te = te;
		this.playerInv = playerInv;
		
		this.xSize = 175;
		this.ySize = 254;
	}
	
	public void onGuiClosed() {
		super.onGuiClosed();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		this.fontRendererObj.drawString("Apple Chest", 7, 5, 0x000000);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
