package com.company.interfaces;


import com.company.enums.Act_Stat;
import com.company.exeption.NotEnoughItemsExeption;
import com.company.objects.items.Items;
import com.company.objects.items.Obct;

public interface Interection {
    void lookAt(Obct var1, Act_Stat var2) throws InterruptedException;

    void see(Obct var1) throws InterruptedException;

    boolean throwItem(Items var1, Obct var2, double var3) throws NotEnoughItemsExeption;

    void throwItem(Obct var1, Items... var2);
}


