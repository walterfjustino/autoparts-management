package br.com.management.autoparts.entities.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

class ApiError(
    val code: Int,
    val status: String,
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    timestamp: LocalDateTime,
    val message: String?,
    val errors: MutableList<String?>
)

