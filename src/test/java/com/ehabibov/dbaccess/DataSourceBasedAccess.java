package com.ehabibov.dbaccess;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.dbunit.DataSourceBasedDBTestCase;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import javax.sql.DataSource;
import java.io.*;
import java.util.List;

public class DataSourceBasedAccess extends DataSourceBasedDBTestCase {

	private String xmlDatasetPath;

	public DataSourceBasedAccess(String xmlDatasetPath) {
		this.xmlDatasetPath = xmlDatasetPath;
	}

	@Override
	protected IDataSet getDataSet() throws DataSetException {

		ReplacementDataSet replacementDataSet = null;
		try {
			InputStream xmlInputStream = this.getClass().getClassLoader().getResourceAsStream(xmlDatasetPath);
			IDataSet flatXmlDataset = new FlatXmlDataSetBuilder().build(xmlInputStream);
			replacementDataSet = new ReplacementDataSet(flatXmlDataset);
			replacementDataSet.setStrictReplacement(true);

			String csvDatasetPath = xmlDatasetPath.replace(".xml", ".csv");
			InputStream csvInputStream = this.getClass().getClassLoader().getResourceAsStream(csvDatasetPath);
			Reader reader = new InputStreamReader(csvInputStream);

			CSVReader csvReader = this.readCsv(reader);
			List<String[]> csvData = csvReader.readAll();
			String[] headerRow = csvData.get(0);
			csvData.remove(headerRow);

			for (String[] csvRow : csvData) {
				for (int i = 0; i < headerRow.length; i++) {
					headerRow[i] = String.format("[%s]", headerRow[i]);
					replacementDataSet.addReplacementObject(headerRow[i], csvRow[i]);
				}
			}
		} catch (IOException | CsvException e) {
			e.printStackTrace();
		}
		return replacementDataSet;
	}

	private CSVReader readCsv(Reader reader){
		CSVParser parser = new CSVParserBuilder()
				.withSeparator(',')
				.withIgnoreQuotations(true)
				.build();

		CSVReader csvReader = new CSVReaderBuilder(reader)
				.withSkipLines(0)
				.withCSVParser(parser)
				.build();

		return csvReader;
	}

	@Override
	protected DataSource getDataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setURL("jdbc:mysql://localhost:3306/orangehrm_db");
		dataSource.setUser("db_user");
		dataSource.setPassword("db_password");
		return dataSource;
	}

}