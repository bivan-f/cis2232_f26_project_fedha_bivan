package ca.hccis.files;

import ca.hccis.files.entity.Camper;
import ca.hccis.files.entity.PokemonCard;
import ca.hccis.util.CisUtility;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/**
 * Controls the overall flow of the program.
 *
 * @author cis2232
 * @since 20260917
 */
public class Controller {

    public static final int EXIT = 0;

    public static final String MENU = "1) Add" + System.lineSeparator()
            + "2) Edit" + System.lineSeparator()
            + "3) View" + System.lineSeparator()
            + EXIT + ") Exit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";
    public static final String MESSAGE_SUCCESS = "Success";

    /**
     * Stores the Pokemon cards.
     */
    private static HashMap<Integer, PokemonCard> cardMap = new HashMap<>();

    /**
     * Used to convert objects to and from JSON.
     */
    private static Gson gson = new Gson();

    /**
     * Location where the JSON file will be saved.
     */
    public static final String PATH_NAME = "c:\\cis2232\\pokemon.json";

    public static void main(String[] args) {

        initialize();

        int menuOption;

        do {

            menuOption = CisUtility.getInputInt(MENU);

            switch (menuOption) {

                case EXIT:
                    System.out.println(MESSAGE_EXIT);
                    break;

                case 1:
                    addCard();
                    break;

                case 2:
                    viewCard();
                    break;

                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }

        } while (menuOption != EXIT);
    }

    /**
     * Processing for menu option 1.
     *
     * Adds a Pokemon card.
     */
    public static void addCard() {

        System.out.println();
        System.out.println("Add Pokemon Card");

        int id = cardMap.size() + 1;

        String name = CisUtility.getInputString("Card name: ");
        String type = CisUtility.getInputString("Card type: ");
        int hitPoints = CisUtility.getInputInt("Hit points: ");
        String attackName = CisUtility.getInputString("Attack name: ");
        int attackDamage = CisUtility.getInputInt("Attack damage: ");

        PokemonCard card = new PokemonCard(
                id,
                name,
                type,
                hitPoints,
                attackName,
                attackDamage
        );

        cardMap.put(id, card);

        writeAll();

        System.out.println("Card added successfully.");
    }

    /**
     * Processing for menu option 2.
     *
     * Displays all Pokemon cards.
     */
    public static void viewCard() {

        System.out.println();
        System.out.println("Pokemon Cards");

        if (cardMap.isEmpty()) {
            System.out.println("No cards found.");
            return;
        }

        for (PokemonCard card : cardMap.values()) {
            System.out.println(card);
        }
    }

    /**
     * Saves all cards to the JSON file.
     */
    public static void writeAll() {

        try {

            FileWriter writer = new FileWriter(PATH_NAME, false);

            for (PokemonCard current : cardMap.values()) {

                writer.append(gson.toJson(current));
                writer.append(System.lineSeparator());
            }

            writer.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Reads all cards from the JSON file.
     */
    public static void readAll() {

        try {

            FileReader reader = new FileReader(PATH_NAME);

            List<String> lines = reader.readAllLines();

            for (String line : lines) {

                PokemonCard cardFromJson =
                        gson.fromJson(line, PokemonCard.class);

                cardMap.put(cardFromJson.getId(), cardFromJson);
            }

            reader.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    /**
     * Initializes the program.
     *
     * Creates the directory if necessary and
     * loads existing cards if the file exists.
     */
    public static void initialize() {

        Path path = Paths.get(PATH_NAME);

        try {

            Files.createDirectories(path.getParent());

        } catch (IOException e) {

            e.printStackTrace();
        }

        if (Files.exists(path)) {

            System.out.println("Pokemon cards exist.");
            readAll();

        } else {

            System.out.println("No Pokemon cards found.");
        }
    }
}

