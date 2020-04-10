package com.gridscape.sep.jsoninput;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.gridscape.sep.org.zigbee.sep.MeterReading;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MeterReadingSub")
@XmlRootElement(name = "MeterReadingSub")
public class MeterReadingSub extends MeterReading {

}

