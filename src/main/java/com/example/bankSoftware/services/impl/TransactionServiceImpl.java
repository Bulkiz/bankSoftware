package com.example.bankSoftware.services.impl;

import com.example.bankSoftware.entities.Account;
import com.example.bankSoftware.entities.Transaction;
import com.example.bankSoftware.services.TransactionService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void makeTransaction(
            Integer sourceAccountId, Integer destinationAccountId,
            BigDecimal transactionAmount) throws InterruptedException {

        Account sourceAccount = em.find(Account.class, sourceAccountId, LockModeType.PESSIMISTIC_WRITE);

        Account destinationAccount = em.find(Account.class, destinationAccountId, LockModeType.PESSIMISTIC_WRITE);
        Thread.sleep(2000);
        createTransaction(transactionAmount, sourceAccount, destinationAccount);

        createTransaction(transactionAmount.negate(), destinationAccount, sourceAccount);

    }
    //todo podrebna i parametur za smetka
    @Override
    public List<Transaction> findAll() throws InterruptedException {
        Thread.sleep(10000);
        return em.createQuery("select a from Transaction as a")
                .setMaxResults(100).getResultList();
    }
    @Override
    public List<Transaction> findById(Integer accountId) throws InterruptedException {
        Thread.sleep(10000);
       return em.createQuery("from Transaction where sourceAccount.id = ?1 " +
                       "order by creationDate desc").
               setParameter(1, accountId).setMaxResults(100).getResultList();
    }

    private void createTransaction(BigDecimal transactionAmount, Account sourceAccount,
                                   Account destinationAccount) {
        sourceAccount.addBalance(transactionAmount);
        em.persist(Transaction.builder().
                sourceAccount(sourceAccount)
                .destinationAccount(destinationAccount)
                .transactionAmount(transactionAmount)
                .creationDate(LocalDateTime.now())
                .build());
    }

}



