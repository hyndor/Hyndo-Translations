package ru.hyndo.translations.bukkit;

import com.google.common.collect.ImmutableMap;
import ru.hyndo.translations.Translation;
import ru.hyndo.translations.TranslationManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BukkitTranslationManager implements TranslationManager {

    private Map<String, Translation> translationMap;

    BukkitTranslationManager(Map<String, Translation> translationMap) {
        this.translationMap = translationMap;
    }

    @Override
    public Optional<Translation> get(String key) {
        return Optional.ofNullable(translationMap.get(key));
    }

    @Override
    public Translation createTranslation(String key) throws IllegalArgumentException {
        if(translationMap.containsKey(key)) {
            throw new IllegalArgumentException(String.format("Translation %s already exists", key));
        }
        Translation translation = new BukkitTranslation(key);
        translationMap.put(key, translation);
        return translation;
    }

    @Override
    public Map<String, Translation> getTranslations() {
        return ImmutableMap.copyOf(translationMap);
    }

    @Override
    public String toString() {
        return "BukkitTranslationManager{" +
                "translationMap=" + translationMap +
                '}';
    }
}
