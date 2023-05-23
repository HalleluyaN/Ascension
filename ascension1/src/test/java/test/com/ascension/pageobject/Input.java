/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test.com.ascension.pageobject;

/**
 *
 * @author halleluyamengesha
 */
public class Input {
    private int zipCode;

    @Override
    public String toString() {
        return "Input{" + "zipCode=" + zipCode + '}';
    }

    public Input(int zipCode) {
        this.zipCode = zipCode;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    
    
}
