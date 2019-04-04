package olah.dome.smartscale

import android.content.Intent
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import olah.dome.smartscale.interactor.FoodInteractor
import olah.dome.smartscale.model.Nutritions
import java.lang.Integer.parseInt

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttSearch.setOnClickListener { gethurka() }
        buttLogout.setOnClickListener { logout() }
    }

    fun gethurka()=execute{
        showProgressDialog()
        val nut: Nutritions? = FoodInteractor.getFood(etFood.text.toString())
        hideProgressDialog()
        val gotGramValue = 234
        val carbsInt = parseInt(nut?.carbs?.value?.toString())
        val caloriesInt = parseInt(nut?.calories?.value?.toString())
        val fatInt = parseInt(nut?.fat?.value?.toString())
        val proteinInt = parseInt(nut?.protein?.value?.toString())
        val carbs = carbsInt * gotGramValue / 100
        val calories = caloriesInt * gotGramValue / 100
        val fat = fatInt * gotGramValue / 100
        val protein = proteinInt * gotGramValue / 100


        tvGram.text = gotGramValue.toString() + " g"
        tvCarbs.text = carbs.toString() + " " +nut?.carbs?.unit
        tvCalories.text = calories.toString() + " " + nut?.calories?.unit
        tvFat.text = fat.toString() + " " + nut?.fat?.unit
        tvProtein.text = protein.toString() + " " + nut?.protein?.unit

        
        //tvCarbs.text = (gotGramValue * nut?.carbs?.value?.toString().toIntOrNull() + nut?.carbs?.unit ?: "Search another food name"
        //tvCalories.text = (gotGramValue * nut?.calories?.value!!.toInt()).toString() + nut?.calories?.unit ?: "Search another food name"
        //tvFat.text = (gotGramValue * nut?.fat?.value!!.toInt()).toString() + nut?.fat?.unit ?: "Search another food name"
        //tvProtein.text = (gotGramValue * nut?.protein?.value!!.toInt()).toString() + nut?.fat?.unit ?: "Search another food name"
    }

    fun logout() {
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}
