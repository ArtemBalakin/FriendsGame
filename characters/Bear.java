package com.company.characters;


import com.company.enums.Act_Stat;
import com.company.enums.Sex;
import com.company.games.Games;
import com.company.objects.items.Bridge;
import com.company.objects.items.Obct;


import java.util.Random;

public class Bear extends Characters {
    public Bear(String name, double borntime, Sex sex, double force, String homeAdress) {
        super(name, borntime, sex, force, homeAdress);
    }

    public void teach(Characters student, Games game) {
        Random random = new Random();
        boolean flag = false;

        while(!flag) {
            if (random.nextBoolean()) {
                System.out.println(this.name + " научил " + student.name + " играть в " + game.getTitle());
                student.skills.add(game.getTitle());
                flag = true;
            } else {
                System.out.println("Обучить не удалось. Герои повторяют попытку");
            }
        }

    }

    @Override
    public void rush(Bridge.Story_Bridge var1, Act_Stat var2) {

    }

    @Override
    public void lookAt(Obct var1, Act_Stat var2) throws InterruptedException {

    }

    @Override
    public void see(Obct var1) throws InterruptedException {

    }


    }



