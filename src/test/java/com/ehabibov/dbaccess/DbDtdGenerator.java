package com.ehabibov.dbaccess;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDtdGenerator {

	public static void main(String[] args) {
		// jdbc:mysql://localhost:3306/orangehrm_db
		// com.mysql.jdbc.Driver

		try {
			Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
			Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/orangehrm_db",
					"db_user", "db_password");
			IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);
			DatabaseConfig config = connection.getConfig();
			config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
			FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream("schema.dtd"));
		} catch (ClassNotFoundException | SQLException | DatabaseUnitException | IOException e) {
			e.printStackTrace();
		}
	}
}
