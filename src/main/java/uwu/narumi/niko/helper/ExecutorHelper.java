package uwu.narumi.niko.helper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorHelper {

  private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

  public static void submit(Runnable runnable) {
    EXECUTOR_SERVICE.submit(runnable);
  }
}
