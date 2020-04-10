/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  
  
package com.gridscape.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportCSV{

	public Map<String, List<String[]>> Import(InputStream iStream) {
		Map<String, List<String[]>> map = new HashMap<String, List<String[]>>();
		String cvsSplitBy = ",";
		String line = "";
		String header[] = null;
		List<String[]> rows = new ArrayList<String[]>();
		int index = 0;
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(iStream));		
			System.out.println("start read data");
			while ((line = br.readLine()) != null) {
				if(index==0){
					header = line.split(cvsSplitBy);
					index = 1;					
					rows.add(header);
				}else{
					String[] tData = line.split(cvsSplitBy);
					String data[] = new String[header.length];
					for(int i=0;i<tData.length;i++){
						System.out.print(tData[i]+" ");
						data[i] = tData[i];
					}					
					rows.add(data);
				}				
			}
			System.out.println("end read data");
			map.put("data", rows);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object> ImportUtilityIntervalData(InputStream iStream) {
		Map<String, Object> map = new HashMap<String, Object>();
		String cvsSplitBy = ",";
		String line = "";
		int max_skipp_line = 6;
		String header[] = null;
		List<String[]> rows = new ArrayList<String[]>();
		int index = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
			
			while ((line = br.readLine()) != null) {
				if (index < max_skipp_line) {
					System.out.println(line);
					if (index == 5) {
						header = line.split(cvsSplitBy);
						rows.add(header);
					} else if (index < 4) {
						String key_val[] = line.split(cvsSplitBy);
						map.put(key_val[0], key_val[1]);
					}
					index++;
				} else {
					String[] tData = line.split(cvsSplitBy);
					String data[] = new String[header.length];
					for (int i = 0; i < tData.length; i++) {
						data[i] = tData[i];
					}
					rows.add(data);
				}
			}
			System.out.println("end read data");
			map.put("data", rows);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public Map<String, Object> importUtilityDataUsingPOI(InputStream in, String contentType){
		Map<String, Object> map = new HashMap<String, Object>();
		List<String[]> rows = new ArrayList<String[]>();
		Workbook workbook = null;
		if(contentType.equals("application/vnd.ms-excel")){
			try {
				workbook = new HSSFWorkbook(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")){
			try {
				workbook = new XSSFWorkbook(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		Sheet sheet = workbook.getSheetAt(0);
		
		Iterator<Row> rowIte = sheet.iterator();
		while(rowIte.hasNext()){
			Row row = rowIte.next();
			if(row == null){
				System.out.println("NULL");
			}
			if(row.getRowNum()<=3){
				try{
				map.put(row.getCell(0).getStringCellValue(), row.getCell(1).getStringCellValue());
				} catch(IllegalStateException ise){
					map.put(row.getCell(0).getStringCellValue(), String.valueOf(row.getCell(1).getNumericCellValue()));
				}
			}
			if(row.getRowNum()>5){
				String data[] = new String[row.getLastCellNum()];
				for(int i =0; i<row.getLastCellNum(); i++){
					if(i == 1){						
						data[i] = new SimpleDateFormat("MM/dd/yyyy").format(row.getCell(i).getDateCellValue());
					} else {
						try{
							data[i] = row.getCell(i).getStringCellValue();
						}catch(IllegalStateException e){
							data[i] = String.valueOf(row.getCell(i).getNumericCellValue());
						}catch(NullPointerException npe){
							data[i] = "";
						}
					}										
				}
				rows.add(data);
			}
			if(row.getRowNum() == sheet.getLastRowNum()){
				break;
			}
		}
		map.put("data", rows);
		return map;
	}
	
	public Map<String,Object> readExcel(InputStream iStream){
		Map<String,Object> map = new HashMap<String, Object>();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(iStream));		
			System.out.println("start read data");
			String line = "";			
			String header[] = null;
			String cvsSplitBy = ",";
			int max_skipp_line = 5;
			int index = 0;
			Map<String,Object> typeMap = new HashMap<String, Object>();
			List<String> type_val = new ArrayList<String>();
			List<String> date = new ArrayList<String>();
			List<String> start_time = new ArrayList<String>();
			List<String> end_time = new ArrayList<String>();
			List<String> usage = new ArrayList<String>();
			List<String> units = new ArrayList<String>();
			List<String> cost = new ArrayList<String>();
			List<String> notes = new ArrayList<String>();
			List<String> unit_cost = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
				if(index<max_skipp_line){
					if(index<max_skipp_line-1){
						map.put(line.split(cvsSplitBy)[0], line.split(cvsSplitBy)[1]);
					}					
				}else{
					if(index==5){
						header = line.split(cvsSplitBy);
					}
					String[] tData = line.split(cvsSplitBy);
					String data[] = new String[header.length];
					for(int i=0;i<tData.length;i++){
						data[i] = tData[i];
					}							
					type_val.add(data[0]);
					date.add(data[1]);
					start_time.add(data[2]);
					end_time.add(data[3]);
					usage.add(data[4]);
					units.add(data[5]);
					cost.add(data[6]);
					notes.add(data[7]);
					unit_cost.add(data[8]);
				}	
				index++;
				if(index==20)break;
				System.out.println(line);
			}		
			String type_key = type_val.get(0).toString();
			type_val.remove(0);
			map.put(type_key,type_val);
			type_key = date.get(0).toString();
			date.remove(0);
			map.put(type_key,date);
			type_key = start_time.get(0).toString();
			start_time.remove(0);
			map.put(type_key,start_time);
			type_key = end_time.get(0).toString();
			end_time.remove(0);
			map.put(type_key,end_time);
			type_key = usage.get(0).toString();
			usage.remove(0);
			map.put(type_key,usage);
			type_key = units.get(0).toString();
			units.remove(0);
			map.put(type_key,units);			
			type_key = cost.get(0).toString();
			cost.remove(0);
			map.put(type_key,cost);
			type_key = notes.get(0).toString();
			notes.remove(0);
			map.put(type_key,notes);
			type_key = unit_cost.get(0).toString();
			unit_cost.remove(0);
			map.put(type_key,unit_cost);
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
}
