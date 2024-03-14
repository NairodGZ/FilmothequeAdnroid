package com.example.demoeni.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.demoeni.diff_callbacks.FilmDiffCallback
import com.example.demoeni.databinding.CellFilmBinding
import com.example.demoeni.model.Film

class FilmAdapter : ListAdapter<Film, FilmAdapter.ViewHolder>(FilmDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val film = getItem(position)
        holder.bind(film);
    }

    class ViewHolder(val binding : CellFilmBinding) : RecyclerView.ViewHolder(binding.root)
    {
        /*
         * Faire le lien avec une donnée envoyée et la vue
         */
        fun bind(data : Film)
        {
            binding.film = data;
            binding.executePendingBindings()

            // Experimental : charger url sur la cellule
            //Picasso.get().load(data.thumbnail_url).into(binding.ivMovieCover)
        }
        companion object
        {
            fun from(parent : ViewGroup) : ViewHolder
            {
                val layoutInflater = LayoutInflater.from(parent.context);
                val binding = CellFilmBinding.inflate(layoutInflater, parent, false)



                return ViewHolder(binding);

            };
        }
    }





}