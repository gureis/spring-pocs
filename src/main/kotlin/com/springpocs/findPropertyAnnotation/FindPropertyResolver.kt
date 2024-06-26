package com.springpocs.findPropertyAnnotation

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.method.HandlerMethod
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.HandlerMapping
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
class FindPropertyResolver : HandlerInterceptor {
    override fun preHandle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        handler: Any
    ): Boolean {
        if (handler is HandlerMethod) {
            val method = handler.method
            val annotation = method.getAnnotation(FindProperty::class.java) ?: return true

            return when (annotation.where) {
                WhereToFindProperty.BODY -> findByBody(request, response, annotation)
                WhereToFindProperty.REQUEST_PARAM -> findByRequestParam(request, response, annotation)
                WhereToFindProperty.PATH_PARAM -> findByPathParam(request, response, annotation)
            }
        }

        return true
    }

    private fun findByBody(
        request: HttpServletRequest,
        response: HttpServletResponse,
        annotation: FindProperty
    ): Boolean {
        val propertyName = '/' + annotation.propertyPattern.replace('.', '/')

        val body = getRequestBody(request)

        val property = getPropertyFromRequestBody(body, propertyName)

        if (property != "0000342") {
            response.status = HttpStatus.FORBIDDEN.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.characterEncoding = "UTF-8"
            response.writer.write("""{"message":"can't do"}""")

            return false
        }

        return true
    }

    private fun findByRequestParam(
        request: HttpServletRequest,
        response: HttpServletResponse,
        annotation: FindProperty
    ): Boolean {
        val requestParam = request.getParameter(annotation.propertyPattern)

        if (requestParam != "0000342") {
            response.status = HttpStatus.FORBIDDEN.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.characterEncoding = "UTF-8"
            response.writer.write("""{"message":"can't do"}""")

            return false
        }

        return true
    }

    private fun findByPathParam(
        request: HttpServletRequest,
        response: HttpServletResponse,
        annotation: FindProperty
    ): Boolean {
        val pathParams = request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE) as LinkedHashMap<String, String>

        if (pathParams[annotation.propertyPattern] != "joão") {
            response.status = HttpStatus.FORBIDDEN.value()
            response.contentType = MediaType.APPLICATION_JSON_VALUE
            response.characterEncoding = "UTF-8"
            response.writer.write("""{"message":"can't do"}""")

            return false
        }

        return true
    }

    private fun getRequestBody(request: HttpServletRequest): String {
        return request.inputStream.bufferedReader().use { it.readText() }
    }

    fun getPropertyFromRequestBody(requestBody: String, propertyName: String): String? {
        val objectMapper = ObjectMapper()
        val jsonNode = objectMapper.readTree(requestBody)
        return jsonNode.at(propertyName).textValue()
    }
}


