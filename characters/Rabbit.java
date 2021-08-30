package com.company.characters;


import com.company.enums.Sex;

public class Rabbit extends Characters {
    public Rabbit(String name, double borntime, Sex sex, double force, String homeAdress) {
        super(name, borntime, sex, force, homeAdress);
    }

    public void command() {
        System.out.println("Throw!");
    }

    public void protrude() {
    }
}
