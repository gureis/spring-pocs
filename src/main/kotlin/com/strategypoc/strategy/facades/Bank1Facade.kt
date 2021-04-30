package com.strategypoc.strategy.facades

import org.springframework.stereotype.Component

@Component("BANK1")
class Bank1Facade : BankFacadeInterface {
    override val name: BankEnum = BankEnum.BANK1

    override fun getBankName(): String {
        return "Jonathan"
    }
}
