import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest
{
  private Clock clock;

  @BeforeEach void setUp()
  {
    System.out.println("---> SetUp()");
    clock = new Clock(0, 0, 0);
  }

  @AfterEach void tearDown()
  {
    System.out.println("<-- tearDown()");
  }

  private String getClock(Clock clock)
  {
    String value =
        clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
    return value;
  }

  @Test void setZero()
  {
    System.out.println("setZero()");
    clock.set(0, 0, 0);
    assertEquals("0:0:0", getClock(clock));
  }

  @Test void setOne()
  {
    System.out.println("setOne()");
    clock.set(0, 0, 1);
    assertEquals("0:0:1", getClock(clock));
    clock.set(0, 1, 0);
    assertEquals("0:1:0", getClock(clock));
    clock.set(1, 0, 0);
    assertEquals("1:0:0", getClock(clock));
  }

  @Test void setMany()
  {
    System.out.println("setMany()");
    clock.set(12, 15, 20);
    assertEquals("12:15:20", getClock(clock));
    clock.set(7, 41, 9);
    assertEquals("7:41:9", getClock(clock));
  }

  @Test void setBoundary()
  {
    System.out.println("setBoundary()");
    System.out.println("Lower left boundary -1");
    assertThrows(IllegalArgumentException.class, () -> {
      clock.set(0, 0, -1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      clock.set(0, -1, 0);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      clock.set(-1, 0, 0);
    });

    System.out.println("Upper left boundary 59 and 23");
    clock.set(0, 0, 59);
    assertEquals("0:0:59", getClock(clock));
    clock.set(0, 59, 0);
    assertEquals("0:59:0", getClock(clock));
    clock.set(23, 0, 0);
    assertEquals("23:0:0", getClock(clock));

    System.out.println("Upper right boundary 60 and 24");
    assertThrows(IllegalArgumentException.class, () -> {
      clock.set(0, 0, 60);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      clock.set(0, 60, 0);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      clock.set(24, 0, 0);
    });
  }


}