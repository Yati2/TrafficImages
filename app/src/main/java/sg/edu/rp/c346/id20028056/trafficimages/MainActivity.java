package sg.edu.rp.c346.id20028056.trafficimages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    AsyncHttpClient client;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.lv);

        client = new AsyncHttpClient();

    }


    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Traffic> alTraffic = new ArrayList<Traffic>();

        client.get("https://api.data.gov.sg/v1/transport/traffic-images", new JsonHttpResponseHandler() {

            String area;
            String imageUrl;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonArrItems = response.getJSONArray("items");
                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
                    JSONArray jsonArrForecasts = firstObj.getJSONArray("cameras");
                    for(int i = 21; i < jsonArrForecasts.length(); i++) {
                        JSONObject jsonObjForecast = jsonArrForecasts.getJSONObject(i);
                        area = getLocation(i);
                        imageUrl = jsonObjForecast.getString("image");
                        Traffic traffic = new Traffic(area, imageUrl);

                        alTraffic.add(traffic);
                        Toast.makeText(MainActivity.this, traffic.getArea(),
                                Toast.LENGTH_SHORT).show();

                    }

                }
                catch(JSONException e){

                }

                //POINT X – Code to display List View
                adapter =new CustomAdapter(MainActivity.this, R.layout.row,alTraffic);
                listView.setAdapter(adapter);

            }//end onSuccess
        });
    }//end onResume

    private String getLocation(int index)
    {
        String area="";
        if(index==21)
        {
           area="Woodlands";
        }
        else if(index==22)
        {
            area="Central Water Catchment";
        }
        else if(index==23)
        {
            area="Sungei Kadut";
        }
        else if(index==24)
        {
            area= "Bukit Timah Expressway ";
        }
        else if(index==25)
        {
            area= "Bukit Panjang ";
        }
        else if(index==26)
        {
            area= "Changi ";
        }
        else if(index==27)
        {
            area= "Tanjong Rhu ";
        }
        else if(index==28)
        {
            area= "Tampines";
        }
        else if(index==29)
        {
            area= "Bedok";
        }
        else if(index==30)
        {
            area= "ECP";
        }
        return area;

    }





}