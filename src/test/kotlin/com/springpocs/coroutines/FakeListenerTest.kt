package com.springpocs.coroutines

import org.amshove.kluent.`should be equal to`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FakeListenerTest(
    @Autowired val listener: FakeListener
) {
    @Test
    fun `it should resolve both coroutines in parallel`() {
        val message1 = mapOf(
            "result" to "FirstResult",
            "delay" to "3000"
        )

        val message2 = mapOf("result" to "SecondResult")

        val result = listener.handle(message1, message2)

        result.size `should be equal to` 2
        result[0] `should be equal to` message1["result"]
        result[1] `should be equal to` message2["result"]
    }
}
