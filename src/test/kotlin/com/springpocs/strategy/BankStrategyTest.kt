package com.springpocs.strategy

import com.springpocs.strategy.facades.BankEnum
import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BankStrategyTest(
    @Autowired private val bankStrategy: BankStrategy
) {
    @Test
    fun `it gets BANK1`() {
        val bankFacade = bankStrategy.get(BankEnum.BANK1)
        bankFacade.getBankName() `should be equal to` "Jonathan"
    }

    @Test
    fun `it gets BANK2`() {
        val bankFacade = bankStrategy.get(BankEnum.BANK2)
        bankFacade.getBankName() `should be equal to` "Maria da Penha"
    }
}
