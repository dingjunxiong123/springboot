package com.boot.enumerated;

import com.boot.mybatis.DescriptionID;

public enum Sex implements DescriptionID {
	boy(0, "男"),
	gril(1, "女"),
	;
	
    private int index;

    private String description;
	
	Sex(int index, String description) {
		this.index = index;
		this.description = description;
	}

	public int getIndex() {
		return index;
	}

	public String getDescription() {
		return description;
	}

}
