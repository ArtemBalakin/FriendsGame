package com.company.objects.items;

public class Sticks extends Items {
    public Sticks(String title, double weight) {
        super(title, weight);
    }

    public void Fall(Obct purpose) {
        System.out.println(this.title + " fell in " + purpose.getTitle());
    }

    public void Fall(java.util.Objects purpose) {
    }

    public void Drift() throws InterruptedException {
        System.out.println(this.title + " drift");
        Thread.sleep(1000L);
    }

    public int hashCode() {
        int result = this.title.hashCode() * 31;
        return result;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            Sticks stick = (Sticks) obj;
            return this.title == stick.title && this.weight == stick.weight;
        } else {
            return false;
        }
    }
}
