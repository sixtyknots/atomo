package com.sixtyknots.atomo.db.entity;

import com.sixtyknots.atomo.util.Constants;
import com.sixtyknots.atomo.util.StringUtils;

/**
 * Entity class that provides a randomly generated String id property.
 * The generation happens on call to getId() method.
 *
 * @author Miroslav Plese
 */
public class RandomStringIdEntity extends BaseEntity<String> {

    /**
     * Returns ID if not null or generates it as random key if it is null.
     *
     * @return ID
     */
    public String getId() {
        if (id == null) {
            id = StringUtils.generateRandomKey(Constants.DEFAULT_RANDOM_KEY_SIZE);
        }

        return id;
    }
}
