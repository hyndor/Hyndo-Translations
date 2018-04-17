package ru.hyndo.translations;

public interface TranslationLoader<T> {

    TranslationManager load(T source);

}
