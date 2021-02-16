package Registration;

import java.sql.*;

public class UserDb {
    public static void insert() {
        String sql = "insert into users(username, user_surname, user_birth_date, user_phone_number, user_email, user_password) values(?, ?, ?, ?, ?, ?)";

        try (Connection conn = new DbConnection().connect();
             PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, SignUpFrame.getTf1().getText());
            ps.setString(2, SignUpFrame.getTf2().getText());
            ps.setString(3, SignUpFrame.getBox1().getSelectedItem() + "/" + SignUpFrame.getBox2().getSelectedItem() + "/" + SignUpFrame.getBox3().getSelectedItem());
            ps.setString(4, "+996" + SignUpFrame.getTf3().getText());
            ps.setString(5, SignUpFrame.getTf4().getText() + "@gmail.com");
            ps.setString(6, encrypt(String.valueOf(SignUpFrame.getTf5().getPassword())));
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean check() {

        String sql = "select * from users where user_email = ? and reverse(substring(user_password for length(user_password) - 1)) = ?;";

        try (Connection conn = new DbConnection().connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, SignInFrame.getTf1().getText() + "@gmail.com");
            stmt.setString(2, String.valueOf(SignInFrame.getTf2().getPassword()));
            System.out.println(String.valueOf(SignInFrame.getTf2().getPassword()));

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static boolean isExist() {
        String sql = "SELECT * FROM users";

        try (Connection conn = new DbConnection().connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                if (rs.getString("user_email").equals(SignUpFrame.getTf4().getText() + "@gmail.com") || rs.getString("user_phone_number").equals("+996" + SignUpFrame.getTf3().getText())) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static boolean isExistEmail() {
        String sql = "SELECT user_email FROM users";

        try (Connection conn = new DbConnection().connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {

                if (rs.getString("user_email").equals(SignInFrame.getEmail())) {
                    return true;

                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static void change() {
        String sql = "UPDATE users SET user_password = ? WHERE user_email = ?";

        try (Connection conn = new DbConnection().connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, encrypt(String.valueOf(ResetFrame.getTf1().getPassword())));
            stmt.setString(2, SignInFrame.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public static String encrypt(String password) {
        StringBuilder builder = new StringBuilder(password).reverse();
        builder.append(password, 0, 1);
        return builder + "";
    }
}
