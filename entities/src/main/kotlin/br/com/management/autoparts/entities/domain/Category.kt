package br.com.management.autoparts.entities.domain

import jakarta.persistence.*

@Entity
@Table(name = "category")
data class Category(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long,

        @Column(nullable = false, unique = true)
        val name: String,

        @Column
        val active: Boolean,

        @Column
        val type: String
)
