package br.com.management.autoparts.web.handler

import br.com.management.autoparts.entities.domain.ApiError
import br.com.management.autoparts.entities.exceptions.CategoryNotFoundException
import org.springframework.context.MessageSource
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.time.LocalDateTime
import java.util.*

@RestControllerAdvice
class ExceptionHandler( val messageSource: MessageSource): ResponseEntityExceptionHandler() {


    @ExceptionHandler(CategoryNotFoundException::class)
    fun handleCategoryNotFoundException(ex: CategoryNotFoundException): ResponseEntity<Any?> {

        return buildResponseEntity(HttpStatus.NOT_FOUND,ex.message, mutableListOf(ex.localizedMessage))

    }

    private fun getMessageProperties(ex: Exception?) = ex?.message?.let {
        messageSource.getMessage(
            it, null, ex.message ?: "server.error", Locale.getDefault()
        )
    }

    private fun buildResponseEntity(httpStatus: HttpStatus, message: String?, errors: MutableList<String?>): ResponseEntity<Any?> {
        val error = ApiError(
            code = httpStatus.value(),
            status = httpStatus.reasonPhrase,
            timestamp = LocalDateTime.now(),
            message = message,
            errors = errors
        )
        return ResponseEntity.status(httpStatus).body(error)
    }

}