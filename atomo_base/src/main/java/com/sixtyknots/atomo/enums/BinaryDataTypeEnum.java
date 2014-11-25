package com.sixtyknots.atomo.enums;

import com.sixtyknots.atomo.util.Assert;

/**
 * Enumeration of binarydatatype types.
 *
 * @author Miroslav Plese
 */
public enum BinaryDataTypeEnum {
    AVATAR,
    WORKOUT_TYPE_IMAGE;

    /**
     * Creates enum object from the given value.
     *
     * @param name String
     * @return BinaryDataTypeEnum
     */
    public static BinaryDataTypeEnum fromName(String name) {
        BinaryDataTypeEnum result = null;

    	if (name != null) {
	    	for (BinaryDataTypeEnum curEnum : BinaryDataTypeEnum.values()) {
	            if (curEnum.name().equals(name)) {
	                result = curEnum;
	                break;
	            }
	        }

	        Assert.notNull(result, "Enum not found with name " + name);
    	}

        return result;
    }
}
