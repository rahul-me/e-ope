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

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gridscape.API_Interface.MicroGridSessionManage;
import com.gridscape.helpers.FileGenerator;
import com.gridscape.helpers.MicroGridProfileHelper;
import com.gridscape.helpers.Uploader;
import com.gridscape.helpers.Utility;
import com.gridscape.jsoninput.GenerateProfile;
import com.gridscape.jsoninput.JsonMicrGridProfile;
import com.gridscape.jsoninput.MapDataList;
import com.gridscape.manager.CustomSecurityManager;
import com.gridscape.model.AssignOperator;
import com.gridscape.model.CommandHistory;
import com.gridscape.model.EnergyDetails;
import com.gridscape.model.ErrorDetails;
import com.gridscape.model.MicroController;
import com.gridscape.model.MicroControllerStatus;
import com.gridscape.model.MicroGridDefaultProfile;
import com.gridscape.model.MicroGridProfile;
import com.gridscape.model.SolarGenerationCharge;
import com.gridscape.model.User;
import com.gridscape.property.ConfigProperties;
import com.gridscape.service.AssignOperatorService;
import com.gridscape.service.CommandHistoryService;
import com.gridscape.service.EnergyDetailService;
import com.gridscape.service.ErrorDetailService;
import com.gridscape.service.MicroControllerStatusServices;
import com.gridscape.service.MicroGridProfileService;
import com.gridscape.service.MicroGridService;
import com.gridscape.service.SolarGenerationChargeService;
import com.gridscape.service.UserService;
import com.gridscape.service.UtilityService;

@Controller
@RequestMapping("/micro")
public class MicroGridController {
	@Autowired
	MicroGridService microGridService;

	@Autowired
	MicroGridSessionManage micro_grid_mg;

	@Autowired
	UserService uService;

	@Autowired
	UtilityService utilityService;

	@Autowired
	AssignOperatorService aoService;

	@Autowired
	ServletContext context;

	@Autowired
	MicroGridProfileService mgps;

	@Autowired
	CustomSecurityManager security_manager;

	@Autowired
	MicroGridSessionManage microGridSessionManage;

	@Autowired
	CommandHistoryService commandHistoryService;

	@Autowired
	ErrorDetailService errorDetailService;

	@Autowired
	AssignOperatorService assignOperatorService;

	@Autowired
	private EnergyDetailService energyDetailService;

	@Autowired
	private MicroControllerStatusServices microControllerStatusServices;

	@Autowired
	private ConfigProperties configProperties;

	@Autowired
	private SolarGenerationChargeService solarGenerationChargeService;

	@Autowired
	private FileGenerator fileGenerator;

	@RequestMapping(value = "/locationMap", method = RequestMethod.GET)
	public ModelAndView microGridMap() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("micro/map");
		return mv;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView microGridList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("micro/list");
		return mv;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView getHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("micro/list");
		return mv;
	}

	@RequestMapping(value = "/plot", method = RequestMethod.GET)
	public ModelAndView getPlot() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("micro/plot");
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(HttpServletRequest request, MicroController obj,
			@CookieValue("token") String token) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multiRequest.getFileMap();
			User user = uService.findByToken(token);
			if (user.getUserRole().getRole().equals("customer-admin")) {
				obj.setUser_id(user.getId().toString());
			}

			MicroController temp = null;
			if (obj.getId() != null) {
				temp = microGridService.findById(obj.getId());				
				if (temp != null) {
					temp.setMicrogrid_name(obj.getMicrogrid_name());
					temp.setAddress_line_1(obj.getAddress_line_1());
					temp.setAddress_line_2(obj.getAddress_line_2());
					temp.setCity(obj.getCity());
					temp.setZip_code(obj.getZip_code());
					temp.setCountry(obj.getCountry());
					temp.setState(obj.getState());
					temp.setAbout(obj.getAbout());
					temp.setUtilityId(obj.getUtilityId());
					temp.setUtility_name(obj.getUtility_name());
					temp.setLongitude(obj.getLongitude());
					temp.setLatitude(obj.getLatitude());
					temp.setOwner_manager_name(obj.getOwner_manager_name());
					temp.setOwner_manager_contact(obj.getOwner_manager_contact());
					temp.setMaintenance_manager_name(obj.getMaintenance_manager_name());
					temp.setMaintenance_manager_contact(obj.getMaintenance_manager_contact());
					temp.setActive(obj.isActive());
					temp.setTime_zone(obj.getTime_zone());
					if (obj.getMax_meter_value() != null) {
						temp.setMax_meter_value(obj.getMax_meter_value());
					} else {
						temp.setMax_meter_value(temp.getMax_meter_value());
					}
					temp.setMax_meter_value(obj.getMax_meter_value());
					microGridService.save(temp);
					temp = this.uploadPic(files, temp);
					// GoogleDriveUploader.createSubFolder("0B2BMyI4gzow-QVhkTlhiNlp0c2s",temp.getMicrogrid_id());
					String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
							+ "/" + request.getContextPath();
					path += "/" + temp.getPic_url();
					// GoogleDriveUploader.listFile();
					map.put("data", temp);
				}
			} else if (user.getUserRole().getRole().equals("customer-admin")) {
				String microgrid_id = null;
				while (true) {
					microgrid_id = Utility.getRandomMicroGridId();
					MicroController mgc = microGridService.findByMicrogrid_Id(microgrid_id);
					if (mgc == null) {
						break;
					}
				}
				obj.setActive(true);
				obj.setMicrogrid_id(microgrid_id);
				temp = microGridService.save(obj);
				map.put("data", this.uploadPic(files, temp));
			} else if (user.getUserRole().getRole().equals("operator")) {
				map.put("data", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	public MicroController uploadPic(Map<String, MultipartFile> files, MicroController temp) {
		try {
			String pic_url = null;
			String profile_img = null;
			for (Map.Entry<String, MultipartFile> entry : files.entrySet()) {
				String key = entry.getKey().toString();
				MultipartFile file = entry.getValue();
				String contentType = file.getContentType();				
				if (key.equals("file1")) {
					// String path = context.getRealPath("/")+
					// "/public/images/micro_controller/"+temp.getId()+"/"+file.getOriginalFilename();
					// pic_url =
					// "/public/images/micro_controller/"+temp.getId()+"/"+file.getOriginalFilename();
					Map<String, Object> map = Uploader.uploadFileToGoogleDrive(temp.getMicrogrid_id(), file,
							"microgrid", contentType);
					// String thum_link = map.get("thum_link").toString();
					String fileId = map.get("fileId").toString();
					pic_url = fileId;
				} else if (key.equals("file2")) {
					// String path = context.getRealPath("/")+
					// "/public/images/micro_controller/"+temp.getId()+"/profile/"+file.getOriginalFilename();
					Map<String, Object> map = Uploader.uploadFileToGoogleDrive(temp.getMicrogrid_id(), file, "profile",
							contentType);
					// String thum_link = map.get("thum_link").toString();
					String fileId = map.get("fileId").toString();
					profile_img = fileId;
				}
			}
			if (pic_url != null) {
				temp.setPic_url(pic_url);
			}
			if (profile_img != null) {
				temp.setProfile_img(profile_img);
			}
			if (pic_url != null || profile_img != null) {
				microGridService.save(temp);
			}
		} catch (Exception e) {

		}

		return temp;
	}

	@RequestMapping(value = "/getlist", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getlist(HttpServletRequest req) {
		
		String userId = req.getParameter("userId");
		String microId = req.getParameter("microId");
		String cityName = req.getParameter("cityName");
		Map<String, Object> map = new HashMap<String, Object>();
		String token = Utility.getTokenByCookie(req);
		User user = uService.findByToken(token);
		if (token != null) {
			if (user != null) {
				if (user.getUserRole().getRole().equalsIgnoreCase("super-admin")) {
					HashMap<String, String> queryMap = new HashMap<String, String>();
					if (userId != null && !userId.equalsIgnoreCase("0")) { // value
																			// that
																			// is
																			// embedded
																			// in
																			// user
																			// drop
																			// down
																			// list
																			// to
																			// again
																			// select
																			// all
																			// users
																			// if
																			// it
																			// has
																			// been
																			// chosen
																			// for
																			// specific
																			// user
						queryMap.put("user_id", userId);
					}
					if (microId != null && !microId.equalsIgnoreCase("")) {
						queryMap.put("microgrid_name", microId);
					}
					if (cityName != null && !cityName.equalsIgnoreCase("0")) { // value
																				// that
																				// is
																				// embedded
																				// in
																				// user
																				// drop
																				// down
																				// list
																				// to
																				// again
																				// select
																				// all
																				// users
																				// if
																				// it
																				// has
																				// been
																				// chosen
																				// for
																				// specific
																				// user
						queryMap.put("mc.city", cityName);
					}
					List<MicroController> microList = null;
					List<User> userList = null;
					List<User> userAssociatedWithMGC = microGridService.findAllMicrogridControllerWithUserDetails(true);
					List<MicroController> citiesAssociatedWithMicroController = microGridService
							.findUniqueCitiesAssociateWithMicroController();
					for (MicroController micro : citiesAssociatedWithMicroController) {
						System.out.println(micro.getCity());
					}
					System.out.println("Size of Map" + queryMap.size());
					if (queryMap.size() > 0) {
						List<Object[]> lists = microGridService.findMicroControllerByFilter(queryMap);
						microList = new ArrayList<MicroController>();
						userList = new ArrayList<User>();
						for (Object[] list : lists) {
							MicroController micro = (MicroController) list[0];
							User userf = (User) list[1];
							microList.add(micro);
							userList.add(userf);
						}
					} else {
						microList = microGridService.GetList();
						userList = microGridService.findAllMicrogridControllerWithUserDetails(false);
					}
					map.put("data", microList);
					map.put("users", userList);
					map.put("uniqueUsers", userAssociatedWithMGC);
					map.put("cities", citiesAssociatedWithMicroController);
					map.put("role", "super-admin");
				} else if (user.getUserRole().getRole().equalsIgnoreCase("customer-admin")) {
					List<MicroController> microList = microGridService.listMicroByUserId(user.getId());
					map.put("data", microList);
					map.put("users", new ArrayList<>());
					map.put("role", "customer-admin");
				} else if (user.getUserRole().getRole().equalsIgnoreCase("operator")) {
					List<AssignOperator> list = aoService.findListByOperatorId(user.getId());
					if (list.size() > 0) {
						List<Long> ids = new ArrayList<Long>();
						for (AssignOperator assignOperator : list) {
							String microIds = assignOperator.getAssignMicrogrid();
							if (microIds != null && !microIds.equals("")) {
								StringTokenizer st = new StringTokenizer(microIds, ",");
								while (st.hasMoreTokens()) {
									ids.add(Long.parseLong(st.nextToken()));
								}
							}
						}
						if (ids.size() > 0) {
							List<MicroController> microList = getMicroControllerByIdArr(ids);
							map.put("data", microList);
							map.put("role", "operator");
							map.put("users", new ArrayList<>());
						} else {
							map.put("role", "operator");
						}

						/*
						 * String obj[] = new String[list.size()]; int index =
						 * 0; for(AssignOperator ao:list){ obj[index] =
						 * ao.getParentId().toString();
						 * System.out.println("obj = "+obj[index]); index++; }
						 * List<MicroController> microList =
						 * microGridService.findListByUserIdArr(obj);
						 * map.put("data", microList); map.put("users", new
						 * ArrayList<>());
						 */
					} else {
						
						List<MicroController> micro = microGridService.GetList();
						List<User> userList = microGridService.findAllMicrogridControllerWithUserDetails(false);
						map.put("data", micro);
						map.put("users", userList);
						map.put("role", "operator");
					}
				}
			} else {
				map.put("data", null);
			}
		} else {
			List<MicroController> micro = microGridService.GetList();
			List<User> userList = microGridService.findAllMicrogridControllerWithUserDetails(false);
			map.put("data", micro);
			map.put("users", userList);
		}
		return map;
	}

	private List<MicroController> getMicroControllerByIdArr(List<Long> ids) {
		List<MicroController> list = new ArrayList<MicroController>();
		for (long id : ids) {
			list.add(microGridService.findById(id));
		}
		return list;
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> find(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		MicroController micro = microGridService.findById(new Long(id));
		map.put("data", micro);
		return map;
	}

	@RequestMapping(value = "/find/operator/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findByOperatorId(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		AssignOperator assignOperator = aoService.findById(Long.parseLong(id));
		long parentId = assignOperator.getParentId();
		List<MicroController> list = microGridService.findListByUserId(parentId);
		String assignedMicrogrid = assignOperator.getAssignMicrogrid();
		List<Long> microgridControllerId = new ArrayList<Long>();
		if (assignedMicrogrid != null) {
			StringTokenizer st = new StringTokenizer(assignedMicrogrid, ",");
			while (st.hasMoreTokens()) {
				long microgridId = Long.parseLong(st.nextToken());
				microgridControllerId.add(microgridId);
			}
		}
		map.put("data", list);
		map.put("assigned", microgridControllerId);
		return map;
	}

	/*
	 * @RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	 * 
	 * @ResponseBody public Map<String,Object> delete(@PathVariable ("id")
	 * String id){ Map<String, Object> map = new HashMap<String, Object>();
	 * MicroController micro = microGridService.findById( new Long(id));
	 * micro.setActive(false); microGridService.save(micro); map.put("status",
	 * true); return map; }
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> delete(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		MicroController micro = microGridService.findById(new Long(id));
		micro.setDeleted(true);
		microGridService.save(micro);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/revertDeletion/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> revertDeletion(@PathVariable("id") String id) {
		boolean status = false;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MicroController micro = microGridService.findById(new Long(id));
			if (micro.isDeleted()) {
				micro.setDeleted(false);
				microGridService.save(micro);
				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		map.put("status", status);
		return map;
	}

	@RequestMapping(value = "/removepic/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> removePic(@PathVariable("id") String id, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		String key = req.getParameter("key");
		MicroController micro = microGridService.findById(new Long(id));
		String path = context.getRealPath("/") + micro.getPic_url();
		if (key.equals("profile")) {
			path = context.getRealPath("/") + micro.getProfile_img();
			micro.setProfile_img(null);
			Uploader.removeGoogleDriveFile(id, "microgrid");
		} else if (key.equals("microgrid")) {
			path = context.getRealPath("/") + micro.getPic_url();
			micro.setPic_url(null);
		}
		microGridService.save(micro);
		File file = new File(path);
		file.deleteOnExit();
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") String id) {
		return "/micro/show";
	}

	@RequestMapping(value = "/findbymicrogridid/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findMicrogridByMicrogrid_id(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MicroController micro = microGridService.findByMicrogrid_Id(id);
			map.put("data", micro);
			Session session = micro_grid_mg.getCurentSession(id);
			if (session != null) {
				if (session.isOpen()) {
					map.put("status", true);
				} else {
					map.put("status", false);
				}
			} else {
				map.put("status", false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/command/{id}", method = RequestMethod.GET)
	public String actionCommand(@PathVariable("id") String id) {
		return "/micro/command";
	}

	@RequestMapping(value = "/isopen/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> sessionopen(@PathVariable("id") String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Session session = micro_grid_mg.getCurentSession(id);
		if (session != null) {
			if (session.isOpen()) {
				map.put("status", true);
			} else {
				map.put("status", false);
			}
		} else {
			map.put("status", false);
		}
		return map;
	}

	private Boolean isGridConnected(String microgrid_id) {
		Session session = micro_grid_mg.getCurentSession(microgrid_id);
		if (session != null) {
			if (session.isOpen()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@RequestMapping(value = "/testconnection", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> testConnection(@RequestBody Map<String, String> input) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		String id = input.get("id");
		String message = input.get("message");
		Session session = micro_grid_mg.getCurentSession(id);
		if (session != null) {
			if (session.isOpen()) {
				session.getBasicRemote().sendText(message);
				map.put("status", true);
			} else {
				map.put("status", false);
			}
		} else {
			map.put("status", false);
		}
		return map;
	}

	@RequestMapping(value = "/mapdata", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMapData(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MapDataList> mapList = null;
		String token = Utility.getTokenByCookie(req);
		if (token != null) {
			User user = uService.findByToken(token);
			if (user != null) {
				if (user.getUserRole().getRole().equalsIgnoreCase("super-admin")) {
					List<MicroController> micro = microGridService.GetList();
					mapList = this.getMapDataList(micro);
					map.put("data", mapList);
				} else if (user.getUserRole().getRole().equalsIgnoreCase("customer-admin")) {
					List<MicroController> microList = microGridService.listMicroByUserId(user.getId());
					mapList = this.getMapDataList(microList);
					map.put("data", mapList);
				} else if (user.getUserRole().getRole().equalsIgnoreCase("operator")) {
					List<AssignOperator> list = aoService.findListByOperatorId(user.getId());
					if (list.size() > 0) {
						List<Long> ids = new ArrayList<Long>();
						for (AssignOperator assignOperator : list) {
							String microIds = assignOperator.getAssignMicrogrid();
							if (microIds != null && !microIds.equals("")) {
								StringTokenizer st = new StringTokenizer(microIds, ",");
								while (st.hasMoreTokens()) {
									ids.add(Long.parseLong(st.nextToken()));
								}

							}
						}
						if (ids.size() > 0) {
							List<MicroController> microList = getMicroControllerByIdArr(ids);
							mapList = this.getMapDataList(microList);
							map.put("data", mapList);
						}

						/*
						 * String objs[] = new String[list.size()]; int index =
						 * 0; for(AssignOperator ao:list){ objs[index] =
						 * ao.getParentId().toString(); index++; }
						 */
						// List<MicroController> microList =
						// microGridService.findListByUserIdArr(objs);

					} else {
						System.out.println("user");
						List<MicroController> micro = microGridService.GetList();
						mapList = this.getMapDataList(micro);
						map.put("data", mapList);
					}
				}
			} else {
				map.put("data", null);
			}
		} else {
			List<MicroController> micro = microGridService.GetList();
			mapList = this.getMapDataList(micro);
			System.out.println("size = " + mapList);
			map.put("data", mapList);
		}
		return map;
	}

	@RequestMapping(value = "/mapdatabyfilter/{by}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getMapDataByFilter(@PathVariable("by") String[] by, HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MapDataList> mapList = null;
		String token = Utility.getTokenByCookie(req);
		if (token != null) {
			User user = uService.findByToken(token);
			if (user != null) {
				if (user.getUserRole().getRole().equalsIgnoreCase("super-admin")) {
					List<MicroController> micro = microGridService.GetList();
					mapList = this.getMapDataListByStatus(micro, by);
					map.put("data", mapList);
				} else if (user.getUserRole().getRole().equalsIgnoreCase("customer-admin")) {
					List<MicroController> microList = microGridService.listMicroByUserId(user.getId());
					mapList = this.getMapDataListByStatus(microList, by);
					map.put("data", mapList);
				} else if (user.getUserRole().getRole().equalsIgnoreCase("operator")) {
					List<AssignOperator> list = aoService.findListByOperatorId(user.getId());
					if (list.size() > 0) {
						List<Long> ids = new ArrayList<Long>();
						for (AssignOperator assignOperator : list) {
							String microIds = assignOperator.getAssignMicrogrid();
							if (microIds != null && !microIds.equals("")) {
								StringTokenizer st = new StringTokenizer(microIds, ",");
								while (st.hasMoreTokens()) {
									ids.add(Long.parseLong(st.nextToken()));
								}

							}
						}
						if (ids.size() > 0) {
							List<MicroController> microList = getMicroControllerByIdArr(ids);
							mapList = this.getMapDataListByStatus(microList, by);
							map.put("data", mapList);
						}

						String objs[] = new String[list.size()];
						int index = 0;
						for (AssignOperator ao : list) {
							objs[index] = ao.getParentId().toString();
							index++;
						}
						// List<MicroController> microList =
						// microGridService.findListByUserIdArr(objs);

					} else {
						System.out.println("user");
						List<MicroController> micro = microGridService.GetList();
						mapList = this.getMapDataListByStatus(micro, by);
						map.put("data", mapList);
					}
				}
			} else {
				map.put("data", null);
			}
		} else {
			List<MicroController> micro = microGridService.GetList();
			mapList = this.getMapDataListByStatus(micro, by);
			map.put("data", mapList);
		}
		return map;
	}

	private List<MapDataList> getMapDataList(List<MicroController> micro) {
		List<MapDataList> mapList = new ArrayList<MapDataList>();
		MapDataList mapDataobj = null;
		for (MicroController obj : micro) {
			mapDataobj = new MapDataList();
			mapDataobj.setId(obj.getId());
			mapDataobj.setMicrogrid_id(obj.getMicrogrid_id());
			mapDataobj.setMicrogrid_name(obj.getMicrogrid_name());
			mapDataobj.setPic_url(obj.getPic_url());
			mapDataobj.setLatitude(obj.getLatitude());
			mapDataobj.setLongitude(obj.getLongitude());
			mapDataobj.setCountry(obj.getCountry());
			mapDataobj.setState(obj.getState());
			mapDataobj.setCity(obj.getCity());
			mapDataobj.setStatus(obj.isActive());
			Boolean gridStatus = isGridConnected(obj.getMicrogrid_id());
			mapDataobj.setGridStatus(gridStatus);
			System.out.println(obj.getMicrogrid_id() + " =gridstatus= " + gridStatus + "=status =" + obj.isActive());
			if (gridStatus == true && obj.isActive() == true) {
				// color green
				mapDataobj.setColor("green");
			} else if (gridStatus == true && obj.isActive() == false) {
				// color orange
				mapDataobj.setColor("orange");
			} else if (gridStatus == false && obj.isActive() == true) {
				// color red
				mapDataobj.setColor("red");
			} else if (gridStatus == false && obj.isActive() == false) {
				// color orange
				mapDataobj.setColor("orange");
			}
			mapList.add(mapDataobj);
		}
		return mapList;
	}

	private List<MapDataList> getMapDataListByStatus(List<MicroController> micro, String[] status) {
		List<MapDataList> mapList = new ArrayList<MapDataList>();
		MapDataList mapDataobj = null;
		for (MicroController obj : micro) {
			mapDataobj = new MapDataList();
			mapDataobj.setId(obj.getId());
			mapDataobj.setMicrogrid_id(obj.getMicrogrid_id());
			mapDataobj.setMicrogrid_name(obj.getMicrogrid_name());
			mapDataobj.setPic_url(obj.getPic_url());
			mapDataobj.setLatitude(obj.getLatitude());
			mapDataobj.setLongitude(obj.getLongitude());
			mapDataobj.setCountry(obj.getCountry());
			mapDataobj.setState(obj.getState());
			mapDataobj.setCity(obj.getCity());
			mapDataobj.setStatus(obj.isActive());
			Boolean gridStatus = isGridConnected(obj.getMicrogrid_id());
			mapDataobj.setGridStatus(gridStatus);
			System.out.println(obj.getMicrogrid_id() + " =gridstatus= " + gridStatus + "=status =" + obj.isActive());
			if (gridStatus == true && obj.isActive() == true) {
				// color green
				mapDataobj.setColor("green");
			} else if (gridStatus == true && obj.isActive() == false) {
				// color orange
				mapDataobj.setColor("orange");
			} else if (gridStatus == false && obj.isActive() == true) {
				// color red
				mapDataobj.setColor("red");
			} else if (gridStatus == false && obj.isActive() == false) {
				// color orange
				mapDataobj.setColor("orange");
			}

			for (String state : status) {
				switch (state) {
				case "operational":
					if (mapDataobj.getColor() == "green") {
						mapList.add(mapDataobj);
					}
					break;
				case "nonoperational":
					if (mapDataobj.getColor() == "red") {
						mapList.add(mapDataobj);
					}
					break;
				case "notconfigured":
					if (mapDataobj.getColor() == "orange") {
						mapList.add(mapDataobj);
					}
					break;
				}
			}

		}
		return mapList;
	}

	@RequestMapping(value = "/profile_management/{id}", method = RequestMethod.GET)
	public String profileManagement(@PathVariable("id") String microgrid_id) {
		System.out.println(microgrid_id);
		return "micro/profile_management";
	}

	@RequestMapping(value = "/save_profile_management", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveProfileManagement(@RequestBody MicroGridProfile obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			System.out.println(obj.getId());
			if (obj.getId() != null) {
				MicroGridProfile mgp = mgps.findById(obj.getId());
				if (mgp != null) {
					mgp.setBattery_low_threshold(obj.getBattery_low_threshold());
					mgp.setBattery_charge_source(obj.getBattery_charge_source());
					mgp.setStandard_situation(obj.getStandard_situation());
					mgp.setCritical_situation(obj.getCritical_situation());
					mgp.setBattery_low(obj.getBattery_low());
					mgp.setSolar_low(obj.getSolar_low());
					mgp.setSolar_present(obj.getSolar_present());
					mgp.setSolar_gr_load(obj.getSolar_gr_load());
					mgp.setBattery_soc(obj.getBattery_soc());
					System.out.println(mgp);
					mgps.save(mgp);
					map.put("status", true);
				} else {
					map.put("status", false);
				}

			} else {

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/generate_profilet", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> generateProfile(@RequestBody GenerateProfile obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		String microgrid_id = obj.getMicrogrid_id();
		String time_slot = obj.getTime_slot();
		System.out.println(microgrid_id + "==" + time_slot);
		mgps.generate_profile(microgrid_id, time_slot);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/edit_profile/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> editProfile(@PathVariable("id") Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		JsonMicrGridProfile mgp = mgps.findByIdWithJson(id);
		map.put("data", mgp);
		return map;
	}

	@RequestMapping(value = "/delete_profile/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> deleteProfile(@PathVariable("id") Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		mgps.delete_profile(id);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/list_profile_management", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listProfileManagement(@CookieValue("token") String token) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		if (user != null) {
			if (user.getUserRole().getRole().equals("customer-admin")) {
				List<MicroController> mList = microGridService.findListByUserId(user.getId());
				Object mIds[] = new Object[mList.size()];
				int index = 0;
				for (MicroController mobj : mList) {
					mIds[index] = mobj.getMicrogrid_id();
					index++;
				}
				List<MicroGridProfile> profileList = mgps.findByMicrogrid__id_arr(mIds);
				map.put("data", profileList);
				map.put("recordsTotal", profileList.size());
				map.put("recordsFiltered", profileList.size());
			} else if (user.getUserRole().getRole().equals("super-admin")) {
				List<MicroGridProfile> profileList = mgps.list();
				map.put("data", profileList);
				map.put("recordsTotal", profileList.size());
				map.put("recordsFiltered", profileList.size());
			}
		}
		return map;
	}

	@RequestMapping(value = "/find_profile_list_by_microgrid_id/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> findProfileListByMicrogrid(@PathVariable("id") String microgrid_id,
			@CookieValue("token") String token) {
		Map<String, Object> map = new HashMap<String, Object>();
		User user = uService.findByToken(token);
		if (user != null) {
			if (user.getUserRole().getRole().equals("customer-admin")) {
				List<MicroController> mList = microGridService.findListByUserId(user.getId());
				Object mIds[] = new Object[mList.size()];
				int index = 0;
				for (MicroController mobj : mList) {
					mIds[index] = mobj.getMicrogrid_id();
					index++;
				}
				List<MicroGridProfile> profileList = mgps.find_list_by_microgrid_id(microgrid_id);
				map.put("data", profileList);
				map.put("recordsTotal", profileList.size());
				map.put("recordsFiltered", profileList.size());
			} else if (user.getUserRole().getRole().equals("super-admin")) {
				List<MicroGridProfile> profileList = mgps.find_list_by_microgrid_id(microgrid_id);
				map.put("data", profileList);
				map.put("recordsTotal", profileList.size());
				map.put("recordsFiltered", profileList.size());
			}
		}
		return map;
	}

	@RequestMapping(value = "/default_profile", method = RequestMethod.GET)
	public String defaultProfile() {
		return "micro/default_profile";
	}

	@RequestMapping(value = "/generate_default_profile", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> generateDefaultProfile(@RequestBody GenerateProfile obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		String time_slot = obj.getTime_slot();
		mgps.generate_default_profile(time_slot);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/list_default_profile", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> listDefaultProfile() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MicroGridDefaultProfile> profileList = mgps.listMicrogridDefaultProfile();
		map.put("data", profileList);
		map.put("recordsTotal", profileList.size());
		map.put("recordsFiltered", profileList.size());
		return map;
	}

	@RequestMapping(value = "/edit_default_profile/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> editDefaultProfile(@PathVariable("id") Long id) {
		Map<String, Object> map = new HashMap<String, Object>();
		JsonMicrGridProfile mgp = mgps.findDefaultProfileByIdWithJson(id);
		map.put("data", mgp);
		return map;
	}

	@RequestMapping(value = "/save_default_profile", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveDefaultProfile(@RequestBody MicroGridDefaultProfile obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			map = mgps.saveMicrogridDefaultProfile(obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/set_standar_profile/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> setStandarProfile(@PathVariable("id") String microgrid_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<MicroGridProfile> mgpList = mgps.find_list_by_microgrid_id(microgrid_id);
		for (MicroGridProfile mgp : mgpList) {
			MicroGridDefaultProfile mgdp = mgps.findStandardProfile(mgp.getStart_time(), mgp.getEnd_time());
			if (mgdp != null) {
				mgp.setBattery_charge_source(mgdp.getBattery_charge_source());
				mgp.setBattery_low(mgdp.getBattery_low());
				mgp.setBattery_low_threshold(mgdp.getBattery_low_threshold());
				mgp.setCritical_situation(mgdp.getCritical_situation());
				mgp.setSolar_low(mgdp.getSolar_low());
				mgp.setStandard_situation(mgdp.getStandard_situation());
				mgp.setSolar_gr_load(mgdp.getSolar_gr_load());
				mgp.setSolar_present(mgdp.getSolar_present());
				mgp.setBattery_soc(mgdp.getBattery_soc());				
				mgps.save(mgp);
				map.put("message", "Default profile applied.!");
			} else {
				map.put("message", "Default profile not found.!");
			}
			map.put("data", mgp);
		}
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/send_profile_to_microgrid_client/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> sendProfileToMicroGrid(@PathVariable("id") String microgrid_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MM-dd'T'H:m:s'Z'");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

		CommandHistory ch = new CommandHistory();
		ch.setMicro_grid_id(microgrid_id);
		ch.setCommand_name("set profile");
		ch.setRequest_time(dateFormatGmt.format(new Date()));
		ch.setMethod_number("500");
		String request_id = security_manager.getReferenceCode();
		ch.setRequest_id(request_id);
		try {
			JSONObject obj = new JSONObject();
			MicroController mc = microGridService.findByMicrogrid_Id(microgrid_id);
			List<MicroGridProfile> mgpList = mgps.find_list_by_microgrid_id(microgrid_id);
			MicroGridProfileHelper microgridProfileHelper = new MicroGridProfileHelper();
			org.json.simple.JSONArray jsonArray = microgridProfileHelper.getListToJsonArray(mgpList);
			ch.setMessage(jsonArray.toString());
			obj.put("m", "500");
			obj.put("micro_grid_id", microgrid_id);
			obj.put("management_profile", jsonArray);
			obj.put("init", "server");
			String time_zone[] = mc.getTime_zone().toString().split("##");
			String sign_val = time_zone[0].substring(0, 1);
			System.out.println("sing val = " + sign_val);
			String hr_min[] = time_zone[0].split(":");
			int hrs = Integer.parseInt(hr_min[0]);
			int min = Integer.parseInt(hr_min[1]);
			System.out.println("hr = " + hrs + " min = " + min);
			int time_zone_val = ((hrs * 60) + min) * 60;
			// String tz = Float.toString(time_zone_val);
			System.out.println("time_zone = " + time_zone_val);
			obj.put("time_zone", Integer.toString(time_zone_val));
			obj.put("current_time", dateFormatGmt.format(new Date()));
			obj.put("request_id", request_id);
			System.out.println("microgrid id = " + microgrid_id);
			Session session = microGridSessionManage.getCurentSession(microgrid_id);
			if (session != null) {
				ch.setState("in process");
				session.getBasicRemote().sendText(obj.toString());
				map.put("message", "Profile successfully send to microgrid.!");
				map.put("error", false);
			} else {
				ch.setState("Send fails");
				map.put("message", "Micro grid not connected to our system.! ");
				map.put("error", true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		commandHistoryService.Save(ch);
		map.put("status", true);
		return map;
	}

	@RequestMapping(value = "/doMyAjax", method = RequestMethod.GET)
	@ResponseBody
	public String doMyAjax() {
		System.out.println("Request has been reached");
		return "reached";
	}

	@RequestMapping(value = "/checkvalidmid/{id}", method = RequestMethod.GET)
	@ResponseBody
	public boolean checkValidMicroGridId(@PathVariable("id") String microgrid_id) {
		return microGridService.checkValidMicroGridId(microgrid_id);
	}

	@RequestMapping(value = "/profileg/{profile}/{id}", method = RequestMethod.GET)
	public ModelAndView getProfileGraph(@PathVariable("profile") String profile, @PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("micro/profileg");
		return mv;
	}

	@RequestMapping(value = "/getprofile/{profile}/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getProfile(@PathVariable("profile") String profile, @PathVariable("id") String id) {
		Map<String, Object> response = new HashMap<String, Object>();
		if (profile != null && profile != "" && id != null && id != "") {
			switch (profile) {
			case "nd":
				List<MicroGridProfile> profiles = mgps.get_profiles_by_microgrid_id(id);
				if (profiles.size() < 1) {
					response.put("availability", "not available");
					response.put("status", "successful");
				} else {
					response.put("availability", "available");
					response.put("data", profiles);
					response.put("status", "successful");
				}
				break;
			case "d":
				List<MicroGridDefaultProfile> dprofiles = mgps.listMicrogridDefaultProfile();
				if (dprofiles.size() < 1) {
					response.put("availability", "not available");
					response.put("status", "successful");
				} else {
					response.put("availability", "available");
					response.put("data", dprofiles);
					response.put("status", "successful");
				}
				break;
			}
		} else {
			response.put("status", "unsuccessful");
		}
		return response;
	}

	public List<Object> findMicroControllerAssociationWithUser(String microgrid_id, long user_id) {
		return microGridService.findMicroControllerAssociationWithUser(microgrid_id, user_id);
	}

	public List<Object> findMicroControllerAssociationWithUser(String microgrid_id, String user_token) {
		return microGridService.findMicroControllerAssociationWithUser(microgrid_id, user_token);
	}

	@RequestMapping(value = "/errorstatus/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getStatus() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("error/status");
		return mv;
	}

	@RequestMapping(value = "/getErrorState/{code}/{m_id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getErrorState(@PathVariable("code") String error_code,
			@PathVariable("m_id") String m_id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<ErrorDetails> list = errorDetailService.findListByMicroControllerIdAndErrorCode(error_code, m_id, 5);
		response.put("data", list);
		return response;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getErrorStatistics/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getErrorStatistics(@PathVariable("id") String m_id) {
		Map<String, Object> response = new HashMap<String, Object>();
		double errorOccurred = errorDetailService.getTotalErrorOccurred(m_id).size();
		double errorSolved = errorDetailService.getResolvedErrorDetails(m_id).size();
		org.json.simple.JSONObject jsonObject = new org.json.simple.JSONObject();
		jsonObject.put("err_tot", errorOccurred);
		jsonObject.put("err_res", errorSolved);
		response.put("data", jsonObject);
		return response;
	}

	public String handlePageForUser(String dynamic_token, String microgrid_id, String default_page) {
		MicroController microController = microGridService.findByMicrogrid_Id(microgrid_id);
		User user = uService.findByToken(dynamic_token);
		if (microController != null && user != null) {
			switch (user.getUserRole().getRole()) {
			case "customer-admin":
				List<Object> list = this.findMicroControllerAssociationWithUser(microController.getMicrogrid_id(),
						user.getId());
				if (!(list.size() > 0))
					default_page = "micro/list";
				break;
			case "operator":
				String assignMicroControllers = assignOperatorService.findListByOperatorId(user.getId()).get(0)
						.getAssignMicrogrid();
				if (assignMicroControllers != null && assignMicroControllers != "") {
					String arr[] = assignMicroControllers.split(",");
					if (java.util.Arrays.binarySearch(arr, String.valueOf(microController.getId())) == -1)
						default_page = "micro/list";
				} else {
					default_page = "micro/list";
				}
				break;
			}
		}
		return default_page;
	}

	@RequestMapping(value = "/currentStatus", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getCurrentStatus(@RequestBody Map<String, Object> request) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			List<EnergyDetails> listSolar = energyDetailService.getCurrentState((String) request.get("microgrid_id"),
					"solar");
			List<EnergyDetails> listBattery = energyDetailService.getCurrentState((String) request.get("microgrid_id"),
					"battery");
			List<EnergyDetails> listGrid = energyDetailService.getCurrentState((String) request.get("microgrid_id"),
					"grid");
			if (listSolar.size() > 0) {
				EnergyDetails energyDetails = listSolar.get(listSolar.size() - 1);
				float solarKW = Float.parseFloat(energyDetails.getWattage_w()) / 1000;
				response.put("solaravail", true);
				response.put("solarpower", solarKW);
				response.put("solarvoltage", energyDetails.getVoltage_v());
				response.put("solarstate", energyDetails.getState());
			} else {
				response.put("solaravail", false);
			}
			if (listBattery.size() > 0) {
				EnergyDetails energyDetails = listBattery.get(listBattery.size() - 1);
				float batteryKW = Float.parseFloat(energyDetails.getWattage_w()) / 1000;
				response.put("batteryavail", true);
				response.put("batterypower", batteryKW);
				response.put("batteryvoltage", energyDetails.getVoltage_v());
				response.put("batterystate", energyDetails.getState());
			} else {
				response.put("batteryavail", false);
			}
			if (listGrid.size() > 0) {
				EnergyDetails energyDetails = listGrid.get(listGrid.size() - 1);
				float gridKW = Float.parseFloat(energyDetails.getWattage_w()) / 1000;
				response.put("gridavail", true);
				response.put("gridpower", gridKW);
				response.put("gridvoltage", energyDetails.getVoltage_v());
				response.put("gridstate", energyDetails.getState());
			} else {
				response.put("gridavail", false);
			}

			MicroControllerStatus microControllerStatus = microControllerStatusServices
					.getMCStatus((String) request.get("microgrid_id"));
			if (microControllerStatus != null) {
				response.put("microcontrollerstatusavail", true);
				response.put("batteryinsource", microControllerStatus.getBattery_in_source());
				response.put("batteryoutsource", microControllerStatus.getBattery_out_source());
				response.put("solaroutsource", microControllerStatus.getSolar_out_source());
			} else {
				response.put("microcontrollerstatusavail", false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return response;
	}

	@RequestMapping(value = "/lastSoc")
	@ResponseBody
	public Map<String, Object> getLastSoc(@RequestBody Map<String, Object> request) {
		Map<String, Object> response = new HashMap<String, Object>();
		String energyDetails = energyDetailService.getLastSOCOfBattry((String) request.get("microgrid_id"));
		if (energyDetails != null) {
			response.put("soc", energyDetails);
		} else {
			response.put("soc", "0");
		}
		return response;
	}

	@RequestMapping(value = "/userBasedMgcList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUserBasedMgcList(@CookieValue("token") String token) {
		Map<String, Object> response = new HashMap<String, Object>();
		try {
			User user = uService.findByToken(token);
			List<MicroController> list = microGridService.getBy(user);
			response.put("status", true);
			response.put("data", list);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", false);
		}
		return response;
	}

	@RequestMapping(value = "/reGenDataForPastThreeMonths", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getREGenDataForPastThreeMonths(@RequestParam String mgc_id) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Object[]> container = new ArrayList<Object[]>();
		try {
			Object[] objects = (Object[]) energyDetailService.getREGenDataForPastThreeMonths(mgc_id, "solar");
			float solarGenCharge = Float.parseFloat(configProperties.getSolarGenCharge());
			Object[] dataVals = null;
			for (int i = 0; i < 3; i++) {
				dataVals = new Object[3];
				Object objVal = objects[i];
				if (objVal != null) {
					double en_gen = (Double) objVal;
					double totSolarGenCharge = (solarGenCharge * en_gen);

					BigDecimal bigDecimal = new BigDecimal(en_gen);
					dataVals[1] = bigDecimal.setScale(4, RoundingMode.HALF_UP).toString();

					bigDecimal = new BigDecimal(totSolarGenCharge);
					dataVals[2] = bigDecimal.setScale(2, RoundingMode.HALF_UP).toString() + " $";
				} else {
					dataVals[1] = "0.0000";
					dataVals[2] = "0.00 $";
				}
				Object month = objects[i + 3];
				dataVals[0] = month;
				container.add(dataVals);
			}

			response.put("data", container);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	@RequestMapping(value = "/getReqREGenData", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getReqREGenData(@RequestParam("mgc_id") String mgc_id,
			@RequestParam("port_cfg") String port_cfg, @RequestParam("year") String year,
			@RequestParam("month") int month) {
		Map<String, Object> response = new HashMap<String, Object>();
		List<Object[]> dataList = new ArrayList<Object[]>();
		try {
			List<Object[]> list = energyDetailService.getRequiredREGenerationData(mgc_id, port_cfg, year, (byte) month);
			Object[] objArr = null;
			for (Object[] object : list) {
				objArr = new Object[4];
				for (int i = 0; i < object.length; i++) {
					switch (i) {
					case 1:
						double en_usage = (Double) object[i];
						double cost = en_usage * Double.parseDouble(configProperties.getSolarGenCharge());
						BigDecimal bigDecimal = new BigDecimal(cost);
						objArr[3] = bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
						// objArr[1] = object[i];
						break;
					}
					objArr[i] = object[i];
				}
				dataList.add(objArr);
			}
			/*
			 * for(Object[] objs : dataList){ for(Object objv : objs){
			 * System.out.print(objv+ "  "); } System.out.println(); }
			 */
			response.put("status", true);
			response.put("data", dataList);
		} catch (Exception e) {
			e.printStackTrace();
			response.put("status", false);
		}
		return response;
	}

	@RequestMapping(value = "/getmgclist", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTotalGeneration() {
		Map<String, Object> response = new HashMap<String, Object>();

		List<MicroController> microControllerList = new ArrayList<MicroController>();

		List<MicroController> microControllerListResult = microGridService.GetList();

		microControllerList = (microControllerListResult.size() > 0) ? microControllerListResult : microControllerList;
		response.put("data", microControllerList);
		return response;

	}

	@RequestMapping(value = "/solarGenerationCharge", method = RequestMethod.GET)
	public ModelAndView getSolarGenerationCharge() {
		return new ModelAndView("micro/solar_generation_charges");

	}

	@RequestMapping(value = "/saveSolarGenerationCharge", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> saveSolarGenerationCharge(@RequestParam("mgc_id") long mgc_id,
			@RequestParam("rate") float rate, @RequestParam("init_type") String init_type,
			@RequestParam("to_current") boolean to_current) {
		Map<String, Object> response = new HashMap<String, Object>();
		solarGenerationChargeService.saveSolarGenerationChargeUsing(mgc_id, rate, init_type, to_current);
		return response;
	}

	@RequestMapping(value = "/downLoadUsageData", method = RequestMethod.GET)
	public void downLoadUsageData(@RequestParam("mgc_id") String mgc_id, @RequestParam("start_date") String start_date,
			@RequestParam("end_date") String end_date, HttpServletResponse response) {
		MicroController microController = microGridService.findByMicrogrid_Id(mgc_id);
		List<Object[]> objects = energyDetailService.getBetweenStartEndDateHaving(start_date, end_date, microController.getMicrogrid_id(),
				"solar");		
		XSSFWorkbook xssfWorkbook = fileGenerator.generateExcelForRenewableEnergyUsageDataNew(objects, microController, start_date, end_date);
		try {
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=Renewable_Energy_Generation.xlsx");
			ServletOutputStream outputstream = response.getOutputStream();
			xssfWorkbook.write(outputstream);
			outputstream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
