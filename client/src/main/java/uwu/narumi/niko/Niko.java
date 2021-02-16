package uwu.narumi.niko;

import java.io.IOException;
import org.lwjgl.opengl.Display;
import uwu.narumi.niko.command.CommandManager;
import uwu.narumi.niko.command.impl.CrashCommand;
import uwu.narumi.niko.command.impl.HelpCommand;
import uwu.narumi.niko.exploit.ExploitManager;
import uwu.narumi.niko.exploit.impl.creative.HopperExploit;
import uwu.narumi.niko.exploit.impl.flood.AttackExploit;
import uwu.narumi.niko.exploit.impl.nbt.BookExploit;
import uwu.narumi.niko.helper.NetHelper;
import uwu.narumi.niko.helper.OpenGlHelper;

public enum Niko {
  INSTANCE;

  private final CommandManager commandManager;
  private final ExploitManager exploitManager;

  Niko() {
    commandManager = new CommandManager(new CrashCommand(), new HelpCommand());
    exploitManager = new ExploitManager(new HopperExploit(), new AttackExploit(),
        new BookExploit());

    NetHelper.createSession("AraAraZapierdala", null);
  }

  public void setDisplay() throws IOException {
    Display.setTitle("NikoClient | http://github.com/narumii/niko");
    OpenGlHelper
        .setWindowIcon("https://i.imgur.com/ONORz2g.png", "https://i.imgur.com/xAIIIeb.png");
  }

  public CommandManager getCommandManager() {
    return commandManager;
  }

  public ExploitManager getExploitManager() {
    return exploitManager;
  }
}
