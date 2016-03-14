package com.example.jiandan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.jiandan.adapter.DuanAdatper;
import com.example.jiandan.bean.Duan;
import com.example.jiandan.utils.UrlConstants;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity implements PullToRefreshBase.OnRefreshListener2<ListView>{
    private static final String TAG = "memejiang";
    @ViewInject(R.id.lv)
    private PullToRefreshListView lv;
    private List<Duan.ItemsContent> itemsList = new ArrayList<>();
    private boolean isClear = false;
    private DuanAdatper adapter;
    private String nextUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        lv.setMode(PullToRefreshBase.Mode.BOTH);
        lv.setOnRefreshListener(this);
        adapter = new DuanAdatper(this,itemsList);
        lv.setAdapter(adapter);
        lv.setRefreshing();
//        lv.setRefreshing(true);



        Log.i(TAG, "onCreate: .......");
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
//        String str = DateUtils.formatDateTime(MainActivity.this, System.currentTimeMillis(),
//                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_ABBREV_ALL);

        Log.i(TAG, "onPullDownToRefresh: ........");//下拉刷新
                isClear = true;
        initData(UrlConstants.GET_DUAN);

    }

    private void initData(String url) {
        Log.i(TAG, "initData: ........");
        RequestParams requestParams = new RequestParams(url);
        x.http().get(requestParams, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                    //返回成功
                Duan duan = JSONObject.parseObject(result, Duan.class);
                Log.i(TAG, "onSuccess: 解析到的数据..."+duan);
                if(duan !=null &&duan.getStatus().equals("ok")&&duan.getComments()!=null){
                    int current_page = duan.getCurrent_page();
//                    StringBuilder sb = new StringBuilder();

                    nextUrl = UrlConstants.GET_DUAN+"&page="+(++current_page);
                    Log.i(TAG, "onSuccess: 下一页url"+ nextUrl);
                    ArrayList<Duan.ItemsContent> itemsContent = duan.getComments();
                    if(isClear&&itemsContent.size()>0){
                        itemsList.clear();
                        isClear = false;
                    }
                            itemsList.addAll(itemsContent);
                            adapter.notifyDataSetChanged();
                            lv.onRefreshComplete();

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.i(TAG, "onError: ");
                Toast.makeText(MainActivity.this,"网络错误",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
        Log.i(TAG, "onPullUpToRefresh: ......上拉加载");
                //上拉加载
                initData(nextUrl);
    }
}
