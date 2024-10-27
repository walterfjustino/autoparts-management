package br.com.management.autoparts.categories.exceptions

import br.com.management.autoparts.categories.enums.ExceptionMessagesEnum
import jakarta.persistence.EntityNotFoundException

class CategoryNotFoundException : EntityNotFoundException {
    constructor(id: Long?) : super(
        java.lang.String.format(
            ExceptionMessagesEnum.CATEGORY_ID_NOT_FOUND.message,
            id
        )
    )

    constructor(name: String?) : super(
        java.lang.String.format(
            ExceptionMessagesEnum.CATEGORY_BY_NAME_NOT_FOUND.message,
            name
        )
    )
}