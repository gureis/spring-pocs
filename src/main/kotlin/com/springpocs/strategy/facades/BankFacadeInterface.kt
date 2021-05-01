package com.springpocs.strategy.facades

interface BankFacadeInterface {
    val name: BankEnum

    fun getBankName(): String
}
