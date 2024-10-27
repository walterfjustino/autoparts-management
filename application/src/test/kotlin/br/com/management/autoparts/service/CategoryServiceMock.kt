package br.com.management.autoparts.service

import com.github.tomakehurst.wiremock.client.WireMock.*
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

interface CategoryServiceMock {

   val CATEGORY_RESOURCE_PATH: String get() = "/api/categories"
   val CATEGORY_GET_ALL: String get() = CATEGORY_RESOURCE_PATH.plus("/all")

    fun mockGetCategoryById(responseBody: String, id: String ): CategoryServiceMock {
        val url = "/api/categories/$id"

        stubFor(get(urlEqualTo(url))
                .willReturn(
                    aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile(responseBody)))
        return this
    }

    fun mockPostCategory(payload: String, response: String): CategoryServiceMock{
       val url = CATEGORY_RESOURCE_PATH

        stubFor(
            post(urlEqualTo(url))
                .withRequestBody(equalTo(payload))
                .willReturn(
                    aResponse()
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withStatus(HttpStatus.CREATED.value())
                        .withBody(response)))
        return this
    }

    fun mockGetCategoryAll(responseBody: String): CategoryServiceMock {
        val url = CATEGORY_GET_ALL

        stubFor(get(urlEqualTo(url))
            .willReturn(
                aResponse()
                    .withStatus(HttpStatus.OK.value())
                    .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .withBodyFile(responseBody)))
        return this
    }
}
