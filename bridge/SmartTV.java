public class SmartTV extends Tv {
    private boolean browsing = false;
    private String url;

    public boolean isBrowsing() {
        return browsing;
    }

    public String getUrl() {
        return url;
    }

    public void browseInternet(String url) {
        if (isEnabled()) {
            browsing = true;
            this.url = url;
        }
    }

    public void stopBrowsingInternet() {
        if (isEnabled()) {
            browsing = false;
            this.url = null;
        }
    }

    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm a SmartTV set.");
        System.out.println("| I'm " + (isEnabled() ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + getVolume() + "%");
        System.out.println("| Current channel is " + getChannel());
        System.out.println("| I'm currently " +  (browsing ? "browsing " + url : "not browsing the internet."));
        System.out.println("------------------------------------\n");
    }
}
