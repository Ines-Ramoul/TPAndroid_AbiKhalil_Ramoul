package adapters

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
import fr.unice.miage.mbds.exemples.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import networks.repositories.ArticleRepository


class ArticlesFragment : Fragment() {
    private val repository = ArticleRepository()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_articles, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        GlobalScope.launch {
            getData()
        }
    }

    //S'execute dans un thread secondeaire
    private suspend fun getData() {
        withContext(Dispatchers.IO) {
            val result = repository.list()
            bindData(result.articles)
        }
    }

    lateinit var root : View
    lateinit var recyclerView : RecyclerView

    //S'execute sur le thread principal
    private suspend fun bindData(result: List<Article>) {
        withContext(Dispatchers.Main) {
            val articles =  result
            val recyclerView: RecyclerView = view!!.findViewById(R.id.recycler_view)
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
        bindRecyclerView(view)
        //bindSpinner(view)
    }

    private fun bindRecyclerView(view: View){
        val listArticles = listOf(
            Article("Titre 1", "Description 1"),
            Article("Titre 1", "Description 1"),
            Article("Titre 1", "Description 1"),
            Article("Titre 1", "Description 1")
        )
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val articles = listOf<Article>()
        val adapterRecycler = ArticleAdapter(listArticles)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.adapter = adapterRecycler
    }

    /*private fun bindSpinner(view: View){
        //recupérer une liste de string depuis les ressources
        val planetes = resources.getStringArray(R.array.planetes)
//recupérer l'instance du spinner dans la vue
        val spinner : Spinner = view.findViewById(R.id.spinner)
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
            ) {
                Toast.makeText(
                    context,
                    "Vous avez selectionné ${planetes[position]}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }



    }*/



}