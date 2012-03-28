# progressive

Progressive is intended to be a simple library of classes to track progress for tasks for a Java application.

# Examples

## Determinate

The example below shows a simple implementation of using a determinate progress monitor. We create a dummy task to track its progress which just counts up to 100 every 50 milliseconds.

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    import javax.swing.SwingUtilities;
    import javax.swing.Timer;
    import javax.swing.UIManager;

    public class DeterminateExample {

      static DeterminateProgressMonitor determinateMonitor;

      public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

          @Override
          public void run() {
            try {
              UIManager.setLookAndFeel(UIManager
                  .getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            // create a dummy task which increments the progress
            final Timer task = new Timer(50, new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e) {
                int progress = determinateMonitor.getCurrent() + 1;
                determinateMonitor.setCurrent(progress,
                        String.format("progress: %d", progress));
              }
            });
            task.setRepeats(true);
            
            // define a delegate to handle what happens when cancel button is clicked
            CancelHandler delegate = new CancelHandler() {

              @Override
              public void canceled() {
                task.stop();
              }
            };
            // create the progress monitor
            determinateMonitor = ProgressUtil
                .createModalDeterminateProgressMonitor(null,
                    "Test Dialog", 0, 100, 0, 0, delegate);
            determinateMonitor.start("Task started");

            // start the task
            task.start();
          }
        });
      }

    }

## Indeterminate

The example below show a simple implementation of how to monitor the progress of an indeterminate task.

    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    import javax.swing.SwingUtilities;
    import javax.swing.Timer;
    import javax.swing.UIManager;

    public class Example {

      static IndeterminateProgressMonitor indeterminateMonitor;
      static int progress;

      public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

          @Override
          public void run() {
            try {
              UIManager.setLookAndFeel(UIManager
                  .getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            // create a dummy task which increments the progress
            final Timer task = new Timer(50, new ActionListener() {

              @Override
              public void actionPerformed(ActionEvent e) {
                progress += 50;
                if (progress >= 2000) {
                  indeterminateMonitor.setCompleted(true);
                }
              }
            });
            task.setRepeats(true);

            // define a delegate to handle what happens when cancel button
            // is clicked
            CancelHandler delegate = new CancelHandler() {

              @Override
              public void canceled() {
                task.stop();
              }
            };
            // create the progress monitor
            indeterminateMonitor = ProgressUtil
                .createModalIndeterminateProgressMonitor(null,
                    "Indeterminate Test", 0, delegate);
            indeterminateMonitor.start("Task started");

            // start the task
            task.start();
          }
        });
      }

    }

