package com.sixtyknots.atomo.db.entity;

/**
 * Entity representing TypeEntities which support ordering via "displayorder" column.
 *
 * @param <IDTYPE> Primary key type
 *
 * @author Miroslav Plese
 */
public class OrderedTypeEntity<IDTYPE> extends TypeEntity<IDTYPE> {
    Short displayorder;

    public Short getDisplayorder() {
        return displayorder;
    }

    public void setOrder(Short displayorder) {
        this.displayorder = displayorder;
    }

    @Override
    protected String toPropertiesString() {
        return super.toPropertiesString() + ", displayorder="+displayorder;
    }
}
