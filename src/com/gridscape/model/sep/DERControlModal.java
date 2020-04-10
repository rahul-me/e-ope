package com.gridscape.model.sep;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gridscape.model.BaseEntity;

@Entity
@Table(name = "sep_der_control")
public class DERControlModal extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6862612453745989089L;

	@Column(name = "randomize_start")
	private short randomizeStart;

	@Column(name = "randomize_duration")
	private short randomizeDuration;

	@Column(name = "creation_time")
	private Long creationTimeInMillies;

	@Column(name = "description")
	private String description;

	@Column(name = "version")
	private int version;

	@Column(name = "mrid")
	private String mrid;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "derp_id")
	private Long derpId;

	@Column(name = "event_start_time")
	private Long eventStartTime;

	@Column(name = "event_duration")
	private Long eventDuration;
	
	@Column(name = "default_der_control", columnDefinition = "boolean default false")
	private boolean defaultDERControl;

	// DERControlBase

	public boolean isDefaultDERControl() {
		return defaultDERControl;
	}

	public void setDefaultDERControl(boolean defaultDERControl) {
		this.defaultDERControl = defaultDERControl;
	}

	// protected SignedPerCent opModFixedFlow;
	@Column
	private Short opModFixedFlow;

	// protected FixedPowerFactor opModFixedPF;
	@Column
	private Short opModFixedPFDisplacement;
	@Column
	private Byte opModFixedPFMultiplier;

	// protected FixedVAr opModFixedVAr;
	@Column
	private Short opModFixedVArRefType;
	@Column
	private Short opModFixedVArValue;

	// protected PerCent opModFixedW;
	@Column
	private Integer opModFixedW;

	// protected DERCurveLink opModFreqWatt;
	@Column
	private Long opModFreqWatt;

	// protected CurvePairType opModHVRT;
	@Column
	private Long opModHVRTLowerLimit;
	@Column
	private Long opModHVRTUpperLimit;

	// protected CurvePairType opModLVRT;
	@Column
	private Long opModLVRTLowerLimit;
	@Column
	private Long opModLVRTUpperLimit;

	// protected DERCurveLink opModVoltVAr;
	@Column
	private Long opModVoltVAr;

	// protected DERCurveLink opModVoltWatt;
	@Column
	private Long opModVoltWatt;

	public short getRandomizeStart() {
		return randomizeStart;
	}

	public void setRandomizeStart(short randomizeStart) {
		this.randomizeStart = randomizeStart;
	}

	public short getRandomizeDuration() {
		return randomizeDuration;
	}

	public void setRandomizeDuration(short randomizeDuration) {
		this.randomizeDuration = randomizeDuration;
	}

	public Long getCreationTimeInMillies() {
		return creationTimeInMillies;
	}

	public void setCreationTimeInMillies(Long creationTimeInMillies) {
		this.creationTimeInMillies = creationTimeInMillies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getMrid() {
		return mrid;
	}

	public void setMrid(String mrid) {
		this.mrid = mrid;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getDerpId() {
		return derpId;
	}

	public void setDerpId(Long derpId) {
		this.derpId = derpId;
	}

	public Long getEventStartTime() {
		return eventStartTime;
	}

	public void setEventStartTime(Long eventStartTime) {
		this.eventStartTime = eventStartTime;
	}

	public Long getEventDuration() {
		return eventDuration;
	}

	public void setEventDuration(Long eventDuration) {
		this.eventDuration = eventDuration;
	}

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

	public void setOpModWattPF(Long opModWattPF) {
		this.opModWattPF = opModWattPF;
	}

	public Integer getRampTms() {
		return rampTms;
	}

	public void setRampTms(Integer rampTms) {
		this.rampTms = rampTms;
	}

	// protected DERCurveLink opModWattPF;
	@Column
	private Long opModWattPF;

	// protected Integer rampTms;
	@Column
	protected Integer rampTms;

	

}
