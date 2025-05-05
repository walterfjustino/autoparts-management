package br.com.management.autoparts.categories.service.impl

import br.com.management.autoparts.categories.service.CategoryService
import br.com.management.autoparts.entities.domain.Category
import br.com.management.autoparts.entities.dto.CategoryDTO
import br.com.management.autoparts.entities.exceptions.CategoryNotFoundException
import br.com.management.autoparts.entities.logger
import br.com.management.autoparts.entities.mapper.CategoryMapper
import br.com.management.autoparts.entities.repository.CategoryRepository
import org.springframework.data.domain.*
import org.springframework.stereotype.Service
import org.springframework.util.ReflectionUtils


@Service
class CategoryServiceImpl(
    private val repository: CategoryRepository,
    private val mapper: CategoryMapper
): CategoryService {

    private val serviceName = "CategoryServiceImpl"

    override fun createCategory(categoryDTO: CategoryDTO): CategoryDTO {
        val methodName = "createCategory"

        logger.info("[START][$serviceName][$methodName][categoryDTO:$categoryDTO]")

        val toModel = mapper.toModel(categoryDTO)

        return mapper.toDTO(repository.save(toModel)).also {
            logger.info("[END][$serviceName][$methodName]")
        }
    }

    override fun getByName(name: String): CategoryDTO {
        val methodName = "getByName"

        logger.info("[START][$serviceName][$methodName][name:$name]")

        val foundCategory = repository.findByName(name)
            .orElseThrow { CategoryNotFoundException(name) }

        return mapper.toDTO(foundCategory).also {
            logger.info("[END][$serviceName][$methodName][response:$it]")
        }
    }

    override fun getById(id: Long): CategoryDTO {
        val methodName = "getById"

        logger.info("[START][$serviceName][$methodName][name:$id]")

          val foundCategory = repository.getReferenceById(id)
        return  mapper.toDTO(foundCategory).also {
            logger.info("[END][$serviceName][$methodName][response:$it]")

        }
    }

    override fun getAll() : List<CategoryDTO>{
        val methodName = "getAll"

        logger.info("[START][$serviceName][$methodName]")

        return repository.findAll()
            .map(mapper::toDTO)
            .toList().also {
                logger.info("[END][$serviceName][$methodName][response:$it]")
            }
    }

    override fun pageGetFilter(searchTerm: String, page: Int, size: Int): Page<CategoryDTO> {
        val methodName = "pageGetFilter"

        logger.info("[START][$serviceName][$methodName][searchTerm:$searchTerm][page:$page][size:$size]")

        val pageRequest = PageRequest.of(page, size, Sort.Direction.ASC,"name")
        return repository.search(searchTerm.lowercase(), pageRequest)
            .map(mapper::toDTO).also {
                logger.info("[END][$serviceName][$methodName][response:$it]")
            }
    }

    override fun pageGetAll(): Page<CategoryDTO> {
        val methodName = "pageGetAll"

        logger.info("[START][$serviceName][$methodName]")

        val sort = Sort.by(Sort.Direction.ASC, "id")
        val page = Pageable.ofSize(20).getSortOr(sort)
        return PageImpl(repository.findAll(page)
            .stream()
            .map(mapper::toDTO)
            .toList()).also {
            logger.info("[END][$serviceName][$methodName][response:$it]")
        }
    }

    override fun update(id: Long, categoryDTO: CategoryDTO) : CategoryDTO {
        val methodName = "update"

        logger.info("[START][$serviceName][$methodName][id:$id][categoryDTO:$categoryDTO]")

        val foundCategoryDTO = repository.findById(id)
            .map {
                it.copy(
                    name = categoryDTO.name,
                    active = categoryDTO.active,
                    type = categoryDTO.type
                )}.orElseThrow { CategoryNotFoundException(id) }
         return mapper.toDTO(repository.save(foundCategoryDTO)).also {

         }
    }

    override fun updatePartial(id: Long, fields: Map<String, Any>): CategoryDTO {
        val methodName = "updatePartial"

        logger.info("[START][$serviceName][$methodName][id:$id][fields:$fields]")

        val foundCategoryDTO = repository.getReferenceById(id)
        fields.forEach{ (key, value) ->
            val findField = ReflectionUtils.findField(Category::class.java, key)!!
            findField.setAccessible(true);
            ReflectionUtils.setField(findField, foundCategoryDTO, value)
        }
        return mapper.toDTO(repository.save(foundCategoryDTO)).also {
            logger.info("[END][$serviceName][$methodName][response:$it]")
        }
    }

    override fun delete(id: Long) {
        val methodName = "delete"

        logger.info("[START][$serviceName][$methodName][id:$id]")

        getById(id)
        repository.deleteById(id).also {
            logger.info("[END][$serviceName][$methodName][response:$it]")
        }
    }

}