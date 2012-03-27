package usr.erichschroeter.progressive;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * The <code>Utils</code> class consists of public static utility methods whose
 * functionality may not be unique for any particular class.
 * 
 * @author Erich Schroeter
 */
class Utils {

	/**
	 * Returns the <code>resource</code> as an <code>ImageIcon</code>.
	 * 
	 * @see #imageIcon(String, ClassLoader)
	 * @param resource
	 *            the icon resource
	 * @return the <code>resource</code> as an <code>ImageIcon</code>
	 */
	public static ImageIcon imageIcon(String resource) {
		return imageIcon(resource, Utils.class.getClassLoader());
	}

	/**
	 * Returns the <code>resource</code> as an <code>ImageIcon</code>.
	 * 
	 * @param resource
	 *            the icon resource
	 * @param classLoader
	 *            the class loader from which to get the resource as a stream
	 * @return the <code>resource</code> as an <code>ImageIcon</code>
	 */
	public static ImageIcon imageIcon(String resource, ClassLoader classLoader) {
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(ImageIO.read(classLoader
					.getResourceAsStream(resource)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return icon;
	}

}
