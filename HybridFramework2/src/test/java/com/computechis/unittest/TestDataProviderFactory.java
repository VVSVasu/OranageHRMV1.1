package com.computechis.unittest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.computechis.factory.ConfigDataProvider;
import com.computechis.factory.ExcelReader;

public class TestDataProviderFactory {
	@Test
	public void testExcelLib() {
		ExcelReader excel = new ExcelReader();
		String data = excel.getStringData("TestSheet", 0, 0);
		Assert.assertEquals(data, "TestingExcel");
	}

	@Test
	public void testConfigLib() {
		ConfigDataProvider config = new ConfigDataProvider();
		String data = config.getValue("testConfig");
		Assert.assertEquals(data, "TestingConfigFile");
	}
}
