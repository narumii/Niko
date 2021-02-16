package uwu.narumi.niko.helper;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

public final class ChatHelper {

  private static final String PREFIX = "にこ";
  private static final Minecraft mc = Minecraft.getMinecraft();

  public static String fix(String string) {
    return string.replace('&', '§').replace(">>", "»");
  }

  public static void printMessage(String message) {
    printMessage(message, true);
  }

  public static void printMessage(String message, boolean prefix) {
    mc.thePlayer.addChatMessage(new ChatComponentText(fix("&d" + PREFIX + " &8>> &7" + message)));
  }
}
