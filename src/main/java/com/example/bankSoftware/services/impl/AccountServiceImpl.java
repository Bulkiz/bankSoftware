package com.example.bankSoftware.services.impl;

import com.example.bankSoftware.entities.Account;
import com.example.bankSoftware.services.AccountService;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


@Transactional
@Service
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    EntityManager em;
    @Override
    public Account createAccount(Account account) {
        account.setId(null);
        em.persist(account);
        return account;
    }

    @Override
    public List<Account> findAll() {
       List<Account> accounts = em.createQuery("select a from Account as a")
               .setMaxResults(100).getResultList();
        return accounts;
    }

    @Override
    public BigDecimal getBalance(Integer id) {
        return em.find(Account.class, id).getBalance();
    }


}
