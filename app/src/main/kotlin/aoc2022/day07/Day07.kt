package aoc2022.day07

import aoc2022.day07.Day07.ResourceType.DIRECTORY
import aoc2022.day07.Day07.ResourceType.FILE
import aoc2022.day07.Day07.part1
import aoc2022.day07.Day07.part2
import aoc2022.toFile
import java.util.UUID

object Day07 {
    fun part1(): Long {
        val root = Directory(id = newId(), name = "/")
        initDirectoryStructure(root)

        return lookup.values
            .filter { it.type == DIRECTORY && it.size <= 100000 }
            .sumOf { it.size }
    }

    fun part2(): Long {
        val rootDirectory = Directory(id = newId(), name = "/")
        initDirectoryStructure(rootDirectory)

        val freeSpace = TOTAL_DISK_SPACE - rootDirectory.size
        val neededSpace = UNUSED_SPACE_NEEDED - freeSpace

        return lookup.values
            .filter { it.size >= neededSpace }
            .minByOrNull { it.size }
            ?.size ?: 0
    }

    private val lookup = mutableMapOf<String, Resource>()

    private const val TOTAL_DISK_SPACE = 70000000
    private const val UNUSED_SPACE_NEEDED = 30000000

    private fun initDirectoryStructure(root: Directory) {
        lookup[root.id] = root
        var curDir = root

        "input-day07.txt".toFile()
            .readLines()
            .drop(1)
            .forEach { line ->
                if (line.startsWith("$")) {
                    if (line.contains("cd")) {
                        val name = line.substringAfterLast(" ")
                        curDir = if (name == "..") {
                            val parentId = checkNotNull(curDir.parent) { "parent of $curDir must not be null!" }
                            lookup[parentId] as Directory
                        } else {
                            val directoryId = curDir.directories.single { lookup[it]?.name == name }
                            lookup[directoryId] as Directory
                        }
                    }
                } else {
                    if (line.startsWith("dir ")) {
                        val directory = Directory(id = newId(), name = line.substringAfterLast(" "), parent = curDir.id)
                        lookup[directory.id] = directory
                        curDir.directories.add(directory.id)
                    } else {
                        val (size, name) = line.split(" ")
                        val file = File(id = newId(), name = name, size = size.toLong())
                        lookup[file.id] = file
                        curDir.files.add(file.id)
                    }
                }
            }
    }

    interface Resource {
        val id: String
        val name: String
        val parent: String?
        val type: ResourceType
        val size: Long
    }

    class File(
        override val id: String,
        override val name: String,
        override val parent: String? = null,
        override val type: ResourceType = FILE,
        override val size: Long
    ) : Resource

    class Directory(
        override val id: String,
        override val name: String,
        override val parent: String? = null,
        override val type: ResourceType = DIRECTORY,
        val directories: MutableList<String> = mutableListOf(),
        val files: MutableList<String> = mutableListOf()
    ) : Resource {
        override val size: Long
            get() = files.sumOf { lookup[it]?.size ?: 0 } + directories.sumOf { lookup[it]?.size ?: 0 }
    }

    enum class ResourceType {
        FILE,
        DIRECTORY
    }

    private fun newId() = UUID.randomUUID().toString()
}

fun main() {
    println(part1())
    println(part2())
}
