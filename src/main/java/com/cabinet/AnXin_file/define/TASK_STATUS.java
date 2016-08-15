package com.cabinet.AnXin_file.define;

public enum TASK_STATUS {

	NONE(-1),
	TO_DELIVER(0),
	TO_DO(1),
	DONE(2),
	TMO(3);	
	
	private int value;
	
	private TASK_STATUS(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	static public TASK_STATUS int2Enum(int value) {
		TASK_STATUS[] all = TASK_STATUS.class.getEnumConstants();
		for (TASK_STATUS item : all) {
			if (item.getValue() == value) {
				return item;
			}
		}
		
		return NONE;
	}
	
}
