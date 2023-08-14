package com.example.worldcup2018.data

import com.example.worldcup2018.data.domain.Match

object DataManager {private val matchList = mutableListOf<Match>()
    private var matchIndex = 1

    fun addMatch(match: Match) {
        matchList.add(match)
    }

    fun getCurrentMatch(): Match = matchList[matchIndex]
    fun getNextMatch(): Match {
        matchIndex++
        if (matchIndex == matchList.size) {
            matchIndex = 0
        }
        return matchList[matchIndex]
    }
    fun getAllMatches(): List<Match> {
        return matchList.toList()
    }

    fun getPreviousMatch(): Match {
        matchIndex--
        if (matchIndex == -1) {
            matchIndex = matchList.size - 1
        }
        return matchList[matchIndex]
    }

}