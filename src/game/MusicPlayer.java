package game;

import java.applet.AudioClip;
import javax.swing.JApplet;

public class MusicPlayer {
	boolean playing;

	MusicPlayer() {
		playing = false;
	}

	public void playMusic(int skin, int state) {
		if (playing) {
			switch (skin) {
			case 0:
				switch (state) {
				case 0:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				case 1:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				case 2:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				}
				break;
			case 1:
				switch (state) {
				case 0:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				case 1:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				case 2:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				}
				break;
			case 2:
				switch (state) {
				case 0:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				case 1:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				case 2:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				}
				break;
			case 3:
				switch (state) {
				case 0:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				case 1:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				case 2:
					System.out.println("playing test song");
					playSound("testsong.wav");
					playing=true;
					break;
				}
				break;
			}
		}

	}

	private void playSound(String fileName) {
		AudioClip sound = JApplet.newAudioClip(getClass().getResource(fileName));
		sound.play();
	}
}
