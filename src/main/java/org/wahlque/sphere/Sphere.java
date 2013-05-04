package org.wahlque.sphere;

/**
 * interface Sphere
 * 
 * Expression syntax: ...
 * 
 * Points array layout: ...
 * 
 * Value array layout: ...
 * 
 * Data array layout: ...
 * 
 * @author Mingli Yuan
 * 
 */
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

    /**
     * Create a space for field calculating, the parameters describe the global
     * grid settings. The grid settings are applied to all calculated fields. If
     * it is in a distributed mode, even different node are with different size,
     * the global grid setting are also hold for all of them, especially the
     * level parameter.
     * 
     * @param level
     *            the scale level ranging from 1 ~ 13
     * @param zscale
     *            the grid number along z-axis
     * @param zaxis
     *            the z-values of the grid along z-axis
     * @return success or error code
     */
    public int mkspace(int level, int zscale, double[] zaxis);

    /**
     * Create a field. If it is in a distributed mode, the field settings for a
     * specific field is applied on all nodes.
     * 
     * @param target
     *            the field name
     * @param type
     *            the field type
     * @param kind
     *            the field kind
     * @param variability
     *            the field variability
     * @param expression
     *            the initialization expression
     * @return success or error code
     */
    public int mkfield(String target, String type, String kind,
            String variability, String expression);

    /**
     * Query the type of the field
     * 
     * @param target
     *            the field name
     * @return the type of the field
     */
    public String type(String target);

    /**
     * Query the kind of the field
     * 
     * @param target
     *            the field name
     * @return the kind of the field
     */
    public String kind(String target);

    /**
     * Query the variability of the field
     * 
     * @param target
     *            the field name
     * @return the variability of the field
     */
    public String variability(String target);

    /**
     * Query values of the field on some specific space-time points. The layout
     * of points array and value array are specified as follow.
     * 
     * @param target
     *            the field name
     * @param points
     *            the space-time points
     * @return the values of the field on these points
     */
    public double[] get(String target, double[] points);

    /**
     * Query values of the field on some specific condition.
     * 
     * @param target
     *            the field name
     * @param condexpr
     *            the condition expression
     * @return the values of the field on these points
     */
    public double[] query(String target, String condexpr);

    /**
     * Set data on some specific point of the field
     * 
     * @param target
     *            the field name
     * @param data
     *            the data array
     * @return success or error code
     */
    public int put(String target, double[] data);

    /**
     * Evaluate an expression and set the result to a specific target
     * 
     * @param target
     *            the field name
     * @param expression
     *            the expression to evaluate
     * @return success or error code
     */
    public int eval(String target, String expression);

    public int mkpart(int level);

    public int mksubspace(int parind);

    public int backup(String target, int parind, double[] data);

    public int exchange(String target, int[] parinds, double[] data);

}
