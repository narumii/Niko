package uwu.narumi.niko.helper;

import java.util.function.Supplier;

public class LazySupplier<T> implements Supplier<T> {

  private final Supplier<T> wrapped;
  private volatile T value;

  public LazySupplier(Supplier<T> wrapped) {
    this.wrapped = wrapped;
  }

  @Override
  public synchronized T get() {
    if (value == null) {
      value = wrapped.get();
    }

    return value;
  }
}
