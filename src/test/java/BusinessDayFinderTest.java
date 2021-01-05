import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BusinessDayFinderTest {

  private BusinessDayFinder businessDayFinder;

  private LocalDateTime moment;


  @Before
  public void setup() {
    businessDayFinder = new BusinessDayFinder();

    moment = LocalDateTime.now();

  }

  @Test
  public void nextBusinessDayNowIsValid() {
    moment = moment.withYear(2020).withMonth(11).withDayOfMonth(25).withHour(14);
    JasonDate jasonDate = businessDayFinder.nextBusinessDay(moment);
    Assert.assertEquals(jasonDate.getYear(), moment.getYear());
    Assert.assertEquals(jasonDate.getMonth(), moment.getMonthValue());
    Assert.assertEquals(jasonDate.getDay(), moment.getDayOfMonth());
    Assert.assertEquals(jasonDate.getHour(), moment.getHour());
    Assert.assertEquals(jasonDate.getMinute(), moment.getMinute());
    Assert.assertEquals(jasonDate.getSecond(), moment.getSecond());

  }

  @Test
  public void nextBusinessDayFriday5pm(){
    moment = moment.withYear(2020).withMonth(11).withDayOfMonth(27).withHour(17);
    JasonDate jasonDate = businessDayFinder.nextBusinessDay(moment);
    Assert.assertEquals(jasonDate.getYear(), moment.getYear());
    Assert.assertEquals(jasonDate.getMonth(), moment.getMonthValue());
    Assert.assertEquals(jasonDate.getDay(), moment.getDayOfMonth() + 3);
    Assert.assertEquals(jasonDate.getHour(), 9);
    Assert.assertEquals(jasonDate.getMinute(), 0);
    Assert.assertEquals(jasonDate.getSecond(), 0);
  }

  @Test
  public void nextBusinessDaySunday(){
    moment = moment.withYear(2020).withMonth(11).withDayOfMonth(29).withHour(17);
    JasonDate jasonDate = businessDayFinder.nextBusinessDay(moment);
    Assert.assertEquals(jasonDate.getYear(), moment.getYear());
    Assert.assertEquals(jasonDate.getMonth(), moment.getMonthValue());
    Assert.assertEquals(jasonDate.getDay(), moment.getDayOfMonth() + 1);
    Assert.assertEquals(jasonDate.getHour(), 9);
    Assert.assertEquals(jasonDate.getMinute(), 0);
    Assert.assertEquals(jasonDate.getSecond(), 0);
  }

  @Test
  public void nextBusinessDaySaturday(){
    moment = moment.withYear(2020).withMonth(11).withDayOfMonth(28).withHour(17);
    JasonDate jasonDate = businessDayFinder.nextBusinessDay(moment);
    Assert.assertEquals(jasonDate.getYear(), moment.getYear());
    Assert.assertEquals(jasonDate.getMonth(), moment.getMonthValue());
    Assert.assertEquals(jasonDate.getDay(), moment.getDayOfMonth() + 2);
    Assert.assertEquals(jasonDate.getHour(), 9);
    Assert.assertEquals(jasonDate.getMinute(), 0);
    Assert.assertEquals(jasonDate.getSecond(), 0);
  }

  @Test
  public void nextBusinessDayTwoDays(){
    moment = moment.withYear(2020).withMonth(11).withDayOfMonth(25).withHour(17);
    JasonDate jasonDate = businessDayFinder.nextBusinessDay(moment);
    Assert.assertEquals(jasonDate.getYear(), moment.getYear());
    Assert.assertEquals(jasonDate.getMonth(), moment.getMonthValue());
    Assert.assertEquals(jasonDate.getDay(), moment.getDayOfMonth() + 2);
    Assert.assertEquals(jasonDate.getHour(), 9);
    Assert.assertEquals(jasonDate.getMinute(), 0);
    Assert.assertEquals(jasonDate.getSecond(), 0);
  }

  @Test
  public void isChristmas(){
    moment = moment.withYear(2020).withMonth(12).withDayOfMonth(25).withHour(10);
    JasonDate jasonDate = businessDayFinder.nextBusinessDay(moment);
    Assert.assertEquals(jasonDate.getYear(), moment.getYear());
    Assert.assertEquals(jasonDate.getMonth(), moment.getMonthValue());
    Assert.assertEquals(jasonDate.getDay(), moment.getDayOfMonth() + 3);
    Assert.assertEquals(jasonDate.getHour(), 9);
    Assert.assertEquals(jasonDate.getMinute(), 0);
    Assert.assertEquals(jasonDate.getSecond(), 0);

  }

}