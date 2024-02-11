package br.com.management.autoparts.categories.mapper

import br.com.management.autoparts.categories.model.Category
import br.com.management.autoparts.categories.model.dto.CategoryDTO
import org.springframework.stereotype.Component

@Component
class CategoryMapper : Mapper<CategoryDTO, Category>{

    override fun toModel(t: CategoryDTO): Category {
        return Category(
            id = t.id,
            name = t.name,
            active = t.active,
            type = t.type
        )
    }

    override fun toDTO(u: Category): CategoryDTO {
        return CategoryDTO(
            id = u.id,
            name = u.name,
            active = u.active,
            type = u.type
        )
    }
}
