package com.JohMagSim.Libr.modelTests;

import com.JohMagSim.Libr.model.*;
import org.junit.*;
import static org.junit.Assert.*;

public class CopyDAOTest {

    public Copy testCopy() {
        Copy copyItem = new Copy(1, 123123, 1);
        return copyItem;
    }

    public Copy copyFindCopybyBarcode() {
        Copy testBarcode = CopyDAO.findCopybyBarcode(123123);
        return testBarcode;
    }

    @Test
    public void copySavetest() {
        Copy test = testCopy();
        CopyDAO.createCopy(test);
    }

    @Test
    public void assertEquals() {
        Copy test = testCopy();
        System.out.println(test);
        Copy testBarcode = copyFindCopybyBarcode();
        System.out.println(testBarcode);
        assertEquals(test,testBarcode);
    }

   private void assertEquals(Copy test, Copy testBarcode) {
    }

}


