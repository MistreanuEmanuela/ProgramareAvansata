package org.example;
import comm.Command;
import comm.DisplayLocales;
import comm.Info;
import comm.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    private static final String DEFAULT_LANGUAGE = "en-US";
    private static final String DEFAULT_COUNTRY = "us";
    private static String BASE_NAME = "res.Messages";
    private static ResourceBundle messages;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Locale.setDefault(new Locale(DEFAULT_LANGUAGE, DEFAULT_COUNTRY));
        messages = ResourceBundle.getBundle(BASE_NAME);

        while (true) {
            System.out.println(messages.getString("prompt"));
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                break;
            }

            Command command = parseCommand(input);
            if (command != null) {
                command.execute();
            } else {
                System.out.println(messages.getString("invalid"));
            }
        }
        scanner.close();
    }

    private static Command parseCommand(String input) {
        String[] tokens = input.split(" ");

        if (tokens.length > 0) {
            String commandName = tokens[0].toLowerCase();

            if (commandName.equals("displaylocales")) {
                System.out.println(messages.getString("locales"));
                return new DisplayLocales();
            }
            else if (commandName.equals("setlocale")) {
                if (tokens.length > 1) {
                    String languageTag = tokens[1];
                    System.out.println(languageTag);
                    if(languageTag.equals("ro-Ro"))
                    {
                        BASE_NAME = "res.Messages_ro";
                        messages = ResourceBundle.getBundle(BASE_NAME);
                    }
                    else
                    {
                        BASE_NAME = "res.Messages";
                        messages = ResourceBundle.getBundle(BASE_NAME);
                    }
                    System.out.println(messages.getString("locale.set"));
                    return new SetLocale(languageTag);
                }
            }
            else if (commandName.equals("info")) {
                Locale locale = Locale.getDefault();
                if (tokens.length > 1) {
                    String languageTag = tokens[1];

                    locale = Locale.forLanguageTag(languageTag);
                }
                return new Info(locale);
            }
        }

        return null;
    }
}
