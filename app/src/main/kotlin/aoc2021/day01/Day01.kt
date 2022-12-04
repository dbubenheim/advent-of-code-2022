package aoc2021.day01

import aoc2021.day01.Day01.calorieCountingPart1
import aoc2021.day01.Day01.calorieCountingPart2
import aoc2021.toFile

object Day01 {

    fun calorieCountingPart1(): Int {
        val lines = "input-day01.txt".toFile().readLines().map { it.toIntOrNull() ?: 0 }
        val calories = mutableListOf<Int>()
        var cuSum = 0
        lines.forEach {
            if (it != 0) {
                cuSum += it
            } else {
                calories.add(cuSum)
                cuSum = 0
            }
        }
        return calories.maxOrNull() ?: 0
    }

    fun calorieCountingPart2(): Int {
        val lines = "input-day01.txt".toFile().readLines().map { it.toIntOrNull() ?: 0 }
        val calories = mutableListOf<Int>()
        var cuSum = 0
        lines.forEach {
            if (it != 0) {
                cuSum += it
            } else {
                calories.add(cuSum)
                cuSum = 0
            }
        }
        return calories.sorted().takeLast(3).sum()
    }
}

fun main() {
    println(calorieCountingPart1())
    println(calorieCountingPart2())
}
