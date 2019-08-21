package com.example.alunos.conversores20;

public class Temperatura {
    public double getCelsiusFromFahr (double fahr){
        return (fahr - 32) * 5 / 9;

    }

    public double getFahrFromCelsius (double celsius) {
        return celsius * 9 / 5 + 32;
    }
}
