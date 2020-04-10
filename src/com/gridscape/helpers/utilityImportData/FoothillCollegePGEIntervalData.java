package com.gridscape.helpers.utilityImportData;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.gridscape.model.IntervalData;
import com.gridscape.model.UtilityImportCustomer;

@Service
public class FoothillCollegePGEIntervalData {
	private final int SKIPP_LINE = 12;

	public UtilityImportCustomer readExcel(InputStream in, String contentType) {
		try {
			Workbook workbook = null;
			if (contentType.equals("application/vnd.ms-excel")) {
				workbook = new HSSFWorkbook(in);
			} else if (contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				workbook = new XSSFWorkbook(in);
			}
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIte = sheet.iterator();
			Row row;
			int index = 0;
			UtilityImportCustomer customer = new UtilityImportCustomer();
			List<IntervalData> intervalDataList = new ArrayList<>();
			IntervalData intervalData = null;
			SimpleDateFormat sdf = null;
			while (rowIte.hasNext()) {
				row = rowIte.next();
				if (index < SKIPP_LINE) {
					if (row.getCell(0).toString().equalsIgnoreCase("title:")) {
						String title = row.getCell(1).toString().substring(1, row.getCell(1).toString().length() - 1);
						customer.setTitle(title);
					} else if (row.getCell(0).toString().equalsIgnoreCase("Report Date")) {
						String reportDate = row.getCell(1).toString().substring(1,
								row.getCell(1).toString().length() - 1);
						customer.setReportDate(reportDate);
					} else if (row.getCell(0).toString().equalsIgnoreCase("Report Span")) {
						String reporSpantDate = row.getCell(1).toString().substring(1,
								row.getCell(1).toString().length() - 1);
						customer.setReportSpan(reporSpantDate);
					} else if (row.getCell(0).toString().equalsIgnoreCase("Total Days")) {
						String totalDays = row.getCell(1).toString().substring(1,
								row.getCell(1).toString().length() - 1);
						customer.setTotalDays(totalDays);
					} else if (row.getCell(0).toString().equalsIgnoreCase("TrendType")) {

					} else if (row.getCell(0).toString().equalsIgnoreCase("Trend Interval")) {
						String interval = row.getCell(1).toString().substring(1,
								row.getCell(1).toString().length() - 1);
						customer.setIntervalLength(interval);
					} else if (row.getCell(0).toString().equalsIgnoreCase("Customer")) {
						String customerName = row.getCell(1).toString().substring(1,
								row.getCell(1).toString().length() - 1);
						customer.setCustomerName(customerName);
					} else if (row.getCell(0).toString().equalsIgnoreCase("Time Zone")) {
						String timeZone = row.getCell(1).toString().substring(1,
								row.getCell(1).toString().length() - 1);
						customer.setTimeZone(timeZone);
					} else if (row.getCell(0).toString().equalsIgnoreCase("Meter")) {
						String meter = row.getCell(1).toString().substring(1, row.getCell(1).toString().length() - 1);
						customer.setMeter(meter);
					}
				} else {
					intervalData = new IntervalData();
					if (row.getCell(0) != null) {
						String timeStamp = row.getCell(0).toString().substring(1,
								row.getCell(0).toString().length() - 1);
						if (timeStamp != null) {
							sdf = new SimpleDateFormat("M/d/yyyy H:mm a");
							Date date = sdf.parse(timeStamp);
							Timestamp sqlDate = new Timestamp(date.getTime());
							intervalData.setTimeStamp(sqlDate);
						}
					}
					if (row.getCell(1) != null) {
						intervalData.setUsageVal(Float.parseFloat(row.getCell(1).toString()));
					}
					intervalDataList.add(intervalData);
				}
				index++;
			}
			customer.setIntervalData(intervalDataList);
			return customer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
}
