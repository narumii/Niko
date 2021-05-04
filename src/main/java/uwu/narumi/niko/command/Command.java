package uwu.narumi.niko.command;

import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.Validate;
import uwu.narumi.niko.exception.CommandException;

public abstract class Command {

  protected static final Minecraft mc = Minecraft.getMinecraft();
  private final String alias;
  private final String description;
  private final String usage;
  private final List<String> aliases;

  public Command() {
    CommandInfo commandInfo = this.getClass().getDeclaredAnnotation(CommandInfo.class);
    Validate.notNull(commandInfo, "CONFUSED ANNOTATION EXCEPTION");

    this.alias = commandInfo.alias();
    this.description = commandInfo.description();
    this.usage = commandInfo.usage();
    this.aliases = Arrays.asList(commandInfo.aliases());
  }

  public abstract void execute(String... args) throws CommandException;

  public boolean is(String string) {
    return string.equalsIgnoreCase(alias) || aliases.stream()
        .anyMatch(stream -> stream.equalsIgnoreCase(string));
  }

  public String getAlias() {
    return alias;
  }

  public String getDescription() {
    return description;
  }

  public String getUsage() {
    return usage;
  }

  public List<String> getAliases() {
    return aliases;
  }
}
