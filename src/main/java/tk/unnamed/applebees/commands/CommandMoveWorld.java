package tk.unnamed.applebees.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.DimensionManager;

public class CommandMoveWorld extends CommandBase {

	@Override
	public String getCommandName() {
		return "moveworld";
	}

	@Override
	public String getCommandUsage(ICommandSender player) {
		return "commands.moveworld.usage";
	}
	
	@Override
	public int getRequiredPermissionLevel()
    {
        return 4;
    }

	@Override
	public void processCommand(ICommandSender player, String[] args) {
		if (args.length < 1)
        {
            throw new WrongUsageException("commands.moveworld.usage", new Object[0]);
        }
        else
        {
            EntityPlayerMP entityplayermp;

            if (args.length == 2)
            {
                entityplayermp = getPlayer(player, args[0]);
                entityplayermp.mcServer.getConfigurationManager().transferPlayerToDimension(entityplayermp, Integer.parseInt(args[1]));
                func_152373_a(player, this, "commands.playertp.success", new Object[] {entityplayermp.getCommandSenderName(), args[1]});
            }
            else
            {
                entityplayermp = getPlayer(player, args[0]);

                if (entityplayermp == null)
                {
                    throw new PlayerNotFoundException();
                }
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
