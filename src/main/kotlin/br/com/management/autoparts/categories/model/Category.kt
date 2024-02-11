package br.com.management.autoparts.categories.model

import jakarta.persistence.*

@Entity
@Table(name = "category")
data class Category(

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long,

        @Column(nullable = false, unique = true)
        var name: String,

        @Column(nullable = false)
        var active: Boolean,

        @Column(nullable = false)
        var type: String
)
