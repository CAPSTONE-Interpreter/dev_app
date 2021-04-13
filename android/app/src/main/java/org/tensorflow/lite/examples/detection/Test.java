package org.tensorflow.lite.examples.detection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

//import io.netty.handler.codec.http.multipart.FileUpload;

public class Test extends AppCompatActivity {

    private Button gogo;
    private ImageView imageViewSelected;
    private Button buttonImageSend, buttonImageSelection;
    private File tempSelectFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        buttonImageSend = findViewById(R.id.btnImageSend);
        buttonImageSend.setEnabled(false);
        buttonImageSend.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view){
                FileUploadUtils.send2Server(tempSelectFile);
                                               }
                                           }
        );


        buttonImageSelection = findViewById(R.id.btnImageSelection);
        buttonImageSelection.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_CREATE_DOCUMENT);
                startActivityForResult(intent, 1);
            }
        });
        imageViewSelected = findViewById(R.id.imgViewSelected);

        gogo = findViewById(R.id.gogo);
        gogo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"로그인 되었습니다.", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Test.this, DetectorActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 1 || resultCode != RESULT_OK) {
            return;
        }

        Uri dataUri = data.getData();
        imageViewSelected.setImageURI(dataUri);

        try {
            InputStream in = getContentResolver().openInputStream(dataUri);
            Bitmap image = BitmapFactory.decodeStream(in);
            imageViewSelected.setImageBitmap(image);
            in.close();

            String date = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss").format(new Date());
            tempSelectFile = new File(Environment.getExternalStorageDirectory() + "Pictures/Test/", "temp_" + date + ".jpeg");
            OutputStream out = new FileOutputStream(tempSelectFile);
            image.compress(Bitmap.CompressFormat.JPEG, 100, out);
        } catch (Exception e) {
            e.printStackTrace();
        }
        buttonImageSend.setEnabled(true);
    }
}
