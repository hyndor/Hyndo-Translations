package ru.hyndo.translations;

import java.util.Locale;

public abstract class AbstractSingleLanguageResolver<T> implements TranslationResolver<T> {

    private Locale locale;

    public AbstractSingleLanguageResolver(Locale locale) {
        this.locale = locale;
    }

    @Override
    public Locale resolve(T player) {
        return locale;
    }
}
