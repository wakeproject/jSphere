package org.wahlque.sphere;

public interface Sphere {

    public static final String SCALAR = "scalar";
    public static final String VECTOR = "vector";
    public static final String SURFICIAL = "surficial";
    public static final String SPATIAL = "spatial";
    public static final String CONSTANT = "constant";
    public static final String TEMPORAL = "temporal";

    public String create(String target, String type, String[] kinds, int scale,
            int zscale, double[] zaxis, String expression);

    public String create(String target, String expression);

    public String type(String target);

    public String[] kinds(String target);

    public double[] get(String target, double[] points);

    public double[] query(String target, String condition);

    public int put(String target, double[] points, double[] values);

    public int add(String target, String source1, String source2);

    public int minus(String target, String source1, String source2);

    public int expand(String target, String source, double scale);

    public int product(String target, String source1, String source2);

    public int inner(String target, String source1, String source2);

    public int cross(String target, String source1, String source2);

    public int dot(String target, String source);

    public int ddot(String target, String source);

    public int grad(String target, String source);

    public int div(String target, String source);

    public int curl(String target, String source);

    public int laplacian(String target, String source);

    public double max(String target);

    public double sum(String target);

}
