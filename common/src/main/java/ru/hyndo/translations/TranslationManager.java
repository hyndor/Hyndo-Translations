package ru.hyndo.translations;

import javax.swing.text.html.Option;
import java.util.Map;
import java.util.Optional;

public interface TranslationManager {

    Optional<Translation> get(String key);

    Translation createTranslation(String key) throws IllegalArgumentException;

    Map<String, Translation> getTranslations();

    default Translation getOrCreateTranslation(String key) {
        return get(key).orElseGet(() -> createTranslation(key));
    }
}
