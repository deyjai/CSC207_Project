/* WebPage
 * By: Jai Dey
 * Last Modified: 11/15/2022
 * Used for static methods that allow to open a webpage */

import java.net.*;
import java.awt.Desktop;

public class WebPage
{
     /**** Static methods ****/
     
     //opens webpage based on a URI. Returns a boolean if the webpage was opened or not.
     public static boolean openWebpage(URI uri)
     {
          //temp variable
          Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null; //initialize the desktop
          
          if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) 
          {
               try 
               {
                    desktop.browse(uri);
                    return true;
               } 
               catch (Exception e) 
               {
                    e.printStackTrace();
               }//end try catch
          }//end if
          return false;
     }//end openWebpage
     
     //opens webpage based on a URL. Returns a boolean if the webpage was opened or not.
     public static boolean openWebpage(URL url) 
     {
          try 
          {
               return openWebpage(url.toURI());
          }
          catch (URISyntaxException e) 
          {
               e.printStackTrace();
          }//end try catch
          
          return false;
     }//end openWebpage
     
}//end of class - WebPage