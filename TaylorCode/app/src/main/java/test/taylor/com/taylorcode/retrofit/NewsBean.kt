package test.taylor.com.taylorcode.retrofit

import com.google.gson.annotations.SerializedName
import test.taylor.com.taylorcode.util.value

data class NewsBean(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: List<News>?
)

data class News(
    @SerializedName("path") var path: String?,
    @SerializedName("image") var image: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("passtime") var passtime: String?
){
    fun toNews() = test.taylor.com.taylorcode.retrofit.repository_livedata.room.News(path,image,title.value,passtime)
}