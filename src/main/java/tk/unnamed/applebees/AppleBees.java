package tk.unnamed.applebees;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import tk.unnamed.applebees.Blocks.BlockManager;
import tk.unnamed.applebees.Crafting.CraftingManager;
import tk.unnamed.applebees.Enchantment.EnchantmentFeast;
import tk.unnamed.applebees.Enchantment.EnchantmentHealthBoost;
import tk.unnamed.applebees.Events.AppleBeesEventHandler;
import tk.unnamed.applebees.Handlers.EMCHandler;
import tk.unnamed.applebees.Handlers.GUIHandler;
import tk.unnamed.applebees.Items.ItemManager;
import tk.unnamed.applebees.Proxy.CommonProxy;
import tk.unnamed.applebees.commands.CommandClearInv;
import tk.unnamed.applebees.commands.CommandMoveWorld;
import tk.unnamed.applebees.commands.CommandPlayerTp;

@Mod(modid = "applebees", name = "AppleBees", version = "V0.9_AlphaRelease", dependencies = "required-before:EE3")
public class AppleBees
{
    public static final String MODID = "applebees";
    public static final String NAME = "AppleBees";
    public static final String VERSION = "V0.9_AlphaRelease";
    
    @SidedProxy(clientSide = "tk.unnamed.applebees.Proxy.ClientProxy", serverSide = "tk.unnamed.applebees.Proxy.CommonProxy")
	public static CommonProxy proxy;
    
    @Instance(MODID)
    public static AppleBees instance;
    
    public static final Enchantment feast = new EnchantmentFeast(54, 1);
    public static final Enchantment healthBoost = new EnchantmentHealthBoost(55, 2);
    
    @EventHandler
    public void preInit(FMLPostInitializationEvent event) {
    	// Item/Block Init and Registering
    	// Config Handling
    	instance = this;
    	proxy.registerTileEntities();
    	ItemManager.registerItems();
    	BlockManager.registerBlocks();
    	CraftingManager.registerCrafting();
    	CraftingManager.registerSmelting();
    	proxy.registerWorldGen();
    	EMCHandler.registerEMCData();
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		// Proxy, TileEntity, Entity, GUI and Packet Registering
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GUIHandler());
    	MinecraftForge.EVENT_BUS.register(AppleBeesEventHandler.class);
    	FMLCommonHandler.instance().bus().register(AppleBeesEventHandler.class);
    	proxy.registerRenders();
		proxy.registerGUIHandler();
		proxy.registerModelBakery();
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
    @EventHandler
	public void serverStaring(FMLServerStartingEvent event) {
    	event.registerServerCommand(new CommandClearInv());
    	event.registerServerCommand(new CommandPlayerTp());
    	event.registerServerCommand(new CommandMoveWorld());
	}
}
