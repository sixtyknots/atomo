package com.sixtyknots.atomo.util;

import com.sixtyknots.atomo.enums.ErrorEnum;

/**
 * General Atomo exception.
 * 
 * @author Miroslav Plese
 */
public class AtomoException extends Exception {
	private static final long serialVersionUID = -625367378848021239L;

	private ErrorEnum error = ErrorEnum.GENERAL;
	
	/**
	 * Constructor accepting exception code and message arguments.
	 * 
	 * @param error Error code
	 * @param msgArgs Message arguments
	 */
	public AtomoException(ErrorEnum error, Object... msgArgs) {
        super(error.getMessage(msgArgs));
        this.error = error;
	}
	
	/**
	 * Constructor accepting exception object, code and message arguments.
	 * 
	 * @param cause Exception cause
	 * @param error Error code
	 * @param msgArgs Message arguments
	 */
    public AtomoException(Exception cause, ErrorEnum error, Object... msgArgs) {
        super(error.getMessage(msgArgs), cause);
        this.error = error;
    }

	/**
	 * @return the error
	 */
	public ErrorEnum getError() {
		return error;
	}
}
