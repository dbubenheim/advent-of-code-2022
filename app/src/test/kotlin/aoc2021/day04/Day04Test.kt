package aoc2021.day04

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class Day04Test {

    @Test
    fun testPart1() = assertThat(Day04.part1()).isEqualTo(602)

    @Test
    fun testPart2() = assertThat(Day04.part2()).isEqualTo(891)
}