package com.example.cert

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WordsMemoryAdapter (
    private val words: List<Words>
): RecyclerView.Adapter<WordsMemoryAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        WordViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_word_memory, parent, false)
        )

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount() = words.size

    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val wordTextView: TextView = itemView.findViewById(R.id.wordTextView)
        private val expTextView: TextView = itemView.findViewById(R.id.expTextView)

        fun bind(words: Words) {
            wordTextView.text = words.word
            expTextView.text = words.exp
        }
    }
}