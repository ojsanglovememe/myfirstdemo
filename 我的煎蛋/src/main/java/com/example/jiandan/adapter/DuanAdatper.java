package com.example.jiandan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jiandan.R;
import com.example.jiandan.bean.Duan;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/2/24.
 */
public class DuanAdatper extends BaseAdapter {
    private List<Duan.ItemsContent> itemsList;
    private LayoutInflater mLayoutInflater;

    public DuanAdatper(Context context,List<Duan.ItemsContent> itemsList) {
        this.itemsList = itemsList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemsList == null?0:itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList == null?null:itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
           ViewHolder mViewHolder = null;
            if(convertView == null){
                    convertView = mLayoutInflater.inflate(R.layout.item_duan,parent,false);
                    mViewHolder = new ViewHolder(convertView);
                    convertView.setTag(mViewHolder);
            }else {
                mViewHolder = (ViewHolder) convertView.getTag();
            }

        Duan.ItemsContent itemsContent = itemsList.get(position);
                mViewHolder.tvAuthor.setText(itemsContent.getComment_author());
                mViewHolder.tvContent.setText(itemsContent.getComment_content());
                mViewHolder.tvDate.setText(itemsContent.getComment_date_gmt());
                mViewHolder.tvNegative.setText(itemsContent.getVote_negative()+"");
                mViewHolder.tvPositive.setText(itemsContent.getVote_positive()+"");

        return convertView;
    }



    class ViewHolder{
        @ViewInject(R.id.tv_author)
        TextView tvAuthor;
        @ViewInject(R.id.tv_date)
        TextView tvDate;
        @ViewInject(R.id.tv_content)
        TextView tvContent;
        @ViewInject(R.id.tv_vote_positive)
        TextView tvPositive;
        @ViewInject(R.id.tv_vote_negative)
        TextView tvNegative;
        public ViewHolder(View conertView){
            x.view().inject(this,conertView);
        }
    }
}
