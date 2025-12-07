package com.shurpeta.command;

import java.util.Scanner;

public class FindCommand implements Command {
    private TariffManager manager;

    public FindCommand(TariffManager manager) {
        this.manager = manager;
    }

    @Override
    public void execute(String details) {
        if (details != null && !details.isEmpty()) {
            manager.find(details);
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введіть діапазон ціни (мін-макс): ");
            String input = scanner.nextLine();
            manager.find(input);
        }
    }

    @Override
    public String getDescription() {
        return "Знайти тариф (можна ввести параметри одразу або потім)";
    }
}