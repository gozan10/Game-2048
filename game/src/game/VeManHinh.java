/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author minht
 */
public class VeManHinh {// vẽ chi tiết các ô
    JLabel arrlb[][] = new JLabel[4][4]; //tạo mảng 2 chiều 4x4
    public void veCacNut(JFrame frame, int W, int H, int M)
    {
        int w = (W-3*M)/4; //kích thước ngang chia đều 4 ô
        int h = (H-3*M)/4;// kích thước dọc chia đều 4 ô
        int x=0,y=0;
        for(int i=0;i<4;i++)
        {
            y=i*h +(1+i)*M;
            for(int j=0;j<4;j++)
            {
                x=j*h+(j+1)*M;
                arrlb[i][j]= taoO(x,y,w,h,i,j); 
                frame.add(arrlb[i][j]);
            }
        }
        frame.add(new JLabel()); 
    }
    private JLabel taoO(int x, int y, int w, int h, int i, int j)
    {
        JLabel l = new JLabel("5");
        l.setBounds(x,y,w,h);
        setBG(l,i,j);
        l.setOpaque(true);
        return l;
         
    }
    private void setBG(JLabel l, int i, int j)
    {
        int d = Data.getData().arr[i][j];
        String color ="";
        switch(d)
        {
            case 2:
                color ="eee4da";
                break;
            case 4:
                color ="ede0c8";
                break;
            case 8:
                color ="f2b179";
                break;
            case 16:
                color ="f59563";
                break;
            case 32:
                color ="f67c5f";
                break;
            case 64:
                color ="f65e3b";
                break;
            case 128:
                color ="edcf72";
                break;
            case 256:
                color ="edcc61";
                break;
            case 512:
                color ="edc850";
                break;
            case 1024:
                color ="edc53f";
                break;
            case 2048:
                color ="edc22e";
                break;
            default:
                color="373737";
                break;
        }
        if(d==0)
        {
            l.setText("");
        }else{
            l.setText(""+d);
        }
        l.setFont(new Font("Sefif",Font.BOLD,26));
        l.setForeground(Color.WHITE);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);  
        l.setBackground(Game.hex2Rgb("#"+color));
        
        
    }
    
    public void upDate(){
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                setBG(arrlb[i][j], i, j);
            }
        }
    }
    
}
