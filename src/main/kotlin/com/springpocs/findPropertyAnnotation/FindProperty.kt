package com.springpocs.findPropertyAnnotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class FindProperty(
    val propertyPattern: String,
    val where: WhereToFindProperty
)
