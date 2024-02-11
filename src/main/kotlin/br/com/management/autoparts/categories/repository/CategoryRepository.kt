package br.com.management.autoparts.categories.repository

import br.com.management.autoparts.categories.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {

    fun findByName(name: String): Optional<Category>

}