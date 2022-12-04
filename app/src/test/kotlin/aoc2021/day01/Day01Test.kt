package aoc2021.day01

import aoc2021.day01.Day01.calorieCountingPart1
import aoc2021.day01.Day01.calorieCountingPart2
import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class Day01Test {

    @Test
    fun testCalorieCountPart1() = assertThat(calorieCountingPart1()).isEqualTo(67450)

    @Test
    fun testCalorieCountPart2() = assertThat(calorieCountingPart2()).isEqualTo(199357)
}