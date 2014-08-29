package tests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;
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

    /*
    All of the tests below fail
    I have a theory that while clickview may click the button
    it does not necessarily also see the onclicklistener
    so while the button is pressed
    it just does nothing

    I think one work around would be to set a method via xml
    however i tried that and kept getting errors in the method not being
    in MainActivity
     */

    @MediumTest
    public void testPlusOneTap(){
        TextView fcount=f1.frag_count;

        int n=1;
        String value = fcount.getText().toString();
        int intvalue = Integer.parseInt(value);
        int amount = intvalue + n;
        String expected=Integer.toString(amount);

        TouchUtils.clickView(this, f1.getView());
        assertEquals(expected, fcount.getText());
    }


    @MediumTest
    public void testPlusOne(){
        TextView fcount=f1.frag_count;
        Button bplus1=f1.add1;

        int n=1;
        String value = fcount.getText().toString();
        int intvalue = Integer.parseInt(value);
        int amount = intvalue + n;
        String expected=Integer.toString(amount);


        TouchUtils.clickView(this, bplus1);
        assertEquals(expected, fcount.getText());
    }

    @MediumTest
    public void testMinusOne(){
        TextView fcount=f1.frag_count;
        Button bminus1=f1.sub1;

        int n=-1;
        String value = fcount.getText().toString();
        int intvalue = Integer.parseInt(value);
        int amount = intvalue + n;
        String expected=Integer.toString(amount);

        TouchUtils.clickView(this, bminus1);
        assertEquals(expected, fcount.getText());
    }

    @MediumTest
    public void testReset(){
        TextView fcount=f1.frag_count;
        Button breset=f1.reset;

        TouchUtils.clickView(this, breset);
        assertEquals("0", fcount.getText());
    }

    @MediumTest
    public void testEditText(){
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                EditText f1editText=f1.frag_text;
                f1editText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Testing 1 2 3");
        getInstrumentation().waitForIdleSync();

    }
}
