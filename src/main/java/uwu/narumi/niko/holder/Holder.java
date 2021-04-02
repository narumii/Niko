package uwu.narumi.niko.holder;

import java.util.ArrayList;
import java.util.List;
import uwu.narumi.niko.helper.TimeHelper;

public class Holder {

  private static final TimeHelper TIME_HELPER = new TimeHelper(); //for tps calculation
  private static final List<Long> TPS_TIMES = new ArrayList<>();
  private static long lastPacketMS = -1;
  private static double TPS = -1;

  public static TimeHelper getTimeHelper() {
    return TIME_HELPER;
  }

  public static List<Long> getTpsTimes() {
    return TPS_TIMES;
  }

  public static long getLastPacketMS() {
    return lastPacketMS;
  }

  public static void setLastPacketMS(long lastPacketMS) {
    Holder.lastPacketMS = lastPacketMS;
  }

  public static double getTPS() {
    return TPS;
  }

  public static void setTPS(double TPS) {
    Holder.TPS = TPS;
  }
}
