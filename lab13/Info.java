package comm;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info implements Command {

    private final Locale locale;

    public Info(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void execute() {
        System.out.println("Country: " + locale.getDisplayCountry(locale));
        System.out.println("Language: " + locale.getDisplayLanguage(locale));
        Currency currency = Currency.getInstance(locale);
        System.out.println("Currency: " + currency.getCurrencyCode() + " (" + currency.getDisplayName(locale) + ")");
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(locale);
        String[] weekDays = dateFormatSymbols.getWeekdays();
        System.out.print("Week Days: ");
        for (int i = 1; i < weekDays.length; i++) {
            System.out.print(weekDays[i] + ", ");
        }
        System.out.println();
        String[] months = dateFormatSymbols.getMonths();
        System.out.print("Months: ");
        for (String month : months) {
            System.out.print(month + ", ");
        }
        System.out.println();
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", locale);
        System.out.println("Today: " + dateFormat.format(currentDate));
    }
}