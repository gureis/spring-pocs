package com.strategypoc.strategy.facades

interface BankFacadeInterface {
    val name: BankEnum

    fun getBankName(): String
}
