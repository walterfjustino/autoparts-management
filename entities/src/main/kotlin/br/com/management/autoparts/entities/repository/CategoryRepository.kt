package br.com.management.autoparts.entities.repository

import br.com.management.autoparts.entities.domain.Category
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<Category, Long> {

    fun findByName(name: String): Optional<Category>
    @Query("""
        FROM Category c 
                WHERE LOWER(c.name) like %:searchTerm% """)
    fun search(@Param("searchTerm") searchTerm: String, pageable: Pageable): Page<Category>

}