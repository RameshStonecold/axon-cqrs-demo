package com.example.cqrsdemo.util

import com.example.cqrsdemo.api.*
import com.example.cqrsdemo.query.model.BankState

class BankConverter {

    // Dto To cmd
    fun createDtoToCmd(dto: CreateBankAccountDto): CreateBankAccountCmd {
        return CreateBankAccountCmd(dto.id,dto.bankAccNo,dto.bankName, dto.accountHolderName, dto.balance)
    }
    fun convertCreditMoneyDtoToCmd(dto: CreditMoneyToAccDto): CreditMoneyToAccCommand {
        return CreditMoneyToAccCommand(dto.id,dto.bankName,dto.creditAmount, dto.balance)
    }
    fun convertDebitMoneyDtoToCmd(dto: DebitMoneyToBankAccDto): DebitMoneyToBankAccCmd {
        return DebitMoneyToBankAccCmd(dto.id,dto.bankName, dto.debitAmount, dto.balance)
    }


// Event to Model
    fun convertCreateBankEventToModel(event: CreateBankAccountEvent): BankState {
        return BankState(event.id,event.bankAccNo,event.bankName, event.accountHolderName, 0.0,0.0,event.balance)
    }
    fun convertCreditMoneyEventToModel(event: CreditMoneyToAccEvent): BankState {
        return BankState(event.id,"",event.bankName,"",event.creditAmount, event.balance)
    }

    fun convertDebitMoneyEventToModel(event: DebitMoneyToBankAccEvent): BankState {
        return BankState(event.id,"",event.bankName, "",0.0,event.debitAmount, event.balance)
    }


}
