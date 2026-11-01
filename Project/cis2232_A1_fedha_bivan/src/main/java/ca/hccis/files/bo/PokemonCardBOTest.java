
package ca.hccis.files.bo;

import ca.hccis.files.entity.PokemonCard;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests the PokemonCardBO calculation method.
 *
 * @author Bivan
 * @since 20261003
 */
public class PokemonCardBOTest {

    @Test
    public void calculateAverageAttackDamage() {

        HashMap<Integer, PokemonCard> cards = new HashMap<>();

        PokemonCard charizard = new PokemonCard(
                1, "2026-10-03", "Charizard", "Fire",
                150, "Fire Spin", 200, 3, 2, 2
        );

        PokemonCard pikachu = new PokemonCard(
                2, "2026-10-03", "Pikachu", "Electric",
                100, "Thunderbolt", 80, 2, 1, 1
        );

        PokemonCard squirtle = new PokemonCard(
                3, "2026-10-03", "Squirtle", "Water",
                70, "Water Gun", 60, 1, 0, 1
        );

        cards.put(1, charizard);
        cards.put(2, pikachu);
        cards.put(3, squirtle);

        PokemonCardBO pokemonCardBO = new PokemonCardBO();

        double result = pokemonCardBO.calculate(charizard, cards);

        assertEquals(70.0, result, 0.001);
    }

    @Test
    public void calculateSameAttackDamage() {

        HashMap<Integer, PokemonCard> cards = new HashMap<>();

        PokemonCard charizard = new PokemonCard(
                1, "2026-10-03", "Charizard", "Fire",
                150, "Fire Spin", 200, 3, 2, 2
        );

        PokemonCard pikachu = new PokemonCard(
                2, "2026-10-03", "Pikachu", "Electric",
                100, "Thunderbolt", 100, 2, 1, 1
        );

        PokemonCard squirtle = new PokemonCard(
                3, "2026-10-03", "Squirtle", "Water",
                70, "Water Gun", 100, 1, 0, 1
        );

        cards.put(1, charizard);
        cards.put(2, pikachu);
        cards.put(3, squirtle);

        PokemonCardBO pokemonCardBO = new PokemonCardBO();

        double result = pokemonCardBO.calculate(charizard, cards);

        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void calculateComparisonValue() {

        HashMap<Integer, PokemonCard> cards = new HashMap<>();

        PokemonCard charizard = new PokemonCard(
                1, "2026-10-03", "Charizard", "Fire",
                150, "Fire Spin", 200, 3, 2, 2
        );

        PokemonCard pikachu = new PokemonCard(
                2, "2026-10-03", "Pikachu", "Electric",
                100, "Thunderbolt", 80, 2, 1, 1
        );

        PokemonCard squirtle = new PokemonCard(
                3, "2026-10-03", "Squirtle", "Water",
                70, "Water Gun", 60, 1, 0, 1
        );

        cards.put(1, charizard);
        cards.put(2, pikachu);
        cards.put(3, squirtle);

        PokemonCardBO pokemonCardBO = new PokemonCardBO();

        double result = pokemonCardBO.calculate(charizard, cards);

        assertTrue(charizard.getCardHitPoints() > result);
    }
}