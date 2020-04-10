package com.example.cqrsdemo.util

data class BankDto (
    var id :String?=null,
    var bankAccNo:String?=null,
    var bankName:String?=null,
    var accountHolderName:String?=null,
    var creditAmount:Double?=null,
    var debitAmount:Double?=null,
    var balance:Double?=null
)
