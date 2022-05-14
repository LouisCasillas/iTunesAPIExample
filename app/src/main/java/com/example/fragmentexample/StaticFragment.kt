package com.example.fragmentexample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class StaticFragment: Fragment() {

    // The fragment first is attached to the Activity
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    // The fragment is created
    // We do not reference the views
    // We handle object creation or dependencies here
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var etMoveThis: EditText
    lateinit var btnMoveThis: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_static, container, false)
        etMoveThis = view.findViewById(R.id.et_move_this)
        btnMoveThis = view.findViewById(R.id.btn_move_this)
        btnMoveThis.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.frag_dynamic, DynamicFragment.newInstance(etMoveThis.text.toString()))
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}