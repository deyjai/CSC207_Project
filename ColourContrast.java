/* Colour  Contrast
 * By: Dunia
 * Last Modified: 12/06/2022
 * Depending on what button is clicked, brightness increases and decreases.
 */

import java.awt.event.*;

public class ColourContrast {

    //attributes
    public MasterView masterView; //stores a pointer to the MasterView
    public ColourContrastView colourContrastView; //stores a pointer to the colourContrastView

    //constructor - initializes all attributes to their default values
    public ColourContrast(ColourContrastView colourContrast, MasterView masterView)
    {
        this.colourContrastView = colourContrast;
        this.masterView = masterView;
    }//end constructor

    public void brightenLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i + 10);
            if (pixelValue > 255)
                pixelValue = 255;
            else if (pixelValue < 0)
                pixelValue = 0;
            brighten[i] = pixelValue;
        }
    }

    public void darkenLUT() {
        short brighten[] = new short[256];
        for (int i = 0; i < 256; i++) {
            short pixelValue = (short) (i - 10);
            if (pixelValue > 255)
                pixelValue = 255;
            else if (pixelValue < 0)
                pixelValue = 0;
            brighten[i] = pixelValue;
        }
    }

    //actionPerformed method - this is called when a button is pressed
    public void actionPerformed(ActionEvent e){

        //if Increase Brightness was pressed
        if(e.getActionCommand().equals("Increase Brightness")){
            //masterView.mainPanel.brightenLUT();
            //masterView.mainPanel.applyFilter();
            //masterView.mainPanel.repaint();
        }
        //if Decrease Brightness was pressed
        else if(e.getActionCommand().equals("Decrease Brightness"))
            //mainPanel.darkenLUT();
            //mainPanel.applyFilter();
            //mainPanel.repaint();
        {

        }//end if

    }
}


