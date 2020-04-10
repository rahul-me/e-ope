package com.gridscape.model.sep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "sep_der_status")
public class DERStatusModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6315440303248892724L;
	
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "derModel"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name="id")
	private Long id;
	
	@Column(name="created_at", insertable = false, updatable = false,columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at", insertable = true, updatable = true,columnDefinition = "timestamp default current_timestamp")
	private Date updated_at;
    	
	
	@Column(name="updated_by")
	private String updated_by;
	
	
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private DERModel derModel;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	@Column(name = "gen_connect_status_time")
	private long genConnectStatusTime;
	
	@Column(name = "gen_connect_status")
	private short genConnectStatus;
	
	@Column(name = "inverter_status_time")
	private long inverterStatusTime;
	
	@Column(name = "inverter_status")
	private short inverterStatus;
	
	@Column(name = "local_control_mode_status_time")
	private long localControlModeStatusTime;
	
	@Column(name = "local_control_mode_status")
	private short localControlModeStatus;
	
	@Column(name = "manufacturer_status_time")
	private long manufacturerStatusTime;
	
	@Column(name = "manufacturer_status")
	private String manufacturerStatus;
	
	@Column(name = "operational_mode_status_time")
	private long operationalModeStatusTime;
	
	@Column(name = "operational_mode_status")
	private short operationalModeStatus;
	
	@Column(name = "reading_time")
	private long readingTime;
	
	@Column(name = "state_of_charge_status_time")
	private long stateOfChargeStatusTime;
	
	@Column(name = "state_of_charge_status")
	private int stateOfChargeStatus;
		
	@Column(name = "storage_mode_status_time")
	private long storageModeStatusTime;
	
	@Column(name = "storage_mode_status")
	private short storageModeStatus;
	
	@Column(name = "stor_connect_status_time")
	private long storConnectStatusTime;
	
	@Column(name = "stor_connect_status")
	private short storConnectStatus;

	public DERModel getDerModel() {
		return derModel;
	}

	public void setDerModel(DERModel derModel) {
		this.derModel = derModel;
	}

	public long getGenConnectStatusTime() {
		return genConnectStatusTime;
	}

	public void setGenConnectStatusTime(long genConnectStatusTime) {
		this.genConnectStatusTime = genConnectStatusTime;
	}

	public short getGenConnectStatus() {
		return genConnectStatus;
	}

	public void setGenConnectStatus(short genConnectStatus) {
		this.genConnectStatus = genConnectStatus;
	}

	public long getInverterStatusTime() {
		return inverterStatusTime;
	}

	public void setInverterStatusTime(long inverterStatusTime) {
		this.inverterStatusTime = inverterStatusTime;
	}

	public short getInverterStatus() {
		return inverterStatus;
	}

	public void setInverterStatus(short inverterStatus) {
		this.inverterStatus = inverterStatus;
	}

	public long getLocalControlModeStatusTime() {
		return localControlModeStatusTime;
	}

	public void setLocalControlModeStatusTime(long localControlModeStatusTime) {
		this.localControlModeStatusTime = localControlModeStatusTime;
	}

	public short getLocalControlModeStatus() {
		return localControlModeStatus;
	}

	public void setLocalControlModeStatus(short localControlModeStatus) {
		this.localControlModeStatus = localControlModeStatus;
	}

	public long getManufacturerStatusTime() {
		return manufacturerStatusTime;
	}

	public void setManufacturerStatusTime(long manufacturerStatusTime) {
		this.manufacturerStatusTime = manufacturerStatusTime;
	}

	public long getOperationalModeStatusTime() {
		return operationalModeStatusTime;
	}

	public String getManufacturerStatus() {
		return manufacturerStatus;
	}

	public void setManufacturerStatus(String manufacturerStatus) {
		this.manufacturerStatus = manufacturerStatus;
	}

	public void setOperationalModeStatusTime(long operationalModeStatusTime) {
		this.operationalModeStatusTime = operationalModeStatusTime;
	}

	public short getOperationalModeStatus() {
		return operationalModeStatus;
	}

	public void setOperationalModeStatus(short operationalModeStatus) {
		this.operationalModeStatus = operationalModeStatus;
	}

	public long getReadingTime() {
		return readingTime;
	}

	public void setReadingTime(long readingTime) {
		this.readingTime = readingTime;
	}

	public long getStateOfChargeStatusTime() {
		return stateOfChargeStatusTime;
	}

	public void setStateOfChargeStatusTime(long stateOfChargeStatusTime) {
		this.stateOfChargeStatusTime = stateOfChargeStatusTime;
	}

	public int getStateOfChargeStatus() {
		return stateOfChargeStatus;
	}

	public void setStateOfChargeStatus(int stateOfChargeStatus) {
		this.stateOfChargeStatus = stateOfChargeStatus;
	}

	public long getStorageModeStatusTime() {
		return storageModeStatusTime;
	}

	public void setStorageModeStatusTime(long storageModeStatusTime) {
		this.storageModeStatusTime = storageModeStatusTime;
	}

	public short getStorageModeStatus() {
		return storageModeStatus;
	}

	public void setStorageModeStatus(short storageModeStatus) {
		this.storageModeStatus = storageModeStatus;
	}

	public long getStorConnectStatusTime() {
		return storConnectStatusTime;
	}

	public void setStorConnectStatusTime(long storConnectStatusTime) {
		this.storConnectStatusTime = storConnectStatusTime;
	}

	public short getStorConnectStatus() {
		return storConnectStatus;
	}

	public void setStorConnectStatus(short storConnectStatus) {
		this.storConnectStatus = storConnectStatus;
	}
	
	
	
}

