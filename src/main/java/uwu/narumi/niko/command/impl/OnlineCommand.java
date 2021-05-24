package uwu.narumi.niko.command.impl;

import uwu.narumi.niko.command.Command;
import uwu.narumi.niko.command.CommandInfo;
import uwu.narumi.niko.exception.CommandException;
import uwu.narumi.niko.helper.ChatHelper;
import uwu.narumi.niko.helper.PlayerHelper;

@CommandInfo(
    alias = "online",
    description = ":D",
    usage = ".online [method]",
    aliases = {"players", "realplayers"}
)
public class OnlineCommand extends Command {

  @Override
  public void execute(String... args) throws CommandException {
    Type type = args.length > 0 ? Type.valueOf(args[0].toUpperCase()) : Type.PLAYER_DATA;
    int onlinePlayers = -1;

    switch (type) {
      case PLAYER_DATA:
        onlinePlayers = PlayerHelper.getOnlinePlayer().size();
        break;
      case TAB_COMPLETE:
        //TODO: LOL I'M LAZY AS FUK
        break;
    }

    ChatHelper.printMessage("Online players: &d" + onlinePlayers);
  }

  enum Type {
    TAB_COMPLETE, PLAYER_DATA
  }
}
