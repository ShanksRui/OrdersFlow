package com.development.order.model.entities.enums;

public enum ShippingStatus {

	CREATED(1),
	COLLECTING_PACKAGES(2),
	IN_TRANSFERENCE(3),
	OUT_FOR_DELIVERY(4),
	DELIVERED(5);
	
	public int code;
	
	ShippingStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static ShippingStatus ValueCode(int code) {
		for(ShippingStatus s : ShippingStatus.values()) {
			if(s.getCode() == code) {
				return s;
			}
		}
		throw new  IllegalArgumentException("invalid code");
	}

}
