package com.karnamic.dsainkotlin.graphs.practice

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
fun numIslands(grid: Array<CharArray>): Int {
    val rows = grid.size
    val cols = grid[0].size
    val visited = mutableSetOf<Pair<Int, Int>>()
    var islands = 0

    val directions = arrayOf(
        intArrayOf(-1, 0), intArrayOf(1, 0),
        intArrayOf(0, -1), intArrayOf(0, 1)
    )

    fun bfs(point: Pair<Int,Int>) {
        var queue = ArrayDeque<Pair<Int,Int>>()
        visited.add(point)
        queue.addLast(point)

        while (!queue.isEmpty()) {
            val (row,col) = queue.removeFirst()

            for ((dr, dc) in directions) {
                val r = row + dr
                val c = col + dc
                if(
                    (r in 0 until rows) && (c in 0 until cols)
                    && grid[r][c] == '1' && !visited.contains(r to c)
                ) {
                    queue.addLast(r to c)
                    visited.add(r to c)
                }
            }
        }
    }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == '1' && !visited.contains(i to j)) {
                bfs(i to j)
                islands += 1
            }
        }
    }

    return islands

}