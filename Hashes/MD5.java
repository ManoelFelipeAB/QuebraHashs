/*
    Equipe:
    ┌────────────────────────────────┐
    │ Manoel Felipe de Almeida Bina; │
    │ Nicholas Davi da Cruz.         │
    └────────────────────────────────┘
*/

package Hashes;

import java.math.BigInteger;
import java.security.MessageDigest;

// Código gerador de hashes MD5 que estamos utilizando para esta atividade
public class MD5 {

    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String md5Hash(String toBeHashed) throws Exception {

        MD5 md5 = new MD5();

        MessageDigest m = MessageDigest.getInstance("MD5");

        m.update(toBeHashed.getBytes(),0, toBeHashed.length());

        return new BigInteger(1, m.digest()).toString(16);
    }
}