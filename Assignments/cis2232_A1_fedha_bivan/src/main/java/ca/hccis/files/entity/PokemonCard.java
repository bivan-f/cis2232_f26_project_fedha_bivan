package ca.hccis.files.entity;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class PokemonCard{

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
            // Required by Jackson
        }

        public PokemonCard(
                int id,
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

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEnteredDateTime() {
            return enteredDateTime;
        }

        public void setEnteredDateTime(String enteredDateTime) {
            this.enteredDateTime = enteredDateTime;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public int getCardHitPoints() {
            return cardHitPoints;
        }

        public void setCardHitPoints(int cardHitPoints) {
            this.cardHitPoints = cardHitPoints;
        }

        public String getCardAttackName() {
            return cardAttackName;
        }

        public void setCardAttackName(String cardAttackName) {
            this.cardAttackName = cardAttackName;
        }

        public int getCardAttackDamage() {
            return cardAttackDamage;
        }

        public void setCardAttackDamage(int cardAttackDamage) {
            this.cardAttackDamage = cardAttackDamage;
        }

        public int getCardAttackCost() {
            return cardAttackCost;
        }

        public void setCardAttackCost(int cardAttackCost) {
            this.cardAttackCost = cardAttackCost;
        }

        public int getCardStage() {
            return cardStage;
        }

        public void setCardStage(int cardStage) {
            this.cardStage = cardStage;
        }

        public int getCardRetreatCost() {
            return cardRetreatCost;
        }

        public void setCardRetreatCost(int cardRetreatCost) {
            this.cardRetreatCost = cardRetreatCost;
        }

        @Override
        public String toString() {

            String stageName;

            if (cardStage == 0) {
                stageName = "Basic";
            } else if (cardStage == 1) {
                stageName = "Stage 1";
            } else {
                stageName = "Stage 2";
            }

            return "\n" +
                    "----------------------------------------\n" +
                    "ID: " + id + "\n" +
                    "Entered: " + enteredDateTime + "\n" +
                    "Pokémon: " + cardName + "\n" +
                    "Type: " + cardType + "\n" +
                    "HP: " + cardHitPoints + "\n" +
                    "Attack: " + cardAttackName + "\n" +
                    "Attack Damage: " + cardAttackDamage + "\n" +
                    "Attack Energy Cost: " + cardAttackCost + "\n" +
                    "Stage: " + stageName + "\n" +
                    "Retreat Cost: " + cardRetreatCost + "\n" +
                    "----------------------------------------";
        }
    }
}
