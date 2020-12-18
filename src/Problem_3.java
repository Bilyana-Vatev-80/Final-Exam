import java.util.*;

public class Problem_3 {
    public static void main(String[] args) {
        class People {
            String name;
            int health;
            int energy;

            public People(String name, int health, int energy) {
                this.name = name;
                this.health = health;
                this.energy = energy;
            }

            public People(String name) {

                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getHealth() {
                return health;
            }

            public void setHealth(int health) {
                this.health = health;
            }

            public void addHealth(int health) {
                this.health += health;
            }

            public void reduceHealth(int health) {
                this.health -= health;
            }

            public int getEnergy() {
                return energy;
            }

            public void setEnergy(int energy) {
                this.energy = energy;
            }

            public void addEnergy(int energy) {
                this.energy = energy;
            }

            public void reduceEnergy() {
                this.energy -= 1;
            }

            @Override
            public String toString() {
                return this.name + " - " + this.health + " - " + this.energy;
            }
        }
            Scanner sc = new Scanner(System.in);

            Map<String, People> people = new TreeMap<>();
            String input;

            while (!"Results".equals(input = sc.nextLine())) {
                String[] commands = input.split(":");
                switch (commands[0]) {
                    case "Add":
                        String name = commands[1];
                        int health = Integer.parseInt(commands[2]);
                        int energy = Integer.parseInt(commands[3]);
                        People p = new People(name);
                        people.putIfAbsent(name, p);
                        if (people.containsKey(name)) {
                            people.get(name).addHealth(health);
                            people.get(name).addEnergy(energy);
                        }
                        break;
                    case "Attack":
                        String attackerName = commands[1];
                        String defenderName = commands[2];
                        int damage = Integer.parseInt(commands[3]);
                        if (people.containsKey(attackerName) && people.containsKey(defenderName)) {
                            people.get(defenderName).reduceHealth(damage);
                            people.get(attackerName).reduceEnergy();
                            if (people.get(defenderName).getHealth() <= 0) {
                                people.remove(defenderName);
                                System.out.printf("%s was disqualified!%n", defenderName);

                            }
                            if (people.get(attackerName).getEnergy() <= 0) {
                                people.remove(attackerName);
                                System.out.printf("%s was disqualified!%n", attackerName);
                            }
                        }
                        break;
                    case "Delete":
                        String delete = commands[1];
                        if ("All".equals(delete)) {
                            people.clear();
                        } else if (people.containsKey(delete)) {
                            people.remove(delete);
                        }
                        break;
                }

            }
            System.out.printf("People count: %d%n", people.size());
            people.values().stream().sorted(Comparator.comparing(People::getHealth).reversed()).forEach(f -> System.out.println(f));
        }
    }

