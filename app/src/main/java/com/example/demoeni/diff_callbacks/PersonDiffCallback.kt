package com.example.demoeni.diff_callbacks

import androidx.recyclerview.widget.DiffUtil
import com.example.demoeni.model.Personne

class PersonDiffCallback : DiffUtil.ItemCallback<Personne>() {

    override fun areItemsTheSame(oldItem: Personne, newItem: Personne): Boolean {
        return oldItem.email == newItem.email;
    }

    override fun areContentsTheSame(oldItem: Personne, newItem: Personne): Boolean {
            return oldItem.equals(newItem);
    }

}