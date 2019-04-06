package com.example.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class NonString {

    private static final String LOG_TAG = "NonEmptyStringTest";

    @SuppressWarnings("unchecked")
    public void test() {
        String result = null;
        EndPointAsyncTask endpointsAsyncTask = new EndPointAsyncTask(getContext(), null);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

}
