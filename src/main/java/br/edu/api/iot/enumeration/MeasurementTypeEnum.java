package br.edu.api.iot.enumeration;

public enum MeasurementTypeEnum {

	HEARTRATE(1,"HEARTRATE"),
	TEMPERATURE(2,"TEMPERATURE"),
	OXYGEN_SATURATION(3,"OXYGEN SATURATION");
	
	private Integer code;
	private String description;
	
	private MeasurementTypeEnum(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	public Integer getCode() {
		return this.code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static MeasurementTypeEnum fromValue(String description) {
		for(MeasurementTypeEnum measurament : MeasurementTypeEnum.values()) {
			if (measurament.getDescription().equalsIgnoreCase(description))
					return measurament;
		}
		return null;
	}
	
	public static MeasurementTypeEnum fromValue(Integer value) {
		for(MeasurementTypeEnum measurament : MeasurementTypeEnum.values()) {
			if (measurament.getCode().intValue() == value.intValue())
					return measurament;
		}
		return null;
	}
}
