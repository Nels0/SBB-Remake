import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sbb_1 extends PApplet {

ArrayList <Block> blocks = new ArrayList <Block> ();
int score = 0;
int balls = 1;
int xcBlocks = 6;
int ycBlocks = 10;
int xSize, ySize;

public void setup() {
  
  xSize = width;
  ySize = height;
  textSize(20);
  newround();

}

public void draw(){
  background(255);

  for (Block b: blocks){
    b.updateBlock();
    //println("Drew block " + b + " at xPos " + b.xPos + " and yPos " + b.yPos);
    b.drawBlock();
  };
  
  
  
  //draw score
  stroke(55);
  textAlign(LEFT, TOP);
  text("Score: " + score, 5,5);
  
  
  //Debug stuff
  if (upPressed){
  };
  

}

public void newround(){
  
  for(int i = 0; i < xcBlocks; i++){
    float chance = random(1);
      if (chance > 0.55f){
        blocks.add(new Block(i,0,score + 1));
        println("New block made, score = "+ score + ", position = " + i);
      };
  };
  for (Block b: blocks){
    b.blockMove();
    if( b.yPos >= ycBlocks){
      gameover();
    };
  };
  
  score++;
  println("new round");
}


public void gameover(){
  exit();
};

class Block {
  float remainder;
  int iRemainder;
  int c;
  int xPos;
  int yPos;
  int xBlockSize = ((xSize - 15 - xcBlocks * 5)/xcBlocks);
  int yBlockSize = 60;
  float xDraw;
  float yDraw;
  
  
  Block(int xPosB, int yPosB, int counterB){
    xPos = xPosB;
    yPos = yPosB;
    remainder = counterB;
    
  }
  
  public void updateBlock (){
    c = color(547,(-150*(remainder/score)+200),51);
    xDraw = xPos*(xBlockSize + 5) + 5;
    yDraw = yPos*(yBlockSize + 5) + 5;
    iRemainder = round(remainder);
    //debug stuff
    
    //println(xPos + yPos);
  };
  
  
  
  public void drawBlock(){    

    stroke(c);
    fill(c);
    rect(xDraw, yDraw, xBlockSize, yBlockSize);
    
    textSize(20);
    stroke(55);
    fill(55);
    textAlign(CENTER,CENTER);
    text(iRemainder,xDraw+(xBlockSize/2), yDraw+(yBlockSize/2));
    
/*
    textSize(10);
    text("Colour: " + (-150*(remainder/score)+200),xDraw+(xBlockSize/2),yDraw+(yBlockSize/2) - 20 );
    text("Fr:" + (remainder/score),xDraw+(xBlockSize/2),yDraw+(yBlockSize/2)+20);
*/
  }
  
  public void blockMove(){
    yPos ++;
  };
  
}

boolean upPressed = false;
boolean downPressed = false;
boolean leftPressed = false;
boolean rightPressed = false;

public void keyPressed() {
  if (key == CODED) {
    if (keyCode == UP) {
      upPressed = true;
      newround();
    }
    else if (keyCode == DOWN) {
      downPressed = true;
    }
    else if (keyCode == LEFT) {
      leftPressed = true;
    }
    else if (keyCode == RIGHT) {
      rightPressed = true;
    }
    if (keyCode == ENTER){
      
    }
  }
}

public void keyReleased() {
  if (key == CODED) {
    if (keyCode == UP) {
      upPressed = false;
    }
    else if (keyCode == DOWN) {
      downPressed = false;
    }
    else if (keyCode == LEFT) {
      leftPressed = false;
    }
    else if (keyCode == RIGHT) {
      rightPressed = false;
    }
  }
}

  public void settings() {  size(600,800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sbb_1" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
