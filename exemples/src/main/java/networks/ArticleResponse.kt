package networks

import adapters.Article

data class ArticleResponse(val status : String, val totalResults: Int, val articles : List<Article>){

}