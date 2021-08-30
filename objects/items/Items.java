package com.company.objects.items;

import com.company.interfaces.ObjectsAction;

public abstract class Items extends Obct implements ObjectsAction {
    public Items(String title, double weight) {
        super(title, weight);
    }

    public void Fall(Obct purpose) {
    }

    public abstract void Fall(java.util.Objects var1);

    public void Drift() throws InterruptedException {
    }
}
