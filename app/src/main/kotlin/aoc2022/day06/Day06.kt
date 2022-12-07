package aoc2022.day06

import aoc2022.day06.Day06.part1
import aoc2022.day06.Day06.part2
import aoc2022.toFile

object Day06 {

    private const val START_OF_PACKET_MARKER = 4
    private const val START_OF_MESSAGE_MARKER = 14

    fun part1() = findMarker(START_OF_PACKET_MARKER)

    fun part2() = findMarker(START_OF_MESSAGE_MARKER)

    private fun findMarker(strategy: Int): Int {
        val chars = mutableSetOf<Char>()
        var isReady = false
        "input-day06.txt".toFile()
            .readLines()
            .first()
            .also { println(it) }
            .scanIndexed("") { idx, line, char ->
                if (!isReady) {
                    val added = chars.add(char)
                    if (added && chars.size >= strategy) isReady = true
                }
                if (isReady) {
                    val lastChars = line.takeLast(strategy - 1).toSet() + char
                    if (lastChars.size == strategy) return idx + 1
                }
                line + char
            }
        error("position not found")
    }
}

fun main() {
    println("position part 1: ${part1()}")
    println("position part 2: ${part2()}")
}
