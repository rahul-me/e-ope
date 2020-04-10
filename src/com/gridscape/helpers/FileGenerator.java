package com.gridscape.helpers;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gridscape.model.MicroController;
import com.gridscape.model.SolarGenerationCharge;
import com.gridscape.service.SolarGenerationChargeService;

@Component
public class FileGenerator {

	@Autowired
	private SolarGenerationChargeService solarGenerationChargeService;

	public XSSFWorkbook generateExcelForRenewableEnergyUsageData(List<Object[]> objects,
			MicroController microController, String start_date, String end_date) {

		// Time Manipulation

		DecimalFormat decimalFormatEnUsage = new DecimalFormat(".####");
		DecimalFormat decimalFormatCost = new DecimalFormat(".##");

		SimpleDateFormat formatorDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatorTime = new SimpleDateFormat("HH:mm");
		SimpleDateFormat formatorMonthIndex = new SimpleDateFormat("MM");
		SimpleDateFormat formatorYear = new SimpleDateFormat("yyyy");

		XSSFWorkbook workb = new XSSFWorkbook();
		XSSFSheet worksheet = workb.createSheet("Renewable Energy Generation");

		worksheet.setColumnWidth(0, 6000);
		worksheet.setColumnWidth(1, 6000);
		worksheet.setColumnWidth(2, 6000);
		worksheet.setColumnWidth(3, 6000);
		worksheet.setColumnWidth(4, 6000);
		worksheet.setColumnWidth(5, 6000);

		XSSFFont wfont = workb.createFont();
		wfont.setFontName("Calibri");

		XSSFCellStyle wstyle = workb.createCellStyle();
		wstyle.setFont(wfont);

		// First Row
		XSSFRow wrow = worksheet.createRow(0);

		XSSFCell wcell = wrow.createCell(0);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("MICRO-GRID NAME");

		wcell = wrow.createCell(1);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue(microController.getMicrogrid_name());

		// second row
		wrow = worksheet.createRow(1);

		wcell = wrow.createCell(0);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("MICRO-GRID ID");

		wcell = wrow.createCell(1);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue(microController.getMicrogrid_id());

		// Third Row
		wrow = worksheet.createRow(2);

		wcell = wrow.createCell(0);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("ADDRESS");

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(microController.getAddress_line_1());
		String add_line_2 = microController.getAddress_line_2();
		if (add_line_2.trim().length() > 0) {
			stringBuilder.append("," + add_line_2);
		}
		stringBuilder.append("," + microController.getCity() + "," + microController.getCountry() + ","
				+ microController.getZip_code());

		wcell = wrow.createCell(1);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue(stringBuilder.toString());

		wrow = worksheet.createRow(4);

		wcell = wrow.createCell(0);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("DATE");

		wcell = wrow.createCell(1);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("START TIME");

		wcell = wrow.createCell(2);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("END TIME");

		wcell = wrow.createCell(3);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("USAGE");

		wcell = wrow.createCell(4);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("UNIT");

		wcell = wrow.createCell(5);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("COST");

		int rowCount = 5;
		int month_index = 0;
		float solarGenerationRate = 0.0f;

		for (int i = 0; i < objects.size(); i++) {

			if (i == 0) {
				continue;
			}

			Object[] data = objects.get(i - 1);
			Timestamp timeStamp = (Timestamp) data[0];

			Date date = new Date(timeStamp.getTime());
			String previousTime = formatorTime.format(date);

			data = objects.get(i);
			timeStamp = (Timestamp) data[0];
			date = new Date(timeStamp.getTime());
			String dateStr = formatorDate.format(date);
			String currentTimeStr = formatorTime.format(date);

			// Energy Usage
			String en_gen = (String) data[1];

			// find cost for this month
			int month_index_of_data = Integer.parseInt(formatorMonthIndex.format(date));
			int yearNumber = Integer.parseInt(formatorYear.format(date));
			if (month_index_of_data != month_index) {
				SolarGenerationCharge solarGenerationCharge = solarGenerationChargeService
						.getHavingMgcIdAndMonthGenerateIfNotExists(microController, month_index_of_data, yearNumber);
				solarGenerationRate = (Float.parseFloat((String) data[1]) * solarGenerationCharge.getRate());
			}

			wrow = worksheet.createRow(rowCount);

			wcell = wrow.createCell(0);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue(dateStr);

			wcell = wrow.createCell(1);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue(previousTime);

			wcell = wrow.createCell(2);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue(currentTimeStr);

			wcell = wrow.createCell(3);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue(String.format("%.4f", Float.parseFloat((String) data[1])));

			wcell = wrow.createCell(4);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("kWh");

			wcell = wrow.createCell(5);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("$" + String.format("%.2f", solarGenerationRate));

			rowCount++;

		}

		return workb;

	}

	public XSSFWorkbook generateExcelForRenewableEnergyUsageDataNew(List<Object[]> objects,
			MicroController microController, String start_date, String end_date) {

		// Set up excel file

		DecimalFormat decimalFormatEnUsage = new DecimalFormat(".####");
		DecimalFormat decimalFormatCost = new DecimalFormat(".##");

		SimpleDateFormat formatorDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatorTime = new SimpleDateFormat("HH:mm");
		SimpleDateFormat formatorMonthIndex = new SimpleDateFormat("MM");
		SimpleDateFormat formatorYear = new SimpleDateFormat("yyyy");

		XSSFWorkbook workb = new XSSFWorkbook();
		XSSFSheet worksheet = workb.createSheet("Renewable Energy Generation");

		worksheet.setColumnWidth(0, 6000);
		worksheet.setColumnWidth(1, 6000);
		worksheet.setColumnWidth(2, 6000);
		worksheet.setColumnWidth(3, 6000);
		worksheet.setColumnWidth(4, 6000);
		worksheet.setColumnWidth(5, 6000);

		XSSFFont wfont = workb.createFont();
		wfont.setFontName("Calibri");

		XSSFCellStyle wstyle = workb.createCellStyle();
		wstyle.setFont(wfont);

		// First Row
		XSSFRow wrow = worksheet.createRow(0);

		XSSFCell wcell = wrow.createCell(0);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("MICRO-GRID NAME");

		wcell = wrow.createCell(1);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue(microController.getMicrogrid_name());

		// second row
		wrow = worksheet.createRow(1);

		wcell = wrow.createCell(0);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("MICRO-GRID ID");

		wcell = wrow.createCell(1);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue(microController.getMicrogrid_id());

		// Third Row
		wrow = worksheet.createRow(2);

		wcell = wrow.createCell(0);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("ADDRESS");

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(microController.getAddress_line_1());
		String add_line_2 = microController.getAddress_line_2();
		if (add_line_2.trim().length() > 0) {
			stringBuilder.append("," + add_line_2);
		}
		stringBuilder.append("," + microController.getCity() + "," + microController.getCountry() + ","
				+ microController.getZip_code());

		wcell = wrow.createCell(1);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue(stringBuilder.toString());

		wrow = worksheet.createRow(4);

		wcell = wrow.createCell(0);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("DATE");

		wcell = wrow.createCell(1);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("START TIME");

		wcell = wrow.createCell(2);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("END TIME");

		wcell = wrow.createCell(3);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("USAGE");

		wcell = wrow.createCell(4);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("UNIT");

		wcell = wrow.createCell(5);
		wcell.setCellStyle(wstyle);
		wcell.setCellValue("COST");

		int rowCount = 5;
		int month_index = 0;
		float solarGenerationRate = 0.0f;

		// end set up

		// Time Manipulation

		Date startDate = DateHelper.convertStringToDate(start_date, "yyyy-MM-dd");
		Calendar startCalendar = Calendar.getInstance();
		startCalendar.setTime(startDate);

		startCalendar = Utility.setHourMinuteSecondsToZero(startCalendar);

		Date endDate = DateHelper.convertStringToDate(end_date, "yyyy-MM-dd");
		Calendar endCalendar = Calendar.getInstance();
		endCalendar.setTime(endDate);

		endCalendar = Utility.setHourMinuteSecondsToZero(endCalendar);

		System.out.println("start time                 End time                   en_usage");

		int lastIndex = 0;
		for (long i = startCalendar.getTimeInMillis(); i <= endCalendar.getTimeInMillis(); i += (900000)) {
			Map<String, Object> result = getEnergyGeneartionBetween(i, (i + 899999), objects, lastIndex);
			float en_generation = (Float) result.get("en_g");
			int li = (Integer) result.get("li");
			lastIndex = li;

			System.out.println(en_generation + "               " + new Date(i).toString() + "               "
					+ new Date(i + 899999).toString());

			// find cost for this month
			int month_index_of_data = Integer.parseInt(formatorMonthIndex.format(new Date(i)));
			int yearNumber = Integer.parseInt(formatorYear.format(new Date(i)));
			if (month_index_of_data != month_index) {
				SolarGenerationCharge solarGenerationCharge = solarGenerationChargeService
						.getHavingMgcIdAndMonthGenerateIfNotExists(microController, month_index_of_data, yearNumber);
				solarGenerationRate = solarGenerationCharge.getRate();
				
				month_index = month_index_of_data;
			}
			
			

			wrow = worksheet.createRow(rowCount);

			wcell = wrow.createCell(0);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue(formatorDate.format(new Date(i)));

			wcell = wrow.createCell(1);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue(formatorTime.format(new Date(i)));

			wcell = wrow.createCell(2);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue(formatorTime.format(new Date(i + 899999)));

			wcell = wrow.createCell(3);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue(String.format("%.4f", en_generation));

			wcell = wrow.createCell(4);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("kWh");

			wcell = wrow.createCell(5);
			wcell.setCellStyle(wstyle);
			wcell.setCellValue("$" + String.format("%.2f", (solarGenerationRate * en_generation)));

			rowCount++;
		}
		return workb;
	}

	private Map<String, Object> getEnergyGeneartionBetween(long startTime, long endTime, List<Object[]> dataList,
			int lastIndex) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		float en_generation = 0.0f;
		int li = 0;
		for (int i = lastIndex; i < dataList.size(); i++) {
			Object[] data = dataList.get(i);
			Timestamp timeStamp = (Timestamp) data[0];
			if (timeStamp.getTime() > endTime)
				break;
			if (timeStamp.getTime() >= startTime && timeStamp.getTime() <= endTime) {
			  System.out.println("En Data: "+data[1]);
				en_generation += Float.parseFloat((String) data[1]);
			}
			li = i;
		}
		returnMap.put("en_g", en_generation);
		returnMap.put("li", li);

		return returnMap;
	}
}
