package com.development.order.model.entities.enums;

public enum Status {

	CREATED_BY_SELLER(1),
	TRACKING_GENERATED(2),
	PICKED_BY_SHIPPING(3),
	ARRIVED_AT_CENTRAL(4),
	VALIDATED_AT_CENTRAL(5),
	IN_STATE_TRANSPORT(6),
	OUT_FOR_DELIVERY(7),
	DELIVERED(8);
	
	public int code;
	
	Status(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
