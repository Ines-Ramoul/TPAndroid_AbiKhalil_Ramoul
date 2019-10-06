package fr.unice.miage.mbds.exemples

import adapters.Article
import adapters.ArticleAdapter
import adapters.ArticlesFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.unice.miage.mbds.exemples.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindFragment()



//finalement, on valide la transaction


    }
private fun bindFragment() {

    //créer une instance du fragment
    val fragment = ArticlesFragment()

//créer un transaction sur le fragment manager
    supportFragmentManager.beginTransaction().apply {
        //replacer le précédent fragment, s'il existe
        replace(R.id.fragment_container, fragment)
        //ajouter la transaction dans la stack
        addToBackStack(null)
    }.commit()
}
}




