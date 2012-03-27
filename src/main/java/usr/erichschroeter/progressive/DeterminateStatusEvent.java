package usr.erichschroeter.progressive;

/**
 * Fired when the status of a {@link AbstractProgressMonitor} changes. The event
 * provides the value boundaries as well as the current value, along with an
 * optional status text.
 * 
 * @author Erich Schroeter
 */
@SuppressWarnings("serial")
public class DeterminateStatusEvent extends StatusEvent {

	int min;
	int max;
	int current;

	/**
	 * Constructs a <code>StatusEvent</code> specifying the current status value
	 * and its boundaries.
	 * 
	 * @param source
	 *            the object which fired the event
	 * @param min
	 *            the minimum boundary for the status value
	 * @param max
	 *            the maximum boundary for the status value
	 * @param current
	 *            the current status value
	 */
	public DeterminateStatusEvent(Object source, int min, int max, int current) {
		this(source, min, max, current, null);
	}

	/**
	 * Constructs a <code>StatusEvent</code> specifying some status text.
	 * 
	 * @param source
	 *            the object that fired the event
	 * @param min
	 *            the minimum boundary for the status value
	 * @param max
	 *            the maximum boundary for the status value
	 * @param current
	 *            the current status value
	 * @param text
	 *            a status message providing status information (optional)
	 */
	public DeterminateStatusEvent(Object source, int min, int max, int current,
			String text) {
		super(source, text);
		this.min = min;
		this.max = max;
		this.current = current;
	}

	/**
	 * Returns the minimum value the progress value may be.
	 * 
	 * @return the minimum progress value
	 */
	public int getMin() {
		return min;
	}

	/**
	 * Returns the maximum value the progress value may be.
	 * 
	 * @return the maximum progress value
	 */
	public int getMax() {
		return max;
	}

	/**
	 * Returns the current progress value.
	 * 
	 * @return the current progress value
	 */
	public int getCurrent() {
		return current;
	}

	/**
	 * Returns <code>true</code> when the current progress value is greater than
	 * or equal to the max progress value.
	 * 
	 * @return <code>true</code> when <code>getCurrent()</code> return value
	 *         &gt;= <code>getMax()</code> return value, else <code>false</code>
	 */
	@Override
	public boolean isCompleted() {
		return current >= max;
	}
}
