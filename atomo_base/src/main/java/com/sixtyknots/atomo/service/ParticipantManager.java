package com.sixtyknots.atomo.service;

import com.sixtyknots.atomo.db.entity.Participant;
import com.sixtyknots.atomo.util.AtomoException;

/**
 * ParticipantManager provides all participant-specific handling methods.
 *   
 * @author Miroslav Plese
 */
public interface ParticipantManager {
    /**
     * Creates a new participant using the provided object data.
     *
     * @param participant Participant object
     * @return Participant ID
     * @throws com.sixtyknots.atomo.util.AtomoException -
     */
    public String create(Participant participant) throws AtomoException;

    /**
     * Returns a participant having the specified ID.
     *
     * @param id Participant ID
     * @return Participant object
     */
    public Participant get(String id);

    /**
     * Updates a participant with the provided object data.
     *
     * @param participant Participant object
     * @throws com.sixtyknots.atomo.util.AtomoException -
     */
    public void update(Participant participant) throws AtomoException;

    /**
     * Deletes a participant having the specified ID.
     *
     * @param id Participant ID
     * @throws com.sixtyknots.atomo.util.AtomoException -
     */
    public void delete(String id) throws AtomoException;
}
