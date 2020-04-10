package com.gridscape.controller;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.helpers.FileGenerator;
import com.gridscape.helpers.ImportCSV;

import com.gridscape.helpers.NrelPVWatt;
import com.gridscape.jsoninput.JsonUtilityRate;
import com.gridscape.model.EnergyDetails;
import com.gridscape.model.SolarEnergyProduction;
import com.gridscape.model.SolarEnergyProductionDetail;
import com.gridscape.helpers.utilityImportData.FoothillCollegePGEIntervalData;
import com.gridscape.jsoninput.JsonUtilityRate;
import com.gridscape.model.Customers;
import com.gridscape.model.IntervalData;
import com.gridscape.model.SolarEstimateCustomer;
import com.gridscape.model.User;
import com.gridscape.model.Utility;
import com.gridscape.model.UtilityBreakDown;
import com.gridscape.model.UtilityImportCustomer;
import com.gridscape.model.UtilityIntervalData;
import com.gridscape.model.UtilityProvider;
import com.gridscape.model.UtilityRate;
import com.gridscape.service.EnergyDetailService;
import com.gridscape.service.MicroGridService;
import com.gridscape.service.SolarEnergyProductionDetailService;
import com.gridscape.service.SolarEnergyProductionService;
import com.gridscape.service.CustomerService;
import com.gridscape.service.IntervalDataService;
import com.gridscape.service.UserService;
import com.gridscape.service.UtilityImportCustomerService;
import com.gridscape.service.UtilityService;

@Controller
@RequestMapping("/utility")
public class UtilityController {
	@Autowired
	UtilityService uService;

	@Autowired
	UserService userService;
	
	@Autowired
	private EnergyDetailService energyDetailService;
	
	@Autowired
	private SolarEnergyProductionService solarEnergyProductionService;
	
	@Autowired
	private MicroGridService microGridService;

	@Autowired
	private UtilityImportCustomerService utilityImportCustomerService;

	@Autowired
	private IntervalDataService intervalDataService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private FoothillCollegePGEIntervalData foothillCollegePGEIntervalDataService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "/utilities/index";
	}

	@RequestMapping(value = "/utilityproviderlist", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUtilityProvider() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UtilityProvider> utilityProvider = uService.getUtilityProvider();
		map.put("data", utilityProvider);
		return map;
	}

	@RequestMapping(value = "/save_provider", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveProvider(@RequestBody UtilityProvider obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj.getId() != null) {
			UtilityProvider up = uService.findUtilityProviderById(obj.getId());
			up.setUtilityName(obj.getUtilityName());
			up.setMeter_fees_per_day(obj.getMeter_fees_per_day());
			uService.saveUtilityProvider(up);
		} else {
			uService.saveUtilityProvider(obj);
		}
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/find_utility_provider/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findUtilityProvider(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		UtilityProvider utilityProvider = uService.findUtilityProviderById(id);
		map.put("data", utilityProvider);
		return map;
	}

	@RequestMapping(value = "/delete_utility_provider/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteUtilityProvider(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		uService.deleteUtilityProviderById(id);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> list(HttpServletRequest req, @CookieValue("token") String token) {
		Map<String, Object> map = new HashMap<String, Object>();
		@SuppressWarnings("unused")
		Integer start = 0;
		@SuppressWarnings("unused")
		Integer len = 0;
		User user = userService.findByToken(token);
		List<Utility> list = null;
		if (user != null) {
			if (user.getUserRole().getRole().equalsIgnoreCase("super-admin")) {
				list = uService.getList();
			} else if (user.getUserRole().getRole().equalsIgnoreCase("customer-admin")) {
				list = uService.findListByUserId(user.getId());
			}
		}
		map.put("recordsTotal", list.size());
		map.put("recordsFiltered", list.size());
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(@RequestBody Utility obj, HttpServletRequest req,
			@CookieValue("token") String token) {
		Map<String, Object> map = new HashMap<String, Object>();
		User userObj = userService.findByToken(token);
		Long userId = null;
		if (userObj.getUserRole().getRole().equalsIgnoreCase("customer-admin")) {
			userId = userObj.getId();
			obj.setUser_id(userId);
		}
		obj = uService.save(obj);
		map.put("status", true);
		map.put("data", obj);
		return map;
	}

	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findById(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Utility obj = uService.findById(id);
		map.put("data", obj);
		return map;
	}

	@RequestMapping(value = "/deleteutility/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteUtility(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		uService.delete(id);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/import", method = RequestMethod.GET)
	public String importExcel() {
		return "utilities/import";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> Upload(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		InputStream inputStream = null;
		try {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multiRequest.getFileMap();
			MultipartFile mFile = files.get("file");
			String filename = mFile.getOriginalFilename();
			String contentType = mFile.getContentType();
			inputStream = mFile.getInputStream();
			if (contentType.equals("application/vnd.ms-excel")
					|| contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
				ImportCSV icsv = new ImportCSV();
				System.out.println(filename.contains("."));
				String[] nameSplit = filename.split("[.]");
				Map<String, Object> mapData = null;
				Customers custEntity = new Customers();
				custEntity.setName(request.getParameter("name"));
				custEntity.setEmail(request.getParameter("email"));
				custEntity.setContactNo(request.getParameter("contact_no"));
				custEntity.setUtilityFormat(Long.parseLong(request.getParameter("utility_format")));
				if (request.getParameter("data_in").equals("kw")) {
					custEntity.setDataInkw(true);
				} else {
					custEntity.setDataInkw(false);
				}
				custEntity.setDocumentName(filename);
				custEntity.setCustomerType("utility_import_data");
				custEntity = customerService.save(custEntity);
				if (nameSplit[1].equalsIgnoreCase("csv")) {
					mapData = icsv.ImportUtilityIntervalData(inputStream);
					uService.saveUtilityIntervalDataInBatch(getUtilityIntervalDataList(mapData, request));
				} else {
					String utilityFormat = request.getParameter("utility_format");
					if (utilityFormat != null) {
						if (utilityFormat.equals("1")) {
							mapData = icsv.importUtilityDataUsingPOI(inputStream, contentType);
							uService.saveUtilityIntervalDataInBatch(getUtilityIntervalDataList(mapData, request));
						} else if (utilityFormat.equals("2")) {
							UtilityImportCustomer customer = foothillCollegePGEIntervalDataService
									.readExcel(inputStream, contentType);
							UtilityImportCustomer temp_customer = utilityImportCustomerService
									.findOneByMeterName(customer.getMeter());
							List<IntervalData> intervalDataList = customer.getIntervalData();
							if (temp_customer != null) {
								Long customerId = temp_customer.getId();
								intervalDataService.saveEntityListInBatch(customerId, intervalDataList);
							} else {
								customer.setCustomer(custEntity);
								utilityImportCustomerService.saveAllEntityInBatch(customer);
							}
						}
					} else {
						System.out.println("utility format null");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}
	
	@RequestMapping(value="/utility_interval_data",method=RequestMethod.GET)
	public ModelAndView utilityIntervalData(@CookieValue("token") String token){
		User user = userService.findByToken(token);		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("utilities/utility_interval_data");
		modelAndView.addObject("userId", user.getId());
		return modelAndView;	
	}

	@SuppressWarnings("unchecked")
	public List<UtilityIntervalData> getUtilityIntervalDataList(Map<String, Object> mapData,
			HttpServletRequest request) {
		List<UtilityIntervalData> uId = new ArrayList<UtilityIntervalData>();
		try {
			String name = mapData.get("Name").toString();
			// String address = mapData.get("Address").toString();
			Date todayDate = new Date();
			String accountNumber = mapData.get("Account Number").toString();
			accountNumber += "/" + todayDate.getTime();
			// save solar estimate customer details
			String customer_name = request.getParameter("name");
			String email = request.getParameter("email");
			String contact_no = request.getParameter("contact_no");
			SolarEstimateCustomer sec = new SolarEstimateCustomer();
			sec.setAccount_no(accountNumber);
			sec.setName(customer_name);
			sec.setContact_no(contact_no);
			sec.setEmail(email);
			uService.saveSolarEstimateCustomer(sec);
			// end
			String service = mapData.get("Service").toString();
			List<String[]> rows = (List<String[]>) mapData.get("data");
			UtilityIntervalData uInterval = null;
			int index = 0;

			for (String row[] : rows) {
				if (index > 0) {
					uInterval = new UtilityIntervalData();
					uInterval.setName(name);
					uInterval.setAccount_no(accountNumber);
					uInterval.setService_no(service);
					// uInterval.setAddress(address);
					uInterval.setType(row[0]);
					String new_date[] = row[1].split("/");
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					uInterval.setDate(formatter.parse(new_date[2] + "-" + new_date[0] + "-" + new_date[1]));
					uInterval.setStart_time(row[2]);
					uInterval.setEnd_time(row[3]);
					uInterval.setUsage(row[4]);
					uInterval.setUnits(row[5]);
					if (row.length > 6) {
						if (row[6] != null && row[6].length() > 0) {
							String cost = row[6].substring(1);
							uInterval.setCost(cost);
						} else {
							uInterval.setCost(row[6]);
						}
					} else {
						uInterval.setCost("0");
					}

					if (row.length > 7) {
						uInterval.setNotes(row[7]);
					} else {
						uInterval.setNotes("");
					}
					if (row.length > 8) {
						uInterval.setUnit_cost(row[8]);
					} else {
						uInterval.setUnit_cost("");
					}
					uId.add(uInterval);
				}
				index++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return uId;
	}

	@RequestMapping(value = "/get_interval_data_list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getIntervalDataList(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UtilityIntervalData> list = uService.getIntervalDataList();
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "/getintervaldata", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getIntervalData(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		String search_filter = req.getParameter("search_filter");
		float solar_avaliable_time = 0.0F;
		if (req.getParameter("solar_avaliable_time") != null
				&& req.getParameter("solar_avaliable_time").toString().length() > 0) {
			solar_avaliable_time = Float.parseFloat(req.getParameter("solar_avaliable_time"));
		}
		float solar_panel_size = 0.0F;
		if (req.getParameter("solar_panel_size") != null
				&& req.getParameter("solar_avaliable_time").toString().length() > 0) {
			solar_panel_size = Float.parseFloat(req.getParameter("solar_panel_size"));
		}
		String account_no = req.getParameter("account_no");
		String energy_cost_on = req.getParameter("energy_cost_on");
		if (search_filter.equals("week")) {
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");
			List<Object[]> list = uService.getIntervalDataUsingAccountNoAndStartDateAndEndDate(energy_cost_on,
					account_no, start_date, end_date, solar_avaliable_time, solar_panel_size);
			map.put("data", list);
		} else if (search_filter.equals("month")) {
			int month_no = Integer.parseInt(req.getParameter("month"));
			int year_no = Integer.parseInt(req.getParameter("year"));
			List<Object[]> list = uService.getIntervalDataUsingAccountNoAndMonthAndYear(energy_cost_on, account_no,
					month_no, year_no, solar_avaliable_time, solar_panel_size);
			map.put("data", list);
		} else if (search_filter.equals("year")) {
			int year_no = Integer.parseInt(req.getParameter("year"));
			List<Object[]> list = uService.getIntervalDataUsingAccountNoAndYear(energy_cost_on, account_no, year_no,
					solar_avaliable_time, solar_panel_size);
			map.put("data", list);
		}
		return map;
	}
	
	@RequestMapping(value="/getintervaldatanew",method=RequestMethod.GET)
	@ResponseBody public Map<String, Object> getIntervalDataa(HttpServletRequest req){
		Map<String, Object> map = new HashMap<String, Object>();
		String search_filter = req.getParameter("search_filter");
		
		float system_capacity = 0.0F;
		if(req.getParameter("solar_panel_size")!=null && req.getParameter("solar_panel_size").toString().length()>0){
			system_capacity = Float.parseFloat(req.getParameter("solar_panel_size"));
		}
		float latVal = 0.0f;
		if(req.getParameter("latVal") != null && req.getParameter("latVal").toString().trim().length()>0){
			latVal = Float.parseFloat(req.getParameter("latVal"));
		}
		float longVal = 0.0f;
		if(req.getParameter("longVal") != null && req.getParameter("longVal").toString().trim().length()>0){
			longVal = Float.parseFloat(req.getParameter("longVal"));
		}
		
		boolean solarProductionDataStatus = uService.fetchSolarEnergyProductionForGivenAttributesUsingNRELApi(latVal, longVal, system_capacity, 270f, 22.6f);
		
		String account_no = req.getParameter("account_no");
		String energy_cost_on = req.getParameter("energy_cost_on");
		
		switch(search_filter){
		case "week":
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");
			List<Object[]> list = uService.getIntervalDataUsingAccountNoAndStartDateAndEndDateApi(energy_cost_on,account_no,start_date,end_date);
			map.put("data", list);
			
			//solar generation part
			if(solarProductionDataStatus){
				SolarEnergyProduction solarEnergyProduction = solarEnergyProductionService.getHaving(latVal, longVal, system_capacity, 270f, 22.6f);
				Long soleEnergyProductionId = solarEnergyProduction.getId();
			}
			break;
		case "month":
			int month_no = Integer.parseInt(req.getParameter("month"));
			int year_no = Integer.parseInt(req.getParameter("year"));
			List<Object[]> listM = uService.getIntervalDataUsingAccountNoAndMonthAndYearApi(energy_cost_on,account_no,month_no,year_no);
			map.put("data", listM);
			break;
		case "year":
			int year_no_for_year_filter = Integer.parseInt(req.getParameter("year"));			
			List<Object[]> listY = uService.getIntervalDataUsingAccountNoAndYearApi(energy_cost_on,account_no,year_no_for_year_filter);						
			map.put("data", listY);
			break;
		}		
		return map;
	}


	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String showUtilityDetails(@PathVariable("id") long id) {

		return "utilities/show";
	}

	@RequestMapping(value = "/bill", method = RequestMethod.GET)
	public String utilityBill() {
		return "utilities/bill";
	}

	@RequestMapping(value = "get_account_no_list_from_interval_data", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> get_account_from_interval_data() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Object> list = uService.getAccountNoListFromIntervalData();
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "calculatebill", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> calculateBill(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		String start_date = req.getParameter("start_date");
		String end_date = req.getParameter("end_date");
		String account_no = req.getParameter("account_no");
		uService.calculateBill(start_date, end_date, account_no);
		map.put("status", true);
		return map;
	}
		
	@RequestMapping(value = "{id}/break_down", method = RequestMethod.GET)
	public String utilityBreakDown(@PathVariable Long id) {
		return "utilities/break_down";
	}

	@RequestMapping(value = "/list_break_down", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listBreakDown() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<com.gridscape.jsoninput.UtilityBreakDown> list = uService.listUtilityBreakDown();
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "/find_break_down_list_by_utility_provider_id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findBreakDownListByUtilityProviderId(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<com.gridscape.jsoninput.UtilityBreakDown> list = uService.findBreakDownListByUtilityProviderId(id);
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "save_break_down", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save_break_down(@RequestBody UtilityBreakDown obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj.getId() != null) {
			UtilityBreakDown temp = uService.findBreakDownById(obj.getId());
			temp.setSeason(obj.getSeason());
			temp.setStart_date(obj.getStart_date());
			temp.setEnd_date(obj.getEnd_date());
			temp.setUtility_provider_id(obj.getUtility_provider_id());
			uService.saveUtilityBreakDown(temp);
		} else {
			uService.saveUtilityBreakDown(obj);
		}
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/find_break_down/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findBreakDownById(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		UtilityBreakDown temp = uService.findBreakDownById(id);
		map.put("data", temp);
		return map;
	}

	@RequestMapping(value = "/find_break_down_by_id_with_json/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findBreakDownByIdWithJson(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		com.gridscape.jsoninput.UtilityBreakDown temp = uService.findBreakDownByIdWithJson(id);
		map.put("data", temp);
		return map;
	}

	@RequestMapping(value = "/delete_break_down/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteBreakDown(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		uService.deleteBreakDown(id);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/provider", method = RequestMethod.GET)
	public String utilityProvider() {
		return "utilities/provider";
	}

	@RequestMapping(value = "/list_provider", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listProvider() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UtilityProvider> list = uService.listProvider();
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "{id}/break_down/{b_id}/utility_rate", method = RequestMethod.GET)
	public String utilityRate(@PathVariable("id") Long id, @PathVariable("b_id") Long b_id) {
		return "utilities/utility_rate";
	}

	@RequestMapping(value = "/list_utility_rate", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listUtilityRate() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<JsonUtilityRate> list = uService.listUtilityRate();
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "/find_break_down_by_utility_provider_id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findBreakDownByUtilityProviderId(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UtilityBreakDown> list = uService.findBreakDownByUtilityProviderId(id);
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "/save_utility_rate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveUtilityRate(@RequestBody UtilityRate obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (obj.getId() != null) {
			UtilityRate ur = uService.findUtilityRateById(obj.getId());
			ur.setGeneration(obj.getGeneration());
			ur.setStartTime(obj.getStartTime());
			ur.setEnd_time(obj.getEnd_time());
			ur.setRate(obj.getRate());
			ur.setUtility_break_down_id(obj.getUtility_break_down_id());
			uService.saveUtilityRate(ur);
		} else {
			uService.saveUtilityRate(obj);
		}
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/find_utility_rate_by_id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findUtilityRateId(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		JsonUtilityRate jsonUtilityRate = uService.findUtilityRateById_with_json(id);
		map.put("data", jsonUtilityRate);
		return map;
	}

	@RequestMapping(value = "/delete_utility_rate/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteUtilityRate(@PathVariable Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		uService.deleteUtilityRate(id);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/foothill_college_analysis", method = RequestMethod.GET)
	public String foothill_college_analysis() {
		return "utilities/foothill_college_analysis";
	}

	@RequestMapping(value = "/utility_import_customer_list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> utilityImportCustomerList(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<UtilityImportCustomer> utilityImportCustomerList = utilityImportCustomerService.findAll();
		System.out.println("size of data = " + utilityImportCustomerList.size());
		map.put("status", true);
		map.put("data", utilityImportCustomerList);
		return map;
	}

	@RequestMapping(value = "/interval_data_list", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> intervalDataList(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (req.getParameter("customer_id") != null) {
			Long customerId = Long.parseLong(req.getParameter("customer_id"));
			List<IntervalData> intervalDataList = intervalDataService.findAllByCustomerId(customerId);
			map.put("status", true);
			map.put("data", intervalDataList);
		} else {
			map.put("status", false);
		}
		return map;
	}

	@RequestMapping(value = "/interval_data_list_by_customer_id_and_year", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> intervalDataListByCustomerIdAndYear(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (req.getParameter("customer_id") != null && req.getParameter("year") != null) {
			Long customerId = Long.parseLong(req.getParameter("customer_id"));
			int year = Integer.parseInt(req.getParameter("year"));
			List<IntervalData> intervalDataList = intervalDataService.findAllByCustomerIdAndYear(customerId, year);
			map.put("status", true);
			map.put("data", intervalDataList);
		} else {
			map.put("status", false);
		}
		return map;
	}

	@RequestMapping(value = "/interval_data_list_by_search_filter", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> interval_data_list_by_search_filter(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		String searchFilter = req.getParameter("search_filter");
		Long customerId = Long.parseLong(req.getParameter("customer_id"));
		if (searchFilter != null && searchFilter.equals("year")) {
			if (customerId != null && req.getParameter("year") != null) {
				int year = Integer.parseInt(req.getParameter("year"));
				List<IntervalData> intervalDataList = intervalDataService.findAllByCustomerIdAndYearAndGroupByMonth(customerId, year);
				map.put("status", true);
				map.put("data", intervalDataList);
			}
		} else if (searchFilter != null && searchFilter.equals("month")) {
			if (customerId != null && req.getParameter("year") != null && req.getParameter("month") != null) {
				int year = Integer.parseInt(req.getParameter("year"));
				int month = Integer.parseInt(req.getParameter("month"));
				List<IntervalData> intervalDataList = intervalDataService.findAllByCustomerIdAndYearAndMonthAndGroupByDate(customerId,
						year, month);
				map.put("status", true);
				map.put("data", intervalDataList);
			}
		} else if (searchFilter != null && searchFilter.equals("week")) {
			String start_date = req.getParameter("start_date");
			String end_date = req.getParameter("end_date");			
			List<IntervalData> intervalDataList = intervalDataService.findAllByCustomerIdAndStartDateAndEndDateWithGroupByDate(customerId,start_date,end_date);
			map.put("status", true);
			map.put("data", intervalDataList);
		}

		return map;
	}
		
	@RequestMapping(value="/renewable_energy_bill", method=RequestMethod.GET)
	public ModelAndView getRenewableEnergyBill(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("utilities/renewable_energy_bill");
		return modelAndView;
	}
}

