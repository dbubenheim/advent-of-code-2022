package aoc2022.day03

import aoc2022.toFile

object Day03 {

    fun part1(): Int {
        return "input-day03.txt"
            .toFile()
            .readLines()
            .sumOf { it.calc() }
    }

    fun part2(): Int {
        return "input-day03.txt"
            .toFile()
            .readLines()
            .chunked(3)
            .sumOf { it.calc2() }
    }

    private fun List<String>.calc2(): Int {
        val char = this[0].toSet().intersect(this[1].toSet()).intersect(this[2].toSet()).single()
        return char.code - if (char.isLowerCase()) 96 else 38
    }

    private fun String.calc(): Int {
        val halfIndex = this.length / 2
        val first = this.substring(0, halfIndex)
        val second = this.substring(halfIndex)
        val char = first.toSet().intersect(second.toSet()).single()
        return char.code - if (char.isLowerCase()) 96 else 38
    }
}

fun main() {
    println(Day03.part1())
    println(Day03.part2())
}
