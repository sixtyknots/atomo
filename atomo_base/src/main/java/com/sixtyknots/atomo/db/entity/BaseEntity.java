package com.sixtyknots.atomo.db.entity;

import com.sixtyknots.atomo.util.ExtendableToString;

/**
 * Base entity with single PK of type IDTYPE.
 *
 * @param <IDTYPE> Primary key type
 *
 * @author Miroslav Plese
 */
public class BaseEntity<IDTYPE> extends ExtendableToString {
    IDTYPE id;

    public IDTYPE getId() {
        return id;
    }

    public void setId(IDTYPE id) {
        this.id = id;
    }

    @Override
    protected String toPropertiesString() {
        return "id="+id;
    }
}
