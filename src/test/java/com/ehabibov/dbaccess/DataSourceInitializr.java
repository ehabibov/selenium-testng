package com.ehabibov.dbaccess;

import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import java.sql.SQLException;

public class DataSourceInitializr {

	public static void main(String[] args) {
		String path = "datasets/UserInsert/users.xml";
		DataSourceBasedAccess dsa = new DataSourceBasedAccess(path);

		try {
			IDataSet dataset = dsa.getDataSet();
			DatabaseConnection connection = new DatabaseConnection(dsa.getDataSource().getConnection());
			connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
			DatabaseOperation.CLEAN_INSERT.execute(connection, dataset);
		} catch (SQLException | DatabaseUnitException e) {
			e.printStackTrace();
		}
	}
}