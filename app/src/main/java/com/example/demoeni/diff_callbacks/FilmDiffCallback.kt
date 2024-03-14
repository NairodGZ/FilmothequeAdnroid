package com.example.demoeni.diff_callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.demoeni.model.Film

class FilmDiffCallback : DiffUtil.ItemCallback<Film>() {

    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.title == newItem.title;
    }
    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.equals(newItem);
    }

}