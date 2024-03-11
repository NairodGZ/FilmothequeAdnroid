package com.example.demoeni

import androidx.recyclerview.widget.DiffUtil

class PersonDiffCallback : DiffUtil.ItemCallback<Personne>() {

    override fun areItemsTheSame(oldItem: Personne, newItem: Personne): Boolean {
        return oldItem.email == newItem.email;
    }

    override fun areContentsTheSame(oldItem: Personne, newItem: Personne): Boolean {
            return oldItem.equals(newItem);
    }

}