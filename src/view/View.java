package view;

import controller.RunAndStopProgram;
import model.Enums;
import model.Gasket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class View extends Thread {
    private RunAndStopProgram runAndStopProgram;
    private JScrollPane jScrollPane;
    private JTextField jTextField;
    private JButton jButtonStart;
    private JButton jButtonStop;
    private Color color;


    private JTextArea jTextArea;
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
        jButtonStart = new JButton("START");
        jButtonStop = new JButton("STOP");

        jPanel.add(jButtonStart);
        jPanel.add(jButtonStop);


        jPanel.add(new JLabel("Commands"));
        jTextField = new JTextField("insert commands or date 17:10_31.12.2020 => 18:15_10.01.2021",30);
        jPanel.add(jTextField);
        jPanel.revalidate();

        jButtonSet = new JButton("SET");
        jPanel.add(jButtonSet);

        jTextArea = new JTextArea(35, 90);
        jScrollPane = new JScrollPane(jTextArea);
        jTextArea.setLineWrap(true);
        jFrame.add(jScrollPane, BorderLayout.CENTER);

        startFlag = true;



        jButtonStart.addActionListener(new ActionListener() {
            //            @Override
            public void actionPerformed(ActionEvent e) {

                // тут прописать старт программы
                color = jPanel.getBackground();
                jPanel.setBackground(Color.GREEN);

                if (runAndStopProgram != null) {
                    runAndStopProgram.startProgram();
                    ConsoleHelper.writeMessage(StringHelper.getString(Enums.PROGRAM_SUCCESSFULLY_LAUNCHED));
                }
                if (runAndStopProgram == null) {
                    runAndStopProgram = new RunAndStopProgram();
                    Gasket.setRunProgramClass(runAndStopProgram);
                }
            }
        });


        jButtonStop.addActionListener(new ActionListener() {
            //            @Override
            public void actionPerformed(ActionEvent e) {
                // тут прописать Стоп программы
                color = jPanel.getBackground();
                jPanel.setBackground(Color.RED);

                runAndStopProgram.stopPrograms();
                ConsoleHelper.writeMessage(StringHelper.getString(Enums.PROGRAM_STOPPED));

            }
        });


        jButtonSet.addActionListener(new ActionListener() {
            //            @Override
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
                    if (string.trim().equals("info")) {
//                        ConsoleHelper.printInfoSettings();
                    } else if (string.trim().equalsIgnoreCase("commands")) {
//                        ConsoleHelper.showCommands();
                    } else {
//                        Gasket.getExecutorCommandos().parseAndExecute(string.replaceAll("=", " === "));
                    }
                }
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
        jFrame.setTitle("NN POWER by SAMUIL_OLEGOVICH");
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


    public boolean isStartFlag() {
        return startFlag;
    }


    public void setPreviousColor() {
        jPanel.setBackground(color);
    }
}
