package com.example.demo.service

import com.example.demo.exceptions.CarAlreadyExistsException
import com.example.demo.exceptions.CarNotFoundException
import com.example.demo.model.Car
import com.example.demo.repository.CarRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarServiceImpl : CarService {


    @Autowired
    lateinit var carRepository: CarRepository

    override fun save(car: Car): Car {
        if (carRepository.findByLicensePlate(car.licensePlate) != null) throw CarAlreadyExistsException(carAlreadyExists)
        return carRepository.save(car)
    }

    override fun getByLicensePlate(licensePlate: String): Car? {
        return carRepository.findByLicensePlate(licensePlate) ?: throw CarNotFoundException(carNotFound)
    }

    override fun removeByLicensePlate(licensePlate: String) {
        carRepository.findByLicensePlate(licensePlate) ?: throw CarNotFoundException(carNotFound)
        return carRepository.deleteById(licensePlate)
    }

    override fun update(car: Car): Car {
        carRepository.findByLicensePlate(car.licensePlate) ?: throw CarNotFoundException(carNotFound)

        return carRepository.save(car)
    }

    companion object {
        const val carNotFound = "Car not found!"
        const val carAlreadyExists = "License plate already registered!"
    }

}