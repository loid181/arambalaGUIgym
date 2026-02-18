package config;
import java.sql.*;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class config {

   public static Connection connectDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection("jdbc:sqlite:gymDB.db");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   
public void addRecord(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }

        int rows = pstmt.executeUpdate(); // Capture how many rows changed
        if (rows > 0) {
            System.out.println("Update Successful! Rows affected: " + rows);
        } else {
            System.out.println("Warning: No rows were updated. Check your ID!");
        }
    } catch (SQLException e) {
        System.out.println("Error adding record: " + e.getMessage());
    }
}
public String authenticate(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("type");
            }
        }
    } catch (SQLException e) {
        System.out.println("Login Error: " + e.getMessage());
    }
    return null;
}
    public String authenticateUser(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("u_type");
                }
            }
        } catch (SQLException e) {
            System.out.println("Query Error: " + e.getMessage());
        }
        return null;
    }

   public void displayData(String sql, javax.swing.JTable table) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         ResultSet rs = pstmt.executeQuery()) {
        
        // This line automatically maps the Resultset to your JTable
        table.setModel(DbUtils.resultSetToTableModel(rs));
        
    } catch (SQLException e) {
        System.out.println("Error displaying data: " + e.getMessage());
    }
}
    public static String hashPassword(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println("Error hashing password: " + e.getMessage());
            return null;
        }
    }
    public boolean isEmailTaken(String email) {
    boolean taken = false;
    String sql = "SELECT email FROM users_tbl WHERE email = ?";
    
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, email);
        
        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                taken = true; // Email found in database
            }
        }
    } catch (SQLException e) {
        System.out.println("Error checking email: " + e.getMessage());
    }
    return taken;
}
   public int getScalar(String sql) {
    try (Connection conn = connectDB();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    return 0;
}
   public ResultSet getData(String sql) throws SQLException {
    Connection conn = connectDB();
    Statement stmt = conn.createStatement();
    return stmt.executeQuery(sql);
}
public int insertData(String sql) {
    try (Connection conn = connectDB(); 
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        int rowsAffected = pstmt.executeUpdate();
        System.out.println("Rows inserted: " + rowsAffected); // This will print in NetBeans console
        return rowsAffected;
    } catch (SQLException e) {
        System.out.println("Insert Error: " + e.getMessage());
        return 0;
    }

}
public void deleteRecord(String sql) {
    try {
        java.sql.Connection conn = connectDB();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.executeUpdate();
        pst.close();
        conn.close();
    } catch (java.sql.SQLException e) {
        System.out.println("Error deleting record: " + e.getMessage());
    }
}
// Inside your config.java, you can have a shared method
public void updateProfile(int id, String name, String email, String phone) {
    String sql = "UPDATE users_tbl SET full_name = ?, email = ?, phonenumber = ? WHERE u_id = ?";
    this.addRecord(sql, name, email, phone, id);
}
}