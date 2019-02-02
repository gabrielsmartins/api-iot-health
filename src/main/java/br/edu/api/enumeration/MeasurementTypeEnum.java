package br.edu.api.enumeration;

public enum MeasurementTypeEnum {

	HEARTRATE(1),
	TEMPERATURE(2),
	OXYGEN_SATURATION(3);
	
	private Integer code;
	
	private MeasurementTypeEnum(Integer code) {
		this.code = code;
	}
	public Integer getCode() {
		return this.code;
	}
	
	public static MeasurementTypeEnum fromValue(Integer value) {
		for(MeasurementTypeEnum measurament : MeasurementTypeEnum.values()) {
			if (measurament.getCode().intValue() == value.intValue())
					return measurament;
		}
		return null;
	}
}
