package com.company;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class EvenOrOddTest {

    private InputStream original;

    private static void setIn(String dir, int iteration) throws FileNotFoundException  {
        final FileInputStream fips = new FileInputStream(new File("testfiles/" + dir + "/input" + iteration + ".txt"));
        System.setIn(fips);
    }

    @Before
    public void saveIn() {
        original = System.in;
    }

    @After
    public void resetIn() {
        System.setIn(original);
    }

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Test
    public void testEvenOrOddOutput() throws Exception {
        String[] args = null;

        String[] results = {"even", "odd", "odd"};

        int iteration = 0;

        while (iteration < results.length) {
            // set input to file stream
            setIn("EvenOrOdd", iteration);

            // run main method and capture output
            EvenOrOdd.main(args);
            String output = systemOutRule.getLog().toLowerCase();

            // check that the current iteration output contains intended result
            String message = "\nExpected output to contain " + results[iteration] + "\n";
            assertTrue(message, output.contains(results[iteration]));

            // clear log and increment iteration
            systemOutRule.clearLog();
            iteration++;
        }

    }
}
