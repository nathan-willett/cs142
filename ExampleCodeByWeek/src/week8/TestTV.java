// CS& 141, Winter 2024

package week8;

public class TestTV {  
  public static void main(String[] args) {
    TV tv1 = new TV(); // Create a TV
    tv1.turnOn(); // Turn on tv1
    tv1.setChannel(30);
    tv1.setVolume(3);
    
    TV tv2 = new TV();
    tv2.turnOn();
    tv2.channelUp();
    tv2.channelUp();
    tv2.volumeUp(); // Increase tv2 volume up 1 level
    
    System.out.println("tv1's channel is " + tv1.channel 
      + " and volume level is " + tv1.volumeLevel);
    System.out.println("tv2's channel is " + tv2.channel 
      + " and volume level is " + tv2.volumeLevel);
  }
}