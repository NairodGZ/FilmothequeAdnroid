package com.example.demoeni

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.example.demoeni.databinding.ActivityRecyclerViewDemoBinding
import kotlinx.coroutines.launch

class RecyclerViewDemoActivity : ComponentActivity() {

    lateinit var vm : ActivityRecyclerViewDemoBinding;
    lateinit var dataList : List<Personne>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = DataBindingUtil.setContentView(this,R.layout.activity_recycler_view_demo)

        // Connecter notre adapter custom (cellule personne etc) au recyclerview
        val adapter = PersonneAdapter();
        vm.RV.adapter = adapter;

        // Alimenter les données
        // MutableList c'est une liste (comme ArraYlist) mais en observable
        // Pourquoi ? Parceque en Front pour synchroniser les modifcations de la liste en temps réel
        // il faut notifier les changement avec le pattern observable
        //dataList = MutableLiveData<MutableList<Personne>>(mutableListOf(Personne("Nairod", "bellaire.dorian@gmail.com", "RERkxafd", "44100", "Nantes", "0690604026"),
           // Personne("Ninise", "bellaire.mariedenise@gmail.com", "123456", "97139", "Abymes", "0690534012")))

//        dataList.observe(this, {
//            adapter.notifyDataSetChanged();
//        })

        lifecycleScope.launch {
            dataList = PersonneService.PersonApi.retrofitService.getPersonnes();

            adapter.submitList(dataList);

        }



    }
}