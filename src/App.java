import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class App {

    public static void main(String[] args) {
        new App();
    }

    JFrame frame;
    JPanel panel;
    JMenuBar menuBar;
    JMenu options, help, refresh, close;

    public App(){
        frame = new JFrame();
        panel = new JPanel();

        menuBar = new JMenuBar();

        options = new JMenu("Optionen");
        options.addMenuListener(new Listener());
        menuBar.add(options);
        help = new JMenu("Hilfe");
        help.addMenuListener(new Listener());
        menuBar.add(help);
        refresh = new JMenu("Aktualisieren");
        refresh.addMenuListener(new Listener());
        menuBar.add(refresh);
        close = new JMenu("Beenden");
        close.addMenuListener(new Listener());
        menuBar.add(close);

        frame.setJMenuBar(menuBar);
        frame.add(panel);

        frame.setVisible(true);
        frame.setSize(720,480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class Listener implements MenuListener{

        @Override
        public void menuSelected(MenuEvent e) {
            if(e.getSource() == close){
                int clicked = JOptionPane.showConfirmDialog(frame,"Are you sure you want to quit?");
                if(clicked == 0){
                    frame.dispose();
                }
            }
        }

        @Override
        public void menuDeselected(MenuEvent e) {
        }

        @Override
        public void menuCanceled(MenuEvent e) {
        }
    }
}
