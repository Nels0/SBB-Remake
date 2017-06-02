
class Block {
  float remainder;
  int iRemainder;
  color c;
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
  
  void updateBlock (){
    c = color(547,(-150*(remainder/score)+200),51);
    xDraw = xPos*(xBlockSize + 5) + 5;
    yDraw = yPos*(yBlockSize + 5) + 5;
    iRemainder = round(remainder);
    //debug stuff
    
    //println(xPos + yPos);
  };
  
  
  
  void drawBlock(){    

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
  
  void blockMove(){
    yPos ++;
  };
  
}