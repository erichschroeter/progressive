package usr.erichschroeter.progressive;

/**
 * The <code>R</code> class contains methods for specifying resources in the
 * <code>usr.erichschroeter.progressive</code> package.
 * 
 * @author Erich Schroeter
 */
class R {

	/** The root package resources are located in. */
	public static final String resourcePackage = "usr/erichschroeter/progressive";

	/**
	 * Returns the resource string that refers to the <code>resource</code> file
	 * in the <code>com.magnetek.magexplorer.hmi.res.png</code> package.
	 * 
	 * @param resource
	 *            the file in the <code>png</code> package
	 * @return the full resource string
	 */
	public static String png(String resource) {
		return String.format("%s/png/%s", resourcePackage, resource);
	}

}
