package com.example.football3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football3.MAIN
import com.example.football3.R
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_menu_start_quiz.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_menuQuizFragment)
        }

        id_menu_settings.setOnClickListener {
            MAIN.navController.navigate(R.id.action_menuFragment_to_settingsFragment)
        }

        id_menu_exit.setOnClickListener {
            MAIN.finish()
        }

    }

}