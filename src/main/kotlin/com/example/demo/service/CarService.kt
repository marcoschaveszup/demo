package com.example.demo.service

import com.example.demo.model.Car

interface CarService {
    fun save(car: Car): Car
    fun getByLicensePlate(licensePlate: String): Car?
    fun removeByLicensePlate(licensePlate: String)
    fun update(car: Car): Car
}