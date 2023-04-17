package com.example.football3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.football3.MAIN
import com.example.football3.R
import kotlinx.android.synthetic.main.fragment_question.*

class QuestionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listQuestion = emptyList<String>()
        var item = 0
        var listNumberTextView = listOf(1,2,3,4)
        var numberMyAnswer = 0

        var listMyQuestion = mutableMapOf<Int,String>()
        var listMyAnswers = mutableMapOf<Int,String>()

        var Question_map_correct = emptyMap<String,String>()
        var Question_map_wrong = emptyMap<String,String>()

        val complexity = requireArguments().getString("complexity")

        when(requireArguments().getString("complexity")){
            "easy" -> {
                listQuestion = listCorrectAnswerEasy.shuffled()
                Question_map_correct = mapCorrectAnswerEasy
                Question_map_wrong = mapWrongAnswerEasy
            }
            "medium" -> {
                listQuestion = listCorrectAnswerMedium.shuffled()
                Question_map_correct = mapCorrectAnswerMedium
                Question_map_wrong = mapWrongAnswerMedium
            }
            "hard" -> {
                listQuestion = listCorrectAnswerHard.shuffled()
                Question_map_correct = mapCorrectAnswerHard
                Question_map_wrong = mapWrongAnswerHard
            }
        }


        id_question_time.text = "$item вопрос"
        id_question_question.text = listQuestion[item]
        listMyQuestion[listMyQuestion.size+1] = listQuestion[item]

        listNumberTextView = listNumberTextView.shuffled()
        when(listNumberTextView[0]){
            1 -> {
                id_question_answer1.text = Question_map_correct[listQuestion[item]]
                id_question_answer2.text = Question_map_wrong[listQuestion[item]+"wrong1"]
                id_question_answer3.text = Question_map_wrong[listQuestion[item]+"wrong2"]
                id_question_answer4.text = Question_map_wrong[listQuestion[item]+"wrong3"]
            }
            2 -> {
                id_question_answer2.text = Question_map_correct[listQuestion[item]]
                id_question_answer1.text = Question_map_wrong[listQuestion[item]+"wrong1"]
                id_question_answer3.text = Question_map_wrong[listQuestion[item]+"wrong2"]
                id_question_answer4.text = Question_map_wrong[listQuestion[item]+"wrong3"]
            }
            3 -> {
                id_question_answer3.text = Question_map_correct[listQuestion[item]]
                id_question_answer2.text = Question_map_wrong[listQuestion[item]+"wrong1"]
                id_question_answer1.text = Question_map_wrong[listQuestion[item]+"wrong2"]
                id_question_answer4.text = Question_map_wrong[listQuestion[item]+"wrong3"]
            }
            4 -> {
                id_question_answer4.text = Question_map_correct[listQuestion[item]]
                id_question_answer2.text = Question_map_wrong[listQuestion[item]+"wrong1"]
                id_question_answer3.text = Question_map_wrong[listQuestion[item]+"wrong2"]
                id_question_answer1.text = Question_map_wrong[listQuestion[item]+"wrong3"]
            }

        }


        id_question_answer1.setOnClickListener {
            numberMyAnswer = 1
            id_question_answer1.setBackgroundResource(R.color.green_answer)
            id_question_answer2.setBackgroundResource(R.color.blue_background)
            id_question_answer3.setBackgroundResource(R.color.blue_background)
            id_question_answer4.setBackgroundResource(R.color.blue_background)
        }

        id_question_answer2.setOnClickListener {
            numberMyAnswer = 2
            id_question_answer2.setBackgroundResource(R.color.green_answer)
            id_question_answer1.setBackgroundResource(R.color.blue_background)
            id_question_answer3.setBackgroundResource(R.color.blue_background)
            id_question_answer4.setBackgroundResource(R.color.blue_background)
        }
        id_question_answer3.setOnClickListener {
            numberMyAnswer = 3
            id_question_answer3.setBackgroundResource(R.color.green_answer)
            id_question_answer1.setBackgroundResource(R.color.blue_background)
            id_question_answer2.setBackgroundResource(R.color.blue_background)
            id_question_answer4.setBackgroundResource(R.color.blue_background)
        }
        id_question_answer4.setOnClickListener {
            numberMyAnswer = 4
            id_question_answer4.setBackgroundResource(R.color.green_answer)
            id_question_answer1.setBackgroundResource(R.color.blue_background)
            id_question_answer3.setBackgroundResource(R.color.blue_background)
            id_question_answer2.setBackgroundResource(R.color.blue_background)
        }


        id_question_button_next.setOnClickListener {
            if(item==9){
                when(numberMyAnswer){
                    1 -> {
                        listMyAnswers[listMyAnswers.size+1] = id_question_answer1.text.toString()
                    }
                    2 -> {
                        listMyAnswers[listMyAnswers.size+1] = id_question_answer2.text.toString()
                    }
                    3 -> {
                        listMyAnswers[listMyAnswers.size+1] = id_question_answer3.text.toString()
                    }
                    4 -> {
                        listMyAnswers[listMyAnswers.size+1] = id_question_answer4.text.toString()
                    }
                }
                list_my_question_for_recycler = listMyQuestion
                list_my_answers_for_recycler = listMyAnswers
                var count = 0

                for(i in 1..10){
                    if(Question_map_correct[list_my_question_for_recycler[i]]== list_my_answers_for_recycler[i]){
                        count+=1
                    }
                }

                when(complexity){
                    "easy" -> {
                        if(MAIN.getRecordEasy()<count){
                            MAIN.setRecordEasy(count)
                        }
                    }
                    "medium" -> {
                        if(MAIN.getRecordMedium()<count){
                            MAIN.setRecordMedium(count)
                        }
                    }
                    "hard" -> {
                        if(MAIN.getRecordHard()<count){
                            MAIN.setRecordHard(count)
                        }
                    }
                }

                var bundle = Bundle()
                bundle.putString("complexity",complexity)
                MAIN.navController.navigate(R.id.action_questionFragment_to_answersFragment,bundle)

            }else{

                id_question_answer1.setBackgroundResource(R.color.blue_background)
                id_question_answer2.setBackgroundResource(R.color.blue_background)
                id_question_answer3.setBackgroundResource(R.color.blue_background)
                id_question_answer4.setBackgroundResource(R.color.blue_background)
                item+=1

                when(numberMyAnswer){
                    1 -> {
                        listMyAnswers[listMyAnswers.size+1] = id_question_answer1.text.toString()
                    }
                    2 -> {
                        listMyAnswers[listMyAnswers.size+1] = id_question_answer2.text.toString()
                    }
                    3 -> {
                        listMyAnswers[listMyAnswers.size+1] = id_question_answer3.text.toString()
                    }
                    4 -> {
                        listMyAnswers[listMyAnswers.size+1] = id_question_answer4.text.toString()
                    }
                }

                id_question_time.text = "$item вопрос"
                id_question_question.text = listQuestion[item]
                listMyQuestion[listMyQuestion.size+1] = listQuestion[item]
                listNumberTextView = listNumberTextView.shuffled()

                when(listNumberTextView[0]){
                    1 -> {
                        id_question_answer1.text = Question_map_correct[listQuestion[item]]
                        id_question_answer2.text = Question_map_wrong[listQuestion[item]+"wrong1"]
                        id_question_answer3.text = Question_map_wrong[listQuestion[item]+"wrong2"]
                        id_question_answer4.text = Question_map_wrong[listQuestion[item]+"wrong3"]
                    }
                    2 -> {
                        id_question_answer2.text = Question_map_correct[listQuestion[item]]
                        id_question_answer1.text = Question_map_wrong[listQuestion[item]+"wrong1"]
                        id_question_answer3.text = Question_map_wrong[listQuestion[item]+"wrong2"]
                        id_question_answer4.text = Question_map_wrong[listQuestion[item]+"wrong3"]
                    }
                    3 -> {
                        id_question_answer3.text = Question_map_correct[listQuestion[item]]
                        id_question_answer2.text = Question_map_wrong[listQuestion[item]+"wrong1"]
                        id_question_answer1.text = Question_map_wrong[listQuestion[item]+"wrong2"]
                        id_question_answer4.text = Question_map_wrong[listQuestion[item]+"wrong3"]
                    }
                    4 -> {
                        id_question_answer4.text = Question_map_correct[listQuestion[item]]
                        id_question_answer2.text = Question_map_wrong[listQuestion[item]+"wrong1"]
                        id_question_answer3.text = Question_map_wrong[listQuestion[item]+"wrong2"]
                        id_question_answer1.text = Question_map_wrong[listQuestion[item]+"wrong3"]
                }
            }

        }


    }




    }




}