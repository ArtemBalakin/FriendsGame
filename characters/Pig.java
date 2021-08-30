package com.company.characters;


import com.company.enums.Act_Stat;
import com.company.enums.Sex;

public class Pig extends Characters {
    public Pig(String name, double borntime, Sex sex, double force, String homeAdress) {
        super(name, borntime, sex, force, homeAdress);
    }

    public void worry(Act_Stat act_stat) {
        System.out.println(this.name + " " + act_stat + " worried");
    }
}
