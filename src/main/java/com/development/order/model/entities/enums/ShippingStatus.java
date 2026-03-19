package com.development.order.model.entities.enums;

public enum ShippingStatus {

	IN_STATE_TRANSPORT(1),
	OUT_FOR_DELIVERY(2),
	DELIVERED(3);
	
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
