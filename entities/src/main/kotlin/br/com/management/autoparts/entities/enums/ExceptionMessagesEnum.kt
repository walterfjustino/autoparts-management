package br.com.management.autoparts.categories.enums

import org.springframework.http.HttpStatus

enum class ExceptionMessagesEnum(val code: Int, val message: String, val httpStatus: HttpStatus) {
    CATEGORY_ID_NOT_FOUND(404001, "Category not found for the category id: %s informed", HttpStatus.NOT_FOUND),
    CATEGORY_BY_NAME_NOT_FOUND(404002, "Category not found for the category name: %s informed", HttpStatus.NOT_FOUND)
}