package org.example;

import javax.sound.midi.*;
import java.util.Random;


public class MidiHello {

    public static void main(String[] args) {

        try {
            Synthesizer synth = MidiSystem.getSynthesizer();

            Random random = new Random();

            synth.open();

            MidiChannel[] channel = synth.getChannels();
            MidiChannel instrument = channel[0];

            instrument.programChange(50);// trumpet for now

            int[] majorScale = {
                    60, 60, 60, // Root
                    62,
                    64, 64,     // Third
                    65,
                    67, 67,     // Fifth
                    69,
                    71,
                    72
            };

            int[] rythms = {
                    250, 250, 250, 500, 500, 1000
            };


           System.out.println("Starting loop...");

           for(int i = 0; i < 20; i++){

               int randomIndex = random.nextInt(majorScale.length);
               int note =  majorScale[randomIndex];

               int rythmIndex = random.nextInt(rythms.length);
                int rythm = rythms[rythmIndex];

               System.out.println("Playing note: " + note);


               instrument.noteOn(note, 90);

               Thread.sleep((int)(rythm * 0.9));

               instrument.noteOff(note);

               Thread.sleep((int)(rythm * 0.1));
           }

            System.out.println("Done loop");
            synth.close();

        } catch (MidiUnavailableException e){
            System.out.println("Audio device is not available" + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Sleep interupted" + e.getMessage());
        }
    }
}


