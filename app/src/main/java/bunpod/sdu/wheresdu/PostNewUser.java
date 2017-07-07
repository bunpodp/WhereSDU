package bunpod.sdu.wheresdu;

import android.content.Context;
import android.os.AsyncTask; //เด็กดื้อ จะพยายามส่งข้อมูลไปยังเซิร์ฟเวรอ์

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by ASUS PC on 7/7/2560.
 */

public class PostNewUser extends AsyncTask<String, Void, String> {

    private Context context; //การต่อท่อให้ตัวอื่นทำงาน

    public PostNewUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", strings[0])
                    .add("User", strings[1])
                    .add("Password", strings[2])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[3]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }
}// Main Class
