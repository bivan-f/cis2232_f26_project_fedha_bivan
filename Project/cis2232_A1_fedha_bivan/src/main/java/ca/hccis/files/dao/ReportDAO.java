package ca.hccis.files.dao;

import ca.hccis.files.entity.PokemonCard;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/pokemon_db";
    private static final String USER = "root";
    private static final String PASS = "";

    public List<PokemonCard> getCardsByType(String type) {
        List<PokemonCard> cards = new ArrayList<>();
        String sql = "SELECT * FROM pokemon_cards WHERE cardType = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, type);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cards.add(new PokemonCard(
                        rs.getInt("id"),
                        rs.getString("enteredDateTime"),
                        rs.getString("cardName"),
                        rs.getString("cardType"),
                        rs.getInt("cardHitPoints"),
                        rs.getString("cardAttackName"),
                        rs.getInt("cardAttackDamage"),
                        rs.getInt("cardAttackCost"),
                        rs.getInt("cardStage"),
                        rs.getInt("cardRetreatCost")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }
}
