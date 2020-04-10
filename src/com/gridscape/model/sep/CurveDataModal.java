package com.gridscape.model.sep;


import javax.persistence.Column;
import javax.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gridscape.model.BaseEntity;
import javax.persistence.Table;



@Entity
@Table(name = "sep_curve_data")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurveDataModal extends BaseEntity {

	private static final long serialVersionUID = 8964341127405915619L;
		
	@Column
	private Byte exitation;
	
	@Column
	private Integer xvalue;
	
	@Column
	private Integer yvalue;
	
	@Column(name = "der_curve_id")
	private Long derCurveId;

	public Byte getExitation() {
		return exitation;
	}

	public void setExitation(Byte exitation) {
		this.exitation = exitation;
	}

	public Integer getXvalue() {
		return xvalue;
	}

	public void setXvalue(Integer xvalue) {
		this.xvalue = xvalue;
	}

	public Integer getYvalue() {
		return yvalue;
	}

	public void setYvalue(Integer yvalue) {
		this.yvalue = yvalue;
	}

	public Long getDerCurveId() {
		return derCurveId;
	}

	public void setDerCurveId(Long derCurveId) {
		this.derCurveId = derCurveId;
	}
	
	
}

