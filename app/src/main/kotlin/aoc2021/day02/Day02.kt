package aoc2021.day02

import aoc2021.day02.Day02.Result.*
import aoc2021.day02.Day02.part1
import aoc2021.day02.Day02.part2
import aoc2021.toFile

object Day02 {
    fun part1() = "input-day02.txt".toFile()
        .readLines()
        .map { it.toRound() }
        .sumOf { it.score }

    fun part2() = "input-day02.txt".toFile()
        .readLines()
        .map { it.toRoundPart2() }
        .sumOf { it.score }

    enum class Shape(private val encryption: Set<String>, val score: Int) {
        ROCK(setOf("A", "X"), 1),
        PAPER(setOf("B", "Y"), 2),
        SCISSORS(setOf("C", "Z"), 3);

        fun vs(shape: Shape): Result {
            return when (this) {
                ROCK -> {
                    when (shape) {
                        ROCK -> DRAW
                        PAPER -> LOSS
                        SCISSORS -> WIN
                    }
                }

                PAPER -> {
                    when (shape) {
                        ROCK -> WIN
                        PAPER -> DRAW
                        SCISSORS -> LOSS
                    }
                }

                SCISSORS -> {
                    when (shape) {
                        ROCK -> LOSS
                        PAPER -> WIN
                        SCISSORS -> DRAW
                    }
                }
            }
        }

        fun findShape(result: Result): Shape {
            return when (result) {
                WIN -> {
                    when (this) {
                        ROCK -> PAPER
                        PAPER -> SCISSORS
                        SCISSORS -> ROCK
                    }
                }

                DRAW -> {
                    when (this) {
                        ROCK -> ROCK
                        PAPER -> PAPER
                        SCISSORS -> SCISSORS
                    }
                }

                LOSS -> {
                    when (this) {
                        ROCK -> SCISSORS
                        PAPER -> ROCK
                        SCISSORS -> PAPER
                    }
                }
            }
        }

        companion object {
            fun from(encryption: String) = values().first { it.encryption.contains(encryption) }
        }
    }

    data class Round(private val opponent: Shape, private val mine: Shape, val score: Int)

    enum class Result(val value: Int, val encryption: String) {
        WIN(6, "Z"),
        DRAW(3, "Y"),
        LOSS(0, "X");

        companion object {
            fun from(encryption: String) = values().first { it.encryption == encryption }
        }
    }

    private fun String.toRound(): Round {
        val (opponent, mine) = split(" ")
        val opponentShape = opponent.toShape()
        val myShape = mine.toShape()
        val score = myShape.score + myShape.vs(opponentShape).value
        return Round(opponentShape, myShape, score)
    }

    private fun String.toRoundPart2(): Round {
        val (opponent, res) = split(" ")
        val opponentShape = opponent.toShape()
        val result = res.toResult()
        val myShape = opponentShape.findShape(result)
        val score = myShape.score + myShape.vs(opponentShape).value
        return Round(opponentShape, myShape, score)
    }

    private fun String.toShape() = Shape.from(this)
    private fun String.toResult() = Result.from(this)
}

fun main() {
    println(part1())
    println(part2())
}

