
#include <Servo.h>
Servo myservo;  // create servo object to control a servo
Servo myservo1;
int pos = 0;    // variable to store the servo position

//#define VCC2 3
//#define GND2 2


void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(LED_BUILTIN, OUTPUT);
  myservo.attach(9);  // attaches the servo on pin 9 to the servo object
  myservo1.attach(10);
  while (!Serial) {
    ; // wait for serial port to connect.
  }
   myservo.write(180); 
   myservo1.write(180);
 
}

void loop() {
  
  if (Serial.available() > 0) {    
    byte incomingByte = 0;
    incomingByte = Serial.read(); // read the incoming byte:
    if (incomingByte ==50) { // -1 means no data is available
       
      //digitalWrite(LED_BUILTIN, HIGH);
      myservo.write(0);
      delay(1000);
      myservo.write(180);
     // Serial.write(1);
     // digitalWrite(LED_BUILTIN, LOW);
    }
    if (incomingByte ==49)
    {
      myservo1.write(0);
      delay(1000);
      myservo1.write(180);
    }
    
  }
  digitalWrite(LED_BUILTIN, LOW);

}
