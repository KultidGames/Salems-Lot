package Game.gfx;
import java.applet.Applet;
import java.applet.AudioClip;

public class Sound {


		public static final Sound ForYou = new Sound("/Sound/For You - Jake Chudnow.ogg");
		private AudioClip clip;

		private Sound(String name) {
			try {
				clip = Applet.newAudioClip(Sound.class.getResource(name));
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		public void play() {
			try {
				new Thread() {
					public void run() {
						clip.play();
					}
				}.start();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
	}
