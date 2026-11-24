
package akun;

import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class BuatHashPassword {

    public static void main(String[] args) throws Exception {

        String password = "Admin123";

        int iterasi = 600000;
        byte[] salt = new byte[16];

        new SecureRandom().nextBytes(salt);

        PBEKeySpec spec = new PBEKeySpec(
                password.toCharArray(),
                salt,
                iterasi,
                256
        );

        byte[] hasil = SecretKeyFactory
                .getInstance("PBKDF2WithHmacSHA256")
                .generateSecret(spec)
                .getEncoded();

        String hash = "pbkdf2-sha256:"
                + iterasi + ":"
                + Base64.getEncoder().encodeToString(salt)
                + ":"
                + Base64.getEncoder().encodeToString(hasil);

        System.out.println(hash);

        spec.clearPassword();
    }
}
