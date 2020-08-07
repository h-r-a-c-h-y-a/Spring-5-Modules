package am.gitc.ch4.factory;

import java.security.MessageDigest;

public class MessageDigester {

    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg) {
        System.out.println("Using digestl");
        digest(msg, digest1);
        System.out.println("Using digest2");
        digest(msg, digest2);
    }

    public void digest(String msg, MessageDigest digest) {
        System. out. println ( "Using algorithm: "
                + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        System.out.println(out);
    }

}
