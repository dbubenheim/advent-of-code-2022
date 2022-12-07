package aoc2022.day05

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class Day05Test {

    @Test
    fun testPart1() = assertThat(Day05.part1()).isEqualTo("ZWHVFWQWW")

    @Test
    fun testPart2() = assertThat(Day05.part2()).isEqualTo("HZFZCCWWV")
}
