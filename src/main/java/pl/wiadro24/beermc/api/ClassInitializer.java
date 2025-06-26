package pl.wiadro24.beermc.api;

import org.slf4j.Logger;

public final class ClassInitializer {
  private Logger logger;

  public ClassInitializer(Logger logger) {
    this.logger = logger;
  }

  public final void initializeClass(Class<?> klass) {
    try {
      Class.forName(klass.getName());
    } catch (ClassNotFoundException e) {
      logger.error(String.format("Couldn't load class: %s", e.getMessage()));
      throw new RuntimeException();
    }
  }
}
