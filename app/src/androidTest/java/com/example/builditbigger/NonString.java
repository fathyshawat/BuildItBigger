package com.example.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static android.support.test.InstrumentationRegistry.getContext;
import static junit.framework.TestCase.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class NonString {

    private static final String LOG_TAG = "NonEmptyStringTest";

    @Test
    public void testGetJokeTask() throws ExecutionException, InterruptedException {
        EndPointAsyncTask testJoke = new EndPointAsyncTask(getContext(),null);
        testJoke.execute();
        String joke = testJoke.get();
        assertNotNull(joke);
    }

}
