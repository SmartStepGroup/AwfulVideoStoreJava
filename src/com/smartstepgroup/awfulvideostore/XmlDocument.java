package com.smartstepgroup.awfulvideostore;

import java.util.ArrayList;

public class XmlDocument {
    public final ArrayList<XmlElement> Elements;

    public XmlDocument() {
        this.Elements = new ArrayList<XmlElement>();
    }

    public void Load() {
        XmlElement starWars = new XmlElement();
        starWars.Values[0] = "Звездные Войны. Эпизод 7";
        starWars.Values[1] = "1.99$";
        starWars.Values[2] = "16";
        starWars.Values[3] = "0";

        XmlElement gnome = new XmlElement();
        gnome.Values[0] = "Белоснежка и 7 гномов";
        gnome.Values[1] = "10.99$";
        gnome.Values[2] = "18";
        gnome.Values[3] = "1";

        XmlElement maria = new XmlElement();
        maria.Values[0] = "Просто Мария";
        maria.Values[1] = "0.99$";
        maria.Values[2] = "13";
        maria.Values[3] = "0";

        XmlElement sea = new XmlElement();
        sea.Values[0] = "Бравый капитан уходит в море";
        sea.Values[1] = "15.99$";
        sea.Values[2] = "4";
        sea.Values[3] = "2";

        Elements.add(starWars);
        Elements.add(gnome);
        Elements.add(maria);
        Elements.add(sea);
    }
}

