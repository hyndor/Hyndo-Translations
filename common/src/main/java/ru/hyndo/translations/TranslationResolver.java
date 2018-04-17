package ru.hyndo.translations;

import java.util.Locale;

public interface TranslationResolver<T> {

    void send(T player, Translation translation, String... args);

    default void send(T player, Translation translation) {
        send(player, translation, new String[] {});
    }

    default void getAndSend(T player, String key) {
        getAndSend(player, key, new String[] {});
    }

    void getAndSend(T player, String key, String... args);
    

    Locale resolve(T player);

}
