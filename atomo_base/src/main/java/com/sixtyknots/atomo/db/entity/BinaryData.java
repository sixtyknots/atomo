package com.sixtyknots.atomo.db.entity;

/**
 * Entity class representing the "binarydata" table.
 *
 * @author Miroslav Plese
 */
public class BinaryData extends TimestampedTypeEntity<String> {
    byte[] binaryvalue;
    String idbinarydatatype;
    String mediatype;

    public BinaryData() {
    }

    public BinaryData(byte[] binaryvalue, String idbinarydatatype, String mediatype) {
        this.binaryvalue = binaryvalue;
        this.idbinarydatatype = idbinarydatatype;
        this.mediatype = mediatype;
    }

    public byte[] getBinaryvalue() {
        return binaryvalue;
    }

    public void setBinaryvalue(byte[] binaryvalue) {
        this.binaryvalue = binaryvalue;
    }

    public String getIdbinarydatatype() {
        return idbinarydatatype;
    }

    public void setIdbinarydatatype(String idbinarydatatype) {
        this.idbinarydatatype = idbinarydatatype;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    @Override
    protected String toPropertiesString() {
        return super.toPropertiesString() +
               ", binaryvalue=" + (binaryvalue == null ? "null" : "BINARY[" + binaryvalue.length + "]") +
               ", idbinarydatatype=" + idbinarydatatype +
               ", mediatype=" + mediatype
               ;
    }
}
