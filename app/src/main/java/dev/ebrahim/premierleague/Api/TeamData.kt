import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("strTeam")
    val teamName: String,
    @SerializedName("strTeamLogo")
    val teamImage: String,
//    @SerializedName("strStadium")
//    val stadiumName: String,
//    @SerializedName("strFacebook")
//    val facebookPage: String,
//    @SerializedName("strTwitter")
//    val twitterHandle: String,
//    @SerializedName("strInstagram")
//    val instagramHandle: String,
    @SerializedName("strDescriptionEN")
    val description: String
)

data class TeamList(
    @SerializedName("teams")
    val teams: List<Team>
)

