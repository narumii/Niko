package uwu.narumi.niko.helper;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;


public final class SystemHelper {

  private static final com.sun.management.OperatingSystemMXBean osBean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
      .getOperatingSystemMXBean();

  public static String humanReadableByteCount(long bytes, boolean si) {
    int unit = si ? 1000 : 1024;
    if (bytes < unit) {
      return bytes + " B";
    }

    int exp = (int) (Math.log(bytes) / Math.log(unit));
    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
  }

  public static OperatingSystemMXBean getOsBean() {
    return osBean;
  }
}
