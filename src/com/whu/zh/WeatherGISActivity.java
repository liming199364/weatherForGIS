package com.whu.zh;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;


import com.esri.android.map.MapView;
import com.esri.android.map.TiledLayer;
import com.esri.android.map.ags.ArcGISLocalTiledLayer;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;


public class WeatherGISActivity extends Activity {
	
	MapView mMapView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		mMapView = new MapView(this);// 实例化MapView对象
		// Retrieve the map and initial extent from XML layout
		mMapView = (MapView) findViewById(R.id.map);
		//添加底图
//		mMapView.addLayer(new ArcGISTiledMapServiceLayer(""+ "http://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer"));
		ArcGISLocalTiledLayer baseMap = new ArcGISLocalTiledLayer(Environment.getExternalStorageDirectory()+"/HuBei.tpk");
		mMapView.addLayer(baseMap);
    }

	@Override
	protected void onDestroy() {
		super.onDestroy();
 }
	@Override
	protected void onPause() {
		super.onPause();
		mMapView.pause();
 }
	@Override
	protected void onResume() {
		super.onResume();
		mMapView.unpause();
	}

}