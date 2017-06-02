package com.dqr.www.multitypestudy.mine.bean;


import com.dqr.www.multitypestudy.mine.MineNavigateType;

public class MineNavBean {
	private byte type; //类型
	private int iconId;
	private String iconName;

	public MineNavBean(@MineNavigateType.Tab byte type, int iconId, String iconName) {
		super();
		this.type=type;
		this.iconId = iconId;
		this.iconName = iconName;
	}
	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public int getIconId() {
		return iconId;
	}

	public void setIconId(int iconId) {
		this.iconId = iconId;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

}
