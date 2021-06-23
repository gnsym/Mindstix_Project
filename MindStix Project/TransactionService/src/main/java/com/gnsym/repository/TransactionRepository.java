package com.gnsym.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gnsym.entity.TransactionMaster;

@Repository
public interface TransactionRepository extends MongoRepository<TransactionMaster, String>{
Optional<TransactionMaster> findByAccountId(long accountId);
}
