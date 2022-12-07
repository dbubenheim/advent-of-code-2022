package aoc2022.day03

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

class Day03Test {

    @Test
    fun testPart1() = assertThat(Day03.part1()).isEqualTo(8109)

    @Test
    fun testPart2() = assertThat(Day03.part2()).isEqualTo(2738)
}
