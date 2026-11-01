package ca.hccis.files;

import ca.hccis.files.entity.Camper;
import ca.hccis.files.entity.PokemonCard;
import ca.hccis.util.CisUtility;
import com.google.gson.Gson;

import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    public static final String PATH_NAME =
            "c:\\cis2232\\pokemon.json";

    private static final Gson gson = new Gson();

    private static final List<PokemonCard> cardList =
            new ArrayList<>();

    // Both threads share this lock when accessing cards and the file.
    private static final Object lock = new Object();

    public static void main(String[] args) {

        initialize();

        Thread consoleThread = new Thread(() -> runConsole());
        Thread popupThread = new Thread(() -> runPopup());

        consoleThread.start();
        popupThread.start();
    }

    // CONSOLE THREAD
    public static void runConsole() {

        int choice = -1;

        while (choice != EXIT) {

            choice = CisUtility.getInputInt(
                    "CONSOLE MENU\n"
                            + "1) Add\n"
                            + "2) View\n"
                            + "3) Calculate\n"
                            + "0) Exit");

            switch (choice) {
                case 1:
                    addConsoleCard();
                    break;
                case 2:
                    viewCards(false);
                    break;
                case 3:
                    calculate(false);
                    break;
                case EXIT:
                    System.out.println("Console thread finished.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // JOPTIONPANE THREAD
    public static void runPopup() {

        int choice = -1;

        while (choice != EXIT) {

            String input = JOptionPane.showInputDialog(
                    null,
                    "1) Add\n2) View\n3) Calculate\n0) Exit",
                    "POKEMON CARD MENU",
                    JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                break;
            }

            try {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1:
                        addPopupCard();
                        break;
                    case 2:
                        viewCards(true);
                        break;
                    case 3:
                        calculate(true);
                        break;
                    case EXIT:
                        JOptionPane.showMessageDialog(
                                null, "Popup thread finished.");
                        break;
                    default:
                        JOptionPane.showMessageDialog(
                                null, "Invalid option.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null, "Please enter a number.");
            }
        }
    }

    // ADD A CARD FROM THE CONSOLE
    public static void addConsoleCard() {

        String name = CisUtility.getInputString("Card name:");
        String type = CisUtility.getInputString("Card type:");
        int hp = CisUtility.getInputInt("Hit points:");
        String attack = CisUtility.getInputString("Attack name:");
        int damage = CisUtility.getInputInt("Attack damage:");
        int cost = CisUtility.getInputInt("Attack cost:");
        int stage = CisUtility.getInputInt("Stage (0, 1, or 2):");
        int retreat = CisUtility.getInputInt("Retreat cost:");

        addCard(name, type, hp, attack, damage, cost, stage, retreat);

        System.out.println("Card added.");
        System.out.println("Total cards: " + getTotal());
    }

    // ADD A CARD FROM JOPTIONPANE
    public static void addPopupCard() {

        try {
            String name = JOptionPane.showInputDialog("Card name:");
            if (name == null) return;

            String type = JOptionPane.showInputDialog("Card type:");
            if (type == null) return;

            int hp = Integer.parseInt(
                    JOptionPane.showInputDialog("Hit points:"));

            String attack = JOptionPane.showInputDialog("Attack name:");
            if (attack == null) return;

            int damage = Integer.parseInt(
                    JOptionPane.showInputDialog("Attack damage:"));

            int cost = Integer.parseInt(
                    JOptionPane.showInputDialog("Attack cost:"));

            int stage = Integer.parseInt(
                    JOptionPane.showInputDialog("Stage (0, 1, or 2):"));

            int retreat = Integer.parseInt(
                    JOptionPane.showInputDialog("Retreat cost:"));

            addCard(name, type, hp, attack, damage, cost, stage, retreat);

            JOptionPane.showMessageDialog(
                    null, "Card added.\nTotal cards: " + getTotal());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    null, "Please enter valid numbers.");
        }
    }

    // SHARED ADD METHOD
    public static void addCard(String name, String type, int hp,
                               String attack, int damage, int cost,
                               int stage, int retreat) {

        synchronized (lock) {

            int id = 1;

            for (PokemonCard card : cardList) {
                if (card.getId() >= id) {
                    id = card.getId() + 1;
                }
            }

            PokemonCard card = new PokemonCard(
                    id,
                    LocalDateTime.now().toString(),
                    name, type, hp, attack, damage,
                    cost, stage, retreat);

            cardList.add(card);

            writeAll();
        }
    }

    // VIEW CARDS
    public static void viewCards(boolean popup) {

        StringBuilder output = new StringBuilder();

        synchronized (lock) {
            for (PokemonCard card : cardList) {
                output.append(card).append("\n");
            }

            output.append("\nTotal cards: ").append(cardList.size());
        }

        if (output.length() == 13) {
            output = new StringBuilder("No cards found.");
        }

        if (popup) {
            JOptionPane.showMessageDialog(null, output.toString());
        } else {
            System.out.println(output);
        }
    }

    // CALCULATE CARD EFFECTIVENESS
    public static void calculate(boolean popup) {

        int id;

        try {
            if (popup) {
                String input = JOptionPane.showInputDialog(
                        "Enter the ID of the card to calculate:");
                if (input == null) return;
                id = Integer.parseInt(input);
            } else {
                id = CisUtility.getInputInt("Enter card ID:");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid ID.");
            return;
        }

        String result;

        synchronized (lock) {

            PokemonCard selected = null;
            double totalDamage = 0;
            double totalHP = 0;
            int count = 0;

            for (PokemonCard card : cardList) {
                if (card.getId() == id) {
                    selected = card;
                } else {
                    totalDamage += card.getCardAttackDamage();
                    totalHP += card.getCardHitPoints();
                    count++;
                }
            }

            if (selected == null) {
                result = "Card not found.";
            } else if (count == 0) {
                result = "Add another card before calculating.";
            } else {

                double averageDamage = totalDamage / count;
                double averageHP = totalHP / count;

                String defender;
                String attacker;

                if (selected.getCardHitPoints() > 2 * averageDamage) {
                    defender = "Strong Defender";
                } else if (selected.getCardHitPoints() < averageDamage) {
                    defender = "Weak Defender";
                } else {
                    defender = "Average Defender";
                }

                if (selected.getCardAttackDamage() > averageHP) {
                    attacker = "Strong Attacker";
                } else if (selected.getCardAttackDamage() < averageHP / 2) {
                    attacker = "Weak Attacker";
                } else {
                    attacker = "Average Attacker";
                }

                result = selected.getCardName() + "\n"
                        + defender + "\n" + attacker;
            }
        }

        if (popup) {
            JOptionPane.showMessageDialog(null, result);
        } else {
            System.out.println(result);
        }
    }

    public static int getTotal() {
        synchronized (lock) {
            return cardList.size();
        }
    }

    // SAVE ALL CARDS
    public static void writeAll() {

        try {
            Path path = Paths.get(PATH_NAME);
            Files.createDirectories(path.getParent());

            List<String> lines = new ArrayList<>();

            for (PokemonCard card : cardList) {
                lines.add(gson.toJson(card));
            }

            Files.write(path, lines);

        } catch (IOException e) {
            System.out.println("Could not save cards.");
            e.printStackTrace();
        }
    }

    // LOAD EXISTING CARDS
    public static void initialize() {

        Path path = Paths.get(PATH_NAME);

        try {
            Files.createDirectories(path.getParent());

            if (Files.exists(path)) {
                synchronized (lock) {
                    for (String line : Files.readAllLines(path)) {
                        if (!line.trim().isEmpty()) {
                            cardList.add(
                                    gson.fromJson(line, PokemonCard.class));
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load cards.");
            e.printStackTrace();
        }
    }
}