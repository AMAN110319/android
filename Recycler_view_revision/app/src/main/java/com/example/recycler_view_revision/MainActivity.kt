package com.example.recycler_view_revision

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycler_view_revision.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var arrContacts:MutableList<ContactModel> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        arrContacts.add(ContactModel(R.drawable.user,"A","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"AB","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"C","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"d","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"E","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"F","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"G","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"H","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"A","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"AB","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"C","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"d","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"E","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"F","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"G","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"H","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"A","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"AB","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"C","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"d","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"E","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"F","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"G","90967876"))
        arrContacts.add(ContactModel(R.drawable.user,"H","90967876"))

//        this is the way how our view must look a like
        binding.recycler.adapter=RecyclerAdapter(arrContacts)
        binding.recycler.layoutManager= LinearLayoutManager(this)
    }
}