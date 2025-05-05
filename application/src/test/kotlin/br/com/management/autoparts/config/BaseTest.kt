//package br.com.management.autoparts.config
//
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
//import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
//import org.springframework.test.context.ActiveProfiles
//import org.springframework.test.context.jdbc.Sql
//import org.springframework.test.context.junit.jupiter.EnabledIf
//import org.springframework.test.web.servlet.MockMvc
//
//@Sql("/dataset.sql")
//@ActiveProfiles("test")
//@AutoConfigureMockMvc
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@EnabledIf(expression = "#{environment['spring.profiles.active'] == null}")
//@AutoConfigureWireMock(port = 0)
//abstract class BaseTest {
//
//    @Autowired
//    protected lateinit var mockMvc: MockMvc
//}