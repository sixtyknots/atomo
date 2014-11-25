package com.sixtyknots.atomo.db;

import com.sixtyknots.atomo.db.entity.BinaryData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Query mapper for binary data.
 *
 * @author Miroslav Plese
 */
public interface BinaryDataMapper extends BaseMapper<BinaryData, String>,
                                          UpdatableMapper<BinaryData, String> {

    public static final String TABLE_NAME = "binarydata";

    @Override
    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id = #{id}")
    BinaryData findOne(@Param("id") String id);

    @Override
    @Insert("INSERT INTO "+TABLE_NAME+" " +
                "(id, binaryvalue, idbinarydatatype, mediatype) " +
            "VALUES " +
                "(#{id}, #{binaryvalue}, #{idbinarydatatype}, #{mediatype})")
    void create(BinaryData binaryData);
}