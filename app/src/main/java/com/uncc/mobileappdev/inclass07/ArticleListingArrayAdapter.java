package com.uncc.mobileappdev.inclass07;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Stephen on 2/26/2018.
 */

public class ArticleListingArrayAdapter extends ArrayAdapter<Articles> {

    Context context;

    public static class ViewHolder{
        ImageView articleImage;
        TextView descritionView;
        TextView dateView;

        public ImageView getArticleImage(){
            return articleImage;
        }

        public void setArticleImage(ImageView articleImage){
            this.articleImage = articleImage;
        }
        public TextView getDescritionView() {
            return descritionView;
        }

        public void setDescritionView(TextView descritionView) {
            this.descritionView = descritionView;
        }

        public TextView getDateView() {
            return dateView;
        }

        public void setDateView(TextView dateView) {
            this.dateView = dateView;
        }
    }


    public ArticleListingArrayAdapter(@NonNull Context context, int resource, @NonNull List<Articles> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Articles article = getItem(position);
        ViewHolder viewHolder;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_article_selector, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.setArticleImage((ImageView) convertView.findViewById(R.id.article_image));
            viewHolder.setDateView((TextView) convertView.findViewById(R.id.date_view));
            viewHolder.setDescritionView((TextView) convertView.findViewById(R.id.description_view));
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
            viewHolder.getDateView().setText(article.getPublishedAtDate());
            viewHolder.getDescritionView().setText(article.getDescription());
            Picasso.with(getContext()).load(article.getUrlToImage()).into(viewHolder.articleImage);


        return convertView;

    }
}
