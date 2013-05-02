package org.wahlque.sphere;

public interface Sphere {

    // type
    public static final String SCALAR = "scalar";
    public static final String VECTOR = "vector";
    // kind
    public static final String SURFICIAL = "surficial";
    public static final String SPATIAL = "spatial";
    // variability
    public static final String CONSTANT = "constant";
    public static final String TEMPORAL = "temporal";

    public String mkspace(int scale, int zscale, double[] zaxis);

    public String mkpartition(int number);

    public String mksubspace(int index);

    public String mkfield(String target, String type, String kind,
            String variability, String expression);

    public String type(String target);

    public String kind(String target);

    public String variability(String target);

    public double[] get(String target, double[] points);

    public int put(String target, double[] points, double[] values);

    public String eval(String target, String expression);

    public double[] query(String target, String condition);

}
