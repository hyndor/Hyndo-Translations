package ru.hyndo.translations.bukkit;

import org.bukkit.entity.Player;
import ru.hyndo.translations.AbstractSingleLanguageResolver;
import ru.hyndo.translations.Translation;
import ru.hyndo.translations.TranslationManager;
import ru.hyndo.translations.TranslationResolver;

import java.util.Locale;
import java.util.Optional;

public class BukkitSingleLanguageResolver extends AbstractSingleLanguageResolver<Player> {

    private TranslationManager translationManager;

    public BukkitSingleLanguageResolver(Locale locale, TranslationManager translationManager) {
        super(locale);
        this.translationManager = translationManager;
    }


    @Override
    public void send(Player player, Translation translation, String... args) {
        String computed = translation.get(resolve(player), args);
        player.sendMessage(computed);
    }

    @Override
    public void getAndSend(Player player, String key, String... args) {
        Translation translation = translationManager.getOrCreateTranslation(key);
        send(player, translation, args);
    }

}
