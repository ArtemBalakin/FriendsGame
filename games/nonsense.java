package com.company.games;

import com.company.characters.Characters;
import com.company.characters.Kenguru;
import com.company.characters.Rabbit;
import com.company.enums.Act_Stat;
import com.company.enums.Bump_Size;
import com.company.exeption.NotEnoughItemsExeption;
import com.company.objects.items.*;

import java.util.*;

public class nonsense extends Pushishki {
    Obct startPoint;
    Obct endPoint;
    private ArrayList<Characters> sequence_moves = new ArrayList();

    public nonsense(String title, Obct startPoint, Obct endPoint, String rules) throws NotEnoughItemsExeption, InterruptedException {
        this.title = title;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.rules = rules;
    }



    protected Characters whoWinner() throws InterruptedException {
        Random random = new Random();
        double random_double = random.nextDouble();
        if ((!(random_double > 0.6D) || this.sequence_moves.size() <= 0) && this.sequence_moves.size() != 1) {
            for (int index = this.sequence_moves.size() - 1; index >= 0; --index) {
                double powForSmallerProbability = 1.0D;
                double powForBiggerProbability = (double) index;
                System.out.println(this.sequence_moves + " " + this.sequence_moves.size());
                if (index + 1 == this.sequence_moves.size() && this.sequence_moves.size() > 1) {
                    powForSmallerProbability = 0.0D;
                }

                if (random_double <= Math.pow(0.4D, powForBiggerProbability) * Math.pow(0.6D, powForSmallerProbability)) {
                    this.winner = (Characters) this.sequence_moves.get(index);
                    break;
                }
            }

            this.winner.upMoodlevel();
            return this.winner;
        } else {
            ((Characters) this.sequence_moves.get(0)).upMoodlevel();
            return this.winner = (Characters) this.sequence_moves.get(0);
        }
    }

    public void start(Characters player) throws InterruptedException, NotEnoughItemsExeption {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        System.out.println(this.title + " start");
        System.out.print(player.getName() + ":");
        Rabbit playerr = (Rabbit) player;
        playerr.command();
        Thread.sleep(1000L);
        Thread.sleep(100L);
        System.out.println("Team of players in " + this.title + " " + this.getCommand());
        int correction = 0;
        int[] misses = new int[]{-1, -1, -1, -1};
        String in = "";
        ArrayList<Integer> inputs = new ArrayList();

        Characters pl;
        for (int number = 0; number < this.command.size(); ++number) {
            System.out.println("Какой герой кинет предмет сейчас?(доступны индексы от 1 до 4)");
            in = input.next();

            int character_index;
            try {
                character_index = Integer.parseInt(in);
                if (character_index < 1 || character_index > 4) {
                    inputs.remove(character_index);
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException var20) {
                System.out.println("Неверный ввод!!");
                --number;
                continue;
            }

            character_index = Integer.parseInt(in);
            if (inputs.contains(character_index)) {
                System.out.println("Этот герой уже кинул предмет!!!");
                --number;
            } else {
                inputs.add(character_index);
                pl = this.command.get(character_index - 1);

                try {
                    System.out.println(((Characters) this.command.get(character_index - 1)).getInventory());
                    System.out.println("Какой предмет герой должен кинуть?(1-палка;2-маленькая шишка;3-большая шишка)");
                    int item_index = input.nextInt();
                    if (item_index >= 1 && item_index <= 3) {
                        if (!(pl.getInventory().get(item_index - 1) instanceof Sticks)) {
                            System.out.println("По правилам игры " + this.title + " нельзя использовать этот предмет");
                            System.out.println("Уверены ли вы в своём действии?");
                            input.nextLine();
                            String answer = input.nextLine();
                            if (answer.equalsIgnoreCase("да")) {
                                pl.throwItem(pl.getInventory().get(item_index - 1), this.startPoint, random.nextDouble() * 90.0D);
                                System.out.println(pl.getName() + " больше не участвует в игре");
                            } else {
                                System.out.println("Неверный ввод!!!");
                                --number;
                                inputs.remove(character_index);
                            }
                        } else if (!pl.throwItem(pl.getInventory().get(item_index - 1), this.startPoint, random.nextDouble() * 90.0D)) {
                            System.out.println(pl.getName() + " больше не участвует в игре");
                            pl.rush((Bridge.Story_Bridge) this.endPoint, Act_Stat.scampering);
                            misses[number] = character_index - 1 - correction;
                            ++correction;
                        } else {
                            this.sequence_moves.add(this.command.get(character_index - 1));
                        }
                    } else {
                        System.out.println("Неверный ввод!!!");
                        --number;
                        inputs.remove(character_index);
                    }
                } catch (IndexOutOfBoundsException | NotEnoughItemsExeption var18) {
                    inputs.remove(character_index);
                    System.out.println("предмета  нет в инвентаре " + pl.getName());
                    System.out.println("Добавить предмет?");
                    String answer = input.next();
                    if (answer.equalsIgnoreCase("да")) {
                        System.out.println("Какой предмет вы хотите добавить?(1-палка;2-маленькая шишка;3-большая шишка)");
                        int added_item_index = input.nextInt();
                        Bump bumpToAdd;
                        switch (added_item_index) {
                            case 1:
                                Sticks stickToAdd = new Sticks("stick", 0.04D);
                                pl.getInventory().add_item(stickToAdd, 20);
                                break;
                            case 2:
                                bumpToAdd = new Bump("Little bump", Bump_Size.LITTLE, 0.03D);
                                pl.getInventory().add_item(bumpToAdd, 20);
                                break;
                            case 3:
                                bumpToAdd = new Bump("Big bump", Bump_Size.BIG, 0.04D);
                                pl.getInventory().add_item(bumpToAdd, 20);
                        }
                    }

                    --number;
                    input.nextLine();
                } catch (InputMismatchException var19) {
                    System.out.println("Неверный ввод (-__-)!!. Вводите цифры от 1 до 3. ");
                    inputs.remove(inputs.lastIndexOf(character_index));
                    --number;
                    input.nextLine();
                }
            }
        }

        if (this.sequence_moves.size() == 0) {
            System.out.println("Все герои промахнулись!\nСделать ещё попытку?");
            if (input.next().equalsIgnoreCase("да")) {
                this.start((Characters) this.command.get(3));
            } else {
                System.out.println("Тогда история Винни и его друзей завершается.");
                System.exit(1);
            }
        }

        System.out.println(this.sequence_moves + " " + this.sequence_moves.size());
        Iterator var21 = this.sequence_moves.iterator();

        while (var21.hasNext()) {
            pl = (Characters) var21.next();
            pl.getInventory().get(0).Fall(this.startPoint);
            pl.getInventory().get(0).Drift();
            pl.rush((Bridge.Story_Bridge) this.endPoint, Act_Stat.scampering);
            pl.lookAt(this.startPoint, Act_Stat.waiting);
        }

        var21 = this.sequence_moves.iterator();

        while (var21.hasNext()) {
            pl = (Characters) var21.next();
            if (pl instanceof Kenguru) {
                ((Kenguru) pl).jump(Act_Stat.clockwork);
                ((Kenguru) pl).squek("Stick, stick, hurry! Stick, stick, hurry!");
            }
        }

        var21 = this.sequence_moves.iterator();

        while (var21.hasNext()) {
            pl = (Characters) var21.next();
            pl.Wait();
        }

        System.out.println("ONE ETERNITY LATER");
        this.whoWinner().see(new Sticks("stick", 0.04D));
        System.out.println(this.winner + " win");
        this.end();
    }

    protected void end() throws InterruptedException {
        System.out.println(this.title + " finish");
        Thread.sleep(3000L);
    }
}
