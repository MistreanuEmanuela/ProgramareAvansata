package comm;
import java.text.DateFormatSymbols;
import java.util.Currency;
import java.util.Locale;
public class DisplayLocales implements Command {

    @Override
    public void execute() {
        Locale[] availableLocales = Locale.getAvailableLocales();
        for (Locale locale : availableLocales) {
            System.out.println(locale.toString());
        }
    }
}