package com.sunggat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineRunnerImpl implements CommandLineRunner {

    private final Translator translator;

    public CommandLineRunnerImpl(Translator translator) {
        this.translator = translator;
    }

    @Override
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        while(!(text = reader.readLine()).equals("exit")) {
            System.out.println(translator.translate(text));
        }
    }
}
