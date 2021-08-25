package com.tispunshahryar960103.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.tispunshahryar960103.coroutinesexample.database.SubscriberDatabase
import com.tispunshahryar960103.coroutinesexample.databinding.ActivityMainBinding
import com.tispunshahryar960103.coroutinesexample.repository.SubscriberRepository
import com.tispunshahryar960103.coroutinesexample.viewModel.SubscriberViewModel
import com.tispunshahryar960103.coroutinesexample.viewModel.SubscriberViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository = SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)

        val subscriberViewModel =
            ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)

        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this


        subscriberViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })



    }


}