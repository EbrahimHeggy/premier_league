import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PremierLeagueTeamsApi {

    // search all teams in the English Premier League
    @GET("search_all_teams.php?l=English%20Premier%20League")
    fun getAllTeamsInEnglishPremierLeague(): Call<TeamList>
}

// Create a Retrofit instance
val retrofit = Retrofit.Builder()
    .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
    .addConverterFactory(GsonConverterFactory.create())
    .build().create(PremierLeagueTeamsApi::class.java)
