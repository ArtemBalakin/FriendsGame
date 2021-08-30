package com.company.interfaces;


import com.company.enums.Act_Stat;
import com.company.objects.items.Bridge;

public interface Actions {
    void rush(Bridge.Story_Bridge var1, Act_Stat var2);

    void Wait() throws InterruptedException;

    void walk(String var1);

    void walk();

    void say(String var1);

    void think(String var1);

    void think();

    void silent();

    void swim();
}

