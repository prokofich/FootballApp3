package com.example.football3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.football3.MAIN
import com.example.football3.R
import com.example.football3.adapter.AnswersAdapter
import kotlinx.android.synthetic.main.fragment_answers.*

class AnswersFragment : Fragment() {

    lateinit var recyclerViewAnswers: RecyclerView
    lateinit var adapterAnswers: AnswersAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_answers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val complexity = requireArguments().getString("complexity")

        //Toast.makeText(requireContext(),"${list_my_question_for_recycler.size} ${list_my_answers_for_recycler.size}",Toast.LENGTH_SHORT).show()

        recyclerViewAnswers = id_answers_rv
        adapterAnswers = AnswersAdapter(requireContext(), complexity!!)
        recyclerViewAnswers.adapter = adapterAnswers

        adapterAnswers.setMap(list_my_question_for_recycler, list_my_answers_for_recycler)

        id_answers_back_to_menu.setOnClickListener {
            MAIN.navController.navigate(R.id.action_answersFragment_to_menuFragment)
        }

    }


}