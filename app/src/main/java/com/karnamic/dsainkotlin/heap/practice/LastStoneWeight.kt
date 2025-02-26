package com.karnamic.dsainkotlin.heap.practice

import java.util.PriorityQueue
import kotlin.math.abs

/**
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 *
 * We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
 *
 * If x == y, both stones are destroyed, and
 * If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
 * At the end of the game, there is at most one stone left.
 *
 * Return the weight of the last remaining stone. If there are no stones left, return 0.
 */
fun lastStoneWeight(stones: IntArray): Int {
    val minHeap = PriorityQueue<Int>()

    stones.forEach {
        minHeap.add( it * -1)
    }

    while(minHeap.size > 1) {
        val result = minHeap.poll()!! - minHeap.poll()!!
        if (result != 0) {
            minHeap.add(result)
        }
    }

    return if (minHeap.isEmpty()) {
        0
    } else {
        minHeap.poll()!! * -1
    }
}

/** Brute force
fun lastStoneWeight(stones: IntArray): Int {
    val currStones = stones.toMutableList()


    while (currStones.size > 1){
        currStones.sortDescending()
        val first = currStones.removeAt(0)
        val second = currStones.removeAt(0)

        if(first != second) {
            currStones.add(abs(first-second))
        }
    }

    return if(currStones.size == 0) {
        0
    } else {
        currStones.last()
    }
}
*/
