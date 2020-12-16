package com.computechis.factory;

public class DataProviderFactory {
	
	public static ExcelReader getExcel() {
		ExcelReader excel = new ExcelReader();
		return excel;
	}
	public static ConfigDataProvider getConfig() {
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}
}
