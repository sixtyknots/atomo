package com.sixtyknots.atomo.db;

/**
 * Mapper for tables supporting full CRUD operations.
 *
 * @param <ENTITY> Entity associated with the mapper
 * @author Miroslav Plese
 */
public interface UpdatableMapper<ENTITY, IDTYPE> extends BaseMapper<ENTITY, IDTYPE> {
    /**
     * Creates new record for the given entity.
     *
     * @param entity Entity
     */
    void create(ENTITY entity);

    /**
     * Updates the given entity.
     *
     * @param entity Entity
     */
    void update(ENTITY entity);

    /**
     * Deletes the entity having the specified ID.
     *
     * @param id Entity ID
     */
    void delete(IDTYPE id);
}
