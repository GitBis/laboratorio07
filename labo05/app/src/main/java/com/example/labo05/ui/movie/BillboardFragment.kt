package com.example.labo05.ui.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import com.example.labo05.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BillboardFragment : Fragment() {

private lateinit var floatingActionButton: FloatingActionButton
private lateinit var cardView: CardView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_billboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind()
        floatingActionButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment3_to_newMovieFragment)
        }
        band()
        cardView.setOnClickListener {
            it.findNavController().navigate(R.id.action_billboardFragment3_to_movieFragment)
        }
    }

    private fun bind(){
        floatingActionButton = view?.findViewById(R.id.floatingActionButton2) as FloatingActionButton
    }

    private fun band(){
        cardView = view?.findViewById(R.id.cardViewStarWars) as CardView
    }

}
