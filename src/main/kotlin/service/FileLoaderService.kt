package org.example.service

class FileLoaderService {
    fun getContentsForDay(day: Int): List<String> =
        (this::class.java.classLoader.getResource("day${day}.txt")
            ?: error("Failed to find .txt file for day $day")
            ).readText().split("\n").filter(String::isNotEmpty)
}