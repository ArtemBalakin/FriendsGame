package com.company.objects.items;


public abstract class Bridge extends Obct {
    public Bridge(String title, double weight) {
        super(title, weight);
    }

    public static class Story_Bridge extends Bridge {
        protected Bridge.Story_Bridge.Side leftSide = new Bridge.Story_Bridge.Side("левая сторона");
        protected Bridge.Story_Bridge.Side rightSide = new Bridge.Story_Bridge.Side("правая сторона");

        public Bridge.Story_Bridge.Side getLeftSide() {
            return this.leftSide;
        }

        public Bridge.Story_Bridge.Side getRightSide() {
            return this.rightSide;
        }

        public Story_Bridge(String title, double weight) {
            super(title, weight);
        }

        private class Side {
            protected String title;

            Side(String title) {
                this.title = title;
            }

            public String getTitle() {
                return this.title;
            }

            public String toString() {
                return this.title;
            }
        }
    }
}

