/* MusicAudio
 * By: Dunia
 * Last Modified: 12/05/2022
 * Description: This class allows for users to turn on/off music, as well as change the volume to whatever
 * level they desire.
 */

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class MusicAudio {
    //attributes
    private AudioView audioView; //holds a pointer to the Audio GUI, AudioView
    private MasterView masterView; //holds a pointer to the MasterView

    //getting audio to work
    Clip clip;
    float originalMusicVolume = 0;
    float currentMusicVolume = 0;
    FloatControl floatControl;
    boolean noMusic = false;
    //String standardMusic = "Audio\\StandardMelody.mp3";
    //String marioMusic = "Audio\\Super_Mario_Bros_Medley.mp3";

    //method to set the music files
    public void setMusicFiles(String standardMusic){
        try{
            AudioInputStream standardMusicFile = AudioSystem.getAudioInputStream(new File(standardMusic).getAbsoluteFile());
            AudioFormat format = standardMusicFile.getFormat();
            clip = AudioSystem.getClip();
            clip.open(standardMusicFile);
            floatControl = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
        }
        catch(Exception e){
        }
    }

    //method to play the music
    public void playMusic(){
        clip.setFramePosition(0);
        clip.start();
    }

    //method to loop the music
    public void loopMusic(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    //call this method to stop music
    public void stopMusicFiles(){
        clip.stop();
    }

    //method for increasing music volume
    public void increaseMusicVolume(){
        currentMusicVolume += 1.0f;
        //the max num that float control accepts is 6, it returns an error otherwise
        if (currentMusicVolume> 6.0f){
            currentMusicVolume = 6.0f;
        }
        floatControl.setValue(currentMusicVolume);
    }

    //method for decreasing music volume
    public void decreaseMusicVolume(){
        currentMusicVolume -= 1.0f;
        //the min num that float control accepts is -80, it returns an error otherwise
        if(currentMusicVolume<-80.0f){
            currentMusicVolume = -80.0f;
        }
        floatControl.setValue(currentMusicVolume);
    }

    }

