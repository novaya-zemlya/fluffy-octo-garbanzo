public class AudioCronicCont {
    private boolean go;

    public AudioCronicCont(){
        go = true;
    }

    public void playMid1(){
        AudioCont.playSound("172561__djgriffin__video-game-7.wav");
    }

    public void playMid2(){
        AudioCont.playSound("806415__harrisonlace__synth_arp_escape_from_boston_dynamics_fmin_125.wav");
    }

    public void playEnd(){
        AudioCont.playSound("803432__logicmoon__under-the-sky.wav");
    }

    public void playAlarm(){
        AudioCont.playSound("33732__jobro__1-alarm-short-e.wav");
    }

    public void stop(){
        AudioCont.stopSound();
    }

    public void playMidGame() throws InterruptedException {
        while (go) {
            playMid1();
            Thread.sleep(142000);
            stop();
            playMid2();
            Thread.sleep(32000);
            stop();
        }
    }

    public void stopLoop(){
        go = false;
    }
}
