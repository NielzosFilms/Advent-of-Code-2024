package org.example.day

import org.example.service.FileLoaderService
import kotlin.math.abs

class Day1(day: Int, fileLoaderService: FileLoaderService) : DayHandler(day, fileLoaderService) {
    override fun process() {
        val leftList: MutableList<String> = mutableListOf()
        val rightList: MutableList<String> = mutableListOf()

        this.input
            .map { it.split("   ") }
            .forEach { parts ->
                leftList.add(parts[0])
                rightList.add(parts[1])
            }

        leftList.sort()
        rightList.sort()

        println(part1(leftList, rightList))
        println(part2(leftList, rightList))
    }

    private fun part1(leftList: MutableList<String>, rightList: MutableList<String>): Int =
        leftList.zip(rightList).sumOf { (left, right) -> abs(left.toInt() - right.toInt()) }

    private fun part2(leftList: MutableList<String>, rightList: MutableList<String>): Int =
        leftList.associateWith { left -> rightList.filter { it == left }.size }
            .map { (left, count) -> left.toInt() * count }
            .sum()
}