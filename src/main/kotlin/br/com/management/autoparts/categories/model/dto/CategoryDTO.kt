package br.com.management.autoparts.categories.model.dto

import jakarta.validation.constraints.NotEmpty

data class CategoryDTO(
    val id: Long,
    @field:NotEmpty
    val name: String,
    val active: Boolean,
    val type: String
)