package com.example.cqrsdemo.controller

import com.example.cqrsdemo.service.BankService
import com.example.cqrsdemo.api.CreateBankAccountDto
import com.example.cqrsdemo.util.BankConverter
import com.example.cqrsdemo.util.BankDto
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.concurrent.CompletableFuture

@RestController("/bank")
class BankAccountController {

    @Autowired
    lateinit var bankService: BankService
    val LOGGER = LoggerFactory.getLogger(BankAccountController::class.java)

    @PostMapping("/createBankAccount")
    fun createBankAcc(@RequestBody createBankAccountDto: CreateBankAccountDto):CompletableFuture<String>{
       val result = bankService.createBankAcc(BankConverter().createDtoToCmd(createBankAccountDto))
        LOGGER.info("Bank Account Created.")
        return result
    }

    @GetMapping("/getById/{id}")
    fun getById(@PathVariable("id")id:String):CompletableFuture<BankDto>{
      return  bankService.getById(id)
    }


}
