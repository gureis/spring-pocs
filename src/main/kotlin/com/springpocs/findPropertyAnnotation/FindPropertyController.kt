package com.springpocs.findPropertyAnnotation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fp")
class FindPropertyController {
    @PostMapping
    @FindProperty("employee.cpf", WhereToFindProperty.BODY)
    fun findPropertyOnBody(@RequestBody request: FindPropertyRequest): String {
        return "Hello World ${request.employee.cpf}"
    }

    @GetMapping("/{name}")
    @FindProperty("documentCode", WhereToFindProperty.REQUEST_PARAM)
    fun findPropertyOnParams(@RequestParam documentCode: String, @PathVariable("name") name: String): String {
        return "Hello $name with document $documentCode"
    }
}