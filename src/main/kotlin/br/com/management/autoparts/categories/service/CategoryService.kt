package br.com.management.autoparts.categories.service

import br.com.management.autoparts.categories.model.dto.CategoryDTO

interface CategoryService {

    fun createCategory(categoryDTO: CategoryDTO): CategoryDTO
    fun getByName(name: String): CategoryDTO
    fun getById(id: Long): CategoryDTO
    fun getAll() : List<CategoryDTO>
    fun update(id: Long, categoryDTO: CategoryDTO): CategoryDTO
    fun updatePartial(id: Long, fields: Map<String, Any>): CategoryDTO
    fun delete(id: Long)
}