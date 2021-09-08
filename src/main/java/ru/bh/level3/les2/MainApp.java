package ru.bh.level3.les2;

import java.sql.*;

public class MainApp {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;

    //CRUD


    public static void main(String[] args) {
        try {
            connect();
            insertExample();
            readExample();
            updateExample();
            deleteOneExample();
            clearTableExample();
            correctFillingTable();
            dropAndCreateTable();
            batchExample(); //отправка запросов пакетом
            preparedStatementExample();
            rollbackExample(); //контрольная точка


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    private static int getStudentScoreByName(String name) {
        try (ResultSet rs = stmt.executeQuery("select score from students where name = '" + name + "';")) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static void rollbackExample() throws SQLException {
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob1', 10");
        Savepoint sp1 = connection.setSavepoint();
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob2', 20");
        connection.rollback(sp1);
        stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Bob3', 30");
        connection.commit();
    }

    private static void preparedStatementExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i < 50; i++) {
            psInsert.setString(1, "BOB" + i);
            psInsert.setInt(2, 100);
            psInsert.executeUpdate();
        }
        connection.commit();
    }

    private static void prepareStatement() throws SQLException {
        psInsert = connection.prepareStatement("insert into students (id,name) value (?,?);");
    }


    private static void batchExample() throws SQLException {
        connection.setAutoCommit(false);
        for (int i = 1; i < 50; i++) {
            stmt.addBatch(String.format("insert into students (name,score) values ('%s', %d)", "Bob #" + i, 100));
        }
        stmt.executeBatch();
        connection.commit();
    }

    private static void dropAndCreateTable() throws SQLException {
        stmt.executeUpdate("drop table if exists students");
        stmt.executeUpdate("create table if not exists students (\n" + " id INTEGER PRIMARY KEY AUTOINCREMENT, \n" + " name TEXT, \n" + "score INTEGER \n" + ");;");
    }

    private static void correctFillingTable() throws SQLException {
        long time = System.currentTimeMillis();
        connection.setAutoCommit(false);
        for (int i = 1; i < 5000; i++) {
            stmt.executeUpdate(String.format("insert into students (name,score) values ('%s', 100)", "Bob #" + i));
        }
        connection.commit();
        System.out.println("TIME: " + (System.currentTimeMillis() - time));
    }

    private static void clearTableExample() throws SQLException {
        stmt.executeUpdate("delete from students");
    }

    private static void deleteOneExample() throws SQLException {
        stmt.executeUpdate("delete from students where id = 5");
    }

    private static void updateExample() throws SQLException {
        stmt.executeUpdate("update students set score = 100 where id > 0");
    }

    private static void readExample() throws SQLException {
        try (ResultSet rs = stmt.executeQuery("select * from students where id > 2;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));
            }
        }
    }

    private static void insertExample() throws SQLException {
        stmt.executeUpdate("insert into students (name, score) value ('Max', 70)");
    }

    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
            stmt = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
    }

    public static void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (psInsert != null) {
                psInsert.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



