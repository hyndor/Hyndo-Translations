package ru.hyndo.translations.bukkit;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import ru.hyndo.translations.StandardLocales;
import ru.hyndo.translations.Translation;
import ru.hyndo.translations.TranslationLoader;
import ru.hyndo.translations.TranslationManager;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SingleLangYamlTranslationLoader implements TranslationLoader<YamlConfiguration> {

    @Override
    public TranslationManager load(YamlConfiguration source) {
        Map<String, Translation> translationMap = new HashMap<>();
        for (String key : source.getKeys(false)) {
            ConfigurationSection translationCfg = source.getConfigurationSection(key);
            Map<Locale, String> locales = new HashMap<>();
            locales.put(StandardLocales.RUSSIAN, translationCfg.getString("translation"));
            Translation translation = new BukkitTranslation("", locales);
            translationMap.put(key, translation);
        }
        return new BukkitTranslationManager(translationMap);
    }

}
