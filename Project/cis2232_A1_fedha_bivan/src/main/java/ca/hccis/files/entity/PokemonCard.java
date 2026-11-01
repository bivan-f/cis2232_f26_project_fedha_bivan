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

    public PokemonCard() {
    }

    public PokemonCard(int id,
                       String enteredDateTime,
                       String cardName,
                       String cardType,
                       int cardHitPoints,
                       String cardAttackName,
                       int cardAttackDamage,
                       int cardAttackCost,
                       int cardStage,
                       int cardRetreatCost) {

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

    // ---------------- GETTERS ----------------

    public int getId() {
        return id;
    }

    public String getEnteredDateTime() {
        return enteredDateTime;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardType() {
        return cardType;
    }

    public int getCardHitPoints() {
        return cardHitPoints;
    }

    public String getCardAttackName() {
        return cardAttackName;
    }

    public int getCardAttackDamage() {
        return cardAttackDamage;
    }

    public int getCardAttackCost() {
        return cardAttackCost;
    }

    public int getCardStage() {
        return cardStage;
    }

    public int getCardRetreatCost() {
        return cardRetreatCost;
    }

    // ---------------- SETTERS ----------------

    public void setId(int id) {
        this.id = id;
    }

    public void setEnteredDateTime(String enteredDateTime) {
        this.enteredDateTime = enteredDateTime;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setCardHitPoints(int cardHitPoints) {
        this.cardHitPoints = cardHitPoints;
    }

    public void setCardAttackName(String cardAttackName) {
        this.cardAttackName = cardAttackName;
    }

    public void setCardAttackDamage(int cardAttackDamage) {
        this.cardAttackDamage = cardAttackDamage;
    }

    public void setCardAttackCost(int cardAttackCost) {
        this.cardAttackCost = cardAttackCost;
    }

    public void setCardStage(int cardStage) {
        this.cardStage = cardStage;
    }

    public void setCardRetreatCost(int cardRetreatCost) {
        this.cardRetreatCost = cardRetreatCost;
    }

    // ---------------- TO STRING ----------------

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + cardName +
                ", Type: " + cardType +
                ", HP: " + cardHitPoints +
                ", Attack: " + cardAttackName +
                ", Damage: " + cardAttackDamage +
                ", Cost: " + cardAttackCost +
                ", Stage: " + cardStage +
                ", Retreat: " + cardRetreatCost +
                ", Entered: " + enteredDateTime;
    }
}
