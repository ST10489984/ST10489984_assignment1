package za.co.varsitycollege.st10489984

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val getStartedButton = findViewById<Button>(R.id.getStartedButton)

        val newUserSwitch = findViewById<Switch>(R.id.newUserSwitch)

        getStartedButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Starting", Toast.LENGTH_SHORT).show()
            var user: Boolean = newUserSwitch.isChecked
            if (user) {
                val intent = Intent(this, New_User::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this,Home_Page::class.java)
                startActivity(intent)
            }

        }
    }
}