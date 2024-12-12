package org.example.day

import org.example.service.FileLoaderService

abstract class DayHandler(day: Int, fileLoaderService: FileLoaderService) {

    protected val input: List<String> = fileLoaderService.getContentsForDay(day)

    abstract fun process()
}