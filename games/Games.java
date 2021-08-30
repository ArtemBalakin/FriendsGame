package com.company.games;

import com.company.characters.Characters;
import com.company.exeption.NotEnoughItemsExeption;

import java.util.ArrayList;
import java.util.List;

public abstract class Games {
    protected String title;
    protected ArrayList<Characters> command = new ArrayList();
    protected Characters winner;
    protected String rules;

    public Games() {
    }

    public Characters getWinner() {
        return this.winner;
    }

    public void setCommand(Characters... command) {
        Characters[] var2 = command;
        int var3 = command.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Characters player = var2[var4];
            this.command.add(player);
        }

    }

    public String getTitle() {
        return this.title;
    }

    public abstract void start(Characters var1) throws InterruptedException, NotEnoughItemsExeption;

    protected abstract void end() throws InterruptedException;

    public List<Characters> getCommand() {
        return this.command;
    }

    public int hashCode() {
        int result = this.title.hashCode();
        return result;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj != null && obj.getClass() == this.getClass()) {
            Games game = (Games)obj;
            return this.title == game.title;
        } else {
            return false;
        }
    }

    public String toString() {
        return this.title;
    }

    public RulesContainer getRulesСontainer() {
        class RuleContainer implements RulesContainer {
            final String rules;

            RuleContainer() {
                this.rules = Games.this.rules;
            }

            public String toString() {
                return this.rules;
            }
        }

        RulesContainer rules = new RuleContainer();
        return rules;
    }

}
