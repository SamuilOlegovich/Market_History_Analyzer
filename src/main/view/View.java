package main.view;

import main.controller.RunAndStopProgram;
import main.model.DataParser;
import main.model.Gasket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class View extends Thread {
    private RunAndStopProgram runAndStopProgram;
    private JTextField jTextFieldStartDate;
    private JTextField jTextFieldEndDate;
    private JScrollPane jScrollPane;
    private JTextField jTextField;
    private Color color;


    private JTextArea jTextArea;
    private JButton jButtonSavePattern;
    private JButton jButtonStatistics;
//    private JButton jButtonStart;
//    private JButton jButtonStop;
    private JButton jButtonSet;
    private JFrame jFrame;
    private JPanel jPanel;

    private boolean startFlag;




    @Override
    public void run() {
        jFrame = getJFrame();
        jPanel = new JPanel();
        jFrame.add(jPanel, BorderLayout.NORTH);
        jPanel.setBackground(Color.LIGHT_GRAY);

        jPanel.add(new JLabel("Commands"));
        jTextField = new JTextField("insert commands...",30);
        jPanel.add(jTextField);
        jPanel.revalidate();
        jButtonSet = new JButton("SET");
        jPanel.add(jButtonSet);


        jPanel.add(new JLabel("Start date"));
        jTextFieldStartDate = new JTextField("enter date... ",13);
        jPanel.add(jTextFieldStartDate);

        jPanel.add(new JLabel("End date"));
        jTextFieldEndDate = new JTextField("hh:mm_dd.mm.yyyy",13);
        jPanel.add(jTextFieldEndDate);

        jButtonStatistics = new JButton("STATISTICS");
        jPanel.add(jButtonStatistics);

        jButtonSavePattern = new JButton("SAVE PATTERN");
        jPanel.add(jButtonSavePattern);




        jTextArea = new JTextArea(35, 90);
        jScrollPane = new JScrollPane(jTextArea);
        jTextArea.setLineWrap(true);
        jFrame.add(jScrollPane, BorderLayout.CENTER);

        startFlag = true;


        jButtonSet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // тут прописать настройки программы
                new Thread() {
                    @Override
                    public void run() {
                        color = jPanel.getBackground();
                        jPanel.setBackground(Color.yellow);
                        try {
                            Thread.sleep(1000 * 2);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        setPreviousColor();
                    }
                }.start();

                String string = jTextField.getText();
                if (string.length() > 3) {
                    if (string.trim().equalsIgnoreCase("info")) {
                        ConsoleHelper.printInfoSettings();
                    } else if (string.trim().equalsIgnoreCase("commands")) {
//                        ConsoleHelper.showCommands();
                    } else {
                        Gasket.getExecutorCommandosClass().parseAndExecute(string.replaceAll("=", " === "));
                    }
                }
            }
        });


        jButtonStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // тут прописать настройки программы
                new Thread() {
                    @Override
                    public void run() {
                        color = jPanel.getBackground();
                        jPanel.setBackground(Color.PINK);
                    }
                }.start();

                String startDate = jTextFieldStartDate.getText();
                String endDate = jTextFieldEndDate.getText();
                new DataParser(startDate, endDate);
            }
        });


        jButtonSavePattern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // тут прописать настройки программы
                new Thread() {
                    @Override
                    public void run() {
                        color = jPanel.getBackground();
                        jPanel.setBackground(Color.BLUE);
                    }
                }.start();
                Gasket.getWritePatternsClass().writePattern();
            }
        });
    }




    private static JFrame getJFrame() {
        JFrame jFrame = new JFrame() {};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        jFrame.setSize(1110, 635);
        jFrame.setLocation(dimension.width/2 - 570, dimension.height/2 - 325);
        jFrame.setTitle("MARKET HISTORY ANALYZER - POWER by SAMUIL_OLEGOVICH");
//        jFrame.setIconImage();
        return jFrame;
    }



    public void updateInfoView(String string) {
        if (string != null) {
            if (string.endsWith("\n")) {
                jTextArea.append(string);
            } else {
                jTextArea.append(string + "\n");
            }
        }
    }

    public void setColorFoStarted() {
        color = jPanel.getBackground();
        jPanel.setBackground(Color.PINK);
    }

    public void setColorError() {
        jPanel.setBackground(Color.RED);
    }


    public boolean isStartFlag() {
        return startFlag;
    }


    public void setPreviousColor() {
        jPanel.setBackground(color);
    }
}
