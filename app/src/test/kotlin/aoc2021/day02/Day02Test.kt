package aoc2021.day02

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class Day02Test {

    @Test
    fun testPart1() = assertThat(Day02.part1()).isEqualTo(11063)

    @Test
    fun testPart2() = assertThat(Day02.part2()).isEqualTo(10349)
}
