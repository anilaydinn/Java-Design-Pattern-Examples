
public class AdapterPatternDemo {

	public static void main(String[] args) {
		
		AudioPlayer audioPlayer = new AudioPlayer();

	      audioPlayer.play("mp3", "beyond the horizon.mp3");
	      audioPlayer.play("mp4", "alone.mp4");
	      audioPlayer.play("vlc", "far far away.vlc");
	      audioPlayer.play("avi", "mind me.avi");
	}
}

interface MediaPlayer{
	
	void play(String audioType, String fileName);
}

class MediaAdapter implements MediaPlayer{

	private AdvancedMediaPlayer advancedMediaPlayer;
	
	public MediaAdapter(String audioType) {
		
		if(audioType.equalsIgnoreCase("vlc")) {
			
			advancedMediaPlayer = new VlcPlayer();
		}
		else if(audioType.equalsIgnoreCase("mp4")) {
			
			advancedMediaPlayer = new Mp4Player();
		}
	}
	
	@Override
	public void play(String audioType, String fileName) {
		
		if(audioType.equalsIgnoreCase("vlc")) {
			
			advancedMediaPlayer.playVlc(fileName);
		}
		else if(audioType.equalsIgnoreCase("mp4")) {
			
			advancedMediaPlayer.playMp4(fileName);
		}
	}
}

class AudioPlayer implements MediaPlayer{
	
	private MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		
		if(audioType.equalsIgnoreCase("mp3")) {
			
			System.out.println("Playing mp3 file. Name: " + fileName);
		}
		else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
			
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}
		else {
			
			System.out.println("Invalid media. " + audioType + " format not supported");
		}
	}
}

interface AdvancedMediaPlayer{
	
	void playVlc(String fileName);
	void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		
		System.out.println("Playing vlc file. Name: " + fileName);
	}

	@Override
	public void playMp4(String fileName) {
		
		//do nothing
	}
}

class Mp4Player implements AdvancedMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		
		//do nothing
	}

	@Override
	public void playMp4(String fileName) {
	
		System.out.println("Playing Mp4 file. Name: " + fileName);
	}
}
