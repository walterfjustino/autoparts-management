package br.com.management.autoparts.service

import br.com.management.autoparts.categories.service.CategoryService
import com.github.tomakehurst.wiremock.WireMockServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = [WiremockContextInitializer::class])
class CategoryServiceTest : CategoryServiceMock{

    @Autowired private lateinit var service: CategoryService
    @Autowired private lateinit var wireMockServer: WireMockServer
//    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @AfterEach
    fun afterEach() {
        wireMockServer.resetAll()
    }
    @Test
    fun `GET category by Id`() {
    mockGetCategoryById(wireMockServer,"shouldBeCreatedCategoryWithResponseBody.json","4")

        val category= service.getById(4);

        Assertions.assertAll(
            Executable { assertNotNull(category) },
            Executable { assertEquals("Brinquedos", category.name) },
            Executable { assertEquals(4, category.id) }
        )

    }
}