package comm;
import java.util.Locale;
public class SetLocale implements Command {
    private final String languageTag;

    public SetLocale(String languageTag) {
        this.languageTag = languageTag;
    }

    @Override
    public void execute() {
        Locale locale = Locale.forLanguageTag(languageTag);
        Locale.setDefault(locale);
    }
}