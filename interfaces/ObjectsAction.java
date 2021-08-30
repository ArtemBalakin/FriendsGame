package com.company.interfaces;


import com.company.objects.items.Obct;

public interface ObjectsAction {
    void Fall(Obct var1);

    void Drift() throws InterruptedException;
}
