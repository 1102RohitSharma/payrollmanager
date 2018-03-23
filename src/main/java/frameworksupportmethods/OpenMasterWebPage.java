/*This function should be considered as a master source code to open each webpage in ERP
* It should take static value of Main menu Path (locators for global master, master setting and etc.)
* Webpage path should be the corresponding locators for webpage in ERP (the location should be module wise)
* Main Menu name should be the value of element in the MainMenu.properties file*/

package frameworksupportmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import webdriver.AppDriver;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class OpenMasterWebPage extends GenericBaseClass {


    public void openMasterWebPage (File WebPage_path, String mainmenu_name, String submenu_name, String webpage_name) throws IOException {

        /*Storing webpage and submenu name in a variable*/
        String sub_menu_name = readFile.readProperty ( WebPage_path, submenu_name );
        String web_page_name = readFile.readProperty ( WebPage_path, webpage_name );

        /*Open main menu*/
        event.click ( readFile.getElement ( mainMenuPath, mainmenu_name ) );

        /*Storing names of all webpages in a web element list*/
        List <WebElement> master_dd = AppDriver.getCurrentDriver ( ).findElements ( By.xpath ( "//ul//li/a" ) );

        /*Opening desired main menu by comparing each value in the list*/
        for ( int i = 0; i < master_dd.size ( ); i++ ) {
            WebElement mainmenudd_item = master_dd.get ( i );
            String innerHTML = mainmenudd_item.getAttribute ( "innerHTML" );
            if ( innerHTML.contentEquals ( sub_menu_name ) ) {
                mainmenudd_item.click ( );
                break;
            }
        }

        /*Opening desired web page by comparing each value in the list*/
        List <WebElement> submenu_dd = AppDriver.getCurrentDriver ( ).findElements ( By.xpath ( "//ul//li/a" ) );
        for ( int i = 0; i < submenu_dd.size ( ); i++ ) {
            WebElement submenudd_item = submenu_dd.get ( i );
            String session_inner_HTML = submenudd_item.getAttribute ( "innerHTML" );
            if ( session_inner_HTML.contentEquals ( web_page_name ) ) {
                submenudd_item.click ( );
                break;
            }
        }
    }
}

