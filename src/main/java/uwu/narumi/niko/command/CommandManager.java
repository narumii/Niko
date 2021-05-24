package uwu.narumi.niko.command;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import uwu.narumi.niko.exception.CommandException;
import uwu.narumi.niko.helper.ChatHelper;

public class CommandManager {

  private static final String PREFIX = ".";

  private final List<Command> commands;

  public CommandManager(Command... commands) {
    this.commands = Arrays.asList(commands);
  }

  public static String getPrefix() {
    return PREFIX;
  }

  public boolean handleCommand(String message) {
    if (/*message.isBlank() ||*/ message.isEmpty()) {
      return false;
    }

    String[] args = message.substring(1).split(" ");
    try {
      getCommand(args[0])
          .orElseThrow(() -> new CommandException(String
              .format("Command \"%s\" not found. Use \".help\" to see command list.", args[0])))
          .execute(Arrays.copyOfRange(args, 1, args.length));
    } catch (CommandException e) {
      ChatHelper.printMessage(e.getMessage());
    }

    /*getCommand(args[0]).ifPresentOrElse(command -> {
      try {
        command.execute(Arrays.copyOfRange(args, 1, args.length));
      } catch (CommandException e) {
        ChatHelper.printMessage(e.getMessage());
      }
    }, () -> ChatHelper.printMessage(
        String.format("Command \"%s\" not found. Use \".help\" to see command list.", args[0])));*/

    return true;
  }

  public void registerCommand(Command command) {
    this.commands.add(command);
  }

  public void registerCommands(Command... commands) {
    this.commands.addAll(Arrays.asList(commands));
  }

  public void unregisterCommand(Command command) {
    this.commands.remove(command);
  }

  public void unregisterCommands(Command... commands) {
    this.commands.removeAll(Arrays.asList(commands));
  }

  public Optional<Command> getCommand(String alias) {
    return commands.stream().filter(command -> command.is(alias)).findFirst();
  }

  public List<Command> getCommands() {
    return commands;
  }
}
