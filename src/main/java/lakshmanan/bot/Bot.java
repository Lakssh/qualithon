package lakshmanan.bot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class Bot {
    private JButton buttonRun;
    private JPanel panelMain;
    private JLabel ImageLogo;
    private ImageIcon image;

    public Bot() {
        buttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Bot has started");
            }
        });
        ImageLogo.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                /*JLabel ImageLogo = new Bot().ImageLogo;
        ImageIcon image = new Bot().image;
        ImageLogo.setLayout(new FlowLayout());
        image = new ImageIcon("bot.png");
        ImageLogo = new JLabel(image);
        ImageLogo.setSize(new Dimension(100,100));
        frame.add(ImageLogo);*/
            }
        });
    }
    public static void main(String[] args){

        JFrame frame = new JFrame("Bot");
        JPanel panel = new Bot().panelMain;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/3-frame.getSize().height/2);
        frame.add(panel, BorderLayout.CENTER);
        //panel.add(new JLabel("<html><font color='red'>Automation Bot</font></html>"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
