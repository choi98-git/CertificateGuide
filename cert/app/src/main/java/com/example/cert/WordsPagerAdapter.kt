package com.example.cert

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsPagerAdapter(
    private val words: List<Word>
): RecyclerView.Adapter<WordsPagerAdapter.WordViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WordViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_word, parent, false)
        )

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount() = words.size

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val explanationTextView: TextView = itemView.findViewById(R.id.explanationTextView)
        private val wordTextView: TextView = itemView.findViewById(R.id.wordTextView)

        fun bind(word: Word){
            explanationTextView.text = word.explanation
            wordTextView.text = word.word
        }
    }
}

