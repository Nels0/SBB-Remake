ArrayList <Block> blocks = new ArrayList <Block> ();
int score = 0;
int balls = 1;
int xcBlocks = 6;
int ycBlocks = 10;
int xSize, ySize;

void setup() {
  size(600,800);
  xSize = width;
  ySize = height;
  textSize(20);
  newround();

}

void draw(){
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

void newround(){
  
  for(int i = 0; i < xcBlocks; i++){
    float chance = random(1);
      if (chance > 0.55){
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


void gameover(){
  exit();
};