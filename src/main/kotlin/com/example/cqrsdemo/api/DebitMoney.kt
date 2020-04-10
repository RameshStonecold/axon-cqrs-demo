package com.example.cqrsdemo.api

import org.axonframework.modelling.command.TargetAggregateIdentifier


data class DebitMoneyToBankAccCmd(@TargetAggregateIdentifier
                                  val id: String,
                                  var bankName: String, val debitAmount:Double, val balance: Double)

data class DebitMoneyToBankAccEvent(val id: String, var bankName: String,val debitAmount:Double, val balance: Double)


data class DebitMoneyToBankAccDto(val id: String, var bankName: String,val debitAmount:Double, val balance: Double)
