package br.com.management.autoparts.categories.gateway

import br.com.management.autoparts.categories.service.CategoryService
import br.com.management.autoparts.entities.dto.CategoryDTO
import br.com.management.autoparts.gateway.categories.GatewayCategoryService
import org.springframework.stereotype.Service

@Service
class GatewayCategoryServiceImpl(
    private val service: CategoryService,
): GatewayCategoryService {

    override fun createCategory(categoryDTO: CategoryDTO) = service.createCategory(categoryDTO)

    override fun getByName(name: String) = service.getByName(name)

    override fun getById(id: Long) = service.getById(id)

    override fun getAll() = service.getAll()

    override fun pageGetFilter(searchTerm: String, page: Int, size: Int) = service.pageGetFilter(searchTerm, page, size)

    override fun pageGetAll() = service.pageGetAll()

    override fun update(id: Long, categoryDTO: CategoryDTO) = service.update(id, categoryDTO)

    override fun updatePartial(id: Long, fields: Map<String, Any>) = service.updatePartial(id, fields)

    override fun delete(id: Long) = service.delete(id)

}