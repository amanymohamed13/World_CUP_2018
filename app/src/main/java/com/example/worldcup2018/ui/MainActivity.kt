package com.example.worldcup2018.ui

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import com.example.worldcup2018.data.DataManager
import com.example.worldcup2018.data.domain.Match
import com.example.worldcup2018.databinding.ActivityMainBinding
import com.example.worldcup2018.util.CsvParser
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val LOG: String = "MAIN_ACTIVITY"
    private val originalMatches = DataManager.getAllMatches().toMutableList()
    private val filteredMatches = mutableListOf<Match>()


    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =
        ActivityMainBinding::inflate

    override fun setup() {
        fileParceing()
        setupSearch()
    }

    override fun addCallBacks() {
        binding?.apply {
            right.setOnClickListener {
                bindMatch(DataManager.getNextMatch())
            }
            left.setOnClickListener {
                bindMatch(DataManager.getPreviousMatch())
            }
        }
    }

    private fun setupSearch() {
        binding?.search?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterMatches(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    private fun filterMatches(query: String) {
        filteredMatches.clear()
        if (query.isEmpty()) {
            filteredMatches.addAll(originalMatches)
        } else {
            for (match in originalMatches) {
                if (match.homeTeamName!!.contains(query, ignoreCase = true) ||
                    match.awayTeamName!!.contains(query, ignoreCase = true)
                ) {
                    filteredMatches.add(match)
                }
            }
        }
        bindMatch(filteredMatches.firstOrNull())
    }

    private fun fileParceing() {
        val inputStream = assets.open("matches.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParser()
        buffer.forEachLine {
            log(it)
            val currantMatch = parser.parse(it)
            DataManager.addMatch(currantMatch)
        }
        bindMatch(DataManager.getCurrentMatch())
    }

    private fun bindMatch(match: Match?) {
        binding?.apply {
            if (match != null) {
                matchDate.text = match.date
                homeTeamName.text = match.homeTeamName
                awayTeamName.text = match.awayTeamName
                homeTeamFullTimeGoals.text = match.homeTeamFullTimeGoals.toString()
                awayTeamFullTimeGoals.text = match.awayTeamFullTimeGoals.toString()
                homeTeamHalfTimeGoals.text = match.homeTeamHalfTimeGoals.toString()
                awayTeamHalfTimeGoals.text = match.awayTeamHalfTimeGoals.toString()
                homeTeamShots.text = match.homeTeamShots.toString()
                awayTeamShots.text = match.awayTeamShots.toString()
                homeTeamCorners.text = match.homeTeamCorners.toString()
                awayTeamCorners.text = match.awayTeamCorners.toString()
                homeTeamYellowCards.text = match.homeTeamYellowCards.toString()
                awayTeamYellowCards.text = match.awayTeamYellowCards.toString()
                homeTeamRedCards.text = match.homeTeamRedCards.toString()
                awayTeamRedCards.text = match.awayTeamRedCards.toString()
            } else {
                matchDate.text = ""
                homeTeamName.text = ""
                awayTeamName.text = ""
                homeTeamFullTimeGoals.text = ""
                awayTeamFullTimeGoals.text = ""
                homeTeamHalfTimeGoals.text = ""
                awayTeamHalfTimeGoals.text = ""
                homeTeamShots.text = ""
                awayTeamShots.text = ""
                homeTeamCorners.text = ""
                awayTeamCorners.text = ""
                homeTeamYellowCards.text = ""
                awayTeamYellowCards.text = ""
                homeTeamRedCards.text = ""
                awayTeamRedCards.text = ""
            }
        }
    }
}
