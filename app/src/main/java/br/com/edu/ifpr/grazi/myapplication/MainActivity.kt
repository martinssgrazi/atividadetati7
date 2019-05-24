package br.com.edu.ifpr.grazi.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.edu.ifpr.grazi.myapplication.entidades.Noticia
import br.com.edu.ifpr.grazi.myapplication.entidades.ResultadoNoticias
import br.com.edu.ifpr.grazi.myapplication.servicos.NoticiasService
import br.com.edu.ifpr.grazi.myapplication.ui.NoticiaAdapter
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_noticia_compacto.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var retrofit: Retrofit
    lateinit var service: NoticiasService
    lateinit var adapter: NoticiaAdapter

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configuraRetrofit()
        carregaDados()



        btBusca.setOnClickListener{
            carregaDados()
        }


    }

    fun configuraRetrofit() {
        val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        service = retrofit.create(NoticiasService::class.java)
    }


    @SuppressLint("NewApi")
    fun carregaDados() {
        val country = resources.configuration.locales[0].country.toLowerCase() // "br" "ar"
        service.getNews(txtBusca.text.toString(), country).enqueue(object : Callback<ResultadoNoticias> {
            override fun onFailure(call: Call<ResultadoNoticias>, t: Throwable) {
               Log.e("grazi", t.message, t)
            }

            override fun onResponse(call: Call<ResultadoNoticias>, response: Response<ResultadoNoticias>) {
                val noticias = response.body()?.noticias
                if (noticias != null)
                    configuraRecyclerView(noticias)

            }
        })
    }

    fun configuraRecyclerView(noticias: List<Noticia>) {
        adapter = NoticiaAdapter(noticias.toMutableList())
        listNoticias.adapter = adapter

        listNoticias.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false
        )
    }

}
