package com.example.football3.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.football3.R
import com.example.football3.view.*
import kotlinx.android.synthetic.main.item_answer.view.*

class AnswersAdapter(private val context: Context, private val complexity:String):RecyclerView.Adapter<AnswersAdapter.AnswersViewHolder>() {

    var mapQuestion = emptyMap<Int,String>()
    var mapAnswers = emptyMap<Int,String>()



    class AnswersViewHolder(view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_answer,parent,false)
        return AnswersViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnswersViewHolder, position: Int) {

        if(complexity=="easy") {
            holder.itemView.id_item_answer_question.text = mapQuestion[position + 1]
            if (mapCorrectAnswerEasy[mapQuestion[position + 1]] != mapAnswers[position + 1]) {
                holder.itemView.id_item_answer_status.text = "Х"
                holder.itemView.id_item_answer_status.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.red_answer
                    )
                )
            } else {
                holder.itemView.id_item_answer_status.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.green_answer
                    )
                )
            }
        }
        if(complexity=="medium") {
            holder.itemView.id_item_answer_question.text = mapQuestion[position + 1]
            if (mapCorrectAnswerMedium[mapQuestion[position + 1]] != mapAnswers[position + 1]) {
                holder.itemView.id_item_answer_status.text = "Х"
                holder.itemView.id_item_answer_status.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.red_answer
                    )
                )
            } else {
                holder.itemView.id_item_answer_status.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.green_answer
                    )
                )
            }
        }
        if(complexity=="hard") {
            holder.itemView.id_item_answer_question.text = mapQuestion[position + 1]
            if (mapCorrectAnswerHard[mapQuestion[position + 1]] != mapAnswers[position + 1]) {
                holder.itemView.id_item_answer_status.text = "Х"
                holder.itemView.id_item_answer_status.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.red_answer
                    )
                )
            } else {
                holder.itemView.id_item_answer_status.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.green_answer
                    )
                )
            }
        }

    }

    override fun getItemCount(): Int {
        return mapQuestion.size
    }

    @SuppressLint("NotifyDataSetChanged")
    @JvmName("setMap1")
    fun setMap(Map1:Map<Int,String>,Map2:Map<Int,String>){
        mapQuestion = Map1
        mapAnswers = Map2
        notifyDataSetChanged()
    }

}