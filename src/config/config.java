package config;
import java.sql.*;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class config {
    
    public static Connection connectDB() {
    Connection con = null;
    try {
        Class.forName("org.sqlite.JDBC"); 
        
        // FIX: Added the missing / after the C: and used forward slashes for safety
        String url = "jdbc:sqlite:C:/Users/PC/Documents/NetBeansProjects/Arambalagui/gymDB.db";
        
        con = DriverManager.getConnection(url); 
        System.out.println("Connection Successful");
    } catch (Exception e) {
        System.out.println("Connection Failed: " + e.getMessage());
    }
    return con;
}

    // This one checks IF the user exists (returns true/false)
    public boolean authenticate(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next(); 
            }
        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
        }
        return false;
    }

    // This one gets the USER TYPE (returns "Admin", "User", etc.)
    // RENAMED to avoid conflict
   public String authenticateUser(String sql, Object... values) {
    try (Connection conn = connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        for (int i = 0; i < values.length; i++) {
            pstmt.setObject(i + 1, values[i]);
        }

        try (ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("u_type"); // Returns "Admin" or whatever is in your DB
            }
        }
    } catch (SQLException e) {
        System.out.println("Query Error: " + e.getMessage());
    }
    return null; // Returns null if no user is found
}

    public void addRecord(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pstmt.setObject(i + 1, values[i]);
            }

            pstmt.executeUpdate();
            System.out.println("Record added successfully!");
        } catch (SQLException e) {
            System.out.println("Error adding record: " + e.getMessage());
        }
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
    
   
}