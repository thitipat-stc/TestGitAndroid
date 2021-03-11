package com.tkm.testgitandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tkm.testgitandroid.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        val btnTest: TextView = root.findViewById(R.id.btn_test)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        btnTest.setOnClickListener {
            textView.text = "Test"
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.btnChaiwichit)
        button.setOnClickListener {
            Toast.makeText(context,"Chaiwichit Ma Laaw", Toast.LENGTH_LONG).show()
        }
    }
}