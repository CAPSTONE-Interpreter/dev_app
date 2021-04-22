package org.tensorflow.lite.examples.detection;

import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FileUploadUtils {
    public static void send2Server(File file) {
        Log.v("태그", "메시지");
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("files", file.getName(), RequestBody.create(MultipartBody.FORM, file))
//                .build();

        Request request = new Request.Builder()
//                .url("http://127.0.0.1:8000/app/hello/")

                .url("http://10.0.2.2:8000/app/hello/")
//                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        Log.v("태그", "pass");
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            //          Callback function to check data returned
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("TEST : ", response.body().string());
            }
        });
    }
}
