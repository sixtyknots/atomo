package com.sixtyknots.atomo.db;

import com.sixtyknots.atomo.db.entity.TransactionStatusType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Query mapper for transaction status types.
 *
 * @author Miroslav Plese
 */
public interface TransactionStatusTypeMapper extends BaseMapper<TransactionStatusType, String> {
    public static final String TABLE_NAME = "transactionstatustype";

    @Override
    @Select("SELECT " +
                "a.id AS id, " +
                "a.name AS name " +
            "FROM " + TABLE_NAME + " a " +
            "WHERE a.id = #{id} ")
    TransactionStatusType findOne(@Param("id") String id);

    @Override
    @Select("SELECT " +
                "a.id AS id, " +
                "a.name AS name " +
            "FROM " + TABLE_NAME + " a " +
            "ORDER BY a.displayorder ")
    List<TransactionStatusType> findAll();
}