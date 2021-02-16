package uwu.narumi.niko.hook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import org.lwjgl.opengl.GL11;
import uwu.narumi.niko.helper.ChatHelper;
import uwu.narumi.niko.helper.OpenGlHelper;
import uwu.narumi.niko.helper.SystemHelper;

public class GuiInGameHook extends GuiIngame {

  private static final Minecraft mc = Minecraft.getMinecraft();

  public GuiInGameHook(Minecraft mcIn) {
    super(mcIn);
  }

  @Override
  public void renderGameOverlay(float partialTicks) {
    super.renderGameOverlay(partialTicks);

    GL11.glScaled(2.0, 2.0, 2.0);
    mc.fontRendererObj.drawStringWithShadow("N§7iko", 1, 1, OpenGlHelper.rainbowColor(3000, 1));
    GL11.glScaled(0.5, 0.5, 0.5);

    if (!mc.isSingleplayer()) {
      int x = (int) mc.thePlayer.posX, y = (int) mc.thePlayer.posY, z = (int) mc.thePlayer.posZ;
      long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

      mc.fontRendererObj
          .drawStringWithShadow(ChatHelper.fix("&fSession: &d" + mc.session.getUsername()), 5, 20,
              0);
      mc.fontRendererObj
          .drawStringWithShadow(ChatHelper.fix("&fServer: &d" + mc.getCurrentServerData().serverIP),
              5, 30, 0);

      if (mc.thePlayer.getClientBrand() != null) {
        mc.fontRendererObj.drawStringWithShadow(
            ChatHelper.fix("&fServer brand: &d" + mc.thePlayer.getClientBrand().split(" ")[0]), 5,
            40, 0);
      }

      mc.fontRendererObj
          .drawStringWithShadow(ChatHelper.fix("&fFPS: &d" + Minecraft.debugFPS), 5, 60, 0);
      mc.fontRendererObj
          .drawStringWithShadow(ChatHelper.fix(String.format("&fX, Y, Z: &d%s, %s, %s", x, y, z)),
              5, 70, 0);

      mc.fontRendererObj.drawStringWithShadow(ChatHelper.fix(
          String.format("&fCPU Usage: &d%.2f", SystemHelper.getOsBean().getProcessCpuLoad() * 1000 / 10)
              + "&d%"), 5, 90, 0);
      mc.fontRendererObj.drawStringWithShadow(ChatHelper.fix(String
              .format("&fRAM Usage: &d%s/%s", SystemHelper.humanReadableByteCount(usedMemory, false),
                  SystemHelper.humanReadableByteCount(Runtime.getRuntime().totalMemory(), false))), 5,
          100, 0);
    }
  }
}
