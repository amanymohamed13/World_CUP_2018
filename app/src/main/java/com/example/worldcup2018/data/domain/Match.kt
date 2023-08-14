package com.example.worldcup2018.data.domain


data class Match(val date: String? = null,
                 val homeTeamName: String? = null,
                 val awayTeamName: String? = null,
                 val homeTeamFullTimeGoals: String? = null,
                 val awayTeamFullTimeGoals: String? = null,
                 val homeTeamHalfTimeGoals: String? = null,
                 val awayTeamHalfTimeGoals: String? = null,
                 val homeTeamShots: String? = null,
                 val awayTeamShots: String? = null,
                 val homeTeamFouls: String? = null,
                 val awayTeamFouls: String? = null,
                 val homeTeamCorners: String? = null,
                 val awayTeamCorners: String? = null,
                 val homeTeamYellowCards: String? = null,
                 val awayTeamYellowCards: String? = null,
                 val homeTeamRedCards: String? = null,
                 val awayTeamRedCards: String? = null,) {

}