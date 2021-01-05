import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name= "jsonDates")
public class JasonDate {

  @NotNull
  private int year;

  @NotNull
  private int month;

  @NotNull
  private int day;

  @NotNull
  private int hour;

  @NotNull
  private int minute;

  @NotNull
  private int second;

  public JasonDate(LocalDateTime moment){
    this.year = moment.getYear();
    this.month = moment.getMonthValue();
    this.day = moment.getDayOfMonth();
    this.hour = moment.getHour();
    this.minute = moment.getMinute();
    this.second = moment.getSecond();
  };

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getHour() {
    return hour;
  }

  public void setHour(int hour) {
    this.hour = hour;
  }

  public int getMinute() {
    return minute;
  }

  public void setMinute(int minute) {
    this.minute = minute;
  }

  public int getSecond() {
    return second;
  }

  public void setSecond(int second) {
    this.second = second;
  }
}

