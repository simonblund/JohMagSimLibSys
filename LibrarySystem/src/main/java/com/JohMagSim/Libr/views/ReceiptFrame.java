package com.JohMagSim.Libr.views;

import com.JohMagSim.Libr.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ReceiptFrame extends JFrame {
    JLabel name = new JLabel();
    JPanel loanpanel = new JPanel();

    public ReceiptFrame(ArrayList<Loan> loans, User user){
        setSize(200,700);
        setTitle("Receipt");
        setLayout(new BorderLayout());

        name.setText(user.getFirstName()+" "+ user.getLastName());
        add(BorderLayout.NORTH,name);
        name.setVisible(true);

        for(int i =0; i<loans.size(); i++){
            // Här kom tidsbristen emot, skulle denormaliserat bättre alternativt skickat med en
            // lista på items till den här viewn för att slippa extremt många db-körningar.
            String title = ItemDAO.findItembyId(CopyDAO.findCopybyId(loans.get(i).getCopyID()).getItemID()).getTitle();
            loanpanel.add(new JLabel(title + "  return date: " + loans.get(i).getExpectedReturnDate()));
        };
        add(BorderLayout.CENTER, loanpanel);
        loanpanel.setVisible(true);
        setVisible(true);


    }

}
