import java.awt.*;
import java.util.Random;
class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
    Random rand = new Random();
    DrawingPanel panel = new DrawingPanel(650, 400);
    Graphics g = panel.getGraphics();
    g.setColor(Color.darkGray);
    g.fillRect(0,0,650,400);
    int x = 50;
    int y = 0;
    int size = 100;
    String value = "";
    String suite = "";
    for(int i = 1; i<=4; i++){
    drawCard(g, rand, value, x+i*100-150, y, suite, size);
    }
    
  }
  public static String getString(Random rand, String value){
    int upperbound = 12;
    int rng = rand.nextInt(upperbound);
    rng+=1;
    if(rng == 1){
      value = "A";
    }
    else if(rng == 11){
      value = "J";
    }
    else if(rng == 12){
      value = "Q";
    }
    else if(rng == 13){
      value = "K";
    }
    else{
      value = String.valueOf(rng);
    }
    return value;
  }

  public static String getSuite(Random rand, String suite){
    int upperbound = 3;
    int rng = rand.nextInt(upperbound);
    rng+=1;
    if(rng == 1){
      suite="\u2660";
    }
    else if (rng==2){
      suite="\u2663";
    }
    else if (rng==3){
      suite="\u2666";
    }
    else{
      suite="\u2665";
    }
    return suite;
  }
  /*
  public static void drawPattern(Graphics g, String value, int x, int y, String suite){
    if(value == "J" ||value == "Q" || value == "K"){
    
    }
    else if(value == "A"){
      g.drawString(suite, x+100, y+150);
    }
    else{
      for(int i=1;i<=Integer.parseInt(value);i++){
        
      }
    }
  }
  */
  public static void drawCard(Graphics g, Random rand, String value, int x, int y, String suite, int size){
    getString(rand, value);
    g.setColor(Color.WHITE);
    g.fillRect(x,y, size,size*3/2);
    value = getString(rand, value);
    suite = getSuite(rand, suite);
    if (suite=="\u2660"|| suite== "\u2663"){
      g.setColor(Color.BLACK);
    }
    else{
      g.setColor(Color.RED);
    }
    g.setFont(new Font("times", Font.PLAIN, size*1/5));
    g.drawString(value,x+size*1/20,y+size*1/5);
    g.drawString(suite,x+size*1/100, y+size*85/200);
    g.setFont(new Font("times", Font.PLAIN, size*-1/5));
    g.drawString(value,x+size*19/20, y+size*5/4);
    g.drawString(suite,x+size*19/20, y+size);
    g.setFont(new Font("times", Font.BOLD, size*7/10));
    g.drawString(suite, x+size*1/6, y+size);
  }
}
  