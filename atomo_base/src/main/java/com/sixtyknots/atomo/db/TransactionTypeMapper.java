package com.sixtyknots.atomo.db;

import com.sixtyknots.atomo.db.entity.TransactionType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Query mapper for transaction types.
 *
 * @author Miroslav Plese
 */
public interface TransactionTypeMapper extends BaseMapper<TransactionType, String> {

    public static final String TABLE_NAME = "transactiontype";

    @Override
    @Select("SELECT " +
                "a.id AS id, " +
                "a.name AS name " +
            "FROM " + TABLE_NAME + " a " +
            "WHERE a.id = #{id} ")
    TransactionType findOne(@Param("id") String id);

    @Override
    @Select("SELECT " +
                "a.id AS id, " +
                "COALESCE(t.name, a.name) AS name " +
            "FROM " + TABLE_NAME + " a " +
            "ORDER BY name ")
    List<TransactionType> findAll();
}