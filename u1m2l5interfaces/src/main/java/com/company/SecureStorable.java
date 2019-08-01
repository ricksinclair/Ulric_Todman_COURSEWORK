package com.company;

public interface SecureStorable extends Storable{

    public void decryptData();
    public void encryptData();
}
