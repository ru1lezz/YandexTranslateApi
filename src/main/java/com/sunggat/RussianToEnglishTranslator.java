package com.sunggat;

public class RussianToEnglishTranslator implements Translator {

    private final TranslationApiClient translationApiClient;

    public RussianToEnglishTranslator(TranslationApiClient translationApiClient) {
        this.translationApiClient = translationApiClient;
    }

    @Override
    public String translate(String text) {
        TranslationResult translationResult = translationApiClient.translate(text);
        return translationResult.getText();
    }
}
