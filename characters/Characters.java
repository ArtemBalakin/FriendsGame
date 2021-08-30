package com.company.characters;


import com.company.enums.Act_Stat;
import com.company.enums.Sex;
import com.company.exeption.NotEnoughItemsExeption;
import com.company.exeption.OneOfCharactersCharacteristicWrong;
import com.company.games.Games;
import com.company.interfaces.Actions;
import com.company.interfaces.Interection;
import com.company.inventory.Inventory;
import com.company.objects.items.Bridge;
import com.company.objects.items.Items;
import com.company.objects.items.Obct;



import java.util.ArrayList;

public abstract class Characters implements Interection, Actions {
    protected String name;
    protected double borntime = -1.0D;
    protected Sex sex;
    protected Inventory inventory;
    protected double stress_level;
    protected double mood_level = 100.0D;
    protected double force;
    protected ArrayList<String> skills;
    protected String homeAdress;

    protected Characters(String name, double borntime, Sex sex, double force, String homeAdress) {
        this.name = name;
        this.borntime = borntime;
        this.sex = sex;
        this.force = force;
        this.inventory = new Inventory(this.name);
        this.skills = new ArrayList();
        this.homeAdress = homeAdress;

        try {
            if (this.name == null || this.name == "" || this.force == 0.0D || this.sex == null || this.borntime == -1.0D) {
                throw new OneOfCharactersCharacteristicWrong("Проверьте характеристики созданных героев");
            }
        } catch (OneOfCharactersCharacteristicWrong var9) {
            System.out.println("ПРОВЕРЬТЕ ХАРАКТЕРИСТИКИ ГЕРОЕВ, КОТОРЫЙ ВЫ СОЗДАЕТЁ!!!\nOneOfCharactersCharacteristicWrong");
            System.exit(1);
        }

    }

    public void upforce() {
        this.force += 5.0D;
    }

    public String GetName() {
        return this.name;
    }

    public double GetBorntime() {
        return this.borntime;
    }

    public Games createGame(Games game) {
        System.out.println(this.name + " придумал " + game.getTitle());
        return game;
    }

    public void lookAt(Obct object, Act_Stat act_stat) throws InterruptedException {
        System.out.println(this.name + " " + Act_Stat.waiting + " looks at " + object.getTitle());
        Thread.sleep(2000L);
    }

    public void worry(Act_Stat act_stat) {
    }

    public void throwItem(Obct purpose, Items... item) {
        if (this.inventory.check(item[0]) && this.inventory.check(item[1])) {
            System.out.println(this.name + " throw " + item[0].getTitle() + " and " + item[1].getTitle() + " в " + purpose.getTitle());
            this.inventory.remove(item[0], 1);
            this.inventory.remove(item[1], 1);
        } else {
            System.out.println("предмета нет в инвентаре");
        }

    }

    public void walk() {
        System.out.println(this.name + " куда-то идет");
    }

    public void walk(String purpose) {
        System.out.println(this.name + " идёт " + purpose);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public boolean throwItem(Items item, Obct purpose, double angle) throws NotEnoughItemsExeption {
        if (this.inventory.check(item)) {
            System.out.println(this.name + " throw " + item.getTitle() + " " + purpose.getTitle());
            this.inventory.remove(item, 1);
            double speed = this.force * 0.1D / item.getWeight();
            double distance = Math.pow(speed, 2.0D) * Math.sin(2.0D * angle) / 9.81D;
            if (distance > purpose.getWidth()) {
                System.out.println(this.name + " промахнулся");
                return false;
            } else {
                return true;
            }
        } else {
            throw new NotEnoughItemsExeption("предмета " + item.getTitle() + " нет в инвентаре " + this.name);
        }
    }

    public String getHomeAdress() {
        return this.homeAdress;
    }

    public String getName() {
        return this.name;
    }

    public void rush(Bridge.Story_Bridge bridge, Act_Stat act_stat) {
        System.out.println(this.name + " " + act_stat + " rush to" + bridge.getLeftSide());
    }

    public void swim() {
    }

    public void Wait() throws InterruptedException {
        System.out.println(this.name + " ожидает");
    }

    public void see(Obct object) throws InterruptedException {
        System.out.println(this.name + " sees " + object.getTitle());
        Thread.sleep(1000L);
    }

    public void protrude() {
    }

    public int hashCode() {
        int result = 31 * this.name.hashCode();
        result = result * 31 + (int) this.borntime;
        result = result * 31 + this.sex.hashCode();
        return result;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            Characters character = (Characters) obj;
            return this.name == character.name   & this.sex == character.sex & this.borntime == character.borntime;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.name;
    }

    public void silent() {
        System.out.println(this.name + " замолчал");
    }

    public void think() {
        System.out.println(this.name + " задумался");
    }

    public void think(String s) {
        System.out.println(this.name + " думает:\n\t" + s);
    }

    public void say(String s) {
        System.out.println(this.name + ":\n\t" + s);
    }

    public void hurt() {
        System.out.println(this.name + " обиделся!!!");
        this.mood_level -= 40.0D;
        System.out.println(this.name + " mood level: " + this.mood_level);
    }

    public void upMoodlevel() {
        this.mood_level += 20.0D;
        if (this.mood_level > 100.0D) {
            System.out.println(this.name + " безумно счастлив!");
        }

    }
}
