package com.company;


import com.company.characters.*;
import com.company.enums.Act_Stat;
import com.company.enums.Bump_Size;
import com.company.enums.Sex;
import com.company.exeption.NotEnoughItemsExeption;
import com.company.games.Pushishki;
import com.company.games.nonsense;
import com.company.objects.items.Bridge;
import com.company.objects.items.Bump;
import com.company.objects.items.River;
import com.company.objects.items.Sticks;

public class Main {
    public static void main(String[] args) throws InterruptedException, NotEnoughItemsExeption {
        System.out.println("Вам предстоит поучаствовать в событиях рассказа про Винни и его друзей.(В зависимости от вашего выбора история может изменяться)");
        River river = new River("River", 10.0D, 1.7976931348623157E308D);
        Bear bear = new Bear("Vinnie", (double) System.currentTimeMillis(), Sex.MALE, 10.0D, "Vinnie home");
        Pig pig = new Pig("Piglet", (double) System.currentTimeMillis(), Sex.MALE, 5.0D, "Piglet home");
        Rabbit rabbit = new Rabbit("Rabbit", (double) System.currentTimeMillis(), Sex.MALE, 3.0D, "Rabbit home");
        Kenguru little_roo = new Kenguru("Little Roo", (double) System.currentTimeMillis(), Sex.MALE, 6.0D, "Littleroo home");
        new Bump("Маленькая шишка", Bump_Size.LITTLE, 0.1D);
        Characters Eeyore = new Characters("Иа-Иа", (double) System.currentTimeMillis(), Sex.MALE, 5.0D, "Eeyore home") {
            public void swim() {
                System.out.println(this.name + " floats with his feet up ");
            }
        };
        Characters[] characters = new Characters[]{little_roo, pig, rabbit, bear};
        Bridge.Story_Bridge story_bridge = new Bridge.Story_Bridge("Bridge", 10000.0D);
        Pushishki pushishki = new Pushishki();
        bear.walk(bear.getHomeAdress());
        bear.think("Кинуть в реку шишки и попытаться угадать, какая выплывет первая-хорошая идея");
        pushishki.start(bear);
        bear.think("Интересная игра. Надо бы научить остальных в нее играть.");
        bear.teach(pig, pushishki);
        bear.teach(little_roo, pushishki);
        bear.teach(rabbit, pushishki);
        pig.say(bear.getName() + " это отличная игра. Давай назовем её в твою честь.");
        bear.think("It's good idea.");
        pushishki.rename("Pushishki");
        rabbit.say("Давайте вместо шишек использовать плаки. Это игра будет называться Пустяки");
        nonsense nonsense = (nonsense) rabbit.createGame(new nonsense("Nonsense", river, story_bridge, "Надо кидать палки в реку.Чья палка первая выплывет из под моста тот и победил!"));
        System.out.println(nonsense.getRulesСontainer());
        river.flow(Act_Stat.lazily);
        Characters[] var12 = characters;
        int var13 = characters.length;

        int var14;
        Characters character;
        for (var14 = 0; var14 < var13; ++var14) {
            character = var12[var14];
            character.getInventory().flush();
            character.getInventory().add_item(new Sticks("stick", 0.09D), 100);
        }

        nonsense.setCommand(pig, bear, little_roo, rabbit);
        nonsense.start(rabbit);
        if (nonsense.getWinner().equals(pig)) {
            pig.worry(Act_Stat.terribly);
        }

        Eeyore.swim();
        pig.say("Смотрите Иа-Иа плывет.");
        var12 = characters;
        var13 = characters.length;

        for (var14 = 0; var14 < var13; ++var14) {
            character = var12[var14];
            character.think();
            character.silent();
        }

    }
}
