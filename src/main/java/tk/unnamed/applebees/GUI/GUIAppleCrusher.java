package tk.unnamed.applebees.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Container.ContainerAppleCrusher;
import tk.unnamed.applebees.TileEntity.TileEntityAppleCrusher;

public class GUIAppleCrusher extends GuiContainer {

public static final ResourceLocation texture = new ResourceLocation(AppleBees.MODID + ":" + "textures/gui/apple_crusher_gui.png");
	
	public TileEntityAppleCrusher appleCrusher;

	public GUIAppleCrusher(InventoryPlayer inventoryPlayer, TileEntityAppleCrusher te) {
		super(new ContainerAppleCrusher(inventoryPlayer, te));
		
		this.appleCrusher = te;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		String name = this.appleCrusher.hasCustomInventoryName() ? this.appleCrusher.getInventoryName() : I18n.format(this.appleCrusher.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 118, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	
		if(this.appleCrusher.isBurning()) {
			int k = this.appleCrusher.getBurnTimeRemainingScaled(40);
			drawTexturedModalRect(guiLeft + 10, guiTop + 18 + 40 - k, 176, 40 - k, 40, k + 1);
		}
		
		int k = this.appleCrusher.getCrushProgressScaled(17);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 41, 41, k + 1);
	}
}
