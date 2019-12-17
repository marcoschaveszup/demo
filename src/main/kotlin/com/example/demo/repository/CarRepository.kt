package com.example.demo.repository

import com.example.demo.model.Car
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CarRepository : CrudRepository<Car, String> {
    fun findByLicensePlate(licensePlate: String): Car?
    fun save(car: Car): Car

}