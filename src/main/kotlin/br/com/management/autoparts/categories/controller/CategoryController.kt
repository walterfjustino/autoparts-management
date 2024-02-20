package br.com.management.autoparts.categories.controller

import br.com.management.autoparts.categories.model.dto.CategoryDTO
import br.com.management.autoparts.categories.service.CategoryService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/categories")
class CategoryController(private val service: CategoryService) {

    @PostMapping
    fun create(@RequestBody @Valid categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCategory(categoryDTO))
    }

    @GetMapping
    fun getByName(@RequestParam("name") name: String): ResponseEntity<CategoryDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(service.getByName(name))
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<CategoryDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id))
    }

    @GetMapping("/all")
    fun getAll() : ResponseEntity<List<CategoryDTO>> {
       return ResponseEntity.status(HttpStatus.OK).body(service.getAll())
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long ,@RequestBody categoryDTO: CategoryDTO): ResponseEntity<CategoryDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, categoryDTO))
    }

    @PatchMapping("/{id}")
    fun updatePartial(@PathVariable id: Long, @RequestBody fields: Map<String, Any>): ResponseEntity<CategoryDTO> {
        return ResponseEntity.status(HttpStatus.OK).body(service.updatePartial(id, fields))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long) : ResponseEntity<Any>{
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(service.delete(id))
    }
}
