package br.com.management.autoparts.entities.mapper

interface Mapper<T, U> {

    fun toModel(t: T): U

    fun toDTO(u: U): T
}