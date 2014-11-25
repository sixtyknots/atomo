package com.sixtyknots.atomo.service.impl;

import com.sixtyknots.atomo.db.MyBatisSqlSessionFactory;
import com.sixtyknots.atomo.db.TransactionMapper;
import com.sixtyknots.atomo.db.entity.Transaction;
import com.sixtyknots.atomo.enums.ErrorEnum;
import com.sixtyknots.atomo.service.TransactionManager;
import com.sixtyknots.atomo.util.Assert;
import com.sixtyknots.atomo.util.AtomoException;
import org.apache.ibatis.session.SqlSession;

public class TransactionManagerImpl implements TransactionManager {

    @Override
    public String create(Transaction transaction) throws AtomoException {
        Assert.notNull(transaction, "Transaction object must be set");

        SqlSession sqlSession = MyBatisSqlSessionFactory.getFactory().openSession();

        try {
            sqlSession.getMapper(TransactionMapper.class).create(transaction);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            throw new AtomoException(ex, ErrorEnum.DB_OP_FAILED);
        } finally {
            sqlSession.close();
        }

        return transaction.getId();
    }

    @Override
    public Transaction get(String id) {
        Transaction result;

        Assert.notEmpty(id, "ID must be set");

        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getFactory().openSession()) {
            result = sqlSession.getMapper(TransactionMapper.class).findOne(id);
        }

        return result;
    }

    @Override
    public void update(Transaction transaction) throws AtomoException {
        Assert.notNull(transaction, "Transaction object must be set");
        Assert.notEmpty(transaction.getId(), "Transaction ID must be set");

        SqlSession sqlSession = MyBatisSqlSessionFactory.getFactory().openSession();

        try {
            sqlSession.getMapper(TransactionMapper.class).update(transaction);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            throw new AtomoException(ex, ErrorEnum.DB_OP_FAILED);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void delete(String id) throws AtomoException {
        Assert.notEmpty(id, "ID must be set");

        SqlSession sqlSession = MyBatisSqlSessionFactory.getFactory().openSession();

        try {
            sqlSession.getMapper(TransactionMapper.class).delete(id);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            throw new AtomoException(ex, ErrorEnum.DB_OP_FAILED);
        } finally {
            sqlSession.close();
        }
    }
}
