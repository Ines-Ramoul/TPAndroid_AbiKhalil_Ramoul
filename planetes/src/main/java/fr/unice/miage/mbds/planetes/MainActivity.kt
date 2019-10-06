package fr.unice.miage.mbds.planetes

import adapters.ArticlesFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.unice.miage.mbds.planetes.R

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
