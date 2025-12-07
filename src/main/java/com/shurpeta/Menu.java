package com.shurpeta;

import com.shurpeta.command.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<String, Command> menuItems = new LinkedHashMap<>();
    private TariffManager manager;

    public Menu() {
        this.manager = new TariffManager();
        menuItems.put("view", new ViewCommand(manager));
        menuItems.put("load", new LoadCommand(manager));
        menuItems.put("find", new FindCommand(manager));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть 'help' для списку.");

        while (true) {
            System.out.print("\nВведіть команду: ");
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) continue;
            String[] parts = line.split(" ", 2);
            String commandName = parts[0].toLowerCase();
            String details = (parts.length > 1) ? parts[1] : null;

            if (commandName.equals("exit")) {
                System.out.println("До побачення!");
                break;
            }

            if (commandName.equals("help")) {
                showHelp();
                continue;
            }

            if (menuItems.containsKey(commandName)) {
                Command cmd = menuItems.get(commandName);
                cmd.execute(details);
            } else {
                System.out.println("Невідома команда. Напиши 'help'.");
            }
        }
    }

    private void showHelp() {
        System.out.println("МЕНЮ");
        System.out.println("help  - Показати це меню");
        System.out.println("exit  - Вийти");
        for (Map.Entry<String, Command> entry : menuItems.entrySet()) {
            System.out.printf("%-5s - %s%n", entry.getKey(), entry.getValue().getDescription());
        }
    }
}