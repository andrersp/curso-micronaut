package br.com.rspinfotec.exception

import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDateTime

@Serdeable
data class ErrorMessage(
    val datetime: String = LocalDateTime.now().toString(),
    val message: String
)
