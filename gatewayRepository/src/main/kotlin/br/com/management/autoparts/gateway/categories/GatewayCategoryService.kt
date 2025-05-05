package br.com.management.autoparts.gateway.categories

import br.com.management.autoparts.entities.dto.CategoryDTO
import org.springframework.data.domain.Page

interface GatewayCategoryService {

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