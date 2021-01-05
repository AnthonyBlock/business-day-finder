import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.DayOfWeek;
import java.time.temporal.ChronoUnit;

public class BusinessDayFinder {

  public LocalDateTime setToOpenTime(LocalDateTime moment, int openTime) {

    LocalDateTime openingTime = moment.truncatedTo(ChronoUnit.DAYS).withHour(openTime);

    return openingTime;
  }

  public boolean isBeforeOpen(LocalDateTime moment, int openTime){

    int hourOfDay = moment.getHour();

    if (hourOfDay < openTime) {
      return true;
    }
    else{
      return false;
    }
  }

  public boolean isAfterClose(LocalDateTime moment, int closeTime){

    int hourOfDay = moment.getHour();

    if (hourOfDay > closeTime) {
      return true;
    }
    else{
      return false;
    }
  }

  public boolean isWeekend(LocalDateTime moment){

    DayOfWeek dayOfWeek = moment.getDayOfWeek();

    if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
      return true;
    }
    else {
      return false;
    }
  }

  public boolean isBankingHoliday(LocalDateTime moment) {

    LocalDate momentDate = moment.toLocalDate();

    int today = moment.getDayOfYear();

    if (momentDate.isLeapYear() && today > 60){
      today = today - 1;
    }

    int newYears = 1;

    int mlk = 20;

    int presidents = 48;

    int memorial = 145;

    int independence = 185;

    int labor = 250;

    int columbus = 285;

    int veterans = 315;

    int thanksgiving = 330;

    int christmas = 359;


    if (today == newYears || today == mlk || today == presidents || today == memorial || today == independence || today == labor || today == columbus || today == veterans || today == thanksgiving || today == christmas){
      return true;
    }
    else {
      return false;
    }

  }

  public JasonDate nextBusinessDay(LocalDateTime moment) {

    int openTime = 9;

    int closeTime = 16;

    if (isBeforeOpen(moment, openTime)) {
      moment = setToOpenTime(moment, openTime);
    }

    if (isAfterClose(moment, closeTime)){
      moment = moment.plusDays(1);
      moment = setToOpenTime(moment, openTime);
    }

    if (isWeekend(moment) || isBankingHoliday(moment)){
      while (isWeekend(moment) || isBankingHoliday(moment)){
       moment= moment.plusDays(1);
      }
      moment = setToOpenTime(moment, openTime);
    }

    return new JasonDate(moment);
  }

}


