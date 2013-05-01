package org.wahlque.healpix;

import static org.junit.Assert.assertEquals;
import static org.wahlque.grid.healpix.Indexer.all;
import static org.wahlque.grid.healpix.Indexer.pxirByRind;
import static org.wahlque.grid.healpix.Indexer.ringByRind;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test for Indexer.
 */
@RunWith(JUnit4.class)
public class IndexerTest 
{

    /**
     *  Test all method
     */
	@Test
    public void testAll()
    {
        assertEquals("failure - results not same", all(0), 12);
        assertEquals("failure - results not same", all(1), 48);
        assertEquals("failure - results not same", all(2), 192);
    }

    /**
     *  Test ringByRind method
     */
	@Test
    public void testRingByRind1()
    {
        assertEquals("failure - results not same", ringByRind(0,  0), 1);
        assertEquals("failure - results not same", ringByRind(0,  1), 1);
        assertEquals("failure - results not same", ringByRind(0,  2), 1);
        assertEquals("failure - results not same", ringByRind(0,  3), 1);
        assertEquals("failure - results not same", ringByRind(0,  4), 2);
        assertEquals("failure - results not same", ringByRind(0,  5), 2);
        assertEquals("failure - results not same", ringByRind(0,  6), 2);
        assertEquals("failure - results not same", ringByRind(0,  7), 2);
        assertEquals("failure - results not same", ringByRind(0,  8), 3);
        assertEquals("failure - results not same", ringByRind(0,  9), 3);
        assertEquals("failure - results not same", ringByRind(0, 10), 3);
        assertEquals("failure - results not same", ringByRind(0, 11), 3);
    }

    /**
     *  Test ringByRind method
     */
	@Test
    public void testRingByRind2()
    {
        assertEquals("failure - results not same", ringByRind(1,  0), 1);
        assertEquals("failure - results not same", ringByRind(1,  1), 1);
        assertEquals("failure - results not same", ringByRind(1,  2), 1);
        assertEquals("failure - results not same", ringByRind(1,  3), 1);
        assertEquals("failure - results not same", ringByRind(1,  4), 2);
        assertEquals("failure - results not same", ringByRind(1,  5), 2);
        assertEquals("failure - results not same", ringByRind(1,  6), 2);
        assertEquals("failure - results not same", ringByRind(1,  7), 2);
        assertEquals("failure - results not same", ringByRind(1,  8), 2);
        assertEquals("failure - results not same", ringByRind(1,  9), 2);
        assertEquals("failure - results not same", ringByRind(1, 10), 2);
        assertEquals("failure - results not same", ringByRind(1, 11), 2);
        assertEquals("failure - results not same", ringByRind(1, 12), 3);
        assertEquals("failure - results not same", ringByRind(1, 13), 3);
        assertEquals("failure - results not same", ringByRind(1, 14), 3);
        assertEquals("failure - results not same", ringByRind(1, 15), 3);
        assertEquals("failure - results not same", ringByRind(1, 16), 3);
        assertEquals("failure - results not same", ringByRind(1, 17), 3);
        assertEquals("failure - results not same", ringByRind(1, 18), 3);
        assertEquals("failure - results not same", ringByRind(1, 19), 3);
        assertEquals("failure - results not same", ringByRind(1, 20), 4);
        assertEquals("failure - results not same", ringByRind(1, 21), 4);
        assertEquals("failure - results not same", ringByRind(1, 22), 4);
        assertEquals("failure - results not same", ringByRind(1, 23), 4);
        assertEquals("failure - results not same", ringByRind(1, 24), 4);
        assertEquals("failure - results not same", ringByRind(1, 25), 4);
        assertEquals("failure - results not same", ringByRind(1, 26), 4);
        assertEquals("failure - results not same", ringByRind(1, 27), 4);
        assertEquals("failure - results not same", ringByRind(1, 28), 5);
        assertEquals("failure - results not same", ringByRind(1, 29), 5);
        assertEquals("failure - results not same", ringByRind(1, 30), 5);
        assertEquals("failure - results not same", ringByRind(1, 31), 5);
        assertEquals("failure - results not same", ringByRind(1, 32), 5);
        assertEquals("failure - results not same", ringByRind(1, 33), 5);
        assertEquals("failure - results not same", ringByRind(1, 34), 5);
        assertEquals("failure - results not same", ringByRind(1, 35), 5);
        assertEquals("failure - results not same", ringByRind(1, 36), 6);
        assertEquals("failure - results not same", ringByRind(1, 37), 6);
        assertEquals("failure - results not same", ringByRind(1, 38), 6);
        assertEquals("failure - results not same", ringByRind(1, 39), 6);
        assertEquals("failure - results not same", ringByRind(1, 40), 6);
        assertEquals("failure - results not same", ringByRind(1, 41), 6);
        assertEquals("failure - results not same", ringByRind(1, 42), 6);
        assertEquals("failure - results not same", ringByRind(1, 43), 6);
        assertEquals("failure - results not same", ringByRind(1, 44), 7);
        assertEquals("failure - results not same", ringByRind(1, 45), 7);
        assertEquals("failure - results not same", ringByRind(1, 46), 7);
        assertEquals("failure - results not same", ringByRind(1, 47), 7);
    }

    /**
     *  Test ringByRind method
     */
	@Test
    public void testRingByRind3()
    {
        assertEquals("failure - results not same", ringByRind(2,   0), 1);
        assertEquals("failure - results not same", ringByRind(2,   3), 1);
        assertEquals("failure - results not same", ringByRind(2,   4), 2);
        assertEquals("failure - results not same", ringByRind(2,  11), 2);
        assertEquals("failure - results not same", ringByRind(2,  12), 3);
        assertEquals("failure - results not same", ringByRind(2,  23), 3);
        assertEquals("failure - results not same", ringByRind(2,  24), 4);
        assertEquals("failure - results not same", ringByRind(2,  39), 4);
        assertEquals("failure - results not same", ringByRind(2,  40), 5);
        assertEquals("failure - results not same", ringByRind(2,  55), 5);
        assertEquals("failure - results not same", ringByRind(2,  56), 6);
        assertEquals("failure - results not same", ringByRind(2,  71), 6);
        assertEquals("failure - results not same", ringByRind(2,  72), 7);
        assertEquals("failure - results not same", ringByRind(2,  87), 7);
        assertEquals("failure - results not same", ringByRind(2,  88), 8);
        assertEquals("failure - results not same", ringByRind(2, 103), 8);
        assertEquals("failure - results not same", ringByRind(2, 104), 9);
        assertEquals("failure - results not same", ringByRind(2, 119), 9);
        assertEquals("failure - results not same", ringByRind(2, 120), 10);
        assertEquals("failure - results not same", ringByRind(2, 135), 10);
        assertEquals("failure - results not same", ringByRind(2, 136), 11);
        assertEquals("failure - results not same", ringByRind(2, 151), 11);
        assertEquals("failure - results not same", ringByRind(2, 152), 12);
        assertEquals("failure - results not same", ringByRind(2, 167), 12);
        assertEquals("failure - results not same", ringByRind(2, 168), 13);
        assertEquals("failure - results not same", ringByRind(2, 179), 13);
        assertEquals("failure - results not same", ringByRind(2, 180), 14);
        assertEquals("failure - results not same", ringByRind(2, 187), 14);
        assertEquals("failure - results not same", ringByRind(2, 188), 15);
        assertEquals("failure - results not same", ringByRind(2, 191), 15);
    }

    /**
     *  Test pxirByRind method
     */
	@Test
    public void testPxirByRind1()
    {
        assertEquals("failure - results not same", pxirByRind(0,  0), 1);
        assertEquals("failure - results not same", pxirByRind(0,  1), 2);
        assertEquals("failure - results not same", pxirByRind(0,  2), 3);
        assertEquals("failure - results not same", pxirByRind(0,  3), 4);
        assertEquals("failure - results not same", pxirByRind(0,  4), 1);
        assertEquals("failure - results not same", pxirByRind(0,  5), 2);
        assertEquals("failure - results not same", pxirByRind(0,  6), 3);
        assertEquals("failure - results not same", pxirByRind(0,  7), 4);
        assertEquals("failure - results not same", pxirByRind(0,  8), 1);
        assertEquals("failure - results not same", pxirByRind(0,  9), 2);
        assertEquals("failure - results not same", pxirByRind(0, 10), 3);
        assertEquals("failure - results not same", pxirByRind(0, 11), 4);
    }

    /**
     *  Test pxirByRind method
     */
	@Test
    public void testPxirByRind2()
    {
        assertEquals("failure - results not same", pxirByRind(1,  0), 1);
        assertEquals("failure - results not same", pxirByRind(1,  1), 2);
        assertEquals("failure - results not same", pxirByRind(1,  2), 3);
        assertEquals("failure - results not same", pxirByRind(1,  3), 4);
        assertEquals("failure - results not same", pxirByRind(1,  4), 1);
        assertEquals("failure - results not same", pxirByRind(1,  5), 2);
        assertEquals("failure - results not same", pxirByRind(1,  6), 3);
        assertEquals("failure - results not same", pxirByRind(1,  7), 4);
        assertEquals("failure - results not same", pxirByRind(1,  8), 5);
        assertEquals("failure - results not same", pxirByRind(1,  9), 6);
        assertEquals("failure - results not same", pxirByRind(1, 10), 7);
        assertEquals("failure - results not same", pxirByRind(1, 11), 8);
        assertEquals("failure - results not same", pxirByRind(1, 12), 1);
        assertEquals("failure - results not same", pxirByRind(1, 13), 2);
        assertEquals("failure - results not same", pxirByRind(1, 14), 3);
        assertEquals("failure - results not same", pxirByRind(1, 15), 4);
        assertEquals("failure - results not same", pxirByRind(1, 16), 5);
        assertEquals("failure - results not same", pxirByRind(1, 17), 6);
        assertEquals("failure - results not same", pxirByRind(1, 18), 7);
        assertEquals("failure - results not same", pxirByRind(1, 19), 8);
        assertEquals("failure - results not same", pxirByRind(1, 20), 1);
        assertEquals("failure - results not same", pxirByRind(1, 21), 2);
        assertEquals("failure - results not same", pxirByRind(1, 22), 3);
        assertEquals("failure - results not same", pxirByRind(1, 23), 4);
        assertEquals("failure - results not same", pxirByRind(1, 24), 5);
        assertEquals("failure - results not same", pxirByRind(1, 25), 6);
        assertEquals("failure - results not same", pxirByRind(1, 26), 7);
        assertEquals("failure - results not same", pxirByRind(1, 27), 8);
        assertEquals("failure - results not same", pxirByRind(1, 28), 1);
        assertEquals("failure - results not same", pxirByRind(1, 29), 2);
        assertEquals("failure - results not same", pxirByRind(1, 30), 3);
        assertEquals("failure - results not same", pxirByRind(1, 31), 4);
        assertEquals("failure - results not same", pxirByRind(1, 32), 5);
        assertEquals("failure - results not same", pxirByRind(1, 33), 6);
        assertEquals("failure - results not same", pxirByRind(1, 34), 7);
        assertEquals("failure - results not same", pxirByRind(1, 35), 8);
        assertEquals("failure - results not same", pxirByRind(1, 36), 1);
        assertEquals("failure - results not same", pxirByRind(1, 37), 2);
        assertEquals("failure - results not same", pxirByRind(1, 38), 3);
        assertEquals("failure - results not same", pxirByRind(1, 39), 4);
        assertEquals("failure - results not same", pxirByRind(1, 40), 5);
        assertEquals("failure - results not same", pxirByRind(1, 41), 6);
        assertEquals("failure - results not same", pxirByRind(1, 42), 7);
        assertEquals("failure - results not same", pxirByRind(1, 43), 8);
        assertEquals("failure - results not same", pxirByRind(1, 44), 1);
        assertEquals("failure - results not same", pxirByRind(1, 45), 2);
        assertEquals("failure - results not same", pxirByRind(1, 46), 3);
        assertEquals("failure - results not same", pxirByRind(1, 47), 4);
    }

    /**
     *  Test pxirByRind method
     */
	@Test
    public void testPxirByRind3()
    {
        assertEquals("failure - results not same", pxirByRind(2,   0), 1);
        assertEquals("failure - results not same", pxirByRind(2,   3), 4);
        assertEquals("failure - results not same", pxirByRind(2,   4), 1);
        assertEquals("failure - results not same", pxirByRind(2,  11), 8);
        assertEquals("failure - results not same", pxirByRind(2,  12), 1);
        assertEquals("failure - results not same", pxirByRind(2,  23), 12);
        assertEquals("failure - results not same", pxirByRind(2,  24), 1);
        assertEquals("failure - results not same", pxirByRind(2,  39), 16);
        assertEquals("failure - results not same", pxirByRind(2,  40), 1);
        assertEquals("failure - results not same", pxirByRind(2,  55), 16);
        assertEquals("failure - results not same", pxirByRind(2,  56), 1);
        assertEquals("failure - results not same", pxirByRind(2,  71), 16);
        assertEquals("failure - results not same", pxirByRind(2,  72), 1);
        assertEquals("failure - results not same", pxirByRind(2,  87), 16);
        assertEquals("failure - results not same", pxirByRind(2,  88), 1);
        assertEquals("failure - results not same", pxirByRind(2, 103), 16);
        assertEquals("failure - results not same", pxirByRind(2, 104), 1);
        assertEquals("failure - results not same", pxirByRind(2, 119), 16);
        assertEquals("failure - results not same", pxirByRind(2, 120), 1);
        assertEquals("failure - results not same", pxirByRind(2, 135), 16);
        assertEquals("failure - results not same", pxirByRind(2, 136), 1);
        assertEquals("failure - results not same", pxirByRind(2, 151), 16);
        assertEquals("failure - results not same", pxirByRind(2, 152), 1);
        assertEquals("failure - results not same", pxirByRind(2, 167), 16);
        assertEquals("failure - results not same", pxirByRind(2, 168), 1);
        assertEquals("failure - results not same", pxirByRind(2, 179), 12);
        assertEquals("failure - results not same", pxirByRind(2, 180), 1);
        assertEquals("failure - results not same", pxirByRind(2, 187), 8);
        assertEquals("failure - results not same", pxirByRind(2, 188), 1);
        assertEquals("failure - results not same", pxirByRind(2, 191), 4);
    }

}
