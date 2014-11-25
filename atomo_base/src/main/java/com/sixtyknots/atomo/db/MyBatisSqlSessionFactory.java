package com.sixtyknots.atomo.db;

import com.sixtyknots.atomo.util.AtomoException;
import com.sixtyknots.atomo.util.Config;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * A singleton MyBatis session factory wrapper class.
 *
 * @author Miroslav Plese
 */
public class MyBatisSqlSessionFactory {
    private static final SqlSessionFactory FACTORY;

    static {
        Environment environment;
        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        try {
            environment = new Environment("development", transactionFactory, getDataSource());
        } catch (AtomoException ex) {
            throw new RuntimeException(ex);
        }

        Configuration config = new Configuration(environment);

        // Add all mappers defined under the specific package
        config.addMappers("com.sixtyknots.atomo.db");

        FACTORY = new SqlSessionFactoryBuilder().build(config);
    }

    /**
     * Returns the SqlSessionFactory object.
     *
     * @return SqlSessionFactory object
     */
    public static SqlSessionFactory getFactory() {
        return FACTORY;
    }

    /**
     * Returns a DataSource object.
     *
     * @return DataSource object
     * @throws AtomoException
     */
    public static DataSource getDataSource() throws AtomoException {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(Config.getInstance().getValue("storage.db.driver"));
        dataSource.setUrl(Config.getInstance().getValue("storage.db.url"));
        dataSource.setUsername(Config.getInstance().getValue("storage.db.username"));
        dataSource.setPassword(Config.getInstance().getValue("storage.db.password"));

        return dataSource;
    }
}
