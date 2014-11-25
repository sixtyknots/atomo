package com.sixtyknots.atomo.db.entity;

import com.sixtyknots.atomo.util.Assert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Entity representing "*type" tables, with one "name" field which contains
 * localized name of the type.
 *
 * @param <IDTYPE> Primary key type
 *
 * @author Miroslav Plese
 */
public class TypeEntity<IDTYPE> extends BaseEntity<IDTYPE> {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected String toPropertiesString() {
        return super.toPropertiesString() + ", name="+name;
    }

    /**
     * Converts TypeEntity list into a map of (Object id, String name) entries.
     *
     * @param entities List of TypeEntity objects
     * @return Map of (Object id, String name) entries
     */
    public static Map<Object, String> listToIdNameMap(List<TypeEntity> entities) {
        if (entities == null) {
            return null;
        }

        Map<Object, String> result = new LinkedHashMap<>();

        for (TypeEntity entity : entities) {
            Assert.notNull(entity.id, "Entity ID cannot be null");
            Assert.isFalse(result.containsKey(entity.id), "Duplicate entity ID");

            result.put(entity.id, entity.name);
        }

        return result;
    }

}
