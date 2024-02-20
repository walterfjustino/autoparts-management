package br.com.management.autoparts.categories.model.dto

import jakarta.validation.constraints.NotEmpty

data class CategoryDTO (
    var id: Long,
    @field:NotEmpty
    var name: String,
    var active: Boolean,
//    @field:NotEmpty
    var type: String) {
}