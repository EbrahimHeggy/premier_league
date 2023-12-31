package dev.ebrahim.premierleague
import dev.ebrahim.premierleague.Adapter.TeamsAdapter
import TeamList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val adapter: TeamsAdapter by lazy { TeamsAdapter(emptyList()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val layoutManager=LinearLayoutManager(this)
        val rv : RecyclerView = findViewById(R.id.rv_teams)
        rv.layoutManager=layoutManager
        rv.adapter=adapter
        requestTeams()
    }


    fun requestTeams() {
        retrofit.getAllTeamsInEnglishPremierLeague().enqueue(object : Callback<TeamList> {
            override fun onResponse(call: Call<TeamList>, response: Response<TeamList>) {
                if (!response.isSuccessful) return
                val teamResponse = response.body()
                teamResponse?.let {
                    adapter.teams = teamResponse.teams
                    adapter.notifyDataSetChanged()
                }
    }
            override fun onFailure(call: Call<TeamList>, t: Throwable) {
                Log.d("***", " onFail ${t.localizedMessage}")
            }
        })
    }


}