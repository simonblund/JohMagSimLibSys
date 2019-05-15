package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.Copy;
import com.JohMagSim.Libr.model.CopyDAO;
import org.junit.Test;

import static org.junit.Assert.*;

public class CopyTest {

public Copy testItem(){
    Copy item = new Copy();

    // Set the parameters
   item.setISBN_EAN("12");
   item.setTitle("En saga");
   item.setYear(2016);
  // item.setStaff_id(0);
  // item.setPublisher_id(0);
  // item.setItemCategory_id(0);
   return item;
}

public Copy testCopy(){
    Copy copy = new Copy();
    copy.setItemID(1);
    copy.setBarCode(123123);
    copy.setState(1);
    return copy;

}


@Test
    public void itemSaveTest(){
    Copy item=testItem();
    CopyDAO.createItem(item);
  }

    @Test
    public void copySaveTest(){
        Copy copy=testCopy();
        CopyDAO.createCopy(copy);
    }


}



/*@Test
    public void userSaveTest(){
        User test = testUser();
        UserDAO.saveUser(test);

        User dbuser = UserDAO.findUsersFromName(test.getFirstName(), test.getLastName()).get(0);
        assertEquals(test.getFirstName(), dbuser.getFirstName());
    }
}
*/
