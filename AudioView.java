/* AudioView
 * By: Dunia
 * Last Modified: 12/04/2022
 * Description: This class displays the interface for the Audio of this application. It shows the options to turn off and on music, as well as sound effects
 * (ex broadcasting game movements) to better support immersion.
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

/*
This will be your GUI. If you're making a model class, DO NOT mix it with this class. You'll need to create a separate
model class, and this class will hold a pointer, so you can access it.

For now, you should make your appropriate set/get methods and assume these methods will give you the info you need.
Again, PLEASE don't make multiple attributes for your kinematics parameters if you're using them.
    - If you're doing the DataModel class, there should be one private ArrayList <double[]> attribute that holds the
    history of all kinematics parameters. You only need one set method (with a parameter for each kinematics value) and
    one get method for this.
    - If any other class needs kinematics parameters, it should have an attribute that points to the DataModel class.
    You can get everything you need using one of the DataModel's get methods.
    - If you need to directly access one of the components in MasterView (this will likely only be for the Audio/AIHelper
    class), you should make an attribute that points to MasterView.

* As for controllers, you can pretend they don't exist for now. Just make an input component (ex. JButton) and a method
that you want to be executed when that button is called.
*/
public class AudioView extends JFrame
{
    public static void open()
    {
        //basics
        AudioView frame = new AudioView();

        //initialize and add the audio panel
        JPanel audioPanel = new JPanel(); //BoxLayout can not be shared (meaning not allowed to be an attribute) so the JPanel has to be made here
        audioPanel.setLayout(new BoxLayout(audioPanel, BoxLayout.Y_AXIS));
        frame.setContentPane(audioPanel);

        //initialize objects for the audio panel - holds text fields and sliders
        JPanel music = new JPanel();
        JPanel soundEffects = new JPanel();

        //changes from last week - exit to dispose, so the entire program doesn't terminate, only the particular window.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

        //some extra features
        frame.setTitle("Audio Settings");
        frame.setLocation(0,0);
        frame.setSize(new Dimension(500, 200));

        //labels - prompts for input (music/sound effects volume)
        JLabel musicVolume = new JLabel("               Music Volume:");
        JLabel soundEffectsVolume = new JLabel("Sound Effects Volume:");

        //slider - input (music volume)
        JSlider changeMusicVolume = new JSlider(0, 100, 0);
        changeMusicVolume.setMinorTickSpacing(5);
        changeMusicVolume.setMajorTickSpacing(10);
        changeMusicVolume.setPaintTicks(true);
        changeMusicVolume.setPaintLabels(true);
        changeMusicVolume.setSnapToTicks(true);
        Dimension d = changeMusicVolume.getPreferredSize();
        changeMusicVolume.setPreferredSize(new Dimension(d.width+100,d.height));

        //slider - input (sound effects volume)
        JSlider changeSoundEffectsVolume = new JSlider(0, 100, 0);
        changeSoundEffectsVolume.setMinorTickSpacing(5);
        changeSoundEffectsVolume.setMajorTickSpacing(10);
        changeSoundEffectsVolume.setPaintTicks(true);
        changeSoundEffectsVolume.setPaintLabels(true);
        changeSoundEffectsVolume.setSnapToTicks(true);
        Dimension d2 = changeSoundEffectsVolume.getPreferredSize();
        changeSoundEffectsVolume.setPreferredSize(new Dimension(d2.width+100,d2.height));

        //creating label where the noMusicImgIcon image will be stored
        JLabel noMusicIcon = new JLabel();
        //resizing the noMusicImgIcon image to another image that's the size of the JLabel
        ImageIcon noMusicImgIcon = new ImageIcon(new ImageIcon("C:\\Users\\dunia\\OneDrive\\Documents\\University\\Course Work\\University Year 4\\Fall Semester\\CSC207\\CSC207_Project\\images\\no_music_icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        //creating an ImageIcon from the resized ImageIcon above
        noMusicIcon.setIcon(noMusicImgIcon);

        //creating label where the noSoundEffectsImgIcon image will be stored
        JLabel noSoundEffectsIcon = new JLabel();
        //resizing the noSoundEffectsImgIcon image to another image that's the size of the JLabel
        ImageIcon noSoundEffectsImgIcon = new ImageIcon(new ImageIcon("C:\\Users\\dunia\\OneDrive\\Documents\\University\\Course Work\\University Year 4\\Fall Semester\\CSC207\\CSC207_Project\\images\\no_sound_effects_icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        //creating an ImageIcon from the resized ImageIcon above
        noSoundEffectsIcon.setIcon(noSoundEffectsImgIcon);

        //add all inputs to their input objects
        music.add(musicVolume);
        music.add(noMusicIcon);
        music.add(changeMusicVolume);
        soundEffects.add(soundEffectsVolume);
        soundEffects.add(noSoundEffectsIcon);
        soundEffects.add(changeSoundEffectsVolume);

        //add all input objects to the first input panel
        audioPanel.add(music);
        audioPanel.add(soundEffects);

    }
}
