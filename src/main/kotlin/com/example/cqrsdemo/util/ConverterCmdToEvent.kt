package com.example.cqrsdemo.util

import com.example.cqrsdemo.api.*


class ConverterCmdToEvent {

  fun convertCmdToEvent(cmd: CreateBankAccountCmd):CreateBankAccountEvent{
        return CreateBankAccountEvent(cmd.id,cmd.bankAccNo,cmd.bankName, cmd.accountHolderName, cmd.balance)
    }

  fun convertCreditMoneyCmdToEvent(cmd:CreditMoneyToAccCommand):CreditMoneyToAccEvent{
      return CreditMoneyToAccEvent(cmd.id,cmd.bankName,cmd.creditAmount, cmd.balance)
  }

  fun convertDebitMoneyCmdToEvent(cmd: DebitMoneyToBankAccCmd):DebitMoneyToBankAccEvent{
      return DebitMoneyToBankAccEvent(cmd.id,cmd.bankName, cmd.debitAmount, cmd.balance)
  }

}
