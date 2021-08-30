package com.company.objects.items;


import com.company.enums.Act_Stat;

public class River extends Obct {
    double width;

    public River(String title, double width, double weight) {
        super(title, weight);
        this.width = width;
    }

    public void flow(Act_Stat flow_stat) throws InterruptedException {
        System.out.println(this.title + " flows " + flow_stat);
        Thread.sleep(3000L);
    }

    public int hashCode() {
        int result = this.title.hashCode() * 31;
        return result;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            River river = (River) obj;
            return this.title == river.title;
        } else {
            return false;
        }
    }
}
