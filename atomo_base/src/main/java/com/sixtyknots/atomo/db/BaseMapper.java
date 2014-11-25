package com.sixtyknots.atomo.db;

import java.util.List;

/**
 * Base mapper with common finder operations.
 *
 * @param <ENTITY> Entity associated with the mapper
 * @param <IDTYPE> Primary key type
 * @author Miroslav Plese
 */
public interface BaseMapper<ENTITY, IDTYPE> {
    /**
     * Returns entity having the specified ID.
     *
     * @param id Entity ID
     * @return The entity
     */
    ENTITY findOne(IDTYPE id);

    /**
     * Returns all entities.
     *
     * @return List of entities
     */
    List<ENTITY> findAll();
}
