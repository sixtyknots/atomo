package com.sixtyknots.atomo.test;

import com.sixtyknots.atomo.db.entity.Participant;
import com.sixtyknots.atomo.db.entity.Transaction;
import com.sixtyknots.atomo.service.ParticipantManager;
import com.sixtyknots.atomo.service.TransactionManager;
import com.sixtyknots.atomo.service.impl.ParticipantManagerImpl;
import com.sixtyknots.atomo.service.impl.TransactionManagerImpl;
import com.sixtyknots.atomo.util.AtomoException;
import com.sixtyknots.atomo.util.Constants;
import com.sixtyknots.atomo.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main entry point for the Atomo Test application.
 *
 * @author Miroslav Plese
 */
public class TestMain {
    private static final Logger log = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) throws AtomoException {
        ParticipantManager partyMgr = new ParticipantManagerImpl();
        TransactionManager txMgr = new TransactionManagerImpl();

        Participant sourceParty = new Participant();
        sourceParty.setId(StringUtils.generateRandomKey(Constants.DEFAULT_RANDOM_KEY_SIZE));
        sourceParty.setName("Miroslav");
        sourceParty.setIdparticipanttype("BUYER");
        partyMgr.create(sourceParty);

        log.debug("Source participant {} created with ID {}", sourceParty.getName(), sourceParty.getId());

        Participant targetParty = new Participant();
        targetParty.setId(StringUtils.generateRandomKey(Constants.DEFAULT_RANDOM_KEY_SIZE));
        targetParty.setName("Ivan");
        targetParty.setIdparticipanttype("MERCHANT");
        partyMgr.create(targetParty);

        log.debug("Target participant {} created with ID {}", targetParty.getName(), targetParty.getId());

        Transaction tx = new Transaction();
        tx.setIdparticipantsource(sourceParty.getId());
        tx.setIdparticipanttarget(targetParty.getId());
        tx.setIdtransactiontype("PAYMENT");
        tx.setIdtransactionstatustype("PENDING");

        txMgr.create(tx);

        log.debug("Transaction of type {} and status {} created with ID {}",
                  tx.getIdtransactiontype(), tx.getIdtransactionstatustype(), tx.getId());

        tx.setIdtransactionstatustype("EXECUTED");

        txMgr.update(tx);

        log.debug("Transaction with ID {} updated to status {}",
                  tx.getId(), tx.getIdtransactionstatustype());

        txMgr.delete(tx.getId());
        partyMgr.delete(targetParty.getId());
        partyMgr.delete(sourceParty.getId());

        log.debug("Participants and transactions deleted from DB");
    }
}
