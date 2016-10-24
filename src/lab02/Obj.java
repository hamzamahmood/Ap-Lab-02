/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

/**
 *
 * @author Hamza
 * Obj class that can hold two arrays
 * Used to return two padded arrays with 2^n size from the padMat() function
 */
public class Obj {  
    private int[][] arr1; //array2
    private int[][] arr2; //array1
      
    public Obj(){
        this.arr1 = null;
        this.arr1 = null;
    }
    public Obj(int[][] x, int[][] y){
        this.arr1 = x;
        this.arr2 = y;
    }
    public int[][] getArr1(){
        return this.arr1;
    }
    public int[][] getArr2(){
        return this.arr2;
    }
}
