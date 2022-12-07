package aoc2022

import java.io.File

fun String.toFile(): File = File(ClassLoader.getSystemResource(this).file)

inline fun <reified T : Enum<T>> enumContains(name: String?): Boolean {
    return enumValues<T>().any { it.name == name }
}
