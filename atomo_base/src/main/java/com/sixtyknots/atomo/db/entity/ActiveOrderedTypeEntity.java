package com.sixtyknots.atomo.db.entity;

/**
 * Entity representing "*type" tables with established order and with one "isactive" field which
 * specifies whether the type is enabled or not.
 *
 * @param <IDTYPE> Primary key type
 *
 * @author Miroslav Plese
 */
public class ActiveOrderedTypeEntity<IDTYPE> extends OrderedTypeEntity<IDTYPE> {
    Boolean isactive;

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    @Override
    protected String toPropertiesString() {
        return super.toPropertiesString() + ", isactive=" + isactive;
    }
}
