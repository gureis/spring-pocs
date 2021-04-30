package com.strategypoc.strategy.facades

class Bank2Facade : BankFacadeInterface {
    override val name: BankEnum = BankEnum.BANK2

    override fun getBankName(): String {
        return "Maria da Penha"
    }
}
