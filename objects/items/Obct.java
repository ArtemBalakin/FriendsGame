package com.company.objects.items;


public abstract class Obct {
    protected double weight;
    protected String title;
    protected double width;

    public double getWidth() {
        return this.width;
    }

    public Obct(String title, double weight) {
        this.title = title;
        this.weight = weight;
    }

    public String getTitle() {
        return this.title;
    }

    public double getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int hascode = this.title.hashCode();
        hascode += (int) this.weight;
        return hascode;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            Obct object = (Obct) obj;
            return this.title == object.title & this.weight == object.weight;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.title;
    }
}

