package com.aninfo.service;

import com.aninfo.exceptions.DepositNegativeSumException;
import com.aninfo.exceptions.InsufficientFundsException;
import com.aninfo.model.Transaction;
import com.aninfo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository TransactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return TransactionRepository.save(transaction);
    }

    public Optional<Transaction> getTransaction(Long id) {
        return TransactionRepository.findById(id);
    }

    public Collection<Transaction> getTransactionsFromAccount(Long cbu) {
        return TransactionRepository.findAll().stream()
        .filter(transaction -> transaction.getAccount().equals(cbu))
        .collect(Collectors.toList());

    }

    public void save(Transaction transaction) {
        TransactionRepository.save(transaction);
    }

    public void deleteById(Long id) {
        TransactionRepository.deleteById(id);
    }

}
