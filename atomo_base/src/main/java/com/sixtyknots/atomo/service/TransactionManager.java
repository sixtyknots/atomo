package com.sixtyknots.atomo.service;

import com.sixtyknots.atomo.db.entity.Transaction;
import com.sixtyknots.atomo.util.AtomoException;

/**
 * TransactionManager provides all transaction-specific handling methods.
 *   
 * @author Miroslav Plese
 */
public interface TransactionManager {
    /**
     * Creates a new transaction using the provided object data.
     *
     * @param transaction Transaction object
     * @return Transaction ID
     * @throws AtomoException -
     */
    public String create(Transaction transaction) throws AtomoException;

    /**
     * Returns a transaction having the specified ID.
     *
     * @param id Transaction ID
     * @return Transaction object
     */
    public Transaction get(String id);

    /**
     * Updates a transaction with the provided object data.
     *
     * @param transaction Transaction object
     * @throws AtomoException -
     */
    public void update(Transaction transaction) throws AtomoException;

    /**
     * Deletes a transaction having the specified ID.
     *
     * @param id Transaction ID
     * @throws AtomoException -
     */
    public void delete(String id) throws AtomoException;
}
