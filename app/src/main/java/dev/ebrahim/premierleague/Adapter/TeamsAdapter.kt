package dev.ebrahim.premierleague.Adapter

import Team
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.ebrahim.premierleague.R

class TeamsAdapter(var teams: List<Team>?): RecyclerView.Adapter<TeamsAdapter.TeamViewHolder>() {
    class TeamViewHolder(view:View):RecyclerView.ViewHolder(view){
        val title: TextView
        val desc : TextView
        val image : ImageView

        init {
            title=view.findViewById(R.id.title)
            desc=view.findViewById(R.id.description)
            image=view.findViewById(R.id.image)
        }
    }

    //mange the view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
       // load xml data to code
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return TeamViewHolder(v)

    }

    override fun getItemCount(): Int {
        return teams?.size ?:0
    }


    // the data i retrive
    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams?.get(position)
        holder.title.text = team?.teamName
        holder.desc.text = team?.description
        Glide.with(holder.itemView)
            .load(team?.teamImage)
            .into(holder.image)

    }
}


