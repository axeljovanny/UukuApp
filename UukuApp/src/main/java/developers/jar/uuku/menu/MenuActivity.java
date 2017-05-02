package developers.jar.uuku.menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import developers.jar.uuku.TabColors;
import developers.jar.uuku.TabLetters;
import developers.jar.uuku.TabLogic;
import developers.jar.uuku.TabNumbers;

public class MenuActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(developers.jar.uuku.R.layout.activity_menu);



        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(developers.jar.uuku.R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);




    }






    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    TabColors tab1 = new TabColors();
                    return tab1;
                case 1:
                    TabLetters tab2 = new TabLetters();
                    return tab2;
                case 2:
                    TabLogic tab3 = new TabLogic();
                    return tab3;
                case 3:
                    TabNumbers tab4 = new TabNumbers();
                    return tab4;
               // case 4:
                  //  TabStories tab5 = new TabStories();
                 //   return tab5;
                default:
                    return null;
            }
        }



        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Colors";
                case 1:
                    return "Letters";
                case 2:
                    return "Logic";
                case 3:
                    return "Numbers";
                //case 4:
                  //  return "Stories";
            }
            return null;
        }
    }
}
