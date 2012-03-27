package usr.erichschroeter.progressive;

/**
 * Monitors the progress of some action. This class used in conjunction with
 * {@link ProgressDialog} can be used to notify an end user of the progress of
 * an action being performed in the background.
 * 
 * @author Erich Schroeter
 * @see ProgressDialog
 * @see ProgressUtil
 */
public class DeterminateProgressMonitor extends AbstractProgressMonitor {

	private DeterminateStatusEvent statusEvent;

	/**
	 * Constructs a default <code>ProgressMonitor</code> specifying 0 for
	 * default progress values.
	 * 
	 * @param milliSecondsToWait
	 *            time to wait before dialog is displayed
	 * @see #DeterminateProgressMonitor(int, int, int, int)
	 */
	public DeterminateProgressMonitor(int milliSecondsToWait) {
		this(0, 0, 0, milliSecondsToWait);
	}

	/**
	 * Constructs a <code>ProgressMonitor</code> specifying the total amount of
	 * progress to monitor and 0 milliseconds to wait before displaying a
	 * dialog.
	 * 
	 * @param min
	 *            the minimum boundary for the status value
	 * @param max
	 *            the maximum boundary for the status value
	 * @param current
	 *            the current status value
	 * @see #DeterminateProgressMonitor(int, int, int, int)
	 */
	public DeterminateProgressMonitor(int min, int max, int current) {
		this(min, max, current, 0);
	}

	/**
	 * Constructs a <code>ProgressMonitor</code> specifying the total amount of
	 * progress to monitor and the milliseconds to wait before displaying a
	 * dialog.
	 * 
	 * @param min
	 *            the minimum boundary for the status value
	 * @param max
	 *            the maximum boundary for the status value
	 * @param current
	 *            the current status value
	 * @param milliSecondsToWait
	 *            time to wait before dialog is displayed
	 * @see AbstractProgressMonitor#AbstractProgressMonitor(int)
	 */
	public DeterminateProgressMonitor(int min, int max, int current,
			int milliSecondsToWait) {
		super(milliSecondsToWait);
		this.statusEvent = new DeterminateStatusEvent(this, min, max, current);
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The event fired is an {@link DeterminateStatusEvent}.
	 */
	@Override
	public void start(String status) {
		fireProgressEvent(new DeterminateStatusEvent(this, statusEvent.min,
				statusEvent.max, statusEvent.current, status));
	}

	/**
	 * {@inheritDoc}
	 * <p>
	 * The event fired is an {@link DeterminateStatusEvent}.
	 */
	@Override
	public void cancel(String status) {
		fireProgressCanceledEvent(new DeterminateStatusEvent(this,
				statusEvent.min, statusEvent.max, statusEvent.current, status));
	}

	/**
	 * Returns the minimum progress value. This is often the value at the start
	 * of monitoring.
	 * 
	 * @return the minimum progress value
	 */
	public int getMin() {
		return statusEvent.min;
	}

	/**
	 * Returns the maximum progress value. Once the current progress value
	 * reaches this value, the progress monitor has completed.
	 * 
	 * @return the maximum progress value
	 */
	public int getMax() {
		return statusEvent.max;
	}

	/**
	 * Returns the current progress value.
	 * 
	 * @return the current progress value
	 */
	public int getCurrent() {
		return statusEvent.current;
	}

	/**
	 * Sets the current progress and fires a status event.
	 * 
	 * @param current
	 *            the current progress value
	 */
	public void setCurrent(int current) {
		setCurrent(current, null);
	}

	/**
	 * Sets the current progress and the status text and fires a status event.
	 * The text is information often useful to display to the end user to notify
	 * them on what is occurring in the background.
	 * 
	 * @param current
	 *            the current progress value
	 * @param status
	 *            the status text
	 */
	public void setCurrent(int current, String status) {
		statusEvent.current = current;
		statusEvent.text = status;
		fireProgressEvent(statusEvent);
	}

	/**
	 * Returns the text of the status event. This is information often useful to
	 * display to the end user to notify them on what is occurring in the
	 * background.
	 * 
	 * @return the status text
	 */
	public String getStatusText() {
		return statusEvent.text;
	}

	/**
	 * Sets the status text and fires a status event. This is information often
	 * useful to display to the end user to notify them on what is occurring in
	 * the background.
	 * 
	 * @param status
	 *            the status text
	 */
	public void updateStatusText(String status) {
		statusEvent.text = status;
		fireProgressEvent(new DeterminateStatusEvent(this, statusEvent.min,
				statusEvent.max, statusEvent.current, status));
	}
}
