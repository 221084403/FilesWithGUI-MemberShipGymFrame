/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import za.ac.tut.membership.MemberShip;

/**
 *
 * @author MNCEDISI
 */
public class MemberShipFrame extends JFrame
{
    //panel
    private JPanel firstContainerPNL;
    private JPanel headingPNL;
    private JPanel clientDetailsPNL;
    private JPanel namePNL;
    private JPanel surnamePNL;
    private JPanel idNoPNL;
    private JPanel genderPNL;
    
    private JPanel secodContainerPNL;
    private JPanel contractOptionPNL;
    private JPanel radioBtnPNL;
    
    private JPanel thridContainerPNL;
    
    private JPanel mainPNL;
    
    //label
    private JLabel headingLBL;
    private JLabel nameLBL;
    private JLabel surnameLBL;
    private JLabel idNoLBL;
    private JLabel genderLBL;
    
    private JLabel typeContractLBL;

    //text field
    private JTextField nameTxtFLD;
    private JTextField surnameTxtFLD;
    private JTextField idNoTxtFLD;
    
    //combo box
    private JComboBox genderCM;
    
    //radio button
    private JRadioButton monthToMonthBTN;
    private JRadioButton sixMonthBTN;
    private JRadioButton annualBTN;
    
    //button group
    private ButtonGroup combineBTNG;
    
    //check box
    private JCheckBox personTrainerCB;
    
    //text area
    private JTextArea commentAreaTxt;
    
    //scrollpane
    private JScrollPane commentAreaSCP;
    
    //menu bar
    private JMenuBar menuBar;
    
    //menu 
    private JMenu fileMenu;
    private JMenu editMenu;
    
    //menu items
    private JMenuItem openFileMenuItem;
    private JMenuItem saveFileMenuItem;
    private JMenuItem deleteFileMenuItem;
    private JMenuItem clearMenuItem;
    private JMenuItem exitMenuItem;
    
    private JMenuItem updateMenuItem;
    private JMenuItem removeFileMenuItem;
    private JMenuItem searchFileMenuItem;

    //path
    private String path;
    
    //list of membership
    private ArrayList<MemberShip> theList;

    public MemberShipFrame() 
    {
        setTitle("Gym membership");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450 , 580);
        setDefaultLookAndFeelDecorated(true);
        //creaing a list
        theList =  new ArrayList<>();
        
        //initailling a path string
        path = "";
        
        //creating panel
        firstContainerPNL = new JPanel(new BorderLayout());
        headingPNL = new JPanel(new FlowLayout(FlowLayout.CENTER));
        clientDetailsPNL  = new JPanel(new GridLayout(4, 1 , 1 , 5));
        clientDetailsPNL.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Client Details"));
        
        namePNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        secodContainerPNL = new JPanel(new BorderLayout());
        radioBtnPNL = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contractOptionPNL = new JPanel(new GridLayout(2, 1 , 1 , 5 ));
        contractOptionPNL.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Contract option"));
        
        thridContainerPNL = new JPanel(new BorderLayout());
        
        mainPNL = new JPanel(new BorderLayout());
        
        //creating label
        headingLBL = new JLabel("Membership Form");
        int iFont = Font.BOLD + Font.ITALIC;
        headingLBL.setFont(new Font(null, iFont, 30));
        headingLBL.setForeground(Color.BLUE);
        headingLBL.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        
        nameLBL = new  JLabel("Name        :");
        surnameLBL = new JLabel("Surname  :");
        idNoLBL = new JLabel("Id No          :");
        genderLBL = new JLabel("Gender      :");
        
        typeContractLBL = new JLabel("Type of Contract :");
        
        //creating text fields
        nameTxtFLD = new JTextField(10);
        surnameTxtFLD = new JTextField(10);
        idNoTxtFLD = new JTextField(10);
        
        //creating string array of object
        String [] genderType  = {"---Please select---" , "Male","Female"};
        
        //creating combo box
        genderCM = new JComboBox(genderType);
        
        //creating radio button
        monthToMonthBTN = new JRadioButton("Month-to-month");
        sixMonthBTN = new JRadioButton("Six month");
        annualBTN = new JRadioButton("Annual");
        
        //creating button group
        combineBTNG = new ButtonGroup();
        
        combineBTNG.add(monthToMonthBTN);
        combineBTNG.add(sixMonthBTN);
        combineBTNG.add(annualBTN);
        
        //creating check box
        personTrainerCB = new JCheckBox("Select the check box if you need a personal trainer ");
        
        //creating text area
        commentAreaTxt = new JTextArea(10, 20);
        commentAreaTxt.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1), "Comments"));
        
        //creating scrollpane
        commentAreaSCP = new JScrollPane(commentAreaTxt, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //creating menu bar
        menuBar = new JMenuBar();
        
        //creating menu
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        
        //creating menu items
        openFileMenuItem = new JMenuItem("Open file...");
        openFileMenuItem.addActionListener(new OpenFileMenuItemListenerMI());
        
        saveFileMenuItem = new JMenuItem("Save file...");
        saveFileMenuItem.addActionListener(new SaveFileMenuItemListenerMI());
        
        deleteFileMenuItem = new JMenuItem("Delete file...");
        deleteFileMenuItem.addActionListener(new DeleteFileListenerFL());
        
        clearMenuItem = new JMenuItem("Clear");
        clearMenuItem.addActionListener(new ClearListenerCL());
        
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitListenerEL());
        
        updateMenuItem = new JMenuItem("Update file...");
        updateMenuItem.addActionListener(new UpdateFileListenerFL());
        
        removeFileMenuItem = new JMenuItem("Remove something...");
        removeFileMenuItem.addActionListener(new RemoveFileListenerFL());
        
        searchFileMenuItem = new JMenuItem("Search something...");
        searchFileMenuItem.addActionListener(new SearchFileListenerFL());
        
        //adding components    
        fileMenu.add(openFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(saveFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(deleteFileMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(clearMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        
        editMenu.add(updateMenuItem);
        editMenu.addSeparator();
        editMenu.add(removeFileMenuItem);
        editMenu.addSeparator();
        editMenu.add(searchFileMenuItem);
        
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        
        headingPNL.add(headingLBL);
        
        namePNL.add(nameLBL);
        namePNL.add(nameTxtFLD);
        
        surnamePNL.add(surnameLBL);
        surnamePNL.add(surnameTxtFLD);
        
        idNoPNL.add(idNoLBL);
        idNoPNL.add(idNoTxtFLD);
        
        genderPNL.add(genderLBL);
        genderPNL.add(genderCM);
        
        clientDetailsPNL.add(namePNL);
        clientDetailsPNL.add(surnamePNL);
        clientDetailsPNL.add(idNoPNL);
        clientDetailsPNL.add(genderPNL);
        
        firstContainerPNL.add(headingPNL , BorderLayout.NORTH);
        firstContainerPNL.add(clientDetailsPNL , BorderLayout.CENTER);
        
        radioBtnPNL.add(typeContractLBL);        
        radioBtnPNL.add(monthToMonthBTN);        
        radioBtnPNL.add(sixMonthBTN);        
        radioBtnPNL.add(annualBTN);   
        
        contractOptionPNL.add(radioBtnPNL);
        contractOptionPNL.add(personTrainerCB);
        
        secodContainerPNL.add(contractOptionPNL);
        
        thridContainerPNL.add(commentAreaSCP);
        
        mainPNL.add(firstContainerPNL , BorderLayout.NORTH);
        mainPNL.add(secodContainerPNL , BorderLayout.CENTER);
        mainPNL.add(thridContainerPNL , BorderLayout.SOUTH);
        
        setJMenuBar(menuBar);
        
        add(mainPNL);
        
        setVisible(true);
    }
    
    private void writeNewFile(ArrayList<MemberShip> theList) throws IOException
    {
        String outcome = "";
        
        File file = new File(path);
        FileWriter fw = new FileWriter(file );
        BufferedWriter bw = new BufferedWriter(fw);
        
        for (MemberShip display : theList) 
            outcome+=display.toString()+"\n";
        
        bw.write(outcome);
        
        bw.close();
    }

    private void readOldFile() throws FileNotFoundException, IOException 
    {
        File file = new File(path);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        
        String line = br.readLine();
        
        while(line != null)
        {
            String data[] = line.split(",");
            String name = data[0] , surname = data[1];
            String idNo = data[2] , gender = data[3];
            String contract = data[4] ;
            boolean personalTrainer = Boolean.valueOf(data[5]);
            
            MemberShip memberShip = new MemberShip(name, surname, idNo, gender, contract, personalTrainer);
            
            theList.add(memberShip);
            
            line = br.readLine();
        }
    }

    private class SearchFileListenerFL implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int errorMsg = JOptionPane.ERROR_MESSAGE;
            String error = "";
            
            try
            {
                readOldFile();
                searchSomeoneInTheFile(theList);
            }
            
            catch (IOException ex) 
            {
                error ="Something went wrong\n"+ex.getMessage();
                JOptionPane.showMessageDialog(MemberShipFrame.this, error ,"Error" , errorMsg);
            }
            
        }

        private void searchSomeoneInTheFile(ArrayList<MemberShip> theList) 
        {
            String outcome = "";
            
            for (MemberShip display : theList) 
            {
                if(getInforFromTheGui().getIdNo().equals(display.getIdNo()))
                {
                    outcome+="Name                     :"+display.getName()+"\n"+
                             "Surname               :"+display.getSurname()+"\n"+
                             "IdNo                        :"+display.getIdNo()+"\n"+
                             "Gender                   :"+display.getGender()+"\n"+
                             "Contract                 :"+display.getContract()+"\n"+
                             "Personal Trainer :"+display.isPersonalTrainer()+"\n\n";
                }
            }
            
            commentAreaTxt.setText(outcome);
        }
    }

    private class RemoveFileListenerFL implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int errorMsg = JOptionPane.ERROR_MESSAGE;
            String error = "";
            
            try
            {
                readOldFile();
                removeSomethingInTheFile(theList);
                writeNewFile(theList); 
            }
            
            catch (IOException ex) 
            {
                error ="Something went wrong\n"+ex.getMessage();
                JOptionPane.showMessageDialog(MemberShipFrame.this, error ,"Error" , errorMsg);
            }
        }

        private void removeSomethingInTheFile(ArrayList<MemberShip> theList) 
        {
            int plianMsg = JOptionPane.PLAIN_MESSAGE;
            
            for (int i = 0 ; i <theList.size() ; i++)
            {
                String idNo = theList.get(i).getIdNo();
                
                if(getInforFromTheGui().getIdNo().equals(idNo))
                {
                    theList.remove(i);
                    
                    JOptionPane.showMessageDialog(MemberShipFrame.this, "Client infor is removed!" , "Display" ,plianMsg);
                }
            }
        }
    }
    
    private class UpdateFileListenerFL implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int errorMsg = JOptionPane.ERROR_MESSAGE;
            String error = "";
            
            try
            {
                readOldFile();
                updateFile(theList);
                writeNewFile(theList);
            } 
            
            catch (FileNotFoundException ex) 
            {
                error ="File not found!";
                JOptionPane.showMessageDialog(MemberShipFrame.this, error ,"Error" , errorMsg);
            } 
            
            catch (IOException ex) 
            {
                error ="Something went wrong\n"+ex.getMessage();
                JOptionPane.showMessageDialog(MemberShipFrame.this, error ,"Error" , errorMsg);
            }
            
        }
  
        private void updateFile(ArrayList<MemberShip> theList)
        {
            int plainMsg = JOptionPane.PLAIN_MESSAGE;
            
            for (MemberShip display : theList)
            { 
                if(getInforFromTheGui().getIdNo().equals(display.getIdNo()))
                {
                    int index = theList.indexOf(display);
                    theList.set(index, getInforFromTheGui());
                    
                    JOptionPane.showMessageDialog(MemberShipFrame.this, "File Updated successfully!","Display",plainMsg);
                }
            }
        }
    }
    private class ExitListenerEL implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    }

    private class ClearListenerCL implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            nameTxtFLD.setText(null);
            surnameTxtFLD.setText(null);
            idNoTxtFLD.setText(null);
            genderCM.setSelectedIndex(0);
            combineBTNG.clearSelection();
            personTrainerCB.setSelected(false);
            commentAreaTxt.setText(null);
        }
    }

    private class DeleteFileListenerFL implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JFileChooser jfc = new JFileChooser();
            
            int errorMsg = JOptionPane.ERROR_MESSAGE;
            int plainMsg = JOptionPane.PLAIN_MESSAGE;
            
            int value = jfc.showSaveDialog(MemberShipFrame.this);
            
            if(value == JFileChooser.APPROVE_OPTION)
            {
                File file  = jfc.getSelectedFile();
                
                if(file.delete())
                    JOptionPane.showMessageDialog(MemberShipFrame.this, "File deleted!" ,"Outcome" ,plainMsg);
                else
                    JOptionPane.showMessageDialog(MemberShipFrame.this, "File Not deleted!" ,"Error" ,errorMsg);
            }
            
            else
            {
                String error = "The if statement failed. The returned value is "+value;
                JOptionPane.showMessageDialog(MemberShipFrame.this, error , "Error",errorMsg);
            }      
        }
    }

    private class SaveFileMenuItemListenerMI implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser jfc = new JFileChooser();
            
            int errorMsg = JOptionPane.ERROR_MESSAGE;    
            int plaineMsg = JOptionPane.PLAIN_MESSAGE;
            String error = "",writeInfor ="";
            
            int value = jfc.showSaveDialog(MemberShipFrame.this);
            
            if(value == JFileChooser.APPROVE_OPTION)
            {
                File file = jfc.getSelectedFile();
                path = file.getPath();
                
                try
                {
                    FileWriter fw = new FileWriter(file , true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    writeInfor  = getInforFromTheGui().toString();
                    
                    bw.write(writeInfor);
                    
                    bw.newLine();
                    
                    bw.close();
                    
                    JOptionPane.showMessageDialog(MemberShipFrame.this, "File saved!" , "Outcome" ,plaineMsg);
                } 
                
                catch (IOException ex) 
                {
                    error  ="Something went wrong\n"+ex.getMessage();
                    JOptionPane.showMessageDialog(MemberShipFrame.this, error , "Error",errorMsg);
                }
            }
            
            else
            {
                error = "The if statement failed. The returned value is "+value;
                JOptionPane.showMessageDialog(MemberShipFrame.this, error , "Error",errorMsg);
            }
        }
    }
    
    private MemberShip getInforFromTheGui() 
    {
        String name = nameTxtFLD.getText();
        String surname = surnameTxtFLD.getText();
        String idNo = idNoTxtFLD.getText();
        String gender = String.valueOf(genderCM.getSelectedItem());
        String contract = getContract();
        boolean personalTrainer = personTrainerCB.isSelected();
        
        MemberShip memberShip = new MemberShip(name, surname, idNo, gender, contract, personalTrainer);
              
        return memberShip;
    }
    
    private String getContract() 
    {
        if(monthToMonthBTN.isSelected())
            return monthToMonthBTN.getText();
        else
            if(sixMonthBTN.isSelected())
                return sixMonthBTN.getText();
        else
            if(annualBTN.isSelected())
                return annualBTN.getText();
        else
            return "Other";
    }

    private class OpenFileMenuItemListenerMI implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            JFileChooser jfc = new JFileChooser();
            
            int errorMsg = JOptionPane.ERROR_MESSAGE;
            String error = "" , outcome = "";
            
            int value = jfc.showOpenDialog(MemberShipFrame.this);
            
            if(value == JFileChooser.APPROVE_OPTION)
            {
                File file = jfc.getSelectedFile();
                path = file.getPath();
                
                try
                {
                    FileReader  fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    
                    String line = br.readLine();
                    
                    while(line !=null)
                    {
                        String data[] = line.split(",");
                        String name = data[0] ,surname = data[1];
                        String idNo = data[2] , gender = data[3];
                        String contract = data[4] ;
                        boolean personalTrainer = Boolean.valueOf(data[5]);
                        
                        outcome+="Name                     :"+name+"\n"+
                                "Surname               :"+surname+"\n"+
                                "IdNo                        :"+idNo+"\n"+
                                "Gender                   :"+gender+"\n"+
                                "Contract                 :"+contract+"\n"+
                                "Personal Trainer :"+personalTrainer+"\n\n";
                        
                        line = br.readLine();
                    }
                    
                    commentAreaTxt.setText(outcome);
                }
                
                catch (FileNotFoundException ex) 
                {
                    error = "File not found";
                    JOptionPane.showMessageDialog(MemberShipFrame.this, error , "Error",errorMsg);
                } 
                
                catch (IOException ex) 
                {
                    error  ="Something went wrong\n"+ex.getMessage();
                    JOptionPane.showMessageDialog(MemberShipFrame.this, error , "Error",errorMsg);
                }
            }
            else
            {
                error = "The if statement failed. The returned value is "+value;
                JOptionPane.showMessageDialog(MemberShipFrame.this, error , "Error",errorMsg);
            }
        }
    }
}
