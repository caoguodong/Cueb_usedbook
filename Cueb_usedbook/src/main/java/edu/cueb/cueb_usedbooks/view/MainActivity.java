package edu.cueb.cueb_usedbooks.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.cueb.cueb_usedbooks.R;


public class MainActivity extends ActionBarActivity {

    private final static int SCANNIN_GREQUEST_CODE = 1;

    private TextView mTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.result);
        Button mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MipcaActivityCapture.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
            }
        });
//        BitmapDrawable bitmap = (BitmapDrawable) getResources().getDrawable(R.drawable.ic_launcher);
//
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
//        bitmap.getBitmap().compress(Bitmap.CompressFormat.PNG,100,stream);
//        byte[] bytes = stream.toByteArray();
//        String key = "123.png";
//        String token = "0bW_r_lVLrfXLTnT-ByaO--rbYmk3Xny2MjsnddL:XuVFSg1aJz80vRUOR-kll8gIoOk=:eyJzY29wZSI6InVzZWRib29rcyIsImRlYWRsaW5lIjoxNDI2MTMzNDYzfQ==";
//        UploadManager uploadManager = new UploadManager();
//        uploadManager.put(bytes,key,token,new UpCompletionHandler() {
//            @Override
//            public void complete(String s, ResponseInfo responseInfo, JSONObject jsonObject) {
//                Log.i("info",responseInfo.toString());
//            }
//        },null);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SCANNIN_GREQUEST_CODE:
                if(resultCode == RESULT_OK){
                    Bundle bundle = data.getExtras();
                    //显示扫描到的内容
                    mTextView.setText(bundle.getString("result"));
                }
                break;
        }
    }
}
