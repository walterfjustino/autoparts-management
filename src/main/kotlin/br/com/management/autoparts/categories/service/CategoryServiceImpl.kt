package br.com.management.autoparts.categories.service

import br.com.management.autoparts.categories.exceptions.CategoryNotFoundException
import br.com.management.autoparts.categories.mapper.CategoryMapper
import br.com.management.autoparts.categories.model.Category
import br.com.management.autoparts.categories.model.dto.CategoryDTO
import br.com.management.autoparts.categories.repository.CategoryRepository
import org.springframework.stereotype.Service
import org.springframework.util.ReflectionUtils
import java.lang.reflect.Field
import java.util.stream.Collectors

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
          val foundCategory = repository.getReferenceById(id)
        return  mapper.toDTO(foundCategory)
    }

    override fun getAll() : List<CategoryDTO>{
        return repository.findAll()
            .map(mapper::toDTO)
            .toList()

    }

    override fun update(id: Long, categoryDTO: CategoryDTO) : CategoryDTO {
        val foundCategoryDTO = repository.findById(id)
            .map {
                it.copy(
                    name = categoryDTO.name,
                    active = categoryDTO.active,
                    type = categoryDTO.type
                )}.orElseThrow { CategoryNotFoundException(id) }
         return mapper.toDTO(repository.save(foundCategoryDTO))
    }

    override fun updatePartial(id: Long, fields: Map<String, Any>): CategoryDTO {
        val foundCategoryDTO = repository.getReferenceById(id);
        fields.forEach{ (key, value) ->
            val findField = ReflectionUtils.findField(Category::class.java, key)!!
            findField.setAccessible(true);
            ReflectionUtils.setField(findField, foundCategoryDTO, value);
        }
        return mapper.toDTO(repository.save(foundCategoryDTO))
    }

    override fun delete(id: Long) {
        getById(id)
        repository.deleteById(id);
    }

}