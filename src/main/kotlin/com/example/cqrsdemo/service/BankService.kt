package com.example.cqrsdemo.service

import com.example.cqrsdemo.api.CreateBankAccountCmd
import com.example.cqrsdemo.util.BankDto
import org.axonframework.commandhandling.gateway.CommandGateway
import org.axonframework.messaging.responsetypes.ResponseTypes
import org.axonframework.queryhandling.QueryGateway
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class BankService( private val commandGateway:CommandGateway,
                   private val queryGateway: QueryGateway) {

    fun createBankAcc(cmd:CreateBankAccountCmd):CompletableFuture<String>{
        return commandGateway.send<Any>(cmd).
                thenApply { "Created Successfully ${cmd.id}" }.
                exceptionally { x->x.message }
    }

    fun getById(id:String):CompletableFuture<BankDto>{
        val bankAcc = queryGateway.query("findByBankId",id,ResponseTypes.instanceOf(BankDto::class.java))
        return bankAcc.thenApply{ x->
            if(x.id!=null) x
            else null
        }
    }



/*val allBankHolders = queryGateway.query("findAll",null, ResponseTypes.multipleInstancesOf(BankDto::class.java))
        allBankHolders.thenApply{ r->
            if(r.size>1){

            }else{

            }
        }*/
}
