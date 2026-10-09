package ca.hccis.files.bo;

import ca.hccis.files.entity.PokemonCard;

import java.util.HashMap;

public class PokemonCardBO {
    /**
     * Calculates the average attack damage of all
     * Pokemon cards other than the selected card.
     *
     * This value can be used to determine the defensive
     * effectiveness of the selected Pokemon card.
     *
     * @param card The selected Pokemon card.
     * @param cardMap The collection of Pokemon cards.
     * @return The average attack damage of the other cards.
     */
    public double calculate(PokemonCard card,
                            HashMap<Integer, PokemonCard> cardMap) {

        int totalAttackDamage = 0;
        int numberOfCards = 0;

        for (PokemonCard current : cardMap.values()) {

            if (current.getId() != card.getId()) {
                totalAttackDamage += current.getAttackDamage();
                numberOfCards++;
            }
        }

        if (numberOfCards == 0) {
            return 0.0;
        }

        return (double) totalAttackDamage / numberOfCards;
    }
}
