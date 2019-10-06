package networks

import adapters.Article
import retrofit2.Call
import retrofit2.http.GET

interface ArticleService {
    @GET("top-headlines?country=us&category=business&apiKey=34f747a623354f7e9c2704f486bed0b9")

    fun list(): Call<ArticleResponse>
    //API : 34f747a623354f7e9c2704f486bed0b9
}