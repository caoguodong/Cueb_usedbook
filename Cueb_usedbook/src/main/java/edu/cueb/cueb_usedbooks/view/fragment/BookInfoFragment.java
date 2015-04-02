package edu.cueb.cueb_usedbooks.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

import edu.cueb.cueb_usedbooks.R;
import edu.cueb.cueb_usedbooks.core.manager.BookManager;
import edu.cueb.cueb_usedbooks.core.network.NetManager;
import edu.cueb.cueb_usedbooks.model.NetWorkListener;
import edu.cueb.cueb_usedbooks.model.classN.Book;


public class BookInfoFragment extends BaseFragment {

    private TextView bookTitle,bookPrice,bookAuthor,bookSummary;
    private NetworkImageView bookImage;

    @Override
    public void init() {
        bookTitle= (TextView) findViewById(R.id.book_title);
        bookPrice= (TextView) findViewById(R.id.book_price);
        bookAuthor= (TextView) findViewById(R.id.book_author);
        bookSummary= (TextView) findViewById(R.id.book_summary);
        bookImage= (NetworkImageView) findViewById(R.id.book_image);

        NetManager.getInstance().checkBookInfo(netWorkListener, BookManager.getInstance().getIsbn());
    }

    private void dismissView(){
        bookTitle.setVisibility(View.GONE);
        bookImage.setVisibility(View.GONE);
        bookPrice.setVisibility(View.GONE);
        bookAuthor.setVisibility(View.GONE);
        bookSummary.setVisibility(View.GONE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_book_info;
    }

    NetWorkListener<Book> netWorkListener = new NetWorkListener<Book>() {
        @Override
        public void onResult(List<Book> res) {
            bookTitle.setText(res.get(0).getTitle());
            if (res.get(0).getAuthor_intro().equals("")){
                Log.i("info",res.get(0).getAuthor()[0]);
               bookAuthor.setText(res.get(0).getAuthor()[0]);
            }else {
               bookAuthor.setText(res.get(0).getAuthor_intro());
            }
            bookPrice.setText("原价："+res.get(0).getPrice());
            bookSummary.setText(res.get(0).getSummary());
            bookImage.setImageUrl(res.get(0).getImage(),NetManager.getInstance().getUbImageCache());

        }

        @Override
        public void onError(int errorType, String error) {

        }
    };
}
