package ru.hyndo.translations.bukkit;

import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.*;
import ru.hyndo.translations.StandardLocales;
import ru.hyndo.translations.Translation;
import ru.hyndo.translations.TranslationManager;

import java.io.File;
import java.util.Optional;

import static org.junit.Assert.*;

public class SingleLangYamlTranslationLoaderTest {

    @Test
    public void load() {
        SingleLangYamlTranslationLoader translationLoader = new SingleLangYamlTranslationLoader();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("singletranslations.yml").getFile());
        TranslationManager manager = translationLoader.load(YamlConfiguration.loadConfiguration(file));
        System.out.println(manager.getTranslations());
        Optional<Translation> translationOptional = manager.get("firstTranslation");
        assertTrue(translationOptional.isPresent());
        Translation translation = translationOptional.get();
        assertEquals(translation.get(StandardLocales.RUSSIAN), "Первый перевод");
        Optional<Translation> secondOpt = manager.get("secondTranslation");
        assertTrue(secondOpt.isPresent());
        assertEquals(secondOpt.get().get(StandardLocales.RUSSIAN), "Второй перевод");
        Optional<Translation> argsTranslationOptional = manager.get("argsTranslation");
        assertTrue(argsTranslationOptional.isPresent());
        String s = argsTranslationOptional.get().get(StandardLocales.RUSSIAN, "Хер", "Пизда");
        assertEquals(s, "Тут типо Хер а там типо хер Пизда");
    }
}