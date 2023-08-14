package com.example.worldcup2018.util

import com.example.worldcup2018.data.domain.Match


class CsvParser {
    fun parse(line: String): Match {
        val tokens = line.split(",")
        return Match(
            date = tokens[Constants.ColumnIndex.DATE],
            homeTeamName = tokens[Constants.ColumnIndex.Home_Team_Name],
            awayTeamName = tokens[Constants.ColumnIndex.Away_TEAM_NAME],
            homeTeamFullTimeGoals = tokens[Constants.ColumnIndex.HOME_TEAM_FULL_TIME_GOALS],
            awayTeamFullTimeGoals = tokens[Constants.ColumnIndex.Away_TEAM_FULL_TIME_GOALS],
            homeTeamHalfTimeGoals = tokens[Constants.ColumnIndex.HOME_TEAM_HALF_TIME_GOALS],
            awayTeamHalfTimeGoals = tokens[Constants.ColumnIndex.Away_TEAM_HALF_TIME_GOALS],
            homeTeamShots = tokens[Constants.ColumnIndex.HOME_TEAM_SHOTS],
            awayTeamShots = tokens[Constants.ColumnIndex.Away_TEAM_SHOTS],
            homeTeamFouls = tokens[Constants.ColumnIndex.HOME_TEAM_FOULS],
            awayTeamFouls = tokens[Constants.ColumnIndex.Away_TEAM_FOULS],
            homeTeamCorners = tokens[Constants.ColumnIndex.HOME_TEAM_CORNERS],
            awayTeamCorners = tokens[Constants.ColumnIndex.Away_TEAM_CORNERS],
            homeTeamYellowCards = tokens[Constants.ColumnIndex.HOME_TEAM_YELLOW_CARD],
            awayTeamYellowCards = tokens[Constants.ColumnIndex.Away_TEAM_YELLOW_CARD],
            homeTeamRedCards = tokens[Constants.ColumnIndex.HOME_TEAM_RED_CARD],
            awayTeamRedCards = tokens[Constants.ColumnIndex.Away_TEAM_RED_CARD],
        )
    }
}