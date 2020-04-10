package com.example.cqrsdemo.query

import com.example.cqrsdemo.api.CreateBankAccountEvent
import com.example.cqrsdemo.api.CreditMoneyToAccEvent
import com.example.cqrsdemo.api.DebitMoneyToBankAccEvent
import com.example.cqrsdemo.query.model.BankState
import com.example.cqrsdemo.util.BankConverter
import org.axonframework.eventhandling.EventHandler
import org.axonframework.queryhandling.QueryGateway
import org.axonframework.queryhandling.QueryHandler
import org.springframework.stereotype.Component

@Component
class BankProjection(private val iBankRepo: IBankRepo,
                     private val queryGateWay:QueryGateway) {

    @EventHandler
    fun on(createBankAccEvent:CreateBankAccountEvent){
        iBankRepo.save(BankConverter().convertCreateBankEventToModel(createBankAccEvent))
    }

    @EventHandler
    fun on(event: CreditMoneyToAccEvent){
       val bankOptional = iBankRepo.findById(event.id).map {x->
           x.id = event.id
           x.bankName = event.bankName
           x.creditAmount = event.creditAmount
           x.balance = event.balance
           x
       }
        iBankRepo.save(bankOptional.get())
    }

    @EventHandler
    fun on(event:DebitMoneyToBankAccEvent){
        val bank = iBankRepo.findById(event.id).map {x->
            x.id = event.id
            x.bankName = event.bankName
            x.debitAmount = event.debitAmount
            x.balance = event.balance
            x
        }
        iBankRepo.save(bank.get())
    }


    @QueryHandler(queryName = "findAll")
    fun findAll():List<BankState>{
       return iBankRepo.findAll()
    }

    @QueryHandler(queryName = "findByBankId")
    fun findById(id:String):BankState{
        return iBankRepo.findById(id).orElse(null)
    }

    /*@QueryHandler(queryName="findAllMoneyCreditedBankHolders")
    fun findAllMoneyCreditedAcc()*/

}
