package com.recommend.reco.app;

/**
 * Created by Sumeet on 22-06-2014.
 */
public class DrawerItem {
    String medTitle;
    boolean isHead;
    int icon;

    /**
     * @param medTitle
     * @param icon
     */
    public DrawerItem(String medTitle, int icon, boolean isHead) {
        super();
        this.medTitle = medTitle;
        this.icon = icon;
        this.isHead = isHead;
    }

    /**
     * @return the medTitle
     */
    public String getMedTitle() {
        return medTitle;
    }

    /**
     * @param medTitle
     *            the medTitle to set
     */
    public void setMedTitle(String medTitle) {
        this.medTitle = medTitle;
    }

    /**
     * @return the icon
     */
    public int getIcon() {
        return icon;
    }

    /**
     * @param icon
     *            the icon to set
     */
    public void setIcon(int icon) {
        this.icon = icon;
    }

    public boolean isHead() {
        return isHead;
    }
}
