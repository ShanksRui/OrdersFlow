package com.development.order.model.entities.enums;

public enum PackageStatus {

	CREATED_BY_SELLER(1),
	TRACKING_GENERATED(2),
	PICKED_BY_SHIPPING(3),
	ARRIVED_AT_CENTRAL(4),
	VALIDATED_AT_CENTRAL(5);
	
	
	public int code;
	
	PackageStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static PackageStatus ValueCode(int code) {
		for(PackageStatus s : PackageStatus.values()) {
			if(s.getCode() == code) {
				return s;
			}
		}
		throw new  IllegalArgumentException("invalid code");
	}

}
