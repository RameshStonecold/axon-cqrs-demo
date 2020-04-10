package com.example.cqrsdemo.api

import org.axonframework.modelling.command.TargetAggregateIdentifier


data class CreditMoneyToAccCommand(@TargetAggregateIdentifier
                                   val id: String,
                                   var bankName: String, val creditAmount:Double,val balance: Double)

data class CreditMoneyToAccEvent(val id: String, var bankName: String,val creditAmount:Double, val balance: Double)

data class CreditMoneyToAccDto(val id: String, var bankName: String,val creditAmount:Double, val balance: Double)


