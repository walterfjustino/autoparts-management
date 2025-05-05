//package br.com.management.autoparts.web.handler
//
//import jakarta.persistence.EntityExistsException
//import jakarta.persistence.EntityNotFoundException
//import org.springframework.http.HttpHeaders
//import org.springframework.http.HttpStatus
//import org.springframework.http.HttpStatusCode
//import org.springframework.http.ResponseEntity
//import org.springframework.http.converter.HttpMessageNotReadableException
//import org.springframework.validation.FieldError
//import org.springframework.validation.ObjectError
//import org.springframework.web.ErrorResponse
//import org.springframework.web.HttpRequestMethodNotSupportedException
//import org.springframework.web.bind.MethodArgumentNotValidException
//import org.springframework.web.bind.annotation.ExceptionHandler
//import org.springframework.web.bind.annotation.ResponseStatus
//import org.springframework.web.bind.annotation.RestControllerAdvice
//import org.springframework.web.context.request.WebRequest
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
//import java.time.LocalDateTime
//import java.util.*
//import java.util.function.Consumer
//
//@RestControllerAdvice
//class GlobalExceptionHandler : ResponseEntityExceptionHandler() {
//    @ExceptionHandler(EntityNotFoundException::class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    fun handleEntityNotFoundException(
//        ex: EntityNotFoundException
//    ): ResponseEntity<Any> {
//        return buildResponseEntity(
//            HttpStatus.NOT_FOUND,
//            ex.message.toString(),
//            listOf(ex.localizedMessage)
//        )
//    }
//
//    @ExceptionHandler(EntityExistsException::class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    fun handleEntityExistsxception(
//        ex: EntityExistsException): ResponseEntity<Any> {
//        return buildResponseEntity(
//            HttpStatus.BAD_REQUEST,
//            ex.message.toString(),
//            listOf(ex.localizedMessage)
//        )
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    override fun handleMethodArgumentNotValid(
//        ex: MethodArgumentNotValidException,
//        headers: HttpHeaders,
//        status: HttpStatusCode,
//        request: WebRequest
//    ): ResponseEntity<Any>? {
//        val errors: MutableList<String> = ArrayList()
//        ex.bindingResult
//            .fieldErrors
//            .forEach(Consumer { fieldError: FieldError ->
//                errors.add(
//                    "Field " + fieldError.field.uppercase(Locale.getDefault()) + " " + fieldError.defaultMessage
//                )
//            })
//        ex.bindingResult
//            .globalErrors
//            .forEach(Consumer { globalError: ObjectError -> errors.add("Object " + globalError.objectName + " " + globalError.defaultMessage) })
//
//        return buildResponseEntity(HttpStatus.BAD_REQUEST, "Informed argument(s) validation error(s)", errors)
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    override fun handleHttpMessageNotReadable(
//        ex: HttpMessageNotReadableException,
//        headers: HttpHeaders,
//        status: HttpStatusCode,
//        request: WebRequest
//    ): ResponseEntity<Any>? {
//        return buildResponseEntity(
//            HttpStatus.BAD_REQUEST, "Malformed JSON body and/or field error",
//            listOf(ex.localizedMessage)
//        )
//    }
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    override fun handleHttpRequestMethodNotSupported(
//        ex: HttpRequestMethodNotSupportedException,
//        headers: HttpHeaders,
//        status: HttpStatusCode,
//        request: WebRequest
//    ): ResponseEntity<Any>? {
//        return buildResponseEntity(HttpStatus.BAD_REQUEST, "Request Method not supported", listOf(ex.localizedMessage))
//    }
//
//    private fun buildResponseEntity(
//        httpStatus: HttpStatus,
//        message: String,
//        errors: List<String>
//    ): ResponseEntity<Any> {
//        val error: ErrorResponse = ErrorResponse.builder()
//            .withCode(httpStatus.value())
//            .withStatus(httpStatus.reasonPhrase)
//            .withMessage(message)
//            .withTimestamp(LocalDateTime.now())
//            .withErrors(errors)
//            .build()
//        return ResponseEntity.status(httpStatus).body(error)
//    }
//}
