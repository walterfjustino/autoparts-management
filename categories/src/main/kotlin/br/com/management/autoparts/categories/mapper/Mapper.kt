package br.com.management.autoparts.categories.mapper

interface Mapper<T, U> {

    fun toModel(t: T): U

    fun toDTO(u: U): T
}