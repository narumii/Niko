package uwu.narumi.niko.command.impl;

import net.minecraft.command.CommandBase;
import net.minecraft.command.NumberInvalidException;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldSettings.GameType;
import uwu.narumi.niko.command.Command;
import uwu.narumi.niko.command.CommandInfo;
import uwu.narumi.niko.exception.CommandException;
import uwu.narumi.niko.helper.ChatHelper;

@CommandInfo(
    alias = "fakegamemode",
    description = "Spoofing your gamemode (only in client)",
    usage = ".fakegamemode <mode/revert>",
    aliases = {"fakegm", "fgm"}
)
public class FakeGamemodeCommand extends Command {

  private GameType savedType;

  @Override
  public void execute(String... args) throws CommandException {
    if (args.length <= 0) {
      throw new CommandException(getUsage());
    }

    if (args[0].equalsIgnoreCase("revert") && savedType != null) {
      mc.playerController.setGameType(savedType);
      ChatHelper.printMessage("Your client gamemode was reverted to &d" + savedType.getName());

      savedType = null;
    }

    try {
      GameType gameType = getGameModeFromCommand(args[0]);
      if (savedType == null) {
        savedType = mc.playerController.getCurrentGameType();
      }

      mc.playerController.setGameType(gameType);
      ChatHelper.printMessage("Your client gamemode was set to &d" + gameType.getName());
    } catch (Exception e) {
      throw new CommandException(getUsage());
    }
  }

  //Don't kill me it's mojang code
  private WorldSettings.GameType getGameModeFromCommand(String argument)
      throws NumberInvalidException {
    return !argument.equalsIgnoreCase(WorldSettings.GameType.SURVIVAL.getName()) && !argument
        .equalsIgnoreCase("s")
        ? (!argument.equalsIgnoreCase(WorldSettings.GameType.CREATIVE.getName()) && !argument
        .equalsIgnoreCase("c")
        ? (!argument.equalsIgnoreCase(WorldSettings.GameType.ADVENTURE.getName()) && !argument
        .equalsIgnoreCase("a")
        ? (!argument.equalsIgnoreCase(WorldSettings.GameType.SPECTATOR.getName()) && !argument
        .equalsIgnoreCase("sp")
        ? WorldSettings.getGameTypeById(
        CommandBase.parseInt(argument, 0, WorldSettings.GameType.values().length - 2))
        : WorldSettings.GameType.SPECTATOR) : WorldSettings.GameType.ADVENTURE)
        : WorldSettings.GameType.CREATIVE) : WorldSettings.GameType.SURVIVAL;
  }
}
