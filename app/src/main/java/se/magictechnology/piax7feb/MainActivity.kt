package se.magictechnology.piax7feb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bild1 = findViewById<ImageView>(R.id.bild1)
        var bild2 = findViewById<ImageView>(R.id.bild2)


        bild2.setImageResource(R.drawable.frog)

        Log.i("PIAXDEBUG", "onCreate")

        val model : FancyViewModel by viewModels()

        findViewById<Button>(R.id.mainButton).setOnClickListener {

            var texten = findViewById<EditText>(R.id.mainEdittext).text.toString()

            model.currentName.value = texten
        }

        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            findViewById<TextView>(R.id.mainTextview).text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentName.observe(this, nameObserver)
    }

    override fun onStart() {
        super.onStart()
        Log.i("PIAXDEBUG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("PIAXDEBUG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("PIAXDEBUG", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("PIAXDEBUG", "onStop")
    }
}

class FancyViewModel : ViewModel() {
    var fruit = ""

    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}