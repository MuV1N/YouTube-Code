package de.muv1n.bot;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dotenv dotenv = Dotenv.load();
        new BotMain(dotenv.get("TOKEN"));
    }
}