package homework.taohuo.GJ;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;
import java.util.List;

import homework.taohuo.LS.CategoryFragment;
import homework.taohuo.R;
import homework.taohuo.TSJ.CartFragment;
import homework.taohuo.TSJ.HotFragment;
import homework.taohuo.ZH.HomeFragment;
import homework.taohuo.ZH.MineFragment;
import homework.taohuo.service.RWUser;

public class MainFragment extends Fragment
{
    private ViewPager mViewPager;
    private RadioGroup mTabRadioGroup;
    private List<Fragment> mFragments;
    private FragmentPagerAdapter mAdapter;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        mViewPager = v.findViewById(R.id.fragment_vp);
        mTabRadioGroup = v.findViewById(R.id.tabs_rg);

        HomeFragment homeFragment = new HomeFragment();
        MineFragment mineFragment = new MineFragment();
        CategoryFragment categoryFragment = new CategoryFragment();
        HotFragment hotFragment = new HotFragment();
        CartFragment cartFragment = new CartFragment();
        mFragments = new ArrayList<>(1);
        mFragments.add(homeFragment);
        mFragments.add(hotFragment);
        mFragments.add(categoryFragment);
        mFragments.add(cartFragment);
        mFragments.add(mineFragment);

        mAdapter = new MyFragmentPagerAdapter(getFragmentManager(), mFragments);
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(mPageChangeListener);
        mTabRadioGroup.setOnCheckedChangeListener(mOnCheckedChangeListener);

        return v;
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        mViewPager.removeOnPageChangeListener(mPageChangeListener);
    }

    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener()
    {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            RadioButton radioButton = (RadioButton) mTabRadioGroup.getChildAt(position);
            radioButton.setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private RadioGroup.OnCheckedChangeListener mOnCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
            for (int i = 0; i < group.getChildCount(); i++) {
                if (group.getChildAt(i).getId() == checkedId) {
                    mViewPager.setCurrentItem(i);
                    return;
                }
            }
        }
    };

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter
    {
        private List<Fragment> mList;

        public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
            super(fm);
            this.mList = list;
        }

        @Override
        public Fragment getItem(int position) {
            return this.mList == null ? null : this.mList.get(position);
        }

        @Override
        public int getCount() {
            return this.mList == null ? 0 : this.mList.size();
        }
    }
}