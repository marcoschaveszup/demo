package com.example.demo.exceptions.handler

import com.example.demo.exceptions.CarAlreadyExistsException
import com.example.demo.exceptions.CarNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.*

@ControllerAdvice
class ControllerAdviceRequestError : ResponseEntityExceptionHandler() {
    @ExceptionHandler(value = [(CarNotFoundException::class)])
    fun carNotFound(ex: CarNotFoundException, request: WebRequest): ResponseEntity<ErrorsDetails> {
        val errorDetails = ErrorsDetails(Date(),
                "Validation Failed",
                ex.message!!
        )
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [(CarAlreadyExistsException::class)])
    fun carAlreadyExists(ex: CarAlreadyExistsException, request: WebRequest): ResponseEntity<ErrorsDetails> {
        val errorDetails = ErrorsDetails(Date(),
                "Validation Failed",
                ex.message!!
        )
        return ResponseEntity(errorDetails, HttpStatus.CONFLICT)
    }
}