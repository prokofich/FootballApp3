package com.example.football3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football3.MAIN
import com.example.football3.R
import kotlinx.android.synthetic.main.fragment_menu_quiz.*

class MenuQuizFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        id_menu_quiz_easy.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","easy")
            MAIN.navController.navigate(R.id.action_menuQuizFragment_to_questionFragment,bundle)
        }

        id_menu_quiz_medium.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","medium")
            MAIN.navController.navigate(R.id.action_menuQuizFragment_to_questionFragment,bundle)
        }

        id_menu_quiz_hard.setOnClickListener {
            var bundle = Bundle()
            bundle.putString("complexity","hard")
            MAIN.navController.navigate(R.id.action_menuQuizFragment_to_questionFragment,bundle)
        }

    }

}