import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  // Image variables
  PImage imgBackground;
  PImage imgIcePlanet;

  // Variables to animate the ice planet
  float fltIceX = 300;
  float fltIceY;
  float fltIceXDir = 2;

  // Variables to animate an ellipse
  float fltCircX = 300;
  float fltCircY = 25;
  float fltCircXDir = 6;
  float fltCircYDir = 3;

  // Size of window
  public void settings() {
    size(600, 600);
  }

  // Setup values and image loading
  public void setup() {
    
    // Load and resize the space background
    imgBackground = loadImage("space.jpg");
    imgBackground.resize(imgBackground.width / 6, imgBackground.height/6);

    // Load and resize the ice planet
    imgIcePlanet = loadImage("planet07.png");
    imgIcePlanet.resize(imgIcePlanet.width / 8, imgIcePlanet.height / 8);
    
  }
  // Images drawn to the screen
  public void draw() {
    
    // Clear out old frames
    image(imgBackground, 0, 0);

    // Ellipse animation
    ellipse(fltCircX, fltCircY, 50, 50);

    // Move the ellipse
    fltCircX += fltCircXDir;
    fltCircY += fltCircYDir;

    // Change the x direction
    if (fltCircX > width - 25 || fltCircX < 25){
      fltCircXDir *= -1;
    }
    // Change the y direction
    if (fltCircY > height - 25 || fltCircY < 25){
      fltCircYDir *= -1;
    }
    
    // Ice planet animation
    // Move the planet
    fltIceX += fltIceXDir;
    fltIceY = 250 + (100 * sin((float)0.05 * fltIceX));

    // Draw the planet
    image(imgIcePlanet, fltIceX, fltIceY);
    
    // Change the x direction
    if (fltIceX > width - (imgIcePlanet.width) || fltIceX < 0){
      fltIceXDir *= -1;
  }
}
}