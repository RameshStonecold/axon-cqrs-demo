package com.example.cqrsdemo.query

import com.example.cqrsdemo.query.model.BankState
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@EnableMongoRepositories
interface IBankRepo : MongoRepository<BankState,String> {
}
