package com.example.projetoicc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.projetoicc2.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLngBounds

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val places = arrayListOf(
        Place(
            "Igreja do Cajuru",
            LatLng(-25.444811843916582, -49.23031524232814),
            "R. Santo Agostinho, 347 - Cajuru, Curitiba - PR"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_maps)

        supportActionBar?.hide()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment.getMapAsync { googleMap ->
            addMarkers(googleMap)

            googleMap.setOnMapLoadedCallback {
                val bounds = LatLngBounds.builder()

                places.forEach {
                    bounds.include(it.latLng)
                }

                    googleMap.moveCamera((CameraUpdateFactory.newLatLng(LatLng(-25.444811843916582, -49.23031524232814))))
                    googleMap.moveCamera(CameraUpdateFactory.zoomTo(15F));
            }
        }
    }

    private fun addMarkers(googleMap: GoogleMap) {
        places.forEach { place ->
            val marker = googleMap.addMarker(MarkerOptions()
                .title(place.name) // Título que tem no pin
                .snippet(place.address)  // Enderoço do pin
                .position(place.latLng))
                //trocar o pin por outro vector asset
                //?.setIcon(BitmapHelper.vectorToBitmap(this, R.drawable.ic_flag, ContextCompat.getColor(this, R.color.black)))
        }
    }

    data class Place(
        val name: String,
        val latLng: LatLng,
        val address: String,
    )


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val curitiba = LatLng(-25.44, -49.23)
        mMap.addMarker(MarkerOptions().position(curitiba).title("Igreja de Cristo no Cajuru"))
        //googleMap.mapType = GoogleMap.MAP_TYPE_HYBRID;
        mMap.moveCamera(CameraUpdateFactory.newLatLng(curitiba))// Move the camera to the map coordinates and zoom in closer.
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(curitiba));
        googleMap.moveCamera(CameraUpdateFactory.zoomTo(15F));
        // Display traffic.
        googleMap.isTrafficEnabled = true
    }
}