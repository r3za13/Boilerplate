package ir.r3za.boilerplate

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.testStringLiveData.observe(this, Observer { it ->
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            tvTest.text = it
        })

        tvTest.setOnClickListener {
            mainViewModel.onPageOpened()
        }

    }
}