package com.springpocs.strategy

import com.springpocs.strategy.facades.BankEnum
import com.springpocs.strategy.facades.BankFacadeInterface
import org.springframework.stereotype.Component
import java.lang.Exception

@Component
class BankStrategy(facades: Set<BankFacadeInterface>) {
    private val strategies: MutableMap<BankEnum, BankFacadeInterface> = mutableMapOf()

    init {
        facades.forEach {
            this.strategies[it.name] = it
        }
    }

    fun get(bank: BankEnum): BankFacadeInterface {
        return strategies[bank]
            ?: throw Exception()
    }
}
