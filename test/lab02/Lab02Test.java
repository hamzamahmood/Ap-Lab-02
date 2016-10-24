/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab02;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hamza
 */
public class Lab02Test {
    
    public Lab02Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    //Testing Strassen's Algoritm on 2x3 x 3x1
    @Test
    public void testMultiplyMatStras1() {
        System.out.println("multiplyMatStras Solution Test 2x3 x 3x1");
        int[][] x = new int[2][3];
        int[][] y = new int[3][1];
        Lab02.randPop(x,2,3);
        Lab02.randPop(y,3,1);
        Obj obj = new Obj();
        obj = Lab02.padMat(x, y);
        x = obj.getArr1();
        y = obj.getArr2();
        //System.out.println(Arrays.deepToString(x));
        //System.out.println(Arrays.deepToString(y));
        int len = x.length;
        int[][] expResult = Lab02.itrMatrixMult(x,y);
        int[][] result = Lab02.multiply(x, y);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    //Testing Strassen's Algoritm on 50x50 x 50x50
    @Test
    public void testMultiplyMatStras2() {
        System.out.println("multiplyMatStras Solution Test 50x50 x 50x50");
        int[][] x = new int[50][50];
        int[][] y = new int[50][50];
        Lab02.randPop(x,50,50);
        Lab02.randPop(y,50,50);
        Obj obj = new Obj();
        obj = Lab02.padMat(x, y);
        x = obj.getArr1();
        y = obj.getArr2();
        //System.out.println(Arrays.deepToString(x));
        //System.out.println(Arrays.deepToString(y));
        int len = x.length;
        int[][] expResult = Lab02.itrMatrixMult(x,y);
        int[][] result = Lab02.multiply(x, y);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    //Testing Strassen's Algoritm on 100x3 x 100x100
    @Test
    public void testMultiplyMatStras3() {
        System.out.println("multiplyMatStras Solution Test 100x3 x 100x100");
        int[][] x = new int[100][3];
        int[][] y = new int[100][100];
        Lab02.randPop(x,100,3);
        Lab02.randPop(y,100,100);
        Obj obj = new Obj();
        obj = Lab02.padMat(x, y);
        x = obj.getArr1();
        y = obj.getArr2();
        //System.out.println(Arrays.deepToString(x));
        //System.out.println(Arrays.deepToString(y));
        int len = x.length;
        int[][] expResult = Lab02.itrMatrixMult(x,y);
        int[][] result = Lab02.multiply(x, y);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    //Testing Strassen's Algoritm on 100x3 x 100x100
    @Test
    public void testMultiplyMatStras4() {
        System.out.println("multiplyMatStras Solution Test 1000x1000 x 1000x1000");
        int[][] x = new int[1000][1000];
        int[][] y = new int[1000][1000];
        Lab02.randPop(x,1000,1000);
        Lab02.randPop(y,1000,1000);
        Obj obj = new Obj();
        obj = Lab02.padMat(x, y);
        x = obj.getArr1();
        y = obj.getArr2();
        //System.out.println(Arrays.deepToString(x));
        //System.out.println(Arrays.deepToString(y));
        int len = x.length;
        int[][] expResult = Lab02.itrMatrixMult(x,y);
        int[][] result = Lab02.multiply(x, y);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    //Testing ItrMatrixMult Solution
    @Test
    public void testItrMatrixMult() {
        System.out.println("itrMatrixMult Solution Test");
        int[][] x = {{2,4},{6,7}};
        int[][] y = {{3,1},{4,2}};
        int[][] expResult = {{22,10},{46,20}};
        int[][] result = Lab02.itrMatrixMult(x, y);
        assertArrayEquals(expResult, result);
    }
    
    //Testing testItrMatrixMult Output Dimension
    @Test
    public void testItrMatrixMultDimension(){
        System.out.println("itrMatrixMult Output Dimension Test");
        int[][] x = {{1,2,4},{4,5,6}};
        int[][] y = {{1,2,3},{4,5,6},{7,8,8}};
        int[][] result = Lab02.itrMatrixMult(x, y);
        assertEquals(result.length,2);
        assertEquals(result[0].length,3);
    }
    
    //Tesing testItrMatrixMult input test
    @Test(expected=IllegalArgumentException.class)
    public void testItrMatrixMultException(){
        System.out.println("itrMatrixMult input Exception Text");
        int[][] x = {{1,2},{1,2}};
        int[][] y = {{1,2,3},{4,5,6},{7,8,8}};
        int[][] result = Lab02.itrMatrixMult(x, y);
    }
    
}
