package am.gitc.ch3.protocol.impl;

import am.gitc.ch3.protocol.ArtworkSender;
import am.gitc.ch3.protocol.Recipient;

public class FtpArtworkSender implements ArtworkSender {
    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {

    }

    @Override
    public String getFriendlyName() {
        return "File Transfer Protocol";
    }

    @Override
    public String getShortName() {
        return "ftp";
    }
}
