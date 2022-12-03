package de.muv1n.bot;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;

public class Main {
    private static final Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) throws InterruptedException, IOException {
        Dotenv dotenv = Dotenv.load();
        new BotMain(dotenv.get("TOKEN"));

    }
    public static Dotenv getDotenv() {
        return dotenv;
    }
}