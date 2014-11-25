package com.sixtyknots.atomo.db;

import com.sixtyknots.atomo.db.entity.Participant;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Query mapper for participant data.
 *
 * @author Miroslav Plese
 */
public interface ParticipantMapper extends BaseMapper<Participant, String>,
                                           UpdatableMapper<Participant, String> {

    public static final String TABLE_NAME = "participant";

    @Override
    @Select("SELECT * FROM " + TABLE_NAME + " WHERE id = #{id}")
    Participant findOne(@Param("id") String id);

    @Override
    @Insert("INSERT INTO "+TABLE_NAME+" " +
                "(id, name, idparticipanttype) " +
            "VALUES " +
                "(#{id}, #{name}, #{idparticipanttype} )")
    void create(Participant participant);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE id = #{id} ")
    void delete(@Param("id") String id);
}