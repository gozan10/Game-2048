/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.Random;

/**
 *
 * @author minht
 */
public class QuanLiData {
    Random r = new Random();

    public QuanLiData() {
        taoSO();
        taoSO();
    }
    
    public void taoSO()
    {
        int oConTrong = checkOConTrong();
        if(oConTrong>=2)
        {
            oConTrong=1;
            
        }
        while(oConTrong!=0)
        {
            int x=r.nextInt(4);
            int y=r.nextInt(4);
            while(Data.getData().arr[x][y]!=0)
            {
                x=r.nextInt(4);
                y=r.nextInt(4);
            }
            if(r.nextInt(10)>8)
            {
                Data.getData().arr[x][y]=4;
            }
            else{
                Data.getData().arr[x][y]=2;
            }
            oConTrong--;
            
        }
        
    }
    public int checkOConTrong(){
        int oConTrong = 0;
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                if(Data.getData().arr[i][j]==0)
                {
                   oConTrong++;
                }
            }
        }
        return oConTrong;
    }
    public void moveLeft(){
        sumLeft();
        mergeLeft();
        taoSO();
    }
    public void moveRight(){ 
        sumRight();
        mergeRight();
        taoSO();
    }
    public void moveUp(){
        sumTop();
        mergeTop();
        taoSO();
    }
    public void moveDown(){
        sumDown();
        mergeDown();
        taoSO();
    }
    
    public void resetGame() {
        for(int r=0; r<4; r++)
        {
            for(int c=0; c<4; c++)
            {
                Data.getData().arr[r][c] = 0;
            }
        }
        taoSO();
        taoSO();
    }
    public boolean gameOver(){
        if (checkOConTrong()==0){
            for (int x = 0; x < 4; x++) 
            {
                for (int y = 0; y < 4; y++) 
                {
                    int t = Data.getData().arr[x][y];
                    // để kiểm tra 2 ô cạnh nhau có giá trị bằng nhau hay ko (hàng ngang hoặc hàng dọc)
                    if ((x < 3 && t == Data.getData().arr[x+1][y]) || ((y < 3) && t == Data.getData().arr[x][y+1]))
                    {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    public boolean win(){
        for (int x=0; x<4; x++){
            for (int y=0; y<4; y++){
                if(Data.getData().arr[x][y] == 2048){
                    return true;
                }
            }
        }
        return false;
    }
    public void sumLeft(){
        for(int r=0; r<4; r++)
        {
            for(int c=0; c<3; c++)
            {
                if (Data.getData().arr[r][c]!=0)
                {
                    for(int c1=c+1; c1<4; c1++)
                    {
                        if (Data.getData().arr[r][c1]!=0)
                        {
                            if (Data.getData().arr[r][c] == Data.getData().arr[r][c1])
                            {
                                Data.getData().arr[r][c] *= 2;
                                Data.getData().arr[r][c1] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public void mergeLeft(){
        for(int r=0; r<4; r++)
        {
            for(int c=0; c<3; c++)
            {
                if (Data.getData().arr[r][c]==0)
                {
                    for(int c1=c+1; c1<4; c1++)
                    {
                        if (Data.getData().arr[r][c1]!=0)
                        {
                            Data.getData().arr[r][c] = Data.getData().arr[r][c1];
                            Data.getData().arr[r][c1] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void sumRight(){
        for(int r=0; r<4; r++)
        {
            for(int c=3; c>=1; c--)
            {
                if (Data.getData().arr[r][c]!=0)
                {
                    for(int c1=c-1; c1>=0; c1--)
                    {
                        if (Data.getData().arr[r][c1]!=0)
                        {
                            if (Data.getData().arr[r][c] == Data.getData().arr[r][c1])
                            {
                                Data.getData().arr[r][c] *= 2;
                                Data.getData().arr[r][c1] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public void mergeRight(){
        for(int r=0; r<4; r++)
        {
            for(int c=3; c>=1; c--)
            {
                if (Data.getData().arr[r][c]==0)
                {
                    for(int c1=c-1; c1>=0; c1--)
                    {
                        if (Data.getData().arr[r][c1]!=0)
                        {
                            Data.getData().arr[r][c] = Data.getData().arr[r][c1];
                            Data.getData().arr[r][c1] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void sumTop(){
        for(int c=0; c<4; c++)
        {
            for(int r=0; r<3; r++)
            {
                if (Data.getData().arr[r][c]!=0)
                {
                    for(int r1=r+1; r1<4; r1++)
                    {
                        if (Data.getData().arr[r1][c]!=0)
                        {
                            if (Data.getData().arr[r][c] == Data.getData().arr[r1][c])
                            {
                                Data.getData().arr[r][c] *= 2;
                                Data.getData().arr[r1][c] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public void mergeTop(){
        for(int c=0; c<4; c++)
        {
            for(int r=0; r<3; r++)
            {
                if (Data.getData().arr[r][c]==0)
                {
                    for(int r1=r+1; r1<4; r1++)
                    {
                        if (Data.getData().arr[r1][c]!=0)
                        {
                            Data.getData().arr[r][c] = Data.getData().arr[r1][c];
                            Data.getData().arr[r1][c] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void sumDown(){
        for(int c=0; c<4; c++)
        {
            for(int r=3; r>=1; r--)
            {
                if (Data.getData().arr[r][c]!=0)
                {
                    for(int r1=r-1; r1>=0; r1--)
                    {
                        if (Data.getData().arr[r1][c]!=0)
                        {
                            if (Data.getData().arr[r][c] == Data.getData().arr[r1][c])
                            {
                                Data.getData().arr[r][c] *= 2;
                                Data.getData().arr[r1][c] = 0;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
    public void mergeDown(){
        for(int c=0; c<4; c++)
        {
            for(int r=3; r>=1; r--)
            {
                if (Data.getData().arr[r][c]==0)
                {
                    for(int r1=r-1; r1>=0; r1--)
                    {
                        if (Data.getData().arr[r1][c]!=0)
                        {
                            Data.getData().arr[r][c] = Data.getData().arr[r1][c];
                            Data.getData().arr[r1][c] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }
    
}
