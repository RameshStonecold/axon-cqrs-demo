package com.example.cqrsdemo.command

import com.example.cqrsdemo.api.*
import com.example.cqrsdemo.util.ConverterCmdToEvent
import org.axonframework.commandhandling.CommandHandler
import org.axonframework.eventsourcing.EventSourcingHandler
import org.axonframework.modelling.command.AggregateIdentifier
import org.axonframework.spring.stereotype.Aggregate
import org.slf4j.LoggerFactory
import java.lang.IllegalStateException
import org.axonframework.modelling.command.AggregateLifecycle.apply


@Aggregate
class BankAccount {

    private val LOG= LoggerFactory.getLogger(BankAccount::class.java)

    @AggregateIdentifier
    var id :String?=null
    var bankAccNo:String?=null
    var bankName:String?=null
    var accountHolderName:String?=null
    var creditAmount:Double?=null
    var debitAmount:Double?=null
    var balance:Double?=null

   constructor()

    /*
    This command handling function(constructor) tells the axon frame work
    registered to the command Bus being capable of handling commands i.e Create Bank Account Command
    * */
    @CommandHandler
  constructor(createBankAccountCmd: CreateBankAccountCmd){
        if(createBankAccountCmd.id!=null) {
            apply(ConverterCmdToEvent().convertCmdToEvent(createBankAccountCmd))
        }else{
            throw IllegalStateException("Invalid Details entered")
        }
 }

    @EventSourcingHandler
    fun handle(event: CreateBankAccountEvent){
        this.id = event.id
        this.bankAccNo = event.bankAccNo
        this.bankName = event.bankName
        this.accountHolderName = event.accountHolderName
        this.balance = event.balance
        LOG.info("Bank Account id "+ event.id)
    }


    @CommandHandler
    fun handler(creditMoneyCmd: CreditMoneyToAccCommand){
        if(creditMoneyCmd.balance>0.0){
        apply(ConverterCmdToEvent().convertCreditMoneyCmdToEvent(creditMoneyCmd))
        }else{
            throw IllegalStateException("Deposit must be positive numbers")
        }
    }

    @EventSourcingHandler
    fun handle(event: CreditMoneyToAccEvent){
        this.id = event.id
        this.bankName = event.bankName
        this.creditAmount = event.creditAmount
        this.balance = event.balance
        LOG.info("${event.creditAmount}/- added to Bank Account")
    }

    @CommandHandler
    fun handler(cmd: DebitMoneyToBankAccCmd){
        apply(ConverterCmdToEvent().convertDebitMoneyCmdToEvent(cmd))
    }
    @EventSourcingHandler
    fun handle(event: DebitMoneyToBankAccEvent){
        this.id = event.id
        this.bankName = event.bankName
        this.debitAmount = event.debitAmount
        this.balance = event.balance
        LOG.info("Current balance after amount debited ${event.balance}")
    }


}
