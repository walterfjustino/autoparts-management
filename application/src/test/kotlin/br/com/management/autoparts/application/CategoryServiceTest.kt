//package br.com.management.autoparts.application
//
//import br.com.management.autoparts.config.BaseTest
//import br.com.management.autoparts.service.CategoryServiceMock
//import br.com.management.autoparts.utils.FileUtils
//import com.github.tomakehurst.wiremock.client.WireMock.*
//import com.google.gson.*
//import org.junit.jupiter.api.Test
//import org.mockito.Mock
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.http.MediaType
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers
//import java.util.*
//
//
//class CategoryServiceTest: BaseTest() {
//
//    @Autowired
//    private lateinit var fileUtils: FileUtils
//
//    @Mock
//    private lateinit var mock: CategoryServiceMock
//
//    @Test
//    @Throws(Exception::class)
//    fun `should create category`() {
//        val path = "/api/categories"
//        val requestBody = fileUtils.loadGeneratedFile("/__files/shouldBeCreateCategoryWithRequestBody.json")
//        val responseBody = fileUtils.loadGeneratedFile("/__files/shouldBeCreatedCategoryWithResponseBody.json")
//
//        println("payload: $requestBody  -> response: $responseBody")
//        mock.mockPostCategory(requestBody, responseBody)
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.post(path)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(requestBody)
//        ).andDo(MockMvcResultHandlers.print())
//            .andExpect(MockMvcResultMatchers.status().isCreated())
//            .andExpect(MockMvcResultMatchers.content().string(responseBody))
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun `should return category by id`() {
//        val id = "4"
//        val url = "/api/categories/$id"
//        val responseBody = fileUtils.loadGeneratedFile("/__files/shouldBeCreatedCategoryWithResponseBody.json")
//
//        mock.mockGetCategoryById(responseBody, id)
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.get(url)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//        ).andDo(MockMvcResultHandlers.print())
//            .andExpect(MockMvcResultMatchers.status().isOk())
//            .andExpect(MockMvcResultMatchers.content().string(responseBody))
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun `should return all categories paginated `() {
//        val url = "/api/categories".plus("/all")
//        val responseBody = fileUtils.loadGeneratedFile("/__files/ShouldBeReturnedAllCategoriesPaginated.json")
//
//        mock.mockGetCategoryAll(responseBody)
//
//        mockMvc.perform(
//            MockMvcRequestBuilders.get(url)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//        ).andDo(MockMvcResultHandlers.print())
//            .andExpect(MockMvcResultMatchers.status().isOk())
//            .andExpect(MockMvcResultMatchers.content().string(responseBody))
//    }
//}
//
//
