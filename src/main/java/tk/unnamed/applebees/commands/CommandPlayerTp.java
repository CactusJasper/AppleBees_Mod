package tk.unnamed.applebees.commands;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.PlayerNotFoundException;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;

public class CommandPlayerTp extends CommandBase {

	@Override
	public String getCommandName() {
		return "playertp";
	}

	@Override
	public String getCommandUsage(ICommandSender player) {
		return "commands.playertp.usage";
	}
	
	@Override
	public int getRequiredPermissionLevel()
    {
        return 1;
    }

	@Override
	public void processCommand(ICommandSender player, String[] args) {
		if (args.length < 1)
        {
            throw new WrongUsageException("commands.playertp.usage", new Object[0]);
        }
        else
        {
            EntityPlayerMP entityplayermp;

            if (args.length != 2 && args.length != 4)
            {
                entityplayermp = getCommandSenderAsPlayer(player);
            }
            else
            {
                entityplayermp = getPlayer(player, args[0]);

                if (entityplayermp == null)
                {
                    throw new PlayerNotFoundException();
                }
            }

            if (args.length != 3 && args.length != 4)
            {
                if (args.length == 1 || args.length == 2)
                {
                    EntityPlayerMP entityplayermp1 = getPlayer(player, args[args.length - 1]);

                    if (entityplayermp1 == null)
                    {
                        throw new PlayerNotFoundException();
                    }

                    if (entityplayermp1.worldObj != entityplayermp.worldObj)
                    {
                        func_152373_a(player, this, "commands.playertp.notSameDimension", new Object[0]);
                        return;
                    }

                    entityplayermp.mountEntity((Entity)null);
                    entityplayermp.playerNetServerHandler.setPlayerLocation(entityplayermp1.posX, entityplayermp1.posY, entityplayermp1.posZ, entityplayermp1.rotationYaw, entityplayermp1.rotationPitch);
                    func_152373_a(player, this, "commands.playertp.success", new Object[] {entityplayermp.getCommandSenderName(), entityplayermp1.getCommandSenderName()});
                }
            }
            else if (entityplayermp.worldObj != null)
            {
                int i = args.length - 3;
                double d0 = func_110666_a(player, entityplayermp.posX, args[i++]);
                double d1 = func_110665_a(player, entityplayermp.posY, args[i++], 0, 0);
                double d2 = func_110666_a(player, entityplayermp.posZ, args[i++]);
                entityplayermp.mountEntity((Entity)null);
                entityplayermp.setPositionAndUpdate(d0, d1, d2);
                func_152373_a(player, this, "commands.playertp.success.coordinates", new Object[] {entityplayermp.getCommandSenderName(), Double.valueOf(d0), Double.valueOf(d1), Double.valueOf(d2)});
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
