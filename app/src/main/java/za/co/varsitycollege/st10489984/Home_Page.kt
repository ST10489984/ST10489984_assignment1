package za.co.varsitycollege.st10489984

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Home_Page : AppCompatActivity() {
    enum class Type {
        Breakfast,
        Lunch,
        Dinner
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val foodSuggestionEditText = findViewById<TextView>(R.id.foodSuggestionEditText)

        val generateFoodButton = findViewById<Button>(R.id.generateFoodButton)

        val timeEditText = findViewById<EditText>(R.id.timeEditText)

        val clearFoodButton = findViewById<Button>(R.id.resetFoodButton)

        val typeSpinner = findViewById<Spinner>(R.id.typeSpinner)

        typeSpinner.adapter=ArrayAdapter<Home_Page.Type>(this,android.R.layout.simple_list_item_1,Type.values())

        clearFoodButton?.setOnClickListener {
            Toast.makeText(this@Home_Page, "Clearing options", Toast.LENGTH_SHORT).show()
            timeEditText.text.clear()
            foodSuggestionEditText.text=""
        }

        generateFoodButton?.setOnClickListener {
            Toast.makeText(this@Home_Page, "Generating Food", Toast.LENGTH_SHORT).show()
            val type = typeSpinner.selectedItem as Type
            val time = timeEditText.text.toString()

            if (time.isEmpty()) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Input Error")
                builder.setMessage("Please enter whether you would like something light or heavy.")
                builder.setPositiveButton("OK") {
                    dialog, _ -> dialog.dismiss()
                }
                builder.show()
                return@setOnClickListener
            }


            var food: String = ""
            when {
                type==Type.Breakfast && timeEditText.text.toString()=="Light" -> food = "You may have:\n\n" +
                        "Chocolate-Zucchini Bran Muffin\n" + "Sweet Potatoes with Yogurt, Almond Butter and Pepita Granola\n" +
                        "Blueberry-Banana-Nut Smoothie\n" + "Breakfast Taco\n" + "Focaccia French Toast\n"

                type==Type.Breakfast && timeEditText.text.toString()=="Heavy" -> food = "You may have:\n\n " +
                        "Tomato and Feta Baked Eggs\n" + "Scrambled Eggs with smoked Trout and Crème Fraiche\n" +
                        "Customizable Egg Muffins\n" + "Sweet Potato Breakfast Burritos\n" + "Cornflakes\n"

                type==Type.Lunch && timeEditText.text.toString()=="Light" -> food = "You may have a:\n\n" + "Chickpea and Lamb Casserole with Preserved Lemon\n" +
                        "Thai Beef and Sweet Chilli Lettuce Wraps\n" + "Lazenby Worcestershire\n" +
                        "Cheese Sandwich\n" + "Maggi Lazenby Stir Fry\n"

                type==Type.Lunch && timeEditText.text.toString()=="Heavy" -> food = "You may have:\n\n" +
                        "Sweet Potato and Peanut curry\n" + "Pepper  Steak Pie\n" + "Fish Pie Mac n Cheese\n" +
                        "Sausage ragu\n" + "Spicy chickpea stew\n"

                type==Type.Dinner && timeEditText.text.toString()=="Light" -> food = "You may have:\n\n" +
                        "Baked Triple Cream Brie, Honey\n" + "Roasted Cauliflower Risotto Pinenuts & Grana Padano\n" +
                        "Gin, Kaffir Lime Cured Salmon, Cucumber & Avocado\n" + "Crispy Pork Belly, Asian Salad & Red Wine Caramel\n" +
                        "Squid Salad, Roast Tomato, Potato & Capsicum Chilli Relish\n"

                type==Type.Dinner && timeEditText.text.toString()=="Heavy" -> food = "You may have:\n\n" +
                        "Lasagna\n" + "Mac n Cheese\n" + "Stew\n" + "Mince mate\n" + "Achni\n"
            }
            foodSuggestionEditText.text = food

        }
    }
}