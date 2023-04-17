package com.JDBC;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
public class PayrollServiceDatabaseTest {
    @Test
    void testConnection() {
        try (Connection conn = PayrollServiceDatabase.getConnection()) {
            assertNotNull(conn);
            assertFalse(conn.isClosed());
            DatabaseMetaData metaData = conn.getMetaData();
            assertEquals("MySQL Connector/J", metaData.getDriverName());
        } catch (SQLException e) {
            fail("Failed to connect to database: " + e.getMessage());
        }
    }

}
