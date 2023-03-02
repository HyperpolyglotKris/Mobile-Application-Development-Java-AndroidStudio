package com.example.myyelp;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.os.Handler;

public class ObjectsArrayList extends ViewModel {

    private MutableLiveData<ObjectsReturn> objectLiveData;
    ObjectsReturn recyclerDataList;
    private String objectName;
    private String objectLocation;

    public ObjectsArrayList() {
        objectLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<ObjectsReturn> getObjectsArrayListObserver() {
        return objectLiveData;
    }

    public void loadObjectsList(String searchText) {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            YelpAPI api = new YelpClient().build();
            Call<ObjectsReturn> call = api.getObjects(searchText, "montreal");
            Callback<ObjectsReturn> callback = new Callback<ObjectsReturn>() {

                @Override
                public void onResponse(Call<ObjectsReturn> call, Response<ObjectsReturn> response) {
                    recyclerDataList = response.body();
                    objectLiveData.postValue(recyclerDataList);
                    Log.d("Testing","image = "+ recyclerDataList.objectsModelArrayList.get(2).getImageUrl());
                    Log.d("Testing", "response =" + response.body().toString());
                    for (int i=0; i<recyclerDataList.objectsModelArrayList.size(); i++) {
                        final ObjectsModel objectsModel = recyclerDataList.objectsModelArrayList.get(i);
                        Log.d("Testing", "name = " + objectsModel.getImageUrl());
                    }
                }

                @Override
                public void onFailure(Call<ObjectsReturn> call, Throwable t) {
                    Log.d("Testing", "error" + t.getLocalizedMessage());
                }
            };
            call.enqueue(callback);
        }, 5000);
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public void setObjectLocation(String objectLocation) {
        this.objectLocation = objectLocation;
    }
}