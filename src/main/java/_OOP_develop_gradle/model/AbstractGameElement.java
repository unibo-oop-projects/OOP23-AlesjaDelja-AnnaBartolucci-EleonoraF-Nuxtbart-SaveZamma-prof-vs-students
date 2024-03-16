package _OOP_develop_gradle.model;

public abstract class AbstractGameElement implements GameElement {
    // Implementazione parziale dei metodi comuni a tutti gli elementi del gioco

    protected Elements<Integer, Integer> position;
    protected String name;
    protected int damage;

    public AbstractGameElement(String name, int damage, Elements<Integer, Integer> position) {
        this.name = name;
        this.damage = damage;
        this.position = position;
    }

    public Elements<Integer, Integer> getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

}
