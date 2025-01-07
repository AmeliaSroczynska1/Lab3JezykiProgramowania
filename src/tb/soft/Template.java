package tb.soft;

import javax.swing.SwingUtilities;

public class Template {
    Template(String[] args) {
        // Invoked on the event dispatching thread.
        // Do any initialization here.
    }

    public void show() {
        // Show the UI.
    }

    public static void main(final String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Template(args).show();
            }
        });
    }
}