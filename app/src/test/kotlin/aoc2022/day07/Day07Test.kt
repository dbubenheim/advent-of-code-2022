package aoc2022.day07

import assertk.assertThat
import assertk.assertions.isEqualTo
import aoc2022.day07.Day07.part1
import aoc2022.day07.Day07.part2
import org.junit.jupiter.api.Test

internal class Day07Test {

    @Test
    fun testPart1() = assertThat(part1()).isEqualTo(1428881)

    @Test
    fun testPart2() = assertThat(part2()).isEqualTo(10475598)
}
