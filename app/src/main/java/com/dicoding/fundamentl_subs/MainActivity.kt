package com.dicoding.fundamentl_subs

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Intents.Insert.DATA
import android.provider.SyncStateContract.Columns.DATA
import android.widget.AdapterView
import android.widget.ListView
import com.dicoding.fundamentl_subs.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var adapter: SandwhichesAdapter
    private lateinit var username:Array<String>
    private lateinit var name:Array<String>
    private lateinit var location:Array<String>
    private lateinit var repository:Array<String>
    private lateinit var company:Array<String>
    private lateinit var followers:Array<String>
    private lateinit var following:Array<String>
    private lateinit var Avatar: TypedArray
    private lateinit var binding: ActivityMainBinding
    private var sands = arrayListOf<Sandwhiches>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listview : ListView = findViewById(R.id.lv_item)
        adapter = SandwhichesAdapter(this)
        listview.adapter = adapter

        prepare()
        inptitem()


        listview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val intent = Intent(this@MainActivity, ClickedItemDetail::class.java)
            intent.putExtra(ClickedItemDetail.EXTRA_DATA,sands[position])
            startActivity(intent)
        }


    }

    private fun prepare(){
        Avatar = resources.obtainTypedArray(R.array.pp_avatar)
        username = resources.getStringArray(R.array.u_name)
        name = resources.getStringArray(R.array.name)
        company = resources.getStringArray(R.array.git_company)
        location = resources.getStringArray(R.array.git_location)
        repository = resources.getStringArray(R.array.repository)
        followers = resources.getStringArray(R.array.git_followers)
        following = resources.getStringArray(R.array.git_following)
    }

    private fun inptitem() {
        for (position in name.indices){
            val user = Sandwhiches(
                username[position],
                name[position],
                Avatar.getResourceId(position, 0),
                company[position],
                followers[position],
                following[position],
                location[position],
                repository[position]
            )
            sands.add(user)
        }
        adapter.sandwhich = sands
    }

}