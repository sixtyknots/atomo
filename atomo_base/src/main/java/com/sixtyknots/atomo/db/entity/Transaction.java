package com.sixtyknots.atomo.db.entity;

/**
 * Entity class representing the "transaction" table.
 *
 * @author Miroslav Plese
 */
public class Transaction extends TimestampedRandomIdStringEntity {
    String idtransactiontype;
    String idparticipantsource;
    String idparticipanttarget;
    String data;
    String idbinarydata;
    String idtransactionstatustype;
    String idparenttransaction;

    public String getIdtransactiontype() {
        return idtransactiontype;
    }

    public void setIdtransactiontype(String idtransactiontype) {
        this.idtransactiontype = idtransactiontype;
    }

    public String getIdtransactionstatustype() {
        return idtransactionstatustype;
    }

    public void setIdtransactionstatustype(String idtransactionstatustype) {
        this.idtransactionstatustype = idtransactionstatustype;
    }

    public String getIdparenttransaction() {
        return idparenttransaction;
    }

    public void setIdparenttransaction(String idparenttransaction) {
        this.idparenttransaction = idparenttransaction;
    }

    public String getIdparticipantsource() {
        return idparticipantsource;
    }

    public void setIdparticipantsource(String idparticipantsource) {
        this.idparticipantsource = idparticipantsource;
    }

    public String getIdparticipanttarget() {
        return idparticipanttarget;
    }

    public void setIdparticipanttarget(String idparticipanttarget) {
        this.idparticipanttarget = idparticipanttarget;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIdbinarydata() {
        return idbinarydata;
    }

    public void setIdbinarydata(String idbinarydata) {
        this.idbinarydata = idbinarydata;
    }

    @Override
    protected String toPropertiesString() {
        return super.toPropertiesString() +
               ", idtransactiontype=" + idtransactiontype +
               ", idparticipantsource=" + idparticipantsource +
               ", idparticipanttarget=" + idparticipanttarget +
               ", data=" + data +
               ", idbinarydata=" + idbinarydata +
               ", idtransactionstatustype=" + idtransactionstatustype +
               ", idparenttransaction=" + idparenttransaction
               ;
    }
}
