package org.example

import org.example.service.DayRunnerService
import org.example.service.FileLoaderService

fun main() {
    val dayRunnerService = DayRunnerService(FileLoaderService())

    dayRunnerService.processAll()
}