package com.example.bankSoftware;

import com.example.bankSoftware.entities.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "select e from Account e where "
            + ":id is null or cast( e.id as string ) like concat (cast(:id as string ), '%') and "
            + ":firstName is null or cast( e.firstName as string ) like concat (cast(:firstName as string ), '%') and "
            + ":lastName is null or lower(e.lastName) like concat (cast(:lastName as string ), '%') and "
            + ":iban is null or lower(e.iban) like concat (cast(:iban as string ), '%') and "
            + ":createDate = e.createDate and "
            + ":balance is null or cast( e.balance as string ) like concat (cast(:balance as string ), '%')",
            countQuery = ( "select count(e) from Account e where "
                    + ":id is null or cast( e.id as string ) like concat (cast(:id as string ), '%') and "
                    + ":firstName is null or cast( e.firstName as string ) like concat (cast(:firstName as string ), '%') and "
                    + ":lastName is null or lower(e.lastName) like concat (cast(:lastName as string ), '%') and "
                    + ":iban is null or lower(e.iban) like concat (cast(:iban as string ), '%') and "
                    + ":createDate = e.createDate and "
                    + ":balance is null or cast( e.balance as string ) like concat (cast(:balance as string ), '%')"))
    Page<Account> findAllPaged(@Param("id") Integer id,
                                      @Param("firstName") String firstName,
                                      @Param("lastName") String lastName,
                                      @Param("iban") String iban,
                                      @Param("createDate") LocalDateTime createDate,
                                      @Param("balance") BigDecimal balance,
                                      Pageable pageable);

}

