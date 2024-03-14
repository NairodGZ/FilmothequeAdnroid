package com.example.demoeni.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demoeni.diff_callbacks.PersonDiffCallback
import com.example.demoeni.databinding.CellPersonBinding
import com.example.demoeni.model.Personne

class PersonneAdapter : ListAdapter<Personne, PersonneAdapter.ViewHolder>(PersonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personne = getItem(position)
        holder.bind(personne);
    }

    class ViewHolder(val binding : CellPersonBinding) : RecyclerView.ViewHolder(binding.root)
    {
        /*
         * Faire le lien avec une donnée envoyée et la vue
         */
        fun bind(data : Personne)
        {
            binding.person = data;
            binding.executePendingBindings()
        }
        companion object
        {
            fun from(parent : ViewGroup) : ViewHolder
            {
                val layoutInflater = LayoutInflater.from(parent.context);
                val binding = CellPersonBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding);

            };
        }
    }





}