package org.example.day

import kotlin.math.abs
import kotlin.math.min

class Day2 : DayHandler {
    override fun process(input: List<String>) {
        val reports = this.convertToReports(input)

        println(reports.filter { this.isSafeReport(it) }.size)
    }

    private fun convertToReports(input: List<String>): List<List<Int>> =
        input.map { line -> line.split(" ").map { it.toInt() } }

    private fun isSafeReport(report: List<Int>): Boolean {
        val isIncreasing = this.isIncreasing(report)
        var prevLevel = report[0]
        for (i in 1 until report.size) {
            val level = report[i]
            if (this.isLevelBad(prevLevel, level, isIncreasing)) {
                return false
            }
            prevLevel = level
        }
        return true
    }

    private fun isLevelBad(prevLevel: Int, level: Int, reportIsIncreasing: Boolean): Boolean {
        if (prevLevel == level) return true
        if (abs(prevLevel - level) !in 1..3) return true

        if (reportIsIncreasing && level < prevLevel) return true
        if (!reportIsIncreasing && level > prevLevel) return true

        return false
    }

    private fun isIncreasing(report: List<Int>): Boolean {
        var prevLevel = report[0]
        var increasingCount = 0
        var decreasingCount = 0
        for (i in 1 until report.size) {
            val level = report[i]
            if (level > prevLevel) {
                increasingCount++
            } else {
                decreasingCount++
            }
            prevLevel = level
        }
        return increasingCount > decreasingCount
    }
}