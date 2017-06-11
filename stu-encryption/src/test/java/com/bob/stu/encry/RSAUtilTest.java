package com.bob.stu.encry;

import com.bob.stu.security.RSAUtil;
import org.junit.Test;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

/**
 * Created by bob on 2017/6/11.
 *
 * @author bob   <bobyang_coder@163.com>
 * @since 2017/6/11
 */
public class RSAUtilTest {

    @Test
    public void generateKeyPair() throws Exception {
        RSAUtil.generateKeyPair();

    }


    @Test
    public void encrypt() throws Exception {

        RSAPublicKey rsaPublicKey = RSAUtil.loadPublicKeyByString("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApu5UI8SlsCLkpK4nV5NI3ksuB4Hiv6Bj\n" +
                "OQNLMg/SEMTJaxR8pxtJskSkE5aPfHneMpOp5k4eI2wpUqaROzrAVW+Qcp2pvaQsxaSgRqeu2hTr\n" +
                "Us5sZUotTBPGaIAWuLsuFjXH5VMBR4uXfmb9ZnhO4Q2ICIO8bjy7d8D0Pq0U/Q94r0W8neIsmn7x\n" +
                "3kNoe1jQIdCXh/uPgoteZu7OqxxVxMWHBNAeHYbQ3k8NvZJreTkvUCWOkulJG0GdgjWunfzhkUbS\n" +
                "qsAElfM7xp2DmOZ58/TmEjdmqF0LLCsnXoa8900VrjLwIPj5DK5PeQVLU7Ne5NECwVGi4B25N0Pi\n" +
                "sFm7rQIDAQAB");

        String encrypt = RSAUtil.encrypt("bob love linlin", rsaPublicKey);


        RSAPrivateKey rsaPrivateKey = RSAUtil.loadPrivateKeyByString("MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCm7lQjxKWwIuSkridXk0jeSy4H\n" +
                "geK/oGM5A0syD9IQxMlrFHynG0myRKQTlo98ed4yk6nmTh4jbClSppE7OsBVb5Bynam9pCzFpKBG\n" +
                "p67aFOtSzmxlSi1ME8ZogBa4uy4WNcflUwFHi5d+Zv1meE7hDYgIg7xuPLt3wPQ+rRT9D3ivRbyd\n" +
                "4iyafvHeQ2h7WNAh0JeH+4+Ci15m7s6rHFXExYcE0B4dhtDeTw29kmt5OS9QJY6S6UkbQZ2CNa6d\n" +
                "/OGRRtKqwASV8zvGnYOY5nnz9OYSN2aoXQssKydehrz3TRWuMvAg+PkMrk95BUtTs17k0QLBUaLg\n" +
                "Hbk3Q+KwWbutAgMBAAECggEBAJRqeWyDvjxoCZlRLbFzReo+NWJ/XLa7Rvy9rPGJl19JVztZL6rz\n" +
                "XAafeLHhvxkQ0TluiDQ3aBxeYi8V4TIj/jT3yBnfi7cMbLIcuFOZaqCC0OcCmOVFmhh1zIXEvG7q\n" +
                "HQOqNVvy/MQ7nCnKL6oXdSoq+bN4TORGIvdKGt5OzMZgsnNFEv/EYlmRqzNFSsxxjGdbZ3SxUXmX\n" +
                "g1vZ9TICF4NmEHUQIgPeUPGkL/ARsyDitR0UA+n+/F0ZzJ5gta29MfieOXH02FMlohy8PU0PRcwb\n" +
                "tP+KiZbbcwXN5+qf+GujMEBEbXg7Gh9n3JvWWg213vQR+sxHjBn9Yxudk+q+WpECgYEA89KmJEgX\n" +
                "MY9ii2GzUwUKyEVIm06Hnc5u0Hbxs+0vwcthP3qk+y/GJNTN49ohaDzMcR4hPH0NYnZLEcOdrYuk\n" +
                "rmt5igNeTv+HskDfHcoDGUU67eiMH+Puq64gLgLz/m/U7gdIla8P0/tcNH07w54MiuZsyh6ChvTI\n" +
                "i/xold0qzBsCgYEAr0SX1cCgtLir3u82lo2JO9LdyV1sZTjX6AY/xocPs6LMP2gkiF2cBteN6lcA\n" +
                "LHiFCfmrdllmjJhRYM9+fI2dAM7PVLVyx/zQonwRVn7alABQ1kiQ7ZdC8IHaMt/+WpZ2L+WHTH0D\n" +
                "1E3jtKbSWAx3qBpdelFKaAZ+23ityRtMA9cCgYBqraWnhisvse6J0UtmbXRUP4wO94L6lpGBgCks\n" +
                "cgBNKDD6VyzMAhENmFYk9RFczA0fCPG9x3ENvXgG47GfdtOsxLU+n06p/b9fTGbSX8qPSe0InpCA\n" +
                "e3e3gc3uk7gxgLiHFIS7iQbB1t520LxPUF1ogHzkygiOB5efN+aCe2v4NQKBgESG9TbGEg+XBNwt\n" +
                "e5Jx1G5ni//nXzJUf1Zg2x6sQB9kT6ea+G247ABg10QAsDizBpFX5Qpo+geOpoLLnhDk7bYbJkVg\n" +
                "jHhVCN3+1GiVQLENTo354XCD69BNdRrfKXwRyDQB8lydpJmlupovf56dgUtgw5vHnOf/Yio9jPVM\n" +
                "jvQRAoGBAO4Rb6Cu0aF1Yb845cxD2NVOMqMtzivn60In/lalToqx25dp0bV5dJrCKMExT5iKsLg+\n" +
                "qehRJnTdMI8bbUtz6rMP+80Jd1x+Vc9uclKZlW7CXhodz5gBj/b7RpaC5SBZfiqjwifN+HBwdCna\n" +
                "cI4XPx26o6YqzGgEsWEJ81vr7s1N");

        String decrypt = RSAUtil.decrypt(encrypt, rsaPrivateKey);
        System.out.println("==========" + decrypt);

    }

}