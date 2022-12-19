package com.example.bankSoftware.services.impl;

import com.example.bankSoftware.entities.Account;
import com.example.bankSoftware.services.AccountService;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    EntityManager em;
    @Transactional
    @Override
    public Account createAccount(Account newAccount) {
        newAccount.setId(null);
        newAccount.setCreateDate(LocalDateTime.now());
        em.persist(newAccount);
        return newAccount;
    }
    @Override
    public List<Account> findAll() {
      return em.createNamedQuery("Account.findAll", Account.class)
               .setMaxResults(100).getResultList();
    }
    @Override
    public BigDecimal getBalance(Integer accountId) {
        return em.find(Account.class, accountId).getBalance();
    }


}
