package networks.repositories

import adapters.Article
import networks.ArticleResponse
import networks.ArticleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleRepository() {
    private val service: ArticleService
    init {
        val retrofit = Retrofit.Builder().apply {
            baseUrl("https://newsapi.org/v2/")
        .addConverterFactory(GsonConverterFactory.create())}.build()
        service = retrofit.create(ArticleService::class.java)
    }

    fun list(): ArticleResponse {
        val response =  service.list().execute()
        return response.body() ?: ArticleResponse("",0, emptyList())
    }

}

