package com.springpocs.configurations

import com.springpocs.findPropertyAnnotation.FindPropertyResolver
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
class InterceptorConfig (
    private val findPropertyInterceptor: FindPropertyResolver
) : WebMvcConfigurer {

    override fun addInterceptors(interceptorRegistry: InterceptorRegistry) {
        interceptorRegistry.addInterceptor(findPropertyInterceptor)
    }
}