package tk.unnamed.applebees.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class CommandClearInv extends CommandBase {

	@Override
	public String getCommandName() {
		return "clearinv";
	}

	@Override
	public String getCommandUsage(ICommandSender player) {
		return "commands.clearinv.usage";
	}
	
	@Override
	public int getRequiredPermissionLevel()
    {
        return 4;
    }

	@Override
	public void processCommand(ICommandSender player, String[] args) {
		EntityPlayerMP entityplayermp = args.length == 0 ? getCommandSenderAsPlayer(player) : getPlayer(player, args[0]);
        Item item = args.length >= 2 ? getItemByText(player, args[1]) : null;
        int i = args.length >= 3 ? parseIntWithMin(player, args[2], 0) : -1;

        if (args.length >= 2 && item == null)
        {
            throw new CommandException("commands.clearinv.failure", new Object[] {entityplayermp.getCommandSenderName()});
        }
        else
        {
            int j = entityplayermp.inventory.clearInventory(item, i);
            entityplayermp.inventoryContainer.detectAndSendChanges();

            if (!entityplayermp.capabilities.isCreativeMode)
            {
                entityplayermp.updateHeldItem();
            }

            if (j == 0)
            {
                throw new CommandException("commands.clearinv.failure", new Object[] {entityplayermp.getCommandSenderName()});
            }
            else
            {
                func_152373_a(player, this, "commands.clearinv.success", new Object[] {entityplayermp.getCommandSenderName(), Integer.valueOf(j)});
            }
        }
	}
	
	@Override
	public List addTabCompletionOptions(ICommandSender player, String[] args)
    {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, getPlayerUsernames()) : (args.length == 2 ? getListOfStringsFromIterableMatchingLastWord(args, Item.itemRegistry.getKeys()) : null);
    }
	
	protected String[] getPlayerUsernames()
    {
        return MinecraftServer.getServer().getAllUsernames();
    }
}
