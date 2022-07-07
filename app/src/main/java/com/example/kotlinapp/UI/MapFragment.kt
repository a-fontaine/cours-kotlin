package com.example.kotlinapp.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.kotlinapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.map_fragment, container, false)

        val mapFragment = childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        mapFragment!!.getMapAsync(OnMapReadyCallback { mMap: GoogleMap ->
            val username = arguments?.getString("username")
            val lat = arguments?.getDouble("lat") as Double
            val lng = arguments?.getDouble("lng") as Double
            if (activity != null) {
                val googleMap = mMap
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
                googleMap.getUiSettings().setMyLocationButtonEnabled(true)
                googleMap.getUiSettings().setCompassEnabled(true)
                googleMap.getUiSettings().setRotateGesturesEnabled(true)
                googleMap.getUiSettings().setZoomGesturesEnabled(true)

                // Add a marker in Sydney and move the camera

                val latlng = LatLng(lat, lng)
                googleMap.addMarker(MarkerOptions().position(latlng).title(username))
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng))

            }
        })

        return v
    }
}