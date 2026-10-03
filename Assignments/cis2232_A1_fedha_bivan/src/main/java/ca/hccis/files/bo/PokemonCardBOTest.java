package ca.hccis.files.bo;

import ca.hccis.files.entity.PokemonCard;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the PokemonCardBO calculation method.
 *
 * These tests were developed using a test-driven
 * development approach.
 *
 * @author Bivan
 * @since 20261003
 */
public class PokemonCardBOTest {

    /**
     * Tests the calculation of the average attack damage
     * of the other Pokemon cards.
     *
     * This test was completed following a
     * test-driven development approach.
     */
    @Test
    public void calculateAverageAttackDamage() {

        HashMap<Integer, PokemonCard> cards = new HashMap<>();

        PokemonCard charizard = new PokemonCard(
                1,
                "Charizard",
                "Fire",
                150,
                "Fire Spin",
                200
        );

        PokemonCard pikachu = new PokemonCard(
                2,
                "Pikachu",
                "Electric",
                100,
                "Thunderbolt",
                80
        );

        PokemonCard squirtle = new PokemonCard(
                3,
                "Squirtle",
                "Water",
                70,
                "Water Gun",
                60
        );

        cards.put(1, charizard);
        cards.put(2, pikachu);
        cards.put(3, squirtle);

        PokemonCardBO pokemonCardBO = new PokemonCardBO();

        double result = pokemonCardBO.calculate(charizard, cards);

        assertEquals(70.0, result, 0.001);
    }

    /**
     * Tests the calculation when the other cards
     * have the same attack damage.
     *
     * This test was completed following a
     * test-driven development approach.
     */
    @Test
    public void calculateSameAttackDamage() {

        HashMap<Integer, PokemonCard> cards = new HashMap<>();

        PokemonCard charizard = new PokemonCard(
                1,
                "Charizard",
                "Fire",
                150,
                "Fire Spin",
                200
        );

        PokemonCard pikachu = new PokemonCard(
                2,
                "Pikachu",
                "Electric",
                100,
                "Thunderbolt",
                100
        );

        PokemonCard squirtle = new PokemonCard(
                3,
                "Squirtle",
                "Water",
                70,
                "Water Gun",
                100
        );

        cards.put(1, charizard);
        cards.put(2, pikachu);
        cards.put(3, squirtle);

        PokemonCardBO pokemonCardBO = new PokemonCardBO();

        double result = pokemonCardBO.calculate(charizard, cards);

        assertEquals(100.0, result, 0.001);
    }

    /**
     * Tests that the calculated average can be used
     * as a comparison value for the selected card.
     *
     * This test was completed following a
     * test-driven development approach.
     */
    @Test
    public void calculateComparisonValue() {

        HashMap<Integer, PokemonCard> cards = new HashMap<>();

        PokemonCard charizard = new PokemonCard(
                1,
                "Charizard",
                "Fire",
                150,
                "Fire Spin",
                200
        );

        PokemonCard pikachu = new PokemonCard(
                2,
                "Pikachu",
                "Electric",
                100,
                "Thunderbolt",
                80
        );

        PokemonCard squirtle = new PokemonCard(
                3,
                "Squirtle",
                "Water",
                70,
                "Water Gun",
                60
        );

        cards.put(1, charizard);
        cards.put(2, pikachu);
        cards.put(3, squirtle);

        PokemonCardBO pokemonCardBO = new PokemonCardBO();

        double result = pokemonCardBO.calculate(charizard, cards);

        assertTrue(charizard.getHitPoints() > result);
    }
}