package com.springpocs.configurations

import org.springframework.stereotype.Component
import org.springframework.util.StreamUtils
import org.springframework.web.filter.OncePerRequestFilter
import java.io.ByteArrayInputStream
import java.io.InputStream
import javax.servlet.FilterChain
import javax.servlet.ReadListener
import javax.servlet.ServletInputStream
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletRequestWrapper
import javax.servlet.http.HttpServletResponse

@Component
class CachedRequestBodyFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val cachedBodyHttpServletRequest = CachedBodyHttpServletRequest(request)
        filterChain.doFilter(cachedBodyHttpServletRequest, response)
    }
}


class CachedBodyHttpServletRequest(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
    private val cachedBody: ByteArray

    init {
        val requestInputStream: InputStream = request.inputStream
        cachedBody = StreamUtils.copyToByteArray(requestInputStream)
    }

    override fun getInputStream(): ServletInputStream {
        return CachedBodyServletInputStream(cachedBody)
    }
}


class CachedBodyServletInputStream(cachedBody: ByteArray?) : ServletInputStream() {
    private val cachedBodyInputStream: InputStream

    init {
        cachedBodyInputStream = ByteArrayInputStream(cachedBody)
    }

    override fun read(): Int {
        return cachedBodyInputStream.read()
    }

    override fun isFinished(): Boolean {
        return cachedBodyInputStream.available() == 0
    }

    override fun isReady(): Boolean {
        return true
    }

    override fun setReadListener(listener: ReadListener?) {}
}