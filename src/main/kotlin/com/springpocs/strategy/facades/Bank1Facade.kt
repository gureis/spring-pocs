package com.springpocs.strategy.facades

import org.springframework.stereotype.Component

@Component
class Bank1Facade : BankFacadeInterface {
    override val name: BankEnum = BankEnum.BANK1

    override fun getBankName(): String {
        return "Jonathan"
    }
}
