package com.sixtyknots.atomo.db.entity;

import java.util.Date;

/**
 * Entity representing TypeEntities which support time-stamping through "datecreated" and "dateupdated" columns.
 *
 * @param <IDTYPE> Primary key type
 *
 * @author Miroslav Plese
 */
public class TimestampedTypeEntity<IDTYPE> extends TypeEntity<IDTYPE> {
    Date datecreated;
    Date dateupdated;

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Date getDateupdated() {
        return dateupdated;
    }

    public void setDateupdated(Date dateupdated) {
        this.dateupdated = dateupdated;
    }

    @Override
    protected String toPropertiesString() {
        return super.toPropertiesString()
                + ", datecreated=" + datecreated
                + ", dateupdated=" + dateupdated;
    }
}
