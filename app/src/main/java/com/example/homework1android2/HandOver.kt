package com.example.homework1android2

object HandOver {

    private var carModel: Car? = null

    fun setData(name: Car) {
        carModel = name
    }

    fun getData() = carModel
}