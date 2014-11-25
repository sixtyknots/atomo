package com.sixtyknots.atomo.db;

import com.sixtyknots.atomo.db.entity.Transaction;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Query mapper for transactions.
 *
 * @author Miroslav Plese
 */
public interface TransactionMapper extends UpdatableMapper<Transaction, String> {

    public static final String TABLE_NAME = "transaction";

    @Override
    @Select("SELECT * FROM "+TABLE_NAME+" WHERE id = #{id}")
    Transaction findOne(@Param("id") String id);

    @Override
    @Select("SELECT * FROM "+TABLE_NAME)
    List<Transaction> findAll();

    @Override
    @Insert("INSERT INTO "+TABLE_NAME+
            " (id, idtransactiontype, idparticipantsource, idparticipanttarget, data, idbinarydata, idtransactionstatustype, idparenttransaction) " +
            "VALUES" +
            " (#{id}, #{idtransactiontype}, #{idparticipantsource}, #{idparticipanttarget}, #{data}, #{idbinarydata}, #{idtransactionstatustype}, #{idparenttransaction})")
    void create(Transaction transaction);

    @Update("UPDATE " + TABLE_NAME + " " +
            "SET idtransactionstatustype = #{idtransactionstatustype}, " +
                "dateupdated=CURRENT_TIMESTAMP " +
            "WHERE id = #{id} ")
    void updateStatus(@Param("id") String id, @Param("idtransactionstatustype") String idtransactionstatustype);

    @Select("SELECT COUNT(*) " +
            "FROM " + TABLE_NAME + " " +
            "WHERE " +
                "(idparticipantsource = #{idparticipant} OR idparticipanttarget = #{idparticipant}) " +
                "AND idtransactiontype = #{idtransactiontype} ")
    int findCountByParticipantAndType(@Param("idparticipant") String idparticipant, @Param("idtransactiontype") String idtransactiontype);

    @Override
    @Update("UPDATE " + TABLE_NAME + " SET " +
            "idtransactiontype=#{idtransactiontype}, " +
            "idparticipantsource=#{idparticipantsource}, " +
            "idparticipanttarget=#{idparticipanttarget}, " +
            "data=#{data}, " +
            "idbinarydata=#{idbinarydata}, " +
            "idtransactionstatustype=#{idtransactionstatustype}, " +
            "idparenttransaction=#{idparenttransaction}, " +
            "dateupdated=CURRENT_TIMESTAMP " +
            "WHERE id=#{id}")
    void update(Transaction transaction);

    @Delete("DELETE FROM " + TABLE_NAME + " WHERE id = #{id} ")
    void delete(@Param("id") String id);
}
