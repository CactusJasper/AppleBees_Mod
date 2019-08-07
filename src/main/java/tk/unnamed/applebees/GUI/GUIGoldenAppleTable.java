package tk.unnamed.applebees.GUI;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Container.ContainerGoldenAppleTable;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleTable;

public class GUIGoldenAppleTable extends GuiContainer {

	public static final ResourceLocation texture = new ResourceLocation(AppleBees.MODID + ":" + "textures/gui/golden_apple_table_gui.png");
		
	private TileEntityGoldenAppleTable te;
	private IInventory playerInv;

	public GUIGoldenAppleTable(InventoryPlayer inventoryPlayer, TileEntityGoldenAppleTable te,  World world, int x, int y, int z) {
		super(new ContainerGoldenAppleTable(inventoryPlayer, te, world, x, y, z));
		
		this.te = te;
		this.playerInv = inventoryPlayer;
		
		this.xSize = 175;
		this.ySize = 202;
	}

	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		
		this.fontRendererObj.drawString("Crafting", 110, 6, 4210752);
		this.fontRendererObj.drawString("Storage", 8, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
