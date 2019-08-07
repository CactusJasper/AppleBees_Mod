package tk.unnamed.applebees.Proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import tk.unnamed.applebees.AppleBees;
import tk.unnamed.applebees.Handlers.GUIHandler;
import tk.unnamed.applebees.TerrainGen.AppleBeesOreGenration;
import tk.unnamed.applebees.TileEntity.TileEntityAppleChest;
import tk.unnamed.applebees.TileEntity.TileEntityAppleCrusher;
import tk.unnamed.applebees.TileEntity.TileEntityAppleFurnace;
import tk.unnamed.applebees.TileEntity.TileEntityAppleTable;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleChest;
import tk.unnamed.applebees.TileEntity.TileEntityGoldenAppleTable;

public class CommonProxy {
	
	public void registerRenders() {
		
	}
	
	public void preInit(FMLPreInitializationEvent e) {

    }

    public void init(FMLInitializationEvent e) {
    	
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
    
    public void registerModelBakery() {
    	
    }
    
    public void registerWorldGen() {
    	GameRegistry.registerWorldGenerator(new AppleBeesOreGenration(), 0);
    }
    
    public void registerTileEntities() {
    	GameRegistry.registerTileEntity(TileEntityAppleChest.class, "apple_chest_tile_entity");
    	GameRegistry.registerTileEntity(TileEntityGoldenAppleChest.class, "golden_apple_chest_tile_entity");
    	GameRegistry.registerTileEntity(TileEntityAppleTable.class, "apple_table_tile_entity");
    	GameRegistry.registerTileEntity(TileEntityAppleFurnace.class, "apple_furance_tile_entity");
    	GameRegistry.registerTileEntity(TileEntityAppleCrusher.class, "apple_crusher_tile_entity");
    	GameRegistry.registerTileEntity(TileEntityGoldenAppleTable.class, "golden_apple_table_tile_entity");
    }
    
    public void registerGUIHandler() {
    	NetworkRegistry.INSTANCE.registerGuiHandler(AppleBees.instance, new GUIHandler());
    }
}
