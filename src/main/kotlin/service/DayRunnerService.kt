package org.example.service

import org.example.day.Day1
import org.example.day.Day2
import org.example.day.DayHandler

class DayRunnerService(
    private val fileLoaderService: FileLoaderService
) {
    private val days: List<DayHandler> = listOf(
        Day1(), Day2(),
    )

    fun processAll() = days.forEach { processSingle(it) }

    fun processSingle(day: Int) = processSingle(days[day - 1])

    private fun processSingle(day: DayHandler) {
        val dayIndex = days.indexOf(day) + 1
        println("\n\n==== Running Day $dayIndex\n")
        day.process(fileLoaderService.getContentsForDay(dayIndex))
        println("\n==== Done")
    }
}