package uwu.narumi.niko.helper;

public class TimeHelper {

  private long time;

  public TimeHelper() {
    time = getCurrentTime();
  }

  public static long getCurrentTime() {
    return System.nanoTime() / 1000000L; //replacement for System.currentTimeMillis()
  }

  public boolean passed(long time) {
    return getTime() > time;
  }

  public void reset() {
    time = getCurrentTime();
  }

  public long getTime() {
    return getCurrentTime() - time;
  }
}
