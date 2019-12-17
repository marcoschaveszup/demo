package com.example.demo.controller

import com.example.demo.model.Car
import com.example.demo.model.Greeting
import com.example.demo.service.CarService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class CarController {

    @Autowired
    lateinit var carService: CarService

    @GetMapping("/greeting")
    fun greeting(): Greeting {
        return Greeting(1, "Greeting")
    }

    @GetMapping("/car/{licensePlate}")
    fun getCar(@PathVariable licensePlate: String): Car? {
        return carService.getByLicensePlate(licensePlate)
    }

    @PostMapping("/car")
    fun saveCar(@RequestBody car: Car): Car {
        return carService.save(car)
    }

    @PutMapping("/car")
    fun updateCar(@RequestBody car: Car): Car {
        return carService.update(car)
    }

    @DeleteMapping("/car/{licensePlate}")
    fun deleteCarByLicensePlate(@PathVariable licensePlate: String) {
        return carService.removeByLicensePlate(licensePlate)
    }


}