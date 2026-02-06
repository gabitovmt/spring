package spring.ch03.collections1;

public class FtpArtworkSender implements ArtworkSender {

    @Override
    public void sendArtwork(String artworkPath, Recipient recipient) {
        // Здесь следует логика обмена данными по сетевому протоколу FTP
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
