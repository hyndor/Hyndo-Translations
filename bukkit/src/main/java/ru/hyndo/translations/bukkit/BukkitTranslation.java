package ru.hyndo.translations.bukkit;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import javafx.util.Pair;
import ru.hyndo.translations.Translation;

import java.text.MessageFormat;
import java.util.*;

public class BukkitTranslation implements Translation {

    private Map<Locale, MessageFormat> locales = new HashMap<>();
    private String id;

    BukkitTranslation(String id, Map<Locale, String> locales) {
        this.locales = Maps.transformValues(locales, MessageFormat::new);
        this.id = id;
    }

    BukkitTranslation(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String get(Locale locale, String... args) {
        return locales.get(locale).format(args);
    }

    @Override
    public Map<Locale, String> getTranslations() {
        return ImmutableMap.copyOf(Maps.transformValues(locales, messageFormat -> messageFormat != null ? messageFormat.format("") : null));
    }

    @Override
    public void set(String s, Locale locale) {
        locales.put(locale, new MessageFormat(s));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BukkitTranslation that = (BukkitTranslation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "BukkitTranslation{" +
                "locales=" + locales +
                ", id='" + id + '\'' +
                '}';
    }
}