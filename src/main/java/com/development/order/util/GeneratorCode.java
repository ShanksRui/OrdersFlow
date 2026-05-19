package com.development.order.util;

import java.util.UUID;

public interface GeneratorCode {

	static String generatorFromCode() {
			return UUID.randomUUID().toString().replace("-", "").substring(0, 8).toUpperCase();
		}
	}

