package com.example.homepage.playSquare.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homepage.R


class SquareRecommendFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_square_recommend, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SquareRecommendFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SquareRecommendFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}