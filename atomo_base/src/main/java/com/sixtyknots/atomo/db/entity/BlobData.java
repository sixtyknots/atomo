package com.sixtyknots.atomo.db.entity;

/**
 * Blob data wrapper entity.
 *
 * @author Miroslav Plese
 */
public class BlobData extends RandomStringIdEntity {
    byte[] data;

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    protected String toPropertiesString() {
        return super.toPropertiesString() +
               ", data=" + (data != null ? "[BINARY]" : "null");
    }
}
