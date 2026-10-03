package ca.hccis.files.entity;


public class PokemonCard {


    private int id;
    private String name;
    private String type;
    private int hitPoints;
    private String attackName;
    private int attackDamage;

    /**
     * Creates a Pokemon card.
     *
     * @param id Card ID
     * @param name Name of the Pokemon
     * @param type Type of the Pokemon
     * @param hitPoints Hit points of the Pokemon
     * @param attackName Name of the attack
     * @param attackDamage Damage caused by the attack
     */
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

    /**
     * Gets the ID of the card.
     *
     * @return card ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the hit points of the card.
     *
     * @return hit points
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Gets the attack damage of the card.
     *
     * @return attack damage
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     * Displays the card information.
     *
     * @return card information
     */
    public String toString() {

        return "ID: " + id
                + " | Name: " + name
                + " | Type: " + type
                + " | HP: " + hitPoints
                + " | Attack: " + attackName
                + " | Damage: " + attackDamage;
    }
}
