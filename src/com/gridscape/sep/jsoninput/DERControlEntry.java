package com.gridscape.sep.jsoninput;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gridscape.model.sep.DERCurveModal;


@JsonIgnoreProperties(ignoreUnknown = true)
public class DERControlEntry {
	
	private String description;
	private short randomizeDuration;
	private short randomizeStart;	
	private String eventStartTime;
	private long eventDuration;
	private long derpId;
	private Long id;
	private Integer version;
	private boolean defaultDERControl;
	
	public boolean isDefaultDERControl() {
		return defaultDERControl;
	}
	public void setDefaultDERControl(boolean defaultDERControl) {
		this.defaultDERControl = defaultDERControl;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	//protected SignedPerCent opModFixedFlow;
	private Short opModFixedFlow;
	
	//protected FixedPowerFactor opModFixedPF;
	private Short opModFixedPFDisplacement;
	private Byte opModFixedPFMultiplier;
	
	//protected FixedVAr opModFixedVAr;
	private Short opModFixedVArRefType;
	private Short opModFixedVArValue;
	
	//protected PerCent opModFixedW;
	private Integer opModFixedW;
	
	//protected DERCurveLink opModFreqWatt;
	private Long opModFreqWatt;	
	private DERCurveModal opModFreqWattOb;
	
	//protected CurvePairType opModHVRT;
	private Long opModHVRTLowerLimit;
	private DERCurveModal opModHVRTLowerLimitOb;	
	private Long opModHVRTUpperLimit;
	private DERCurveModal opModHVRTUpperLimitOb;
	
	//protected CurvePairType opModLVRT;
	private Long opModLVRTLowerLimit;
	private DERCurveModal opModLVRTLowerLimitOb;
	private Long opModLVRTUpperLimit;
	private DERCurveModal opModLVRTUpperLimitOb;
	
	//protected DERCurveLink opModVoltVAr;
	private Long opModVoltVAr;
	private DERCurveModal opModVoltVArOb;
	
	//protected DERCurveLink opModVoltWatt;
	private Long opModVoltWatt;
	private DERCurveModal opModVoltWattOb;
	
    //protected DERCurveLink opModWattPF;
	private Long opModWattPF;
	private DERCurveModal opModWattPFOb;
	
	//protected Integer rampTms;
	protected Integer rampTms;
	

	public Short getOpModFixedFlow() {
		return opModFixedFlow;
	}
	public void setOpModFixedFlow(Short opModFixedFlow) {
		this.opModFixedFlow = opModFixedFlow;
	}
	public Short getOpModFixedPFDisplacement() {
		return opModFixedPFDisplacement;
	}
	public void setOpModFixedPFDisplacement(Short opModFixedPFDisplacement) {
		this.opModFixedPFDisplacement = opModFixedPFDisplacement;
	}
	public Byte getOpModFixedPFMultiplier() {
		return opModFixedPFMultiplier;
	}
	public void setOpModFixedPFMultiplier(Byte opModFixedPFMultiplier) {
		this.opModFixedPFMultiplier = opModFixedPFMultiplier;
	}
	public Short getOpModFixedVArRefType() {
		return opModFixedVArRefType;
	}
	public void setOpModFixedVArRefType(Short opModFixedVArRefType) {
		this.opModFixedVArRefType = opModFixedVArRefType;
	}
	public Short getOpModFixedVArValue() {
		return opModFixedVArValue;
	}
	public void setOpModFixedVArValue(Short opModFixedVArValue) {
		this.opModFixedVArValue = opModFixedVArValue;
	}
	public Integer getOpModFixedW() {
		return opModFixedW;
	}
	public void setOpModFixedW(Integer opModFixedW) {
		this.opModFixedW = opModFixedW;
	}
	public Long getOpModFreqWatt() {
		return opModFreqWatt;
	}
	public void setOpModFreqWatt(Long opModFreqWatt) {
		this.opModFreqWatt = opModFreqWatt;
	}	
	public Long getOpModVoltVAr() {
		return opModVoltVAr;
	}
	public void setOpModVoltVAr(Long opModVoltVAr) {
		this.opModVoltVAr = opModVoltVAr;
	}
	public Long getOpModVoltWatt() {
		return opModVoltWatt;
	}
	public void setOpModVoltWatt(Long opModVoltWatt) {
		this.opModVoltWatt = opModVoltWatt;
	}
	public Long getOpModWattPF() {
		return opModWattPF;
	}
	public Long getOpModHVRTLowerLimit() {
		return opModHVRTLowerLimit;
	}
	public void setOpModHVRTLowerLimit(Long opModHVRTLowerLimit) {
		this.opModHVRTLowerLimit = opModHVRTLowerLimit;
	}
	public Long getOpModHVRTUpperLimit() {
		return opModHVRTUpperLimit;
	}
	public void setOpModHVRTUpperLimit(Long opModHVRTUpperLimit) {
		this.opModHVRTUpperLimit = opModHVRTUpperLimit;
	}
	public Long getOpModLVRTLowerLimit() {
		return opModLVRTLowerLimit;
	}
	public void setOpModLVRTLowerLimit(Long opModLVRTLowerLimit) {
		this.opModLVRTLowerLimit = opModLVRTLowerLimit;
	}
	public Long getOpModLVRTUpperLimit() {
		return opModLVRTUpperLimit;
	}
	public void setOpModLVRTUpperLimit(Long opModLVRTUpperLimit) {
		this.opModLVRTUpperLimit = opModLVRTUpperLimit;
	}
	public void setOpModWattPF(Long opModWattPF) {
		this.opModWattPF = opModWattPF;
	}
	public Integer getRampTms() {
		return rampTms;
	}
	public void setRampTms(Integer rampTms) {
		this.rampTms = rampTms;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public short getRandomizeDuration() {
		return randomizeDuration;
	}
	public void setRandomizeDuration(short randomizeDuration) {
		this.randomizeDuration = randomizeDuration;
	}
	public short getRandomizeStart() {
		return randomizeStart;
	}
	public void setRandomizeStart(short randomizeStart) {
		this.randomizeStart = randomizeStart;
	}
	public String getEventStartTime() {
		return eventStartTime;
	}
	public void setEventStartTime(String eventStartTime) {
		this.eventStartTime = eventStartTime;
	}
	public long getEventDuration() {
		return eventDuration;
	}
	public void setEventDuration(long eventDuration) {
		this.eventDuration = eventDuration;
	}
	public long getDerpId() {
		return derpId;
	}
	public void setDerpId(long derpId) {
		this.derpId = derpId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public DERCurveModal getOpModFreqWattOb() {
		return opModFreqWattOb;
	}
	public void setOpModFreqWattOb(DERCurveModal opModFreqWattOb) {
		this.opModFreqWattOb = opModFreqWattOb;
	}
	public DERCurveModal getOpModHVRTLowerLimitOb() {
		return opModHVRTLowerLimitOb;
	}
	public void setOpModHVRTLowerLimitOb(DERCurveModal opModHVRTLowerLimitOb) {
		this.opModHVRTLowerLimitOb = opModHVRTLowerLimitOb;
	}
	public DERCurveModal getOpModHVRTUpperLimitOb() {
		return opModHVRTUpperLimitOb;
	}
	public void setOpModHVRTUpperLimitOb(DERCurveModal opModHVRTUpperLimitOb) {
		this.opModHVRTUpperLimitOb = opModHVRTUpperLimitOb;
	}
	public DERCurveModal getOpModLVRTLowerLimitOb() {
		return opModLVRTLowerLimitOb;
	}
	public void setOpModLVRTLowerLimitOb(DERCurveModal opModLVRTLowerLimitOb) {
		this.opModLVRTLowerLimitOb = opModLVRTLowerLimitOb;
	}
	public DERCurveModal getOpModLVRTUpperLimitOb() {
		return opModLVRTUpperLimitOb;
	}
	public void setOpModLVRTUpperLimitOb(DERCurveModal opModLVRTUpperLimitOb) {
		this.opModLVRTUpperLimitOb = opModLVRTUpperLimitOb;
	}
	public DERCurveModal getOpModVoltVArOb() {
		return opModVoltVArOb;
	}
	public void setOpModVoltVArOb(DERCurveModal opModVoltVArOb) {
		this.opModVoltVArOb = opModVoltVArOb;
	}
	public DERCurveModal getOpModVoltWattOb() {
		return opModVoltWattOb;
	}
	public void setOpModVoltWattOb(DERCurveModal opModVoltWattOb) {
		this.opModVoltWattOb = opModVoltWattOb;
	}
	public DERCurveModal getOpModWattPFOb() {
		return opModWattPFOb;
	}
	public void setOpModWattPFOb(DERCurveModal opModWattPFOb) {
		this.opModWattPFOb = opModWattPFOb;
	}
	
	
	
	
	
}

