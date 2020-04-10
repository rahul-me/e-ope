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

package com.gridscape.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.API_Interface.MicroGridAPI;
import com.gridscape.helpers.TimeZone;
import com.gridscape.helpers.Utility;
import com.gridscape.jsoninput.ColumnGraph;
import com.gridscape.model.BatteryStatus;
import com.gridscape.model.EnergyDetails;
import com.gridscape.model.MicroController;
import com.gridscape.model.User;
import com.gridscape.service.AssignOperatorService;
import com.gridscape.service.BatterySerivace;
import com.gridscape.service.CommonService;
import com.gridscape.service.EnergyDetailService;
import com.gridscape.service.LoginService;
import com.gridscape.service.MicroGridService;
import com.gridscape.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {
  private static final Logger LOG = Logger.getLogger(HomeController.class.getName());
  @Autowired
  LoginService lService;

  @Autowired
  BatterySerivace bService;

  @Autowired
  MicroGridService mService;

  @Autowired
  EnergyDetailService eds;

  @Autowired
  CommonService cService;

  @Autowired
  MicroGridController microGridController;

  @Autowired
  UserService userService;

  @Autowired
  AssignOperatorService assignOperatorService;

  @Autowired
  MicroGridService microGridService;

  Utility uHelper = new Utility();

  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public ModelAndView index() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("home");
    return mv;
  }

  @RequestMapping(value = "/currentstatus/{id}", method = RequestMethod.GET)
  public ModelAndView index2(@PathVariable("id") String id, HttpServletRequest request) {
    String viewName = "home/currentstatus";
    ModelAndView mv = new ModelAndView();
    String token = Utility.getTokenByCookie(request);
    MicroController microController = microGridService.findByMicrogrid_Id(id);
    if (token != null && microController != null) {
      User user = userService.findByToken(token);
      viewName = handlePageByUser(user, microController);
    }
    mv.setViewName(viewName);
    return mv;
  }

  @RequestMapping(value = "/blank", method = RequestMethod.GET)
  public ModelAndView blank() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("blank");
    return mv;
  }

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("login");
    return mv;
  }

  @RequestMapping(value = "/contactus", method = RequestMethod.GET)
  public ModelAndView contactus() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("contactus");
    return mv;
  }

  @RequestMapping(value = "/publicmap", method = RequestMethod.GET)
  public ModelAndView publicMap() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/public/map");
    return mv;
  }

  @RequestMapping(value = "/showdata", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> showData(HttpServletRequest req) {
    Map<String, Object> map = new HashMap<String, Object>();
    String token = Utility.getTokenByCookie(req);
    String microgrid_id = Utility.getMicrogrid_idByCookie(req);
    if (token != null) {
      MicroController micro = mService.findByMicrogrid_Id(microgrid_id);
      map.put("micro", micro);

      BatteryStatus bs = bService.findByMicrogridId(microgrid_id);
      map.put("battery", bs);
    }
    return map;
  }

  @RequestMapping(value = "/showdata/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> showDataForMicroGridId(@PathVariable("id") String id,
      HttpServletRequest req) {
    Map<String, Object> map = new HashMap<String, Object>();
    String token = Utility.getTokenByCookie(req);
    String microgrid_id = id;
    if (token != null) {
      MicroController micro = mService.findByMicrogrid_Id(microgrid_id);
      map.put("micro", micro);

      BatteryStatus bs = bService.findByMicrogridId(microgrid_id);
      map.put("battery", bs);
    }
    return map;
  }

  @RequestMapping(value = "/load_data", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> loadData(HttpServletRequest req) {
    Map<String, Object> map = new HashMap<String, Object>();
    String token = Utility.getTokenByCookie(req);
    String microgrid_id = Utility.getMicrogrid_idByCookie(req);
    if (token != null) {
      List<EnergyDetails> ed = eds
          .findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(microgrid_id, "load", "in");
      map.put("load", ed);
    }
    return map;
  }

  @RequestMapping(value = "/load_data/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> loadDataForMicroGridId(@PathVariable("id") String id,
      HttpServletRequest req) {
    Map<String, Object> map = new HashMap<String, Object>();
    String token = Utility.getTokenByCookie(req);
    String microgrid_id = id;
    if (token != null) {
      List<EnergyDetails> ed = eds
          .findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(microgrid_id, "load", "in");
      map.put("load", ed);
    }
    return map;
  }

  @RequestMapping(value = "/solar_data", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> solarData(HttpServletRequest req) {
    Map<String, Object> map = new HashMap<String, Object>();
    String token = Utility.getTokenByCookie(req);
    String microgrid_id = Utility.getMicrogrid_idByCookie(req);
    if (token != null) {
      List<EnergyDetails> ed = eds
          .findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(microgrid_id, "solar", "in");
      map.put("solar", ed);
    }
    return map;
  }

  @RequestMapping(value = "/getload", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> loadList(HttpServletRequest req) {
    Map<String, Object> map = new HashMap<String, Object>();
    String token = Utility.getTokenByCookie(req);
    String microgrid_id = Utility.getMicrogrid_idByCookie(req);
    List<ColumnGraph> listColumnGraph = new ArrayList<ColumnGraph>();
    if (token != null) {
      List<EnergyDetails> edList = eds.findListByMicrogrid_IdAndPort_cfgForweek(microgrid_id,
          "load", "in");
      if (edList.size() > 0) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        ColumnGraph cg = null;
        for (int i = 0; i < 7; i++) {
          date = cal.getTime();
          cg = new ColumnGraph();
          cg.setDate(sdf.format(date));
          cg.setKwh("0");
          for (EnergyDetails obj : edList) {
            if (obj.getEvent_time().equals(cg.getDate())) {
              cg.setKwh(obj.getKwh());
              break;
            }
          }
          cal.add(Calendar.DAY_OF_MONTH, -1);
          listColumnGraph.add(cg);
        }

      }
      map.put("load", listColumnGraph);
    }

    return map;
  }

  @RequestMapping(value = "/getgraphsolrdata", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getSolarData(HttpServletRequest req) throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = Utility.getMicrogrid_idByCookie(req);
    map.put("solardata", this.getSolarData(microgrid_id, "solar", "in"));
    return map;
  }

  @RequestMapping(value = "/get_battery_status", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getLatestBateryDetail(HttpServletRequest req) throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = Utility.getMicrogrid_idByCookie(req);
    List<EnergyDetails> ed = eds.find_last_microgrid_id_and_port_cfg(microgrid_id, "battery");
    map.put("battery_status", ed);
    return map;
  }

  @RequestMapping(value = "/get_battery_status/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getLatestBateryDetailByMicroGridId(@PathVariable String id,
      HttpServletRequest req) throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = id;
    List<EnergyDetails> ed = eds.find_last_microgrid_id_and_port_cfg(microgrid_id, "battery");
    map.put("battery_status", ed);
    return map;
  }

  /**
   * Seperate version of this method is in use now
   * 
   * @param req
   * @return
   * @throws ParseException
   */
  @Deprecated
  @RequestMapping(value = "/getgraphdata", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getGraphData(HttpServletRequest req) throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = Utility.getMicrogrid_idByCookie(req);

    TimeZone timeZone = Utility.getTimeZoneObject(mService.findZoneById(microgrid_id));
    // get electricity load data (kw)
    map.put("zone", timeZone.getZone());
    map.put("electricitydata", this.getElectricityData(microgrid_id, "load", "in", 0));
    // end electricity data
    // get weekly grid and solar data
    map.put("weeklysolardata", this.getWeeklyLoadData(microgrid_id, "renewable", "out"));
    map.put("weeklygriddata", this.getWeeklyLoadData(microgrid_id, "grid", "out"));
    // end weekly load data
    
    // get meter data
    // map.put("meterdata", this.getMeterData(microgrid_id, "load", "in"));
    // end meter data
    
    // get data for pie chart
    map.put("batterydata", this.getBatteryData(microgrid_id, "battery", null));
    // map.put("battery_discharge_data", this.getBatteryData(microgrid_id,"battery","discharge"));
    map.put("solardata", this.getLastData(microgrid_id, "solar", "out"));
    List<EnergyDetails> ed = eds.find_last_microgrid_id_and_port_cfg(microgrid_id, "battery");
    map.put("battery_status", ed);
    map.put("griddata", this.getLastData(microgrid_id, "grid", "out"));
    // end
    // set grid status data for checking grid is on / off
    map.put("grid_status_Data", this.getLastData(microgrid_id, "grid", "out"));
    // end
    // energy load distribution data
    map.put("energy_distribution_data",
        this.getEnergyDistributionData(microgrid_id, "solar", "out", 0));
    map.put("grid_energy_data", this.getEnergyDistributionData(microgrid_id, "grid", "out", 0));
    map.put("grid_energy_data_in", this.getEnergyDistributionData(microgrid_id, "grid", "in", 0));
    map.put("load_energy_data", this.getEnergyDistributionData(microgrid_id, "load", "in", 0));
    // end
    // get daily solar data (kwh)
    map.put("dailySolarData", this.getDailySolarData(microgrid_id, "solar", "out", 500));
    // end daily solar data
    // get kwh sum for last month (30 days carbon footprint)
    map.put("gridkwhsum", this.getSumOfKwhForCurrentMonth(microgrid_id, "grid", "out"));
    map.put("solarkwhsum", this.getSumOfKwhForCurrentMonth(microgrid_id, "renewable", "out"));
    map.put("currentsolar", this.getCurrentStatus(microgrid_id, "solar", "out"));
    // end
    return map;
  }

  /**
   * The reason I have to make another getGraphData method was that we were getting microgrid id
   * from cookie value. And there is no need for extra coding while we can get it from a client side
   * 
   * @param id
   * @param req
   * @return
   * @throws ParseException
   */
  @RequestMapping(value = "/getgraphdata/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> getGraphDataByMicroGridId(@PathVariable String id,
      HttpServletRequest req) throws ParseException {
    LOG.info("start of getgraphdata");
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = id;
    if (mService.findByMicrogrid_Id(microgrid_id) == null) {
      return map;
    }
    TimeZone timeZone = Utility.getTimeZoneObject(mService.findZoneById(microgrid_id));
    // get electricity load data (kw)
    map.put("zone", timeZone.getZone());
    // map.put("electricitydata", this.getElectricityData(microgrid_id, "load", "in", 0));
    // end electricity data
    // get weekly grid and solar data
    //    map.put("weeklysolardata", this.getWeeklyLoadData(microgrid_id, "renewable", "out"));
    //    map.put("weeklygriddata", this.getWeeklyLoadData(microgrid_id, "grid", "out"));
    // end weekly load data
    // get meter data
    // map.put("meterdata", this.getMeterData(microgrid_id, "load", "in"));
    // end meter data
    // get data for pie chart
    map.put("batterydata", this.getBatteryData(microgrid_id, "battery", null));
    // map.put("battery_discharge_data",
    // this.getBatteryData(microgrid_id,"battery","discharge"));
    map.put("solardata", this.getLastData(microgrid_id, "solar", "out"));
    List<EnergyDetails> ed = eds.find_last_microgrid_id_and_port_cfg(microgrid_id, "battery");
    map.put("battery_status", ed);
    map.put("griddata", this.getLastData(microgrid_id, "grid", "out"));
    // end
    // set grid status data for checking grid is on / off
    map.put("grid_status_Data", this.getLastData(microgrid_id, "grid", "out"));
    // end
    // energy load distribution data
    // map.put("energy_distribution_data", this.getEnergyDistributionData(microgrid_id, "solar",
    // "out", 0));
    // map.put("grid_energy_data", this.getEnergyDistributionData(microgrid_id, "grid", "out", 0));
    // map.put("grid_energy_data_in",this.getEnergyDistributionData(microgrid_id, "grid","in",0));
    // map.put("load_energy_data", this.getEnergyDistributionData(microgrid_id, "load", "in", 0));
    // end
    // get daily solar data (kwh)
    // map.put("dailySolarData", this.getDailySolarData(microgrid_id, "solar", "out", 500));
    // end daily solar data
    // get kwh sum for last month (30 days carbon footprint)
   
    // end
    LOG.info("end of getgraphdata");

    return map;
  }
  @RequestMapping(value = "/footprint/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> footprint(@PathVariable String id, HttpServletRequest req)
      throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = id;
    if (mService.findByMicrogrid_Id(microgrid_id) == null) {
      return map;
    }
    TimeZone timeZone = Utility.getTimeZoneObject(mService.findZoneById(microgrid_id));
    map.put("zone", timeZone.getZone());
    map.put("gridkwhsum", this.getSumOfKwhForCurrentMonth(microgrid_id, "grid", "out"));
    map.put("solarkwhsum", this.getSumOfKwhForCurrentMonth(microgrid_id, "renewable", "out"));    
    // end weekly load data
    return map;
  }
  @RequestMapping(value = "/energy_usage_weekly/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> energyUsageWeekly(@PathVariable String id, HttpServletRequest req)
      throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = id;
    if (mService.findByMicrogrid_Id(microgrid_id) == null) {
      return map;
    }
    TimeZone timeZone = Utility.getTimeZoneObject(mService.findZoneById(microgrid_id));
    // get weekly grid and solar data
    map.put("zone", timeZone.getZone());
    map.put("weeklysolardata", this.getWeeklyLoadData(microgrid_id, "renewable", "out"));
    map.put("weeklygriddata", this.getWeeklyLoadData(microgrid_id, "grid", "out"));
    // end weekly load data
    return map;
  }
  @RequestMapping(value = "/energy_usage/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> energyUsage(@PathVariable String id, HttpServletRequest req)
      throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = id;
    if (mService.findByMicrogrid_Id(microgrid_id) == null) {
      return map;
    }
    TimeZone timeZone = Utility.getTimeZoneObject(mService.findZoneById(microgrid_id));
    map.put("zone", timeZone.getZone());
    map.put("electricitydata", this.getElectricityData(microgrid_id, "load", "in", 0));
    // end electricity data
    return map;
  }

  @RequestMapping(value = "/daily_solar/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> dailySolar(@PathVariable String id, HttpServletRequest req)
      throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = id;
    if (mService.findByMicrogrid_Id(microgrid_id) == null) {
      return map;
    }
    TimeZone timeZone = Utility.getTimeZoneObject(mService.findZoneById(microgrid_id));
    map.put("zone", timeZone.getZone());
    map.put("currentsolar", this.getCurrentStatus(microgrid_id, "solar", "out"));
    map.put("dailySolarData", this.getDailySolarData(microgrid_id, "solar", "out", 500));
    return map;
  }

  @RequestMapping(value = "/load_distribution/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Map<String, Object> loadDistribution(@PathVariable String id, HttpServletRequest req)
      throws ParseException {
    Map<String, Object> map = new HashMap<String, Object>();
    String microgrid_id = id;
    if (mService.findByMicrogrid_Id(microgrid_id) == null) {
      return map;
    }
    TimeZone timeZone = Utility.getTimeZoneObject(mService.findZoneById(microgrid_id));
    // get electricity load data (kw)
    map.put("zone", timeZone.getZone());
    // energy load distribution data
    map.put("energy_distribution_data",
        this.getEnergyDistributionData(microgrid_id, "solar", "out", 0));
    map.put("grid_energy_data", this.getEnergyDistributionData(microgrid_id, "grid", "out", 0));
    map.put("grid_energy_data_in", this.getEnergyDistributionData(microgrid_id, "grid", "in", 0));
    map.put("load_energy_data", this.getEnergyDistributionData(microgrid_id, "load", "in", 0));
    // end
    return map;
  }

  private List<EnergyDetails> getCurrentStatus(String microgrid_id, String port_cfg, String state) {
    return eds.getCurrentStatus(microgrid_id, port_cfg, state);
  }

  private List<EnergyDetails> getSumOfKwhForCurrentMonth(String microgrid_id, String port_cfg,
      String state) {
    // get the sum of kwh for current month
    // note : each date of highest value for kwh field is selected.
    List<EnergyDetails> edsList = eds.getSumOfKwhForCurrentMonth(microgrid_id, port_cfg, state);
    return edsList;
  }

  private List<EnergyDetails> getEnergyDistributionData(String microgrid_id, String port_cfg,
      String state, int limit) {
    List<EnergyDetails> edsList = eds.findEnergyDistributionData(microgrid_id, port_cfg, state,
        limit);
    return edsList;
  }

  private List<EnergyDetails> getDailySolarData(String microgrid_id, String port_cfg, String state,
      int limit) {
    List<EnergyDetails> edsList = eds.findDailySolarData(microgrid_id, port_cfg, state, limit);
    return edsList;
  }/* getEnergyDistributionData */

  public List<EnergyDetails> getLastData(String microgrid_id, String port_cfg, String state) {
    List<EnergyDetails> ed = null;
    if (microgrid_id != null) {
      ed = eds.findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(microgrid_id, port_cfg,
          state);
    }
    return ed;
  }

  private List<EnergyDetails> getBatteryData(String microgrid_id, String port_cfg, String state) {
    List<EnergyDetails> list = eds
        .findBatteryListByMicrogrid_IdAndPort_cfgForCurrentDate(microgrid_id, port_cfg, state);
    return list;
  }

  public List<EnergyDetails> getSolarData(String microgrid_id, String port_cfg, String state)
      throws ParseException {
    List<EnergyDetails> edList = null;
    if (microgrid_id != null) {
      edList = eds.findListByMicrogrid_IdAndPort_cfgWithGroupByDate(microgrid_id, port_cfg, state);
    }
    return edList;
  }

  public List<EnergyDetails> getMeterData(String microgrid_id, String port_cfg, String state) {
    List<EnergyDetails> ed = null;
    if (microgrid_id != null) {
      ed = eds.findByMicrogrid_IdAndPort_cfgForCurrentDateWithLastRecord(microgrid_id, port_cfg,
          state);
    }
    return ed;
  }

  public List<EnergyDetails> getMonthlyData(String microgrid_id, String port_cfg, String state)
      throws ParseException {
    List<EnergyDetails> edList = null;
    if (microgrid_id != null) {
      edList = eds.findListByMicrogrid_IdAndPort_cfgForMonth(microgrid_id, port_cfg, state);
    }
    return edList;
  }

  public List<EnergyDetails> getElectricityData(String microgrid_id, String port_cfg, String state,
      int limit) throws ParseException {
    List<EnergyDetails> list = eds.findListByMicrogrid_IdAndPort_cfgForCurrentDate(microgrid_id,
        port_cfg, state, limit);
    return list;
  }

  public List<EnergyDetails> getWeeklyLoadData(String microgrid_id, String port_cfg, String state) {
    List<EnergyDetails> edList = null;
    if (microgrid_id != null) {
      edList = eds.findListByMicrogrid_IdAndPort_cfgForweek(microgrid_id, port_cfg, state);
    }
    return edList;
  }

  public List<EnergyDetails> getMonthlyLoadData(String microgrid_id, String port_cfg, String state)
      throws ParseException {
    List<EnergyDetails> edList = null;
    if (microgrid_id != null) {
      edList = eds.findListByMicrogrid_IdAndPort_cfgForMonth(microgrid_id, port_cfg, state);
    }
    return edList;
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView getHomePage() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("micro/list");
    return mv;
  }

  public String handlePageByUser(User user, MicroController microController) {
    String pageMapping = "home/currentstatus";
    switch (user.getUserRole().getRole()) {
    case "customer-admin":
      List<Object> list = microGridController
          .findMicroControllerAssociationWithUser(microController.getMicrogrid_id(), user.getId());
      if (!(list.size() > 0))
        pageMapping = "micro/list";
      break;
    case "operator":
      String assignMicroControllers = assignOperatorService.findListByOperatorId(user.getId())
          .get(0).getAssignMicrogrid();
      if (assignMicroControllers != null && assignMicroControllers != "") {
        String arr[] = assignMicroControllers.split(",");
        if (java.util.Arrays.binarySearch(arr, String.valueOf(microController.getId())) == -1)
          pageMapping = "micro/list";
      } else {
        pageMapping = "micro/list";
      }
      break;
    }
    return pageMapping;
  }
}
