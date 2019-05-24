package com.JohMagSim.Libr.viewcontroller;

import com.JohMagSim.Libr.model.*;
import com.JohMagSim.Libr.views.*;

import java.awt.event.*;

public class StaffTabCopiesCreateTabVC {
    private StaffTabCopiesCreateTab cip;
    private Item loadedItem;

    public StaffTabCopiesCreateTabVC(StaffTabCopiesCreateTab createCopyTab){
        cip = createCopyTab;
    }

    public StaffTabCopiesCreateTab getCip(){
        return cip;
    }

    public void initStaffTabCopiesCreateTab(){
        cip.setVisible(true);
        cip.add(cip.getSearchForm());
        cip.getSearchForm().setVisible(true);
        cip.updateUI();
    }

    private ActionListener searchItem = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String ibanean = cip.getSearchItemT().getText();
            int id = ibanean.charAt(0);
            loadedItem = ItemDAO.findItembyId(id);

            cip.getLabel().setText("Item edited "+ loadedItem.getTitle());
            cip.remove(cip.getSearchForm());
            cip.getSearchForm().setVisible(false);
            cip.getForm().setVisible(true);
        }
    };

    private ActionListener saveCopy = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Copy copy = new Copy();

            copy.setBarCode(cip.getBarcodeT().getText());
            copy.setState(cip.getStateT().getSelectedIndex());
            copy.setItemID(loadedItem.getId());

            CopyDAO.createCopy(copy);
        }
    };

}
