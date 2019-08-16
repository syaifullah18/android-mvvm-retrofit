package com.example.inicumalatihan.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.SearchView
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.inicumalatihan.R
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inicumalatihan.DiktiAdapter
import com.example.inicumalatihan.models.room.Dikti
import com.example.inicumalatihan.viewModel.remote.DiktiViewModel
import com.google.android.material.snackbar.Snackbar


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class Home : Fragment() {
    var rvHeadline: RecyclerView? = null
    var diktiViewModel: DiktiViewModel? = null
    var adapter: DiktiAdapter ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        diktiViewModel = ViewModelProviders.of(this).get(DiktiViewModel::class.java!!)
        diktiViewModel!!.getDiktiRepository()!!.observe(this, Observer {diktiResponse ->
            try {
                setupRecyclerView(diktiResponse as ArrayList<Dikti>)
            }
            catch (tpe : TypeCastException){
                Snackbar.make(view, "Data Tidak Ditemukan", Snackbar.LENGTH_LONG).show()
            }
        })
    }

    fun getById(){
        diktiViewModel = ViewModelProviders.of(this).get(DiktiViewModel::class.java)
        diktiViewModel!!.getDiktiRepository()!!.observe(this, Observer { diktiResponse ->
            try {
                setupRecyclerView(diktiResponse as ArrayList<Dikti>)
            }
            catch (tpe : TypeCastException){

            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val inflater  = activity?.menuInflater
        inflater?.inflate(R.menu.main_menu, menu)

        val searchItem : MenuItem? = menu?.findItem(R.id.action_search)
        val searchView : SearchView = searchItem?.actionView as SearchView

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }

        })

    }

    private fun setupRecyclerView(diktiList: ArrayList<Dikti>) {
        adapter = activity?.let { DiktiAdapter(it, diktiList) }
        recyclerview_dikti.setAdapter(adapter)
        recyclerview_dikti.layoutManager = LinearLayoutManager(activity)
    }

    interface HomeInterface {
        fun filter(diktiAdapter: DiktiAdapter)
    }


}
