package br.com.management.autoparts.entities.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class ErrorResponse private constructor(
    val code: Int?,
    val status: String?,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    val timestamp: LocalDateTime?,
    val message: String?,
    val errors: List<String>?) {

    data class Builder(
        var code: Int? = null,
        var status: String? = null,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
        var timestamp: LocalDateTime? = null,
        var message: String? = null,
        var errors: List<String>? = null){

        fun withCode(code: Int) = apply{ this.code = code }
        fun withStatus(status: String) = apply { this.status = status }
        fun withTimestamp(timestamp: LocalDateTime) = apply { this.timestamp = timestamp }
        fun withMessage(message: String) = apply { this.message = message}
        fun withErrors(errors: List<String>) = apply { this.errors = errors }
        fun build() = ErrorResponse(code, status, timestamp, message, errors)
    }
}