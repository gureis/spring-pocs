package com.springpocs.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runBlocking
import org.springframework.stereotype.Component

@Component
class FakeListener(
    private val parallelUseCase: ParallelUseCase
) {
    fun handle(message1: Map<String, String>, message2: Map<String, String>) = runBlocking {
        val exec1 = async(Dispatchers.Default) { parallelUseCase.execute(message1) }

        val exec2 = async(Dispatchers.Default) { parallelUseCase.execute(message2) }

        val results = awaitAll(exec1, exec2)

        println("Both completed")

        return@runBlocking results
    }
}
