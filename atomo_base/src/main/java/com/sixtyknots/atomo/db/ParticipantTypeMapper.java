package com.sixtyknots.atomo.db;

import com.sixtyknots.atomo.db.entity.ParticipantType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Query mapper for participant types.
 *
 * @author Miroslav Plese
 */
public interface ParticipantTypeMapper extends BaseMapper<ParticipantType, String> {

    public static final String TABLE_NAME = "participanttype";

    @Override
    @Select("SELECT " +
                "a.id AS id, " +
                "a.name AS name " +
            "FROM " + TABLE_NAME + " a " +
            "WHERE a.id = #{id} ")
    ParticipantType findOne(@Param("id") String id);

    @Override
    @Select("SELECT " +
                "a.id AS id, " +
                "COALESCE(t.name, a.name) AS name " +
            "FROM " + TABLE_NAME + " a " +
            "ORDER BY name ")
    List<ParticipantType> findAll();
}