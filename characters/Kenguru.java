package com.company.characters;


import com.company.enums.Act_Stat;
import com.company.enums.Sex;

public class Kenguru extends Characters {
    public Kenguru(String name, double borntime, Sex sex, double force, String homeAdress) {
        super(name, borntime, sex, force, homeAdress);
    }

    public void squek(String s) {
        System.out.println(this.name + " squek:\n\t " + s);
        this.stress_level += 3.0D;
    }

    public void jump(Act_Stat act_stat) throws InterruptedException {
        System.out.println(this.name + " jump " + act_stat);
        Thread.sleep(1000L);
    }
}
