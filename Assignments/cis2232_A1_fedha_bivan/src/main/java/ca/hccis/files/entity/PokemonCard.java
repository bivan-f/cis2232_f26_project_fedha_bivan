package ca.hccis.files.entity;


public class PokemonCard {

    private int id;
    private String enteredDateTime;
    private String cardName;
    private String cardType;
    private int cardHitPoints;
    private String cardAttackName;
    private int cardAttackDamage;
    private int cardAttackCost;
    private int cardStage;
    private int cardRetreatCost;

    public PokemonCard(int id, String enteredDateTime,
                       String cardName, String cardType,
                       int cardHitPoints, String cardAttackName,
                       int cardAttackDamage, int cardAttackCost,
                       int cardStage, int cardRetreatCost) {

        this.id = id;
        this.enteredDateTime = enteredDateTime;
        this.cardName = cardName;
        this.cardType = cardType;
        this.cardHitPoints = cardHitPoints;
        this.cardAttackName = cardAttackName;
        this.cardAttackDamage = cardAttackDamage;
        this.cardAttackCost = cardAttackCost;
        this.cardStage = cardStage;
        this.cardRetreatCost = cardRetreatCost;
    }

    public int getId() {
        return id;
    }

    public String getCardName() {
        return cardName;
    }

    public int getCardHitPoints() {
        return cardHitPoints;
    }

    public int getCardAttackDamage() {
        return cardAttackDamage;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Date: " + enteredDateTime
                + " | Name: " + cardName
                + " | Type: " + cardType
                + " | HP: " + cardHitPoints
                + " | Attack: " + cardAttackName
                + " | Damage: " + cardAttackDamage
                + " | Attack Cost: " + cardAttackCost
                + " | Stage: " + cardStage
                + " | Retreat Cost: " + cardRetreatCost;
    }
}