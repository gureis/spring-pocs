package com.springpocs.findPropertyAnnotation

import com.fasterxml.jackson.annotation.JsonProperty

data class FindPropertyRequest(
    @JsonProperty("employee", required = true)
    val employee: FindPropertyRequestEmployee
)

data class FindPropertyRequestEmployee(
    @JsonProperty("cpf", required = true)
    val cpf: String
)
