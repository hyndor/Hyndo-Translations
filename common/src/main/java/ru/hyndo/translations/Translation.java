package ru.hyndo.translations;

import java.util.Locale;
import java.util.Map;

public interface Translation {

    /**
     * @return translation id
     */
    String getId();

    /**
     * @param locale translation locale
     * @return i18n translation
     */
    default String get(Locale locale) {
        return get(locale, new String[] {});
    }

    /**
     * @param locale translation locale
     * @param args args to be appended in the translation. MessageFormat is used
     * @return i18n translation
     */
    String get(Locale locale, String... args);

    /**
     * @return immutable view of all translations
     */
    Map<Locale, String> getTranslations();

    /**
     * @param text i18 translation
     * @param locale language
     */
    void set(String text, Locale locale);

}
