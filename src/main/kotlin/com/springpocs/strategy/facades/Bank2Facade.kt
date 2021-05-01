package com.springpocs.strategy.facades

import org.springframework.stereotype.Component

@Component
class Bank2Facade : BankFacadeInterface {
    override val name: BankEnum = BankEnum.BANK2

    override fun getBankName(): String {
        return "Maria da Penha"
    }
}
