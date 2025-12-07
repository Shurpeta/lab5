package com.shurpeta.command;

import com.shurpeta.models.BasicTariff;
import com.shurpeta.models.InternetTariff;
import com.shurpeta.models.Tariff;
import com.shurpeta.models.UnlimitedTariff;

import java.util.ArrayList;
import java.util.List;

public class TariffManager {
    private List<Tariff> tariffs = new ArrayList<>();
    public void loadDefaultData() {
        tariffs.add(new BasicTariff("Економ", 100, 500));
        tariffs.add(new InternetTariff("СуперНет", 250, 1200));
        tariffs.add(new UnlimitedTariff("Безлім", 400, 300));
        System.out.println("-> Дані завантажено!");
    }

    public void showAll() {
        if (tariffs.isEmpty()) {
            System.out.println("Список пустий.");
            return;
        }
        for (Tariff t : tariffs) {
            System.out.println(t);
        }
    }
    public void find(String params) {
        System.out.println("-> Шукаємо тариф за параметрами: " + params);
    }
}