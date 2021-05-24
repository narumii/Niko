package uwu.narumi.niko.command.impl;

import uwu.narumi.niko.Niko;
import uwu.narumi.niko.command.Command;
import uwu.narumi.niko.command.CommandInfo;
import uwu.narumi.niko.exception.CommandException;
import uwu.narumi.niko.helper.ChatHelper;

@CommandInfo(
    alias = "help"
)
public class HelpCommand extends Command {

  @Override
  public void execute(String... args) throws CommandException {
    if (args.length > 0) {
      ChatHelper.printMessage("\n", false);
      Command command = Niko.INSTANCE.getCommandManager().getCommand(args[0])
          .orElseThrow(
              () -> new CommandException(String.format("Command \"%s\" not found.\n", args[0])));

      ChatHelper
          .printMessage(String.format("&5%s&f: &d%s\n", command.getAlias(), command.getUsage()));

      /*Niko.INSTANCE.getCommandManager().getCommand(args[0])
          .ifPresentOrElse(command -> ChatHelper.printMessage(
              String.format("&5%s&f: &d%s\n", command.getAlias(), command.getUsage())),
              () -> ChatHelper.printMessage(String.format("Command \"%s\" not found.\n", args[0])));*/
      return;
    }

    ChatHelper.printMessage("\n", false);
    Niko.INSTANCE.getCommandManager().getCommands().stream()
        .filter(command -> !(command instanceof HelpCommand))
        .forEach(command -> ChatHelper.printMessage(
            String.format("&5%s &f- &d%s", command.getAlias(), command.getDescription())));

    ChatHelper.printMessage("\n", false);
  }
}
