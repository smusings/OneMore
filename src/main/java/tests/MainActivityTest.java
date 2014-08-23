package tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.smusing.onemore.app.FragmentOne;
import com.smusing.onemore.app.MainActivity;

public class MainActivityTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest(){
        super(MainActivity.class);
    }

    //the activity/fragment we use to test
    public MainActivity mMainActivity;
    public FragmentOne f1;


    @Override
    public void setUp() throws Exception{
        super.setUp();

        setActivityInitialTouchMode(true);

        mMainActivity=getActivity();
        f1=mMainActivity.f1;
    }

    //checks to see if anything is null
    public void testPreconditions(){
        assertNotNull("Activity is null", mMainActivity);
        assertNotNull("Fragment One is null", f1);
    }


    @MediumTest
    public void testPlusOne(){
        TextView fcount=f1.frag_count;
        Button bplus1=f1.add1;

        TouchUtils.clickView(this, bplus1);
        assertTrue(View.VISIBLE==fcount.getVisibility());
        assertEquals("1", fcount.getText());
    }
}
