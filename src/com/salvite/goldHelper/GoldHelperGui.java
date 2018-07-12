package com.salvite.goldHelper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GoldHelperGui extends JFrame {
    private JPanel rootPanel;
    private JList expList;
    private JButton resetButton;
    private JButton pidgey2;
    private JButton pidgey3;
    private JButton pidgey4;
    private JButton caterpie2;
    private JButton caterpie3;
    private JButton rattata4;
    private JButton sentret3;
    private JButton sentret2;
    private JTextField expText;
    private JButton sandshrew6;
    private JButton geodude6;
    private JButton onix6;
    private JButton joey;
    private JButton don;
    private JButton ralphSkip;
    private JButton daniel;
    private JButton bill;
    private JButton anthony;
    private JButton benny;
    private JLabel invisibleLabel;
    private int expCount;


    public GoldHelperGui() {
        setContentPane(rootPanel);
        setupButtons();
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void setupButtons() {
        pidgey2.addActionListener(createActionListener(15));
        pidgey3.addActionListener(createActionListener(23));
        pidgey4.addActionListener(createActionListener(31));
        caterpie2.addActionListener(createActionListener(22));
        caterpie3.addActionListener(createActionListener(30));
        sentret2.addActionListener(createActionListener(16));
        sentret3.addActionListener(createActionListener(24));
        rattata4.addActionListener(createActionListener(32));
        sandshrew6.addActionListener(createActionListener(79));
        geodude6.addActionListener(createActionListener(73));
        onix6.addActionListener(createActionListener(92));

        joey.addActionListener(createActionListener(48));
        don.addActionListener(createActionListener(66));
        ralphSkip.addActionListener(createActionListener(-237));
        daniel.addActionListener(createActionListener(253));
        bill.addActionListener(createActionListener(290));
        anthony.addActionListener(createActionListener(409));
        benny.addActionListener(createActionListener(622));

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expCount = 0;
                expText.setText("" + expCount);
                updateList();
            }
        });
    }

    private ActionListener createActionListener(int expGained) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expCount += expGained;
                expText.setText("" + expCount);
                updateList();
            }
        };
    }

    private void updateList() {
        ListModel listModel = expList.getModel();
        ArrayList<Integer> selectedIndexes = new ArrayList<>();

        for(int i = 0; i < listModel.getSize(); i++) {
            String currentElement = listModel.getElementAt(i).toString().trim();

            String[] stringComponents = currentElement.split(" ");

            try{
                int valueNeeded = Integer.valueOf(stringComponents[0]);
                if(valueNeeded <= expCount) {
                    selectedIndexes.add(i);
                }
            } catch (Exception e) { }
        }

        int[] indexes = new int[selectedIndexes.size()];

        for(int i = 0; i < selectedIndexes.size(); i++) {
            indexes[i] = selectedIndexes.get(i);
        }

        expList.setSelectedIndices(indexes);
    }
}
