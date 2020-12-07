package kz.dias.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class Application {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5436/";
    static final String USER = "postgres";
    static final String PASS = "123";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Connection conn = null;
        Statement stmt = null;
        boolean flag = false;

        try {
            Class.forName(JDBC_DRIVER);

            System.out.println("Connecting to database...");

            try {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5436/students", USER, PASS);
                flag = true;
                System.out.println("Students database exists");
            } catch (Exception se) {
                se.printStackTrace();
            }

            if(!flag) {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);


                System.out.println("Creating database...");
                stmt = conn.createStatement();

                String sql = "CREATE DATABASE students";
                stmt.executeUpdate(sql);
                System.out.println("Database created successfully...");

                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5436/students", USER, PASS);

                System.out.println("Creating table...");
                stmt = conn.createStatement();
                String sqlTable = "CREATE TABLE students (\n" +
                        "\tid serial PRIMARY KEY,\n" +
                        "\tname varchar(100) NOT NULL,\n" +
                        "\tsurname varchar(100) NOT NULL,\n" +
                        "\tsubject varchar(100) NOT NULL,\n" +
                        "\tgrade varchar(100) NOT NULL\n" +
                        ")";
                stmt.executeUpdate(sqlTable);
                System.out.println("Table created successfully...");

                System.out.println("Adding students to the database...");
                stmt = conn.createStatement();
                String sqlInsert = "INSERT INTO students(name, surname, subject, grade)\n" +
                        "VALUES ('Диас', 'Алпысбаев', 'математика', '10A'), ('Магжан', 'Татыбаев', 'физика', '11A');";
                stmt.executeUpdate(sqlInsert);
                System.out.println("Students are added successfully...");
            }
        } catch (Exception se) {
            se.printStackTrace();
        }
        finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }

}
