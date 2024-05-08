package com.springpocs.findPropertyAnnotation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fp")
class FindPropertyController {
    @PostMapping
    @FindProperty("employee.cpf")
    fun findPropertyOnBody(@RequestBody request: FindPropertyRequest): String {
        return "Hello World ${request.employee.cpf}"
    }
}