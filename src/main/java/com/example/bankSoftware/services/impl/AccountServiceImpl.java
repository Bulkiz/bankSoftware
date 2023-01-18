package com.example.bankSoftware.services.impl;

import com.example.bankSoftware.AccountRepository;
import com.example.bankSoftware.dtos.AccountDto;
import com.example.bankSoftware.entities.Account;
import com.example.bankSoftware.services.AccountService;
import com.example.bankSoftware.utils.PageCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort.Order;

@Service
public class AccountServiceImpl implements AccountService {

    @PersistenceContext
    EntityManager em;

    @Autowired ModelMapper modelMapper;

    @Autowired AccountRepository accountRepository;
    @Transactional
    @Override
    public Account createAccount(Account newAccount) {
        newAccount.setId(null);
        newAccount.setCreateDate(LocalDateTime.now());
        em.persist(newAccount);
        return newAccount;
    }

    @Transactional
    @Override
    public Account updateAccount(Account account){
        account.setCreateDate(LocalDateTime.now());
        em.merge(account);
        return account;
    }

    @Override
    public Account findAccountById(Integer id) {
        return em.find(Account.class, id);
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

    @Transactional
    @Override
    public PageCustom<AccountDto> findAllPaged(Integer id, String firstName, String lastName,
                                            String iban, LocalDateTime creationDate, BigDecimal balance, Integer page, Integer size,
                                            List<String> sortBys, List<Sort.Direction> sortDirections){

        List<Order> orders = new ArrayList<>();
        if (!sortBys.isEmpty()) {
            if (sortBys.size() == sortDirections.size()) {
                for (int i = 0; i < sortBys.size(); i++) {
                    orders.add(new Order(sortDirections.get(i), sortBys.get(i)));
                }
            }
        }
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(orders));

        Page<AccountDto> accountPage = accountRepository.findAllPaged(id, firstName, lastName,
                        iban,
                        creationDate,
                        balance, pagingSort)
                .map(account -> modelMapper.map(account, AccountDto.class));

        return new PageCustom<>(accountPage);
    }


}
