package aoc2022.day05

import aoc2022.day05.Day05.part1
import aoc2022.day05.Day05.part2
import aoc2022.toFile

object Day05 {

    private val stacksRegex = "^\\s+[0-9](\\s+[0-9]+)*\$".toRegex()
    private val cratesRegex = "([A-Z])|\\s{2}(\\s)\\s".toRegex()
    private val rearrangementRegex = "move ([0-9]+) from ([0-9]+) to ([0-9]+)".toRegex()

    fun part1(): String {
        val lines = "input-day05.txt".toFile()
            .readLines()
            .also { println("amount of lines:\t${it.size}") }

        val cratesCount = lines
            .single { it.matches(stacksRegex) }
            .substringAfterLast(" ")
            .toInt()
            .also { println("amount of crates:\t$it") }

        val stacks = mutableListOf<ArrayDeque<String>>()
        repeat(cratesCount) { stacks.add(ArrayDeque()) }

        lines.takeWhile { it.isNotBlank() }
            .dropLast(1)
            .reversed()
            .map { it.addCratesTo(stacks) }

        lines.takeLastWhile { it.isNotBlank() }
            .map { it.toRearrangementProcedure() }
            .also { println(it) }
            .forEach { proc ->
                repeat(proc.amount) {
                    stacks[proc.to].add(stacks[proc.from].removeLast())
                }
            }

        return stacks.joinToString("") { it.last() }
    }

    fun part2(): String {
        val lines = "input-day05.txt".toFile()
            .readLines()
            .also { println("amount of lines:\t${it.size}") }

        val cratesCount = lines
            .single { it.matches(stacksRegex) }
            .substringAfterLast(" ")
            .toInt()
            .also { println("amount of crates:\t$it") }

        val stacks = mutableListOf<ArrayDeque<String>>()
        repeat(cratesCount) { stacks.add(ArrayDeque()) }

        lines.takeWhile { it.isNotBlank() }
            .dropLast(1)
            .reversed()
            .map { it.addCratesTo(stacks) }

        lines.takeLastWhile { it.isNotBlank() }
            .map { it.toRearrangementProcedure() }
            .also { println(it) }
            .forEach { proc ->
                val list = mutableListOf<String>()
                repeat(proc.amount) {
                    list.add(stacks[proc.from].removeLast())
                }
                stacks[proc.to].addAll(list.reversed())
            }

        return stacks.joinToString("") { it.last() }
    }

    data class RearrangementProcedure(val amount: Int, val from: Int, val to: Int)

    private fun String.toRearrangementProcedure(): RearrangementProcedure {
        val (amount, from, to) =
            requireNotNull(rearrangementRegex.find(this)?.destructured?.toList()).map { it.toInt() }
        return RearrangementProcedure(amount, from - 1, to - 1)
    }

    private fun String.addCratesTo(stacks: MutableList<ArrayDeque<String>>) {
        cratesRegex.findAll(this).toList()
            .filter { it.value.isNotBlank() }
            .forEach { stacks[it.range.first / 4].add(it.value) }
    }
}

fun main() {
    println(part1())
    println(part2())
}
