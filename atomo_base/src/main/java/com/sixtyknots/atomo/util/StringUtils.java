package com.sixtyknots.atomo.util;

import com.sixtyknots.atomo.enums.KeyCharsetEnum;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Various String utility methods.
 * 
 * @author Miroslav Plese
 */
public class StringUtils {

    /**
     * Instantiation is not permitted.
     */
	protected StringUtils() {}
	
	/**
	 * Returns string variant of the given list, using the provided delimiter between the list elements.
	 * 
	 * @param list The list to be converted into string
	 * @param delimiter Delimiter to be used in the string
	 * @return Delimited string
	 */
	public static String listToString(List<?> list, String delimiter) {
        return listToString(list, delimiter, null);
	}

    /**
   	 * Returns string variant of the given list, using the provided delimiter between the list elements,
     * having each element surrounded by provided surrounder.
   	 *
   	 * @param list The list to be converted into string
   	 * @param delimiter Delimiter to be used in the string
     * @param surrounder Optional element surrounder character
   	 * @return Delimited string
   	 */
   	public static String listToString(List<?> list, String delimiter, String surrounder) {
   		if (list == null) {
   			return null;
   		} else {
   			if (list.size() == 0) {
   				return "";
   			} else {
   				StringBuffer strBuf = new StringBuffer();

   				for (Object element : list) {
                    if (surrounder != null) {
                        strBuf.append(surrounder).append(element).append(surrounder);
                    } else {
   					    strBuf.append(element);
                    }

                    strBuf.append(delimiter);
   				}

   				return strBuf.toString().substring(0, strBuf.length() - delimiter.length());
   			}
   		}
   	}

	/**
	 * Returns list of string parts, splitted by the specified delimiter.
	 *  
	 * @param string The string to be converted into list
	 * @param delimiter Delimiter used in the string 
	 * @return List of string parts
	 */
	public static List<String> stringToList(String string, String delimiter) {
		if (string == null) {
			return null;
		} else {
			String[] parts = string.split(delimiter);
			return Arrays.asList(parts);
		}
	}
	
	/**
	 * Returns true if the provided string is null or has zero-length.
	 * 
	 * @param string String to be tested
	 * @return True if the string is null or has zero-length, false otherwise
	 */
	public static boolean isEmpty(String string) {
		return string == null || string.length() == 0; 
	}
	
	/**
	 * Capitalizes given string, i.e. changes first letter to upper case.
	 * 
	 * @param string String to be capitalized
	 * @return Capitalized string
	 */
	public static String capitalize(String string) {
		if (string == null || string.length() == 0) {
			return string;
		} else {
	        char chars[] = string.toCharArray();
	        chars[0] = Character.toUpperCase(chars[0]);
	        return new String(chars);
		}
	}


    /**
     * Returns a newly generated random key with the given size.
     *
     * @param size Key size
     * @return Generated random key
     */
    public static String generateRandomKey(int size) {
        Assert.isTrue(size > 0, "Key size must be larger than zero");

        StringBuilder result = new StringBuilder();
        KeyCharsetEnum[] charsets = { KeyCharsetEnum.LOWER_CASE_LETTERS, KeyCharsetEnum.UPPER_CASE_LETTERS, KeyCharsetEnum.NUMBERS };
        String validCharStrings = KeyCharsetEnum.getValidCharStrings(charsets);

        for (int i=0; i<size; i++) {
           result.append(validCharStrings.charAt(ThreadLocalRandom.current().nextInt(validCharStrings.length())));
        }

        return result.toString();
    }

    /**
     * Abbreviates the given text to the specified length.
     *
     * @param text Text to abbreviate
     * @param limit Abbreviation length
     * @return Abbreviated text
     */
    public static String abbreviate(String text, Integer limit) {
        if (text == null) {
            return null;
        }

        if (limit == null) {
            return text;
        }

        if (text.length() > limit) {
            return text.substring(0, limit) + "...";
        } else {
            return text;
        }
    }

    /**
     * Returns string representation of the given map, but masking the value having the specified key.
     * Useful for printing out maps that store sensitive data.
     *
     * @param map Map
     * @param maskedKey Masked key
     * @return String representation of the map
     */
    public static String maskingMapToString(Map<String, Object> map, String maskedKey) {
        return maskingMapToString(map, Arrays.asList(new String[]{maskedKey}));
    }

    /**
     * Returns string representation of the given map, but masking the value having the specified key.
     * Useful for printing out maps that store sensitive data.
     *
     * @param map Map
     * @param maskedKeys Masked keys
     * @return String representation of the map
     */
    public static String maskingMapToString(Map<String, Object> map, List<String> maskedKeys) {
        if (map == null) {
            return null;
        }

        String result;
        StringBuffer buf = new StringBuffer("{");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            buf.append(entry.getKey()).append("=");

            if (!maskedKeys.contains(entry.getKey())) {
                buf.append(entry.getValue());
            } else {
                buf.append("[HIDDEN]");
            }

            buf.append(", ");
        }

        if (buf.length() > 2) {
            result = buf.substring(0, buf.length() - 2);
        } else {
            result = buf.toString();
        }

        return result + "}";
    }

    /**
     * Returns Javascript map representation of the given map.
     *
     * @param jsMapName JS map variable name
     * @param map Map
     * @return Javascript map representation of the map
     */
    public static String mapToJsMap(String jsMapName, Map<String, Object> map) {

        Assert.notEmpty(jsMapName, "JS map name must be set");

        if (map == null) {
            return null;
        }

        StringBuffer buf = new StringBuffer();

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            buf.append(jsMapName).append("['").append(entry.getKey())
               .append("'] = '").append(entry.getValue()).append("';\n");
        }

        return buf.toString();
    }

    /**
     * Check that the given CharSequence is neither null nor of length 0. Note: Will return true for a CharSequence that purely consists of whitespace.
     *
     * NOTE: Shamelessly copied from Spring's StringUtils class.
     *
     * @param str Character sequence to check
     * @return true if the sequence passes checks
     */
    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    /**
     * Check that the given String is neither null nor of length 0. Note: Will return true for a String that purely consists of whitespace.
     *
     * NOTE: Shamelessly copied from Spring's StringUtils class.
     *
     * @param str String to check
     * @return true if the string passes checks
     */
    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    /**
     * Replace all occurences of a substring within a string with another string.
     *
     * NOTE: Shamelessly copied from Spring's StringUtils class.
     *
     * @param inString String to examine
     * @param oldPattern String to replace
     * @param newPattern String to insert
     * @return a String with the replacements
     */
    public static String replace(String inString, String oldPattern, String newPattern) {
        if (!hasLength(inString) || !hasLength(oldPattern) || newPattern == null) {
            return inString;
        }

        StringBuilder sb = new StringBuilder();

        int pos = 0; // our position in the old string
        int index = inString.indexOf(oldPattern);

        // the index of an occurrence we've found, or -1
        int patLen = oldPattern.length();

        while (index >= 0) {
            sb.append(inString.substring(pos, index));
            sb.append(newPattern);
            pos = index + patLen;
            index = inString.indexOf(oldPattern, pos);
        }

        sb.append(inString.substring(pos));

        // remember to append any characters to the right of a match
        return sb.toString();
    }
}
