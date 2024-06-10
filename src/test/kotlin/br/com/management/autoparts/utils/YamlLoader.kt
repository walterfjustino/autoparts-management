package br.com.management.autoparts.utils

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean
import org.springframework.core.io.ClassPathResource

class YamlLoader(fileLocation: String?, scenario: String) {
    private val yaml = YamlPropertiesFactoryBean()
    private val scenario: String

    init {
        yaml.setResources(ClassPathResource(fileLocation!!))
        this.scenario = scenario
    }

    val input: String get() = yaml.getObject()!!.getProperty("$scenario.input")
}