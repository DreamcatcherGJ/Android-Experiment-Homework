package homework.taohuo.LS.category_fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import homework.taohuo.GJ.JumpActivity;
import homework.taohuo.R;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment3 extends Fragment implements View.OnClickListener {


    private View mView;
    private LinearLayout shop1, shop2, shop3, shop4;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    private Button btn1, btn2, btn3, btn4;
    private Intent intent;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.mipmap.zh_img01,
            R.mipmap.zh_img02,
            R.mipmap.zh_img03,
            R.mipmap.zh_img04
    };

    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    private FragmentTransaction fragmentTransaction;
    private LinearLayout myLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.ls_category_fragment3, container, false);
        init();
        setView();
        return mView;
    }

    private void init() {
        myLinearLayout = Objects.requireNonNull(getActivity()).findViewById(R.id.myLinearLayout);
        shop1 = mView.findViewById(R.id.shop1);
        shop1.setOnClickListener(this);
        shop2 = mView.findViewById(R.id.shop2);
        shop2.setOnClickListener(this);
        shop3 = mView.findViewById(R.id.shop3);
        shop3.setOnClickListener(this);
        shop4 = mView.findViewById(R.id.shop4);
        shop4.setOnClickListener(this);
    }

    private void setView() {
        mViewPaper = (ViewPager) mView.findViewById(R.id.vp);

        //显示的图片
        images = new ArrayList<ImageView>();
        for (int i = 0; i < imageIds.length; i++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));
        dots.add(mView.findViewById(R.id.dot_4));

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                //title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.mipmap.zh_dot_yes);
                dots.get(oldPosition).setBackgroundResource(R.mipmap.zh_dot_no);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.shop1:
                intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",51);
                intent.putExtra("shop_id","10");
                startActivity(intent);
                break;
            case R.id.shop2:
                intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",51);
                intent.putExtra("shop_id","11");
                startActivity(intent);
                break;
            case R.id.shop3:
                intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",51);
                intent.putExtra("shop_id","12");
                startActivity(intent);
                break;
            case R.id.shop4:
                intent = new Intent(getActivity(), JumpActivity.class);
                intent.putExtra("id",51);
                intent.putExtra("shop_id","14");
                startActivity(intent);
                break;
        }
    }


    public class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//          super.destroyItem(container, position, object);
//          view.removeView(view.getChildAt(position));
//          view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                2,
                2,
                TimeUnit.SECONDS);
    }


    /**
     * 图片轮播任务
     *
     * @author liuyazhuang
     */
    private class ViewPageTask implements Runnable {

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        }

        ;
    };

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }

}
