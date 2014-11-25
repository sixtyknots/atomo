package com.sixtyknots.atomo.db.entity;

/**
 * Entity class representing the "participant" table.
 *
 * @author Miroslav Plese
 */
public class Participant extends TimestampedTypeEntity<String> {
    String idparticipanttype;

    public String getIdparticipanttype() {
        return idparticipanttype;
    }

    public void setIdparticipanttype(String idparticipanttype) {
        this.idparticipanttype = idparticipanttype;
    }

    @Override
    protected String toPropertiesString() {
        return super.toPropertiesString() +
                ", idparticipanttype=" + idparticipanttype
                ;
    }
}
