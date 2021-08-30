package com.company.objects.items;

import com.company.enums.Bump_Size;

public class Bump extends Items {
    Bump_Size size;

    public Bump(String title, Bump_Size size, double weight) {
        super(title, weight);
        this.size = size;
    }

    public Bump_Size getSize() {
        return this.size;
    }

    @Override
    public void Fall(Obct purpose) {
    }

    @Override
    public void Fall(java.util.Objects var1) {

    }


    public void Drift() throws InterruptedException {
    }

    public String toString() {
        return this.title;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            Bump bump = (Bump) obj;
            return this.title == bump.title && this.size == bump.size && this.weight == bump.weight;
        } else {
            return false;
        }
    }
}


