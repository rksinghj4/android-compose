package com.example.statehoisting

import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.android.parcel.Parcelize


class StateHoistingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Parcelize
data class City(val name: String, val country: String) : Parcelable

@Composable
fun CityScreen() {
    var selectedCity = rememberSaveable { //All data types that are added to the Bundle are saved automatically.
        mutableStateOf(City("Madrid", "Spain"))
    }
}


/**
 * If for some reason @Parcelize is not suitable, you can use mapSaver to define your own rule
 * for converting an object into a set of values that the system can save to the Bundle.
 */

data class City1(val name: String, val country: String)

val CitySaver = run {
    val nameKey = "Name"
    val countryKey = "Country"
    mapSaver(
        save = { mapOf(nameKey to it.name, countryKey to it.country) }, // Convert object to map
        restore = { City1(it[nameKey] as String, it[countryKey] as String) } //Restore to object
    )
}

val CitySaverUsingListSaver = listSaver<City1, Any>(
    save = { listOf(it.name, it.country) }, // Convert object to list
    restore = { City1(it[0] as String, it[1] as String) }  //Restore to object
)

@Composable
fun CityScreenWithMapSaver() {
    var selectedCity = rememberSaveable(stateSaver = CitySaver) {
        mutableStateOf(City1("Madrid", "Spain"))
    }

    var selectedCity1 = rememberSaveable(stateSaver = CitySaverUsingListSaver) {
        mutableStateOf(City1("Madrid", "Spain"))
    }
}