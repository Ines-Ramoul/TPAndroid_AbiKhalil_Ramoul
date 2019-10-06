package adapters

import android.R
import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.android.synthetic.main.fragment_articles.*;

class ArticlesFragment : Fragment() {

   // private val repository = ArticleRepository()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(fr.unice.miage.mbds.planetes.R.layout.fragment_articles, container, false)
    }

   /* override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch {
            getData()
        }
    }*/

    //S'execute dans un thread secondeaire
   /* private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            bindData(result.articles)
        }
    }*/

    lateinit var root : View
    lateinit var recyclerView : RecyclerView

    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {
            val articles =  result
            val recyclerView: RecyclerView = view!!.findViewById(fr.unice.miage.mbds.planetes.R.id.recycler_view)
            val adapterRecycler = ArticleAdapter(articles)
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapterRecycler
        }
    }



    fun addFragmentToActivity(supportFragmentManager: FragmentManager, fragment: Fragment, frameId: Int) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(frameId, fragment)
        transaction.commit()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        root = view
        //bindRecyclerView(view)
        bindSpinner(view)
    }

    private fun bindRecyclerView( text: String){
        //val mySpinner = view.findViewById(fr.unice.miage.mbds.planetes.R.id.spinner) as Spinner
        //val text = mySpinner.selectedItem.toString()
        var recyclerView: RecyclerView = this.view!!.findViewById(fr.unice.miage.mbds.planetes.R.id.recycler_view)
        var articles = listOf<Article>()

        when (text) {
            "Mercure" -> {
                articles = listOf<Article>(
                    Article(text, getString(fr.unice.miage.mbds.planetes.R.string.Mercure), fr.unice.miage.mbds.planetes.R.drawable.mercure)
                )
            }
            "Venus" -> {
                articles = listOf<Article>(
                    Article(text, getString(fr.unice.miage.mbds.planetes.R.string.Venus), fr.unice.miage.mbds.planetes.R.drawable.venus)
                )
            }
            "Terre" -> {
                articles = listOf<Article>(
                    Article(text, getString(fr.unice.miage.mbds.planetes.R.string.Terre), fr.unice.miage.mbds.planetes.R.drawable.terre)
                )
            }
            "Mars" -> {
                articles = listOf<Article>(
                    Article(text, getString(fr.unice.miage.mbds.planetes.R.string.Mars), fr.unice.miage.mbds.planetes.R.drawable.mars)
                )
            }
            "Jupiter" -> {
                articles = listOf<Article>(
                    Article(text, getString(fr.unice.miage.mbds.planetes.R.string.Jupiter), fr.unice.miage.mbds.planetes.R.drawable.jupiter)
                )
            }
            "Saturne" -> {
                articles = listOf<Article>(
                    Article(text, getString(fr.unice.miage.mbds.planetes.R.string.Saturne), fr.unice.miage.mbds.planetes.R.drawable.saturne)
                )
            }
            "Uranus" -> {
                articles = listOf<Article>(
                    Article(text, getString(fr.unice.miage.mbds.planetes.R.string.Uranus), fr.unice.miage.mbds.planetes.R.drawable.uranus)
                )
            }
            "Neptune" -> {
                articles = listOf<Article>(
                    Article(text, getString(fr.unice.miage.mbds.planetes.R.string.Neptune), fr.unice.miage.mbds.planetes.R.drawable.neptune)
                )
            }
        }

        val adapterRecycler = ArticleAdapter(articles)
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        recyclerView.adapter = adapterRecycler
    }

    private fun bindSpinner(view: View){
        //recupérer une liste de string depuis les ressources
        val planetes = resources.getStringArray(fr.unice.miage.mbds.planetes.R.array.planets)
//recupérer l'instance du spinner dans la vue
        val spinner : Spinner = view.findViewById(fr.unice.miage.mbds.planetes.R.id.spinner)
//instancier l'adapteur
        val adapter = ArrayAdapter(view.context, android.R.layout.simple_spinner_item, planetes)
//associer l'adapter au spinner
        spinner.adapter = adapter
//Listener quand l'utilisateur selectionne un élément
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(view.context, "Vous n'avez rien selectionné", Toast.LENGTH_LONG)
                    .show()
            }

            override fun onItemSelected(
                adapter: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ): Unit {
                Toast.makeText(
                    context,
                    "Vous avez selectionné ${planetes[position]}",
                    Toast.LENGTH_LONG
                ).show()
                bindRecyclerView(planetes[position].toString())

            }

        }




}
}