package com.sunggat;

import java.io.IOException;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) throws IOException {
        TranslationApiClient translationApiClient = new TranslationApiClientImpl();
        Translator translator = new RussianToEnglishTranslator(translationApiClient);
        CommandLineRunner commandLineRunner = new CommandLineRunnerImpl(translator);
        commandLineRunner.run();
    }
}
