package com.example.cqrsdemo.api

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.util.*

data class CreateBankAccountCmd( @TargetAggregateIdentifier
                                val id: String, var bankAccNo:String,
                                var bankName:String, var accountHolderName:String, val balance:Double)


data class CreateBankAccountEvent(val id: String, var bankAccNo:String,
                                  var bankName:String, var accountHolderName:String, val balance:Double)


data class CreateBankAccountDto(val id: String, var bankAccNo:String,
                                  var bankName:String, var accountHolderName:String, val balance:Double)
