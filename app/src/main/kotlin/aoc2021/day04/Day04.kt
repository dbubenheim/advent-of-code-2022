package aoc2021.day04

import aoc2021.day04.Day04.part1
import aoc2021.day04.Day04.part2
import aoc2021.toFile

object Day04 {

    fun part1() = "input-day04.txt".toFile()
        .readLines()
        .map { it.toAssignmentPair() }
        .count { it.fullyContains() }

    fun part2() = "input-day04.txt".toFile()
        .readLines()
        .map { it.toAssignmentPair() }
        .count { it.overlaps() }

    private fun String.toAssignmentPair(): AssignmentPair {
        val (first, second) = split(",")
        val (firstFrom, firstTo) = first.split("-")
        val (secondFrom, secondTo) = second.split("-")
        return AssignmentPair(firstFrom.toInt()..firstTo.toInt(), secondFrom.toInt()..secondTo.toInt())
    }

    data class AssignmentPair(val first: IntRange, val second: IntRange) {
        fun fullyContains() = first.all { it in second } || second.all { it in first }
        fun overlaps() = first.any { it in second } || second.any { it in first }
    }
}

fun main() {
    println(part1())
    println(part2())
}