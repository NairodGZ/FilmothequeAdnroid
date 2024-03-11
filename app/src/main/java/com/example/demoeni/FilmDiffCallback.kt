package com.example.demoeni

import androidx.recyclerview.widget.DiffUtil

class FilmDiffCallback : DiffUtil.ItemCallback<Film>() {

    override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.title == newItem.title;
    }
    override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
        return oldItem.equals(newItem);
    }

}