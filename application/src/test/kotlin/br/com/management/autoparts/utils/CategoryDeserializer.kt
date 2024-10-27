package br.com.management.autoparts.utils

import br.com.management.autoparts.categories.model.dto.CategoryDTO
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import org.springframework.stereotype.Component
import java.lang.reflect.Type

@Component
class CategoryDeserializer : JsonDeserializer<CategoryDTO> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): CategoryDTO {
        val jsonObject = json?.asJsonObject
        return CategoryDTO(
            id = jsonObject?.get("id")?.asLong ?: 0,
            name = jsonObject?.get("name")?.asString ?: "",
            active = jsonObject?.get("active")?.asBoolean ?: false ,
            type = jsonObject?.get("type")?.asString ?: "",
        )
    }
}
