package ca.hccis.files.entity;


public class PokemonCard {

    private int id;
    private String name;
    private String type;
    private int hitPoints;
    private String attackName;
    private int attackDamage;

    public PokemonCard(int id, String name, String type,
                       int hitPoints, String attackName,
                       int attackDamage) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.hitPoints = hitPoints;
        this.attackName = attackName;
        this.attackDamage = attackDamage;
    }

    public int getId() {
        return id;
    }

    public String toString() {

        return "ID: " + id
                + " | Name: " + name
                + " | Type: " + type
                + " | HP: " + hitPoints
                + " | Attack: " + attackName
                + " | Damage: " + attackDamage;
    }
}
