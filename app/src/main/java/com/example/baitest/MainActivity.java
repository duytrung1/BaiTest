package com.example.baitest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitest.Modeel.JsonApi;
import com.example.baitest.Modeel.Model;
import com.example.baitest.Modeel.Subjects;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
TextView so1;
RecyclerView recyclerView;
Adapter adapter;
TextView code;
private List<Subjects> arrayList=new ArrayList<>();
String url="https://apingweb.com/api/daa62f1fc782e55fb2e8418eb2bf6a1c20/employee";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Screen 1");
        recyclerView = findViewById(R.id.recyview);
        code=findViewById(R.id.code);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://apingweb.com/api/daa62f1fc782e55fb2e8418eb2bf6a1c20/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final JsonApi jsonApi=retrofit.create(JsonApi.class);
        Call<Model> call=jsonApi.getPost();
         call.enqueue(new Callback<Model>() {
             @Override
             public void onResponse(Call<Model> call, Response<Model> response) {
                 arrayList=response.body().getData();
                 adapter=new Adapter(arrayList,MainActivity.this);
                 recyclerView.setAdapter(adapter);

             }

             @Override
             public void onFailure(Call<Model> call, Throwable t) {

             }
         });
       // GetData(url);
    }
//    private void GetData(String url) {
//        RequestQueue requestQueue = Volley.newRequestQueue(getApplication());
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
//                new com.android.volley.Response.Listener<JSONArray>() {
//                    @Override
//                    public void onResponse(JSONArray response) {
//                        for (int i = 0; i < response.length(); i++) {
//                            try {
//                                JSONObject object = response.getJSONObject(i);
//                                Toast.makeText(MainActivity.this, ""+object, Toast.LENGTH_SHORT).show();
//
//
//                            } catch (JSONException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getBaseContext(), "loi", Toast.LENGTH_SHORT).show();
//                    }
//                }
//        );
//        requestQueue.add(jsonArrayRequest);
//    }

}
