package pageObjects.saucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.saucelab.InventoryPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryPageObject extends BasePage {
    public InventoryPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSortDropDown(String valueItem){
        waitForElementClickable(driver, InventoryPageUI.SORT_DROPDOWN);
        selectItemInDefaultDropdown(driver, InventoryPageUI.SORT_DROPDOWN, valueItem);
    }

    public boolean isProductNameSortAscending(){
        waitForAllElementVisible(driver, InventoryPageUI.PRODUCT_NAME);

        List<WebElement> productName = getListElement(driver, InventoryPageUI.PRODUCT_NAME);

        List<String> productNameTextUI = new ArrayList<String>();

        for (WebElement product: productName){
            productNameTextUI.add(product.getText());
        }

        System.out.println("------Product name at UI------");
        for(String name: productNameTextUI){
            System.out.println(name);
        }

        List<String>  productNameTextSort = new ArrayList<String>(productNameTextUI);

        //Sort by Collection
        Collections.sort(productNameTextSort);
        System.out.println("------Product name after Sorting------");
        for(String name: productNameTextSort){
            System.out.println(name);
        }
        return productNameTextSort.equals(productNameTextUI);

    }

    public boolean isProductNameSortDescending(){
        waitForAllElementVisible(driver, InventoryPageUI.PRODUCT_NAME);

        List<WebElement> productName = getListElement(driver, InventoryPageUI.PRODUCT_NAME);

        List<String> productNameTextUI = new ArrayList<String>();

        for (WebElement product: productName){
            productNameTextUI.add(product.getText());
        }

        System.out.println("------Product name at UI------");
        for(String name: productNameTextUI){
            System.out.println(name);
        }

        List<String>  productNameTextSort = new ArrayList<String>(productNameTextUI);

        //Sort by Collection
        Collections.sort(productNameTextSort);
        //Reverse data
        Collections.reverse(productNameTextSort);

        System.out.println("------Product name after Sorting------");
        for(String name: productNameTextSort){
            System.out.println(name);
        }
        return productNameTextSort.equals(productNameTextUI);
    }

    public boolean isProductPriceSortAscending(){
        waitForAllElementVisible(driver, InventoryPageUI.PRODUCT_PRICE);

        List<WebElement> productPrice = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);

        List<Float> productPriceTextUI = new ArrayList<Float>();

        for (WebElement product: productPrice){
            productPriceTextUI.add(Float.valueOf(product.getText().replace("$","")));
        }
            System.out.println("------Product name at UI------");
            for(Float name: productPriceTextUI) {
                System.out.println(name);
            }

            List<Float> productPriceTextSort = new ArrayList<Float>(productPriceTextUI);

            //Sort
            Collections.sort(productPriceTextSort);

            System.out.println("------Product price after Sorting------");
            for(Float name: productPriceTextSort){
                System.out.println(name);
            }
            return productPriceTextSort.equals(productPriceTextUI);
    }

    public boolean isProductPriceSortDescending() {
        waitForAllElementVisible(driver, InventoryPageUI.PRODUCT_PRICE);

        List<WebElement> productPrice = getListElement(driver, InventoryPageUI.PRODUCT_PRICE);

        List<Float> productPriceTextUI = new ArrayList<Float>();

        for (WebElement product : productPrice) {
            productPriceTextUI.add(Float.valueOf(product.getText().replace("$", "")));
            }
        System.out.println("------Product name at UI------");
        for (Float name : productPriceTextUI) {
            System.out.println(name);
        }

            List<Float> productPriceTextSort = new ArrayList<Float>(productPriceTextUI);

            //Sort
            Collections.sort(productPriceTextSort);
            //Reverse data
            Collections.reverse(productPriceTextSort);

            System.out.println("------Product price after Sorting DESC------");
            for (Float name : productPriceTextSort) {
                System.out.println(name);
            }
            return productPriceTextSort.equals(productPriceTextUI);
    }

    WebDriver driver;

}
