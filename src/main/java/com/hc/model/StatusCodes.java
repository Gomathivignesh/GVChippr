package com.hc.model;

public enum StatusCodes {
    SUCCESS ("SUCCESS", 0),
    NO_RECORD_FOUND ("NO_RECORD_FOUND", 1),
    VALIDATION_ERROR ("VALIDATION_ERROR", 2),
    INTERNAL_ERROR ("INTERNAL_ERROR", 3),
    DATA_ERROR("DATA_ERROR",4),
	RESET_WORKOUT("MORE THAN 4 DAYS, RESET WORKOUT",5),
	NO_CURRENT_WORKOUT("NO CURRENT WORK OUT PRESENT FOR USER",6);
    public String messageKey;
    public int code;

    StatusCodes(String  key, int code){
        this.messageKey = key;
        this.code = code;
    }
}
