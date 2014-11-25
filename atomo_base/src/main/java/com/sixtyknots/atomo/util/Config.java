package com.sixtyknots.atomo.util;

import com.sixtyknots.atomo.enums.ErrorEnum;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Singleton configuration holder class.
 *
 * @author Miroslav Plese
 */
public class Config {

    private static final String PROPS_FILE = "/" + Constants.APP_ID + ".properties";

    private static Config INSTANCE = null;

    private Properties props = null;

    /**
     * Internal constructor that loads the properties from specific file
     * which must be present in the classpath.
     *
     * @throws AtomoException
     */
    private Config() throws AtomoException {
        props = new Properties();

        InputStream is = Config.class.getResourceAsStream(PROPS_FILE);

        if (is == null) {
            throw new AtomoException(ErrorEnum.PROPERTIES_FILE_MISSING, PROPS_FILE);
        }

        try {
            props.load(is);
        } catch (IOException ex) {
            throw new AtomoException(ex, ErrorEnum.PROPERTIES_FILE_INVALID, PROPS_FILE);
        }
    }

    /**
     * Returns the singleton Configuration class instance.
     *
     * @return Configuration instance
     * @throws AtomoException
     */
    public static synchronized Config getInstance() throws AtomoException {
        if (INSTANCE == null) {
            INSTANCE = new Config();
        }

        return INSTANCE;
    }

    /**
     * Returns value of a property identified with the specified key.
     *
     * @param propKey Property key
     * @return Value of the property
     */
    public String getValue(String propKey){
        return this.props.getProperty(propKey);
    }
}