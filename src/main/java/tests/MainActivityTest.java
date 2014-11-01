package tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.smusing.onemore.app.FragmentOne;
import com.smusing.onemore.app.MainActivity;
import com.smusing.onemore.app.R;

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

        mMainActivity = getActivity();
        f1 = (FragmentOne)mMainActivity.getFragmentManager().findFragmentById(R.id.fragment1);

    }

    //checks to see if anything is null
    public void testPreconditions(){
        assertNotNull("Activity is null", mMainActivity);
        assertNotNull("Fragment One is null", f1);
    }

    /*
        the long clickview will extend the fragment to the whole screen
        the buttons will appear
        then and only then are they clickable!
    */

    @MediumTest
    public void testPlusOneTap(){
        TextView fcount = f1.itemCount_tv;

        String value = fcount.getText().toString();
        int intvalue = Integer.parseInt(value);
        int amount = intvalue + 1;
        String expected = Integer.toString(amount);

        TouchUtils.clickView(this, f1.getView());
        assertEquals(expected, fcount.getText());
    }


    @MediumTest
    public void testPlusOne(){
        TextView fcount = f1.itemCount_tv;
        Button bplus1 = f1.add1;


        String value = fcount.getText().toString();
        int intvalue = Integer.parseInt(value);
        int amount = intvalue + 1;
        String expected = Integer.toString(amount);


        TouchUtils.longClickView(this, fcount);
        TouchUtils.clickView(this, bplus1);
        TouchUtils.longClickView(this, fcount);
        assertEquals(expected, fcount.getText());
    }

    @MediumTest
    public void testMinusOne(){
        TextView fcount = f1.itemCount_tv;
        Button bminus1 = f1.sub1;

        String value = fcount.getText().toString();
        int intvalue = Integer.parseInt(value);
        int amount = intvalue - 1;
        String expected = Integer.toString(amount);

        TouchUtils.longClickView(this, fcount);
        TouchUtils.clickView(this, bminus1);
        TouchUtils.longClickView(this, fcount);
        assertEquals(expected, fcount.getText());
    }

    @MediumTest
    public void testReset(){
        TextView fcount = f1.itemCount_tv;
        Button breset = f1.reset;


        TouchUtils.longClickView(this, fcount);
        TouchUtils.clickView(this, breset);
        TouchUtils.longClickView(this, fcount);
        assertEquals("0", fcount.getText());
    }

    @MediumTest
    public void testEditText(){
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                EditText f1editText = f1.itemLabel_et;
                f1editText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Testing 1 2 3");
        getInstrumentation().waitForIdleSync();
    }
}
