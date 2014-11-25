package com.sixtyknots.atomo.service.impl;

import com.sixtyknots.atomo.db.MyBatisSqlSessionFactory;
import com.sixtyknots.atomo.db.ParticipantMapper;
import com.sixtyknots.atomo.db.entity.Participant;
import com.sixtyknots.atomo.enums.ErrorEnum;
import com.sixtyknots.atomo.service.ParticipantManager;
import com.sixtyknots.atomo.util.Assert;
import com.sixtyknots.atomo.util.AtomoException;
import org.apache.ibatis.session.SqlSession;

public class ParticipantManagerImpl implements ParticipantManager {

    @Override
    public String create(Participant participant) throws AtomoException {
        Assert.notNull(participant, "Participant object must be set");

        SqlSession sqlSession = MyBatisSqlSessionFactory.getFactory().openSession();

        try {
            sqlSession.getMapper(ParticipantMapper.class).create(participant);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            throw new AtomoException(ex, ErrorEnum.DB_OP_FAILED);
        } finally {
            sqlSession.close();
        }

        return participant.getId();
    }

    @Override
    public Participant get(String id) {
        Participant result;

        Assert.notEmpty(id, "ID must be set");

        try (SqlSession sqlSession = MyBatisSqlSessionFactory.getFactory().openSession()) {
            result = sqlSession.getMapper(ParticipantMapper.class).findOne(id);
        }

        return result;
    }

    @Override
    public void update(Participant participant) throws AtomoException {
        Assert.notNull(participant, "Participant object must be set");
        Assert.notEmpty(participant.getId(), "Participant ID must be set");

        SqlSession sqlSession = MyBatisSqlSessionFactory.getFactory().openSession();

        try {
            sqlSession.getMapper(ParticipantMapper.class).update(participant);
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
            sqlSession.getMapper(ParticipantMapper.class).delete(id);
            sqlSession.commit();
        } catch (Exception ex) {
            sqlSession.rollback();
            throw new AtomoException(ex, ErrorEnum.DB_OP_FAILED);
        } finally {
            sqlSession.close();
        }
    }
}
