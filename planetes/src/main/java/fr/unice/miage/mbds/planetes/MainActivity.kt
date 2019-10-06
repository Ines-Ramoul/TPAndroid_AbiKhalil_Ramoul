package fr.unice.miage.mbds.planetes

import adapters.Article
import adapters.ArticleAdapter
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // bindFragment()
        //recupérer une liste de string depuis les ressources

        val planetes = resources.getStringArray(fr.unice.miage.mbds.planetes.R.array.planets)
//recupérer l'instance du spinner dans la vue
        val spinner: Spinner = findViewById(R.id.spinner)
//instancier l'adapteur
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, planetes)
//associer l'adapter au spinner
        spinner.adapter = adapter
//Listener quand l'utilisateur selectionne un élément
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(baseContext, "Vous n'avez rien selectionné", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onItemSelected(
                adapter: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ): Unit {
                Toast.makeText(
                    baseContext,
                    "Vous avez selectionné ${planetes[position]}",
                    Toast.LENGTH_LONG
                ).show()
                bindRecyclerView(planetes[position].toString())
            }



        }


    }


//finalement, on valide la transaction


    private fun bindRecyclerView(text: String) {
        //val mySpinner = view.findViewById(fr.unice.miage.mbds.planetes.R.id.spinner) as Spinner
        //val text = mySpinner.selectedItem.toString()
        var recyclerView: RecyclerView =
            findViewById(R.id.recycler_view)
        var articles = listOf<Article>()

        when (text) {
            "Mercure" -> {
                articles = listOf<Article>(
                    Article(
                        text,
                        getString(R.string.Mercure),
                        R.drawable.mercure
                    )
                )
            }
            "Venus" -> {
                articles = listOf<Article>(
                    Article(
                        text,
                        getString(R.string.Venus),
                        R.drawable.venus
                    )
                )
            }
            "Terre" -> {
                articles = listOf<Article>(
                    Article(
                        text,
                        getString(R.string.Terre),
                        R.drawable.terre
                    )
                )
            }
            "Mars" -> {
                articles = listOf<Article>(
                    Article(
                        text,
                        getString(R.string.Mars),
                        R.drawable.mars
                    )
                )
            }
            "Jupiter" -> {
                articles = listOf<Article>(
                    Article(
                        text,
                        getString(R.string.Jupiter),
                        R.drawable.jupiter
                    )
                )
            }
            "Saturne" -> {
                articles = listOf<Article>(
                    Article(
                        text,
                        getString(R.string.Saturne),
                        R.drawable.saturne
                    )
                )
            }
            "Uranus" -> {
                articles = listOf<Article>(
                    Article(
                        text,
                        getString(R.string.Uranus),
                        R.drawable.uranus
                    )
                )
            }
            "Neptune" -> {
                articles = listOf<Article>(
                    Article(
                        text,
                        getString(R.string.Neptune),
                        R.drawable.neptune
                    )
                )
            }
        }

        val adapterRecycler = ArticleAdapter(articles)
        recyclerView.layoutManager = LinearLayoutManager(baseContext)
        recyclerView.adapter = adapterRecycler
    }
}



