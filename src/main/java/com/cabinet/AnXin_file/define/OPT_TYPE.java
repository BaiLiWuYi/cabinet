package com.cabinet.AnXin_file.define;

public enum OPT_TYPE {

	NONE(-1),
	DEPOSIT(0),
	FETCH(1);
	
	private int value;
	
	private OPT_TYPE(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	static public OPT_TYPE int2Enum(int value) {
		OPT_TYPE[] all = OPT_TYPE.class.getEnumConstants();
		for (OPT_TYPE item : all) {
			if (item.getValue() == value) {
				return item;
			}
		}
		
		return NONE;
	}
	
}
