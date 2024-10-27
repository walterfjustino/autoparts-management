package br.com.management.autoparts.categories.service

import br.com.management.autoparts.categories.model.dto.CategoryDTO
import org.springframework.data.domain.Page

interface CategoryService {

    fun createCategory(categoryDTO: CategoryDTO): CategoryDTO
    fun getByName(name: String): CategoryDTO
    fun getById(id: Long): CategoryDTO
    fun getAll() : List<CategoryDTO>
    fun pageGetFilter(searchTerm: String, page: Int, size: Int) : Page<CategoryDTO>
    fun pageGetAll() : Page<CategoryDTO>
    fun update(id: Long, categoryDTO: CategoryDTO): CategoryDTO
    fun updatePartial(id: Long, fields: Map<String, Any>): CategoryDTO
    fun delete(id: Long)
}