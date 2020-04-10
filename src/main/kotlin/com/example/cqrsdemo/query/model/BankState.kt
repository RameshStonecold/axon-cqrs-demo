package com.example.cqrsdemo.query.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class BankState (
        @Id
        var id :String?=null,
        var bankAccNo:String?=null,
        var bankName:String?=null,
        var accountHolderName:String?=null,
        var creditAmount:Double?=null,
        var debitAmount:Double?=null,
        var balance:Double?=null
)
