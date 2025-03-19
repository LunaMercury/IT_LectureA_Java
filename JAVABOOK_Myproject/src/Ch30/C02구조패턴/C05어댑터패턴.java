package Ch30.C02구조패턴;
//어댑터 패턴 (Adapter Pattern):
//이 패턴은 호환되지 않는 인터페이스를 가진 클래스들을 함께 동작하도록 만드는 패턴입니다. 
//어댑터 클래스를 사용하여 서로 다른 인터페이스를 가진 클래스들이 함께 작동할 수 있도록 중개 역할을 
//수행합니다.

/* 어댑터 패턴의 실제 활용 예시:
 * 
 * 1. 외부 라이브러리 통합
 *    - 서드파티 결제 시스템을 자사 시스템에 통합할 때 (예: PG사 결제모듈 연동)
 *    - 다양한 소셜 로그인 API를 통합할 때 (카카오, 네이버, 구글 로그인 등)
 * 
 * 2. 레거시 시스템 연동
 *    - 기존 레거시 코드를 새로운 시스템에 통합할 때
 *    - 기존 데이터베이스 시스템을 새로운 ORM으로 마이그레이션할 때
 * 
 * 3. 인터페이스 호환성
 *    - List, Set 등 서로 다른 컬렉션 타입을 변환할 때
 *    - XML을 JSON으로 변환하는 등 데이터 포맷 변환 시
 * 
 * 4. 하드웨어 드라이버
 *    - 프린터, 스캐너 등 다양한 하드웨어 드라이버를 통합할 때
 *    - 다양한 센서 데이터를 표준화된 형식으로 변환할 때
 */







interface MediaPlayer {
    void play(String audioType, String fileName);
}

interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // Do nothing
    }
}

class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        // Do nothing
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file: " + fileName);
    }
}

//미디어 어댑터 클래스 
class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer advancedMediaPlayer;

    //오디오타입에 따라서 Player를 다르게 생성 
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    //오디오 타입에 따라서 해당 플레이어를 실행 
    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("vlc")) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (audioType.equalsIgnoreCase("mp4")) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
//오디오 플레이어에 미디어 어탭터를 속성으로 넣어둠
//미디어 플레이어 Inteface를 상속함 -> Play Method 사용가능 -> Overriding 처리
//
class AudioPlayer implements MediaPlayer {
    private MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file: " + fileName);
        } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        } else {
            System.out.println("Invalid media. " + audioType + " format not supported");
        }
    }
}

public class C05어댑터패턴 {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "song.mp3");
        audioPlayer.play("mp4", "movie.mp4");
        audioPlayer.play("vlc", "music.vlc");
        audioPlayer.play("avi", "video.avi");
    }
}
