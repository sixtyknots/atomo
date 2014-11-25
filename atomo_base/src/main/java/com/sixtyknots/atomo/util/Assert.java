package com.sixtyknots.atomo.util;

import com.sixtyknots.atomo.enums.ErrorEnum;

import java.util.Collection;
import java.util.List;

/**
 * Assertion support class.
 * 
 * @author Miroslav Plese
 */
public class Assert {
	
	/**Default constructor*/
	private Assert(){}
	
    /**
     * Asserts whether the given value is not null.
     * 
     * @param tested Value to be tested
     */
    public static void notNull(Object tested) {
        if (tested == null) {
            throw new IllegalArgumentException("Object value cannot be null");
        }
    }

    /**
     * Asserts whether the given value is not null.
     * 
     * @param tested Value to be tested
     * @param msg Exception message
     */
    public static void notNull(Object tested, String msg) {
        if (tested == null) {
            throw new IllegalArgumentException(msg);
        }
    }
    
    /**
     * Asserts whether the given value is null.
     * 
     * @param tested Value to be tested
     */
    public static void isNull(Object tested) {
        if (tested != null) {
            throw new IllegalArgumentException("Object value must be null");
        }
    }

    /**
     * Asserts whether the given value is null.
     * 
     * @param tested Value to be tested
     * @param msg Exception message
     */
    public static void isNull(Object tested, String msg) {
        if (tested != null) {
            throw new IllegalArgumentException(msg);
        }
    }
    
    /**
     * Asserts whether the given value is not zero.
     * 
     * @param tested Value to be tested
     */
    public static void notZero(int tested) {
        if (tested == 0) {
            throw new IllegalArgumentException("Integer value cannot be zero");
        }
    }
    
    /**
     * Asserts whether the given value is not zero.
     * 
     * @param tested Value to be tested
     * @param msg Exception message
     */
    public static void notZero(int tested, String msg) {
        if (tested == 0) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Asserts whether the given value is zero.
     * 
     * @param tested Value to be tested
     */
    public static void isZero(int tested) {
    	if (tested != 0) {
    		throw new IllegalArgumentException("Integer value must be zero");
    	}
    }
    
    /**
     * Asserts whether the given value is zero.
     * 
     * @param tested Value to be tested
     * @param msg Exception message
     */
    public static void isZero(int tested, String msg) {
    	if (tested != 0) {
    		throw new IllegalArgumentException(msg);
    	}
    }

    /**
     * Asserts whether the given value is not null or empty.
     * 
     * @param tested Value to be tested
     */
    public static void notEmpty(String tested) {
        if (tested == null || tested.length() == 0) {
            throw new IllegalArgumentException("String value cannot be empty");
        }
    }
    
    /**
     * Asserts whether the given value is not null or empty.
     * 
     * @param tested Value to be tested
     * @param msg Exception message
     */
    public static void notEmpty(String tested, String msg) {
        if (tested == null || tested.length() == 0) {
            throw new IllegalArgumentException(msg);
        }
    }
    
    /**
     * Asserts whether the given list is not null or empty.
     * 
     * @param tested Value to be tested
     */
    public static void notEmpty(List<?> tested) {
        if (tested == null || tested.size() == 0) {
            throw new IllegalArgumentException("List can not be empty");
        }
    }
    
    /**
     * Asserts whether the given list is not null or empty.
     * 
     * @param tested Value to be tested
     * @param msg Exception message
     */
    public static void notEmpty(List<?> tested, String msg) {
        if (tested == null || tested.size() == 0) {
            throw new IllegalArgumentException(msg);
        }
    }

    /**
     * Asserts whether the given value equals() the target.
     * 
     * @param tested Value to be tested
     * @param target Target value
     */
    public static void equals(Object tested, Object target) {
    	if (!target.equals(tested)) {
    		throw new IllegalArgumentException("Object value does not match expected value of "+target);
    	}
    }
    
    /**
     * Asserts whether the given value equals() the target.
     * 
     * @param tested Value to be tested
     * @param target Target value
     * @param msg Exception message
     */
    public static void equals(Object tested, Object target, String msg) {
    	if (!target.equals(tested)) {
    		throw new IllegalArgumentException(msg);
    	}
    }
    
    /**
     * Asserts whether the given value does not equals() the target.
     * 
     * @param tested Value to be tested
     * @param target Target value
     */
    public static void notEquals(Object tested, Object target) {
    	if (target.equals(tested)) {
    		throw new IllegalArgumentException("Object value cannot be "+target);
    	}
    }
    
    /**
     * Asserts whether the given value does not equals() the target.
     * 
     * @param tested Value to be tested
     * @param target Target value
     * @param msg Exception message
     */
    public static void notEquals(Object tested, Object target, String msg) {
    	if (target.equals(tested)) {
    		throw new IllegalArgumentException(msg);
    	}
    }
    
    /**
     * Asserts whether the given value is true.
     * 
     * @param tested Value to be tested
     */
    public static void isTrue(boolean tested) {
    	if (!tested) {
    		throw new IllegalArgumentException("Object value is not TRUE");
    	}
    }
    
    /**
     * Asserts whether the given value is true.
     * 
     * @param tested Value to be tested
     * @param msg Exception message
     */
    public static void isTrue(boolean tested, String msg) {
    	if (!tested) {
    		throw new IllegalArgumentException(msg);
    	}
    }
    
    /**
     * Asserts whether the given value is false.
     * 
     * @param tested Value to be tested
     */
    public static void isFalse(boolean tested) {
    	if (tested) {
    		throw new IllegalArgumentException("Object value is not FALSE");
    	}
    }
    
    /**
     * Asserts whether the given value is false.
     * 
     * @param tested Value to be tested
     * @param msg Exception message
     */
    public static void isFalse(boolean tested, String msg) {
    	if (tested) {
    		throw new IllegalArgumentException(msg);
    	}
    }
    
    /**
     * Asserts whether the given value is an instance of the given class.
     * 
     * @param tested Value to be tested
     * @param clazz Class against the value is checked
     */
    public static void instanceOf(Object tested, Class<?> clazz) {
        if (!clazz.isInstance(tested)) {
            throw new IllegalArgumentException("Object is not an instance of " + clazz.getName());
        }
    }
    
    /**
     * Asserts whether the given object retrieved from DB exists.
     * 
     * @param tested DB object to be tested
     * @throws AtomoException -
     */
    public static void recordExists(Object tested) throws AtomoException {
    	if (tested == null) {
    		throw new AtomoException(ErrorEnum.DB_RECORD_NOT_FOUND);
    	}
    }

    /**
     * Asserts whether the given object retrieved from DB exists.
     * 
     * @param tested DB object to be tested
     * @param msg Exception message
     * @throws AtomoException -
     */
    public static void recordExists(Object tested, String msg) throws AtomoException {
    	if (tested == null) {
    		throw new AtomoException(ErrorEnum.DB_RECORD_NOT_FOUND, msg);
    	}
    }

	/**
	 * Asserts whether the given list of objects retrieved from DB exists (is
	 * populated with data).
	 *
	 * @param tested the list of DB objects to be tested
	 * @throws AtomoException in case the provided list is empty or <code>null</code>
	 */
	public static void recordExists(List<?> tested) throws AtomoException {
		if (tested == null || tested.isEmpty()) {
			throw new AtomoException(ErrorEnum.DB_RECORD_NOT_FOUND);
		}
	}

	/**
	 * Asserts whether the given list of objects retrieved from DB exists (is
	 * populated with data).
	 *
	 * @param tested the list of DB objects to be tested
	 * @param msg the exception message to display
	 * @throws AtomoException in case the provided list is empty or <code>null</code>
	 */
	public static void recordExists(List<?> tested, String msg) throws AtomoException {
		if (tested == null || tested.isEmpty()) {
			throw new AtomoException(ErrorEnum.DB_RECORD_NOT_FOUND, msg);
		}
	}
	

	 /**
    * Asserts whether the given value is contained in the given collection.
    * 
    * @param tested Value to be tested
	 * @param collection target Collection object
    */
   public static void isContainedInCollection(Object tested, Collection<?> collection) {
       if (collection.contains(tested)) {
           throw new IllegalArgumentException("Object can not be contained in the given collection " + collection);
       }
   }
   
   /**
    * Asserts whether the given value is contained in the given collection.
    * 
    * @param tested Value to be tested
	 * @param collection target Collection object
	 * @param msg Exception message
    */
   public static void isContainedInCollection(Object tested, Collection<?> collection, String msg) {
       if (collection != null && collection.contains(tested)) {
           throw new IllegalArgumentException(msg);
       }
   }
}
