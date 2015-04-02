package edu.cueb.cueb_usedbooks.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONObject;

import java.util.List;

import edu.cueb.cueb_usedbooks.R;
import edu.cueb.cueb_usedbooks.core.manager.BookManager;
import edu.cueb.cueb_usedbooks.core.network.NetManager;
import edu.cueb.cueb_usedbooks.model.NetRequestHolder;
import edu.cueb.cueb_usedbooks.model.NetWorkListener;
import edu.cueb.cueb_usedbooks.model.classN.Book;
import edu.cueb.cueb_usedbooks.view.fragment.BookInfoFragment;


public class MainActivity extends ActionBarActivity {

    private final static int SCANNIN_GREQUEST_CODE = 1;

    private TextView mTextView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NetManager.getInstance().init(getApplicationContext());
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

                    findViewById(R.id.resss).setVisibility(View.GONE);
                    Bundle bundle = data.getExtras();
                    //显示扫描到的内容
                    mTextView.setText(bundle.getString("result"));
                    BookManager.getInstance().setIsbn(bundle.getString("result"));

                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.main_container,new BookInfoFragment());
                    transaction.commit();
                }
                break;
        }
    }
}
