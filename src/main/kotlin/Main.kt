package org.example

import org.example.day.Day1
import org.example.service.FileLoaderService

fun main() {
    val fileLoaderService = FileLoaderService()

    Day1(1, fileLoaderService)
        .process()
}