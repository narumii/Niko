package uwu.narumi.niko;

import java.io.IOException;
import net.arikia.dev.drpc.DiscordRPC;
import org.lwjgl.opengl.Display;
import uwu.narumi.niko.command.CommandManager;
import uwu.narumi.niko.command.impl.ExploitCommand;
import uwu.narumi.niko.command.impl.FakeGamemodeCommand;
import uwu.narumi.niko.command.impl.HelpCommand;
import uwu.narumi.niko.command.impl.OnlineCommand;
import uwu.narumi.niko.exploit.ExploitManager;
import uwu.narumi.niko.exploit.impl.creative.AnvilExploit;
import uwu.narumi.niko.exploit.impl.flood.AttackExploit;
import uwu.narumi.niko.exploit.impl.nbt.BookExploit;
import uwu.narumi.niko.exploit.impl.nbt.ExploitFixerExploit;
import uwu.narumi.niko.exploit.impl.nbt.OnePacketExploit;
import uwu.narumi.niko.exploit.impl.other.ChunkLoadExploit;
import uwu.narumi.niko.exploit.impl.other.FaweExploit;
import uwu.narumi.niko.exploit.impl.other.SpamExploit;
import uwu.narumi.niko.helper.NetHelper;
import uwu.narumi.niko.helper.OpenGlHelper;
import uwu.narumi.niko.rpc.DiscordRichPresenceManager;

public enum Niko {
  INSTANCE;

  private final CommandManager commandManager;
  private final ExploitManager exploitManager;
  private final DiscordRichPresenceManager discordRichPresence;

  Niko() {
    System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase", "false");

    discordRichPresence = new DiscordRichPresenceManager();
    commandManager = new CommandManager(
        new ExploitCommand(),
        new HelpCommand(),
        new OnlineCommand(),
        new FakeGamemodeCommand()
    );

    exploitManager = new ExploitManager(
        new AnvilExploit(),
        new AttackExploit(),
        new BookExploit(),
        new SpamExploit(),
        new FaweExploit(),
        new ChunkLoadExploit(),
        new ExploitFixerExploit(),
        new OnePacketExploit()
    );

    //If you want to use niko from launcher please remove this
    NetHelper.createSession("FuckYooniks", null);
    Runtime.getRuntime().addShutdownHook(new Thread(this::shutDown));
  }

  public void setDisplay() throws IOException {
    Display.setTitle("NikoClient | http://github.com/narumii/niko");
    OpenGlHelper
        .setWindowIcon("https://i.imgur.com/ONORz2g.png", "https://i.imgur.com/xAIIIeb.png");
  }

  public void shutDown() {
    DiscordRPC.discordShutdown();
  }

  public CommandManager getCommandManager() {
    return commandManager;
  }

  public ExploitManager getExploitManager() {
    return exploitManager;
  }

  public DiscordRichPresenceManager getDiscordRichPresence() {
    return discordRichPresence;
  }
}
