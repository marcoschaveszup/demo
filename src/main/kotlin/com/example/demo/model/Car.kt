package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
class Car(@Id val licensePlate: String, val make: String, val model: String, val color: String, val year: Int)