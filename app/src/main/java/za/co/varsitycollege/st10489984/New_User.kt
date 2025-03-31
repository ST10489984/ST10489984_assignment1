package za.co.varsitycollege.st10489984

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class New_User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the button for creating a new user
        val newUserButton = findViewById<Button>(R.id.newUserButton)

        // Set an OnClickListener for the new user button
        newUserButton.setOnClickListener() {
            // Create an Intent to start the Home_Page activity
            val intent = Intent(this,Home_Page::class.java)
            // Start the Home_Page activity
            startActivity(intent)
        }
    }
}