public class SmartRemote extends BasicRemote {
    protected boolean voiceControl = false;

    public SmartRemote(Device device) {
        super.device = device;
    }
    public boolean isVoiceControlOn() {
        return voiceControl;
    }

    public void voiceControl() {
        if (isVoiceControlOn()) {
            System.out.println("Remote: voice control off");
            voiceControl = false;
        }
        else {
            System.out.println("Remote: voice control on");
            voiceControl = true;
        }
    }

}
