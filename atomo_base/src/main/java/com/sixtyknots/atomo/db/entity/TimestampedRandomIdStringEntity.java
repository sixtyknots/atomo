package com.sixtyknots.atomo.db.entity;

import java.util.Date;

/**
 * Entity representing RandomIdStringEntities which support time-stamping through "datecreated" and "dateupdated" columns.
 *
 * @author Miroslav Plese
 */
public class TimestampedRandomIdStringEntity extends RandomStringIdEntity {
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
