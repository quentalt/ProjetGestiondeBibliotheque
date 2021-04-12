/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livre;

import java.io.File;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
/**
 *
 * @author quentin
 */
class Barcode2  {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

    //Get Bookland Barcode instance from the Factory
    //International Standard Book Number (ISBN)
       

    net.sourceforge.barbecue.Barcode barcode = BarcodeFactory.createBookland("0-18-852663-6");

    File imgFile = new File("testbookland.png");

    //Write the bar code to PNG file
    BarcodeImageHandler.savePNG(barcode, imgFile);
  }

 
}
         // generate barcode to BufferedImage object


    

     
     
    
    
    
    