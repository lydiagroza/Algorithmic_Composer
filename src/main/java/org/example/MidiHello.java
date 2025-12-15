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

            int[] majorScale = {60, 62, 64, 65, 67, 69, 71, 72};


           System.out.println("Starting loop...");

           for(int i = 0; i < 20; i++){

               int randomIndex = random.nextInt(majorScale.length);

               int note =  majorScale[randomIndex];

               System.out.println("Playing note: " + note);

               instrument.noteOn(note, 90);

               Thread.sleep(500);

               instrument.noteOff(note);
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


