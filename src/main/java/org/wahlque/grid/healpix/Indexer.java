package org.wahlque.grid.healpix;

import static java.lang.Math.*;

public class Indexer
{

	/* Base parameters for cell of tessellation */
    public static final int NTHETA = 3;
    public static final int NPHI   = 4;

	/* Numbers of power 2 */
    public static final int P0   = 1;
    public static final int P1   = 2;
    public static final int P2   = 4;
    public static final int P3   = 8;
    public static final int P4   = 16;
    public static final int P5   = 32;
    public static final int P6   = 64;
    public static final int P7   = 128;
    public static final int P8   = 256;
    public static final int P9   = 512;
    public static final int P10  = 1024;
    public static final int P11  = 2048;
    public static final int P12  = 4096;
    public static final int P13  = 8192;

	/* Scale numbers */
    public static final int N0   = 12;
    public static final int N1   = 48;
    public static final int N2   = 192;
    public static final int N3   = 768;
    public static final int N4   = 3072;
    public static final int N5   = 12288;
    public static final int N6   = 49152;
    public static final int N7   = 196608;
    public static final int N8   = 786432;
    public static final int N9   = 3145728;
    public static final int N10  = 12582912;
    public static final int N11  = 50331648;
    public static final int N12  = 201326592;
    public static final int N13  = 805306368;

    public static int power(int level)
    {
        switch (level) {
        case 0: return P0;
        case 1: return P1;
        case 2: return P2;
        case 3: return P3;
        case 4: return P4;
        case 5: return P5;
        case 6: return P6;
        case 7: return P7;
        case 8: return P8;
        case 9: return P9;
        case 10: return P10;
        case 11: return P11;
        case 12: return P12;
        case 13: return P13;
        default: return -1;
        }
    }

    public static int all(int level)
    {
        switch (level) {
        case 0: return N0;
        case 1: return N1;
        case 2: return N2;
        case 3: return N3;
        case 4: return N4;
        case 5: return N5;
        case 6: return N6;
        case 7: return N7;
        case 8: return N8;
        case 9: return N9;
        case 10: return N10;
        case 11: return N11;
        case 12: return N12;
        case 13: return N13;
        default: return -1;
        }
    }

    public static int ringByRind(int level, int index)
    {
        int ring = -1,
            size = power(level),
            ncap = 2 * size * (size - 1),
            nblt = ncap + 4 * size * size,
            equt = nblt + 4 * size,
            sblt = 12 * size * size - ncap,
            scap = 12 * size * size;

        if (index < 0) {
            return ring;
        } else if (index < ncap) {
            double half = (index + 1.0) / 2.0;
            ring = 1 + (int) (floor(sqrt(half - sqrt(floor(half)))));
            return ring;
        } else if (index < nblt) {
            index = index - ncap;
            ring = size + (int) (floor(index / 4.0 / size));
            return ring;
        } else if (index < equt) {
            index = index - ncap;
            ring = size + (int) (floor(index / 4.0 / size));
            return ring;
        } else if (scap < index) {
            return ring;
        } else if (sblt < index) {
            index = scap - index - 1;
            float half = (float) ((index + 1.0) / 2.0);
            ring = 4 * size - 1 - (int) (floor(sqrt(half - sqrt(floor(half)))));
            return ring;
        } else if (equt <= index) {
            index = index - equt;
            ring = 2 * size + (int) (1 + floor(index / 4.0 / size));
            return ring;
        }

        return ring;
    }

    public static int pxirByRind(int level, int index)
    {
        int pxir = -1,
            size = power(level),
            ncap = 2 * size * (size - 1),
            scap = 12 * size * size,
            ring = ringByRind(level, index);

        if (ring < 0) {
            return pxir;
        } else if (ring <= size) {
            pxir = index + 1 - 2 * ring * (ring - 1);
            return pxir;
        } else if (ring <= 3 * size) {
            index = index - ncap;
            pxir = 1 + index % (4 * size);
            return pxir;
        } else if (ring < 4 * size) {
            int dual = 4 * size - ring;
            pxir = 4 * dual - (scap - index - 1 - 2 * dual * (dual - 1));
            return pxir;
        }

        return pxir;
    }

}
