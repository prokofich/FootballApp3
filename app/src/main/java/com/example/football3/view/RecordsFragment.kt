package com.example.football3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football3.MAIN
import com.example.football3.R
import kotlinx.android.synthetic.main.fragment_records.*

class RecordsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_records, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_record_easy.text = "рекорд легкого уровня:${MAIN.getRecordEasy()}"
        id_record_medium.text = "рекорд среднего уровня:${MAIN.getRecordMedium()}"
        id_record_hard.text = "рекорд сложного уровня:${MAIN.getRecordHard()}"

        id_record_back.setOnClickListener {
            MAIN.navController.navigate(R.id.action_settingsFragment_to_menuFragment)
        }

    }

}