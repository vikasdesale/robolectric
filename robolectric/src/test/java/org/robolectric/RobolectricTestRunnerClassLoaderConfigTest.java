package org.robolectric;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.internal.bytecode.InstrumentingClassLoader;
import org.robolectric.test.DummyClass;

@RunWith(TestRunners.SelfTest.class)
public class RobolectricTestRunnerClassLoaderConfigTest {

  @Test
  public void testUsingClassLoader() throws ClassNotFoundException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    Assert.assertEquals(classLoader.getClass().getName(), InstrumentingClassLoader.class.getName());
  }

  @Test
  public void testGetPackage() {
    assertThat(DummyClass.class.getClassLoader()).isInstanceOf(InstrumentingClassLoader.class);
    assertThat(DummyClass.class.getPackage()).isNotNull();
    assertThat(DummyClass.class.getName()).startsWith(DummyClass.class.getPackage().getName());
  }
}
