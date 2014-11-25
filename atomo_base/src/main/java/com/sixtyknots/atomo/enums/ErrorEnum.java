package com.sixtyknots.atomo.enums;

import com.sixtyknots.atomo.util.Assert;
import com.sixtyknots.atomo.util.StringUtils;

import javax.xml.bind.annotation.XmlEnum;

/**
 * Defines application error codes.
 * 
 * @author Miroslav Plese
 */
@XmlEnum
public enum ErrorEnum {
	/** General application error */
    GENERAL                     			(0, 500, "General application error"),
    
    // ---------------------------------------------------------------------------------------------------------
    // DB related errors
    
    /** Stale application data */
    DB_STALE_STATE							(50, 409, "Stale application data"),
    /** Record not found */
    DB_RECORD_NOT_FOUND						(60, 404, "Record not found: {0}"),
    /** Database operation failed */
    DB_OP_FAILED                            (70, 500, "Database operation failed"),

    // ---------------------------------------------------------------------------------------------------------
    // Property files errors
    
    /** No properties files found at the given location */
    PROPERTIES_FILE_MISSING     			(300, 500, "Properties file not found: {0}"),
    /** Empty properties file */
    PROPERTIES_FILE_EMPTY       			(301, 500, "Empty properties file: {0}"),
    /** Invalid properties file */
    PROPERTIES_FILE_INVALID     			(302, 500, "Invalid properties file: {0}"),
    
    // ---------------------------------------------------------------------------------------------------------
    // Text parsing errors

    /** Unable to parse XML */
    INVALID_XML     						(500, 500, "Unable to parse XML"),

    /** Unable to parse the date */
    INVALID_DATE_FORMAT     				(501, 500, "Unable to parse date: {0}");

    private final int code;
    private final int httpStatus;
    private final String message;
    
    /**
     * Constructor with code and message arguments.
     * 
     * @param code The error code
     * @param httpStatus The HTTP status
     * @param message The error message
     */
    private ErrorEnum(int code, int httpStatus, String message) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    /**
     * Gets the code
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * Gets the HTTP status
     * @return the HTTP status
     */
    public int getHttpStatus() {
    	return httpStatus;
    }
    
    /**
     * Gets the message
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Returns error message with "{n}" tokens replaced with provided arguments
     * and a suffix added at the end specifying the error code "(ERR123)".
     * 
     * @param msgArgs Message arguments
     * @return Updated message
     */
    public String getMessage(Object ... msgArgs) {
        String result = message;
        
        if (msgArgs != null && msgArgs.length > 0) {
            for (int i=0; i<msgArgs.length; i++) {
        		result = StringUtils.replace(result,
                        "{" + i + "}",
                        msgArgs[i] != null ? msgArgs[i].toString() : "null");
            }
        } else {
        	// No args received, remove "{n}" placeholders
        	result = result.replaceAll("\\{.*?\\}", "");
        }
        
        return result + " (ERR" + code + ")";
    }

    /**
   	 * Returns message code corresponding to this enum.
   	 *
   	 * @return Message code
   	 */
   	public String toMessageCode() {
   		return "common.operation.error."+name().toLowerCase();
   	}

    /**
     * Returns enum name from the given value.
     *
     * @param code Code
     * @return name
     */
    public static String toName(int code) {
    	String result = null;
    	
        for (ErrorEnum curEnum : ErrorEnum.values()) {
            if (curEnum.code == code) {
                result = curEnum.name();
                break;
            }
        }
        
        Assert.notNull(result, "Enum not found for code: " + code);
        
        return result;
    }

    /**
    /**
     * Creates enum object from the given value.
     *
     * @param code Code
     * @return RequestStatusEnum
     */
    public static ErrorEnum fromCode(int code) {
    	ErrorEnum result = null;
    	
        for (ErrorEnum curEnum : ErrorEnum.values()) {
            if (curEnum.code == code) {
                result = curEnum;
                break;
            }
        }

        Assert.notNull(result, "Enum not found for code: " + code);
        
        return result;
    }
}

