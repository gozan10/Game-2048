/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author minht
 */
public class Game {
    
    JFrame game; // tạo khung
    QuanLiManHinh qlMH; 
    VeManHinh vMH;
    QuanLiData qlDT;
    
    private void init()
    {
        game = new JFrame();
        qlMH = new QuanLiManHinh(vMH,qlDT,game);
    }
    
    
    
    public Game() {
        init();
        setUp();
        
    }
    
    
    public void setUp()
    {
        qlMH.setUp(game);
    }
    public void runGame()
    {
        game.setVisible(true); // để hiển thị màn hình trò chơi
    }
    public static Color hex2Rgb(String colorStr)//biến đổi các mã hex thành các màu
    {
        return new Color(
            Integer.valueOf(colorStr.substring(1,3),16),
            Integer.valueOf(colorStr.substring(3,5),16),
            Integer.valueOf(colorStr.substring(5,7),16)      
        );     
    }
    public static void main(String[] args) {
        Game gm = new Game();
        gm.runGame();
    }
    
}
