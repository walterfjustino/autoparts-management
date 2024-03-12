package br.com.management.autoparts.service

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

interface CategoryServiceMock {

    fun mockGetCategoryById(wireMockServer: WireMockServer, responseBody: String, id: String ): CategoryServiceMock {
        val url = "/api/v1/categories/$id"

        wireMockServer.stubFor(get(urlEqualTo(url))
                .willReturn(
                    aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .withBodyFile(responseBody)))
        return this
    }
}
