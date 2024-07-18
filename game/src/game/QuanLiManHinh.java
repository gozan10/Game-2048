/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author minht
 */
public class QuanLiManHinh { // quản lý khung
    public int mg = 2; //căn lề 
    public int withMH =600+3*mg; //chieu rong
    public int heightMH =600+3*mg;// chieu dai
    VeManHinh vMH;
    QuanLiData qlDT;
    public QuanLiManHinh(VeManHinh vMH,QuanLiData qlDT,JFrame frame)
    {
        this.vMH = vMH;
        this.vMH = new VeManHinh();
        this.qlDT = qlDT;
        this.qlDT = new QuanLiData();
        this.vMH.veCacNut(frame,withMH,heightMH, mg);
    }
    
    public void setUp(JFrame frame)
    {   
        frame.setSize(withMH+16+2*mg, heightMH+38+2*mg);
        //Khi ấn nút pause chương trình sẽ dừng
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Game.hex2Rgb("#000000"));
        
        frame.addKeyListener( new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                  qlDT.resetGame();
                }
                if (qlDT.gameOver()){
                    JOptionPane.showMessageDialog(frame, "Game over\nNhấn ESC để chơi lại");
                }
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        qlDT.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        qlDT.moveRight();
                        break;
                    case KeyEvent.VK_DOWN:
                        qlDT.moveDown();
                        break;
                    case KeyEvent.VK_UP:
                        qlDT.moveUp();
                        break;
                }
                
                //System.out.println(myScore);
                //kiem tra thua roi thong bao
                vMH.upDate();
                if (qlDT.gameOver() && !qlDT.win()){
                    JOptionPane.showMessageDialog(frame, "Game over\nNhấn ESC để chơi lại");
                }
                //kiem tra win
                if (qlDT.win()){
                    System.out.println("winner:");
                    JOptionPane.showMessageDialog(frame, "Win\n Nhấn ESC để chơi lại");
                }
                
            }
        });
        
    }
}
