package com.springpocs.coroutines

import kotlinx.coroutines.delay
import org.springframework.stereotype.Component

@Component
class ParallelUseCase {
    suspend fun execute(params: Map<String, String>): String {
        val delay = params["delay"]?.toLong()
            ?: 2000

        delay(delay)

        return params["result"] ?: "DefaultResult"
    }
}
