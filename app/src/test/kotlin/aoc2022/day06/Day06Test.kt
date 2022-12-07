package aoc2022.day06

import assertk.assertThat
import assertk.assertions.isEqualTo
import aoc2022.day06.Day06.part1
import aoc2022.day06.Day06.part2
import org.junit.jupiter.api.Test

internal class Day06Test {

    @Test
    fun testPart1() = assertThat(part1()).isEqualTo(1987)

    @Test
    fun testPart2() = assertThat(part2()).isEqualTo(3059)
}
