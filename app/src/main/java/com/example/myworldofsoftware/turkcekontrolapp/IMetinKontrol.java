package com.example.myworldofsoftware.turkcekontrolapp;

public interface IMetinKontrol {
    public String MetinKontrolEt(String[] kelime);
    public int BuyukUnluUyumuKalinTest(String[] kelime);
    public int BuyukUnluUyumuİnceTest(String[] kelime);
    public int KucukUnluUyumuDuzTest(String[] kelime);
    public int KucukUnluUyumuYuvarlakTest(String[] kelime);
    public Boolean TurkceyeOzguHarfTesti(String[] kelime);
    public Boolean TurkcedeOlmayanHarfTesti(String[] kelime);
    public Boolean KelimeSonHarfKontrol(String[] kelime);
    public Boolean YanyanaSesliHarfKontrol(String[] kelime);

}
