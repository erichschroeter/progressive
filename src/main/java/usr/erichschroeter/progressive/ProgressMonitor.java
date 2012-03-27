package usr.erichschroeter.progressive;

/**
 * An interface to define an object which monitors progress.
 * 
 * @author Erich Schroeter
 */
public interface ProgressMonitor {

	/**
	 * Starts monitoring progress.
	 */
	public void start();

	/**
	 * Cancels monitoring progress.
	 */
	public void cancel();

	/**
	 * Adds the progress listener to receive status events on the progress.
	 * 
	 * @param l
	 *            the progress listener to add
	 */
	public void addProgressListener(ProgressListener l);

	/**
	 * Removes the progress listener from the list to receive status events on
	 * the progress.
	 * 
	 * @param l
	 *            the progress listener to remove
	 */
	public void removeProgressListener(ProgressListener l);

}
