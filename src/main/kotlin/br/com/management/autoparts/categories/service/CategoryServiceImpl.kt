package br.com.management.autoparts.categories.service

import br.com.management.autoparts.categories.exceptions.CategoryNotFoundException
import br.com.management.autoparts.categories.mapper.CategoryMapper
import br.com.management.autoparts.categories.model.dto.CategoryDTO
import br.com.management.autoparts.categories.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
    private val repository: CategoryRepository,
    private val mapper: CategoryMapper
) : CategoryService {

    override fun createCategory(categoryDTO: CategoryDTO): CategoryDTO {
        return mapper.toDTO(repository.save(mapper.toModel(categoryDTO)));
    }

    override fun getByName(name: String): CategoryDTO {
        val foundCategory = repository.findByName(name)
            .orElseThrow { CategoryNotFoundException(name) }
        return mapper.toDTO(foundCategory)
    }

    override fun getById(id: Long): CategoryDTO {
        val foundCategory = repository.findById(id)
            .orElseThrow { CategoryNotFoundException(id) }
        return  mapper.toDTO(foundCategory)
    }

    override fun getAll() : List<CategoryDTO>{
        return repository.findAll()
            .map(mapper::toDTO)
            .toList()

    }

    override fun update(categoryDTO: CategoryDTO) : CategoryDTO {
        val foundCategoryDTO = getById(categoryDTO.id)
        val updateCategory = foundCategoryDTO.copy(
            id = categoryDTO.id,
            name = categoryDTO.name,
            active = categoryDTO.active,
            type = categoryDTO.type)
        return mapper.toDTO(repository.save(mapper.toModel(updateCategory)))
    }

    override fun delete(id: Long) {
        getById(id)
        repository.deleteById(id);
    }
}