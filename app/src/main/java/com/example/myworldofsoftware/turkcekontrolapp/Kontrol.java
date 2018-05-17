package com.example.myworldofsoftware.turkcekontrolapp;

public class Kontrol implements IMetinKontrol {

    int yuzde = 0;
    String metinRapor = "";

    @Override
    public String MetinKontrolEt(String[] kelime) {

        int toplamYuzde = 0; //Kelimenin Türkçe olma yüzdesini tutan değişken

        toplamYuzde += BuyukUnluUyumuKalinTest(kelime);
        toplamYuzde += BuyukUnluUyumuİnceTest(kelime);
        toplamYuzde += KucukUnluUyumuDuzTest(kelime);
        toplamYuzde += KucukUnluUyumuYuvarlakTest(kelime);

        if(TurkceyeOzguHarfTesti(kelime).equals(true)) {
            metinRapor += "\n\nKelime içerisinde sadece Türkçede bulunan bir harf bulunduğu için Türkçe bir kelimedir.";
            toplamYuzde = 100;
        }
        if(TurkcedeOlmayanHarfTesti(kelime).equals(true)) {
            metinRapor += "\n\nKelime içerisinde Türkçede bulunmayan bir harf olduğu için Türkçe bir kelime değil";
            toplamYuzde = 0;
        }
        /*if(KelimeSonHarfKontrol(kelime).equals(true)){
            metinRapor += "\n Kelime sonunda b,c,d,g harflerinden birisi olduğu için Türkçe bir kelime değil";
            toplamYuzde = 0;
        }*/
        if(YanyanaSesliHarfKontrol(kelime).equals(true)){
            metinRapor += "\n\nYan yana iki tane sesli harf geldiği için Türkçe bir kelime değil";
            toplamYuzde = 0;
        }
        metinRapor += "\n\nTürkçe bir kelime olma ihtimali: %"+toplamYuzde;
        return metinRapor;
    }

    @Override
    public int BuyukUnluUyumuKalinTest(String[] kelime) {

        yuzde = 0;
        for (int i = 0; i < kelime.length; i++) {
            if (kelime[i].equals("a") || kelime[i].equals("ı") || kelime[i].equals("o") || kelime[i].equals("u")) {
                //Kelimede büyük ünlü uyumunda kalınlık aranacak bir harf bulunursa
                for (int j = i; j < kelime.length; j++) {
                    if (kelime[j].equals("a") || kelime[j].equals("ı") || kelime[j].equals("o") || kelime[j].equals("u"))
                        //Eğer kaldığımız indisten sonra kalınlık uyumu devam ediyorsa büyük ünlü uyumunda kalınlık uyumu vardır.
                        yuzde = 30;
                    else if (kelime[j].equals("e") || kelime[j].equals("i") || kelime[j].equals("ö") || kelime[j].equals("ü"))
                        //Eğer kaldığımız indisten sonra ince bir ünlü gelmişse büyük ünlü uyumunda kalınlık uyumu yoktur.
                        yuzde = 0;
                }

            }
            break;
        }
        metinRapor += "\nBüyük Ünlü Uyumu-İncelik Uyumu: " + yuzde;
        return yuzde;
    }
    @Override
    public int BuyukUnluUyumuİnceTest(String[] kelime) {

        yuzde = 0;
        for (int i = 0; i < kelime.length; i++) {
            if (kelime[i].equals("e") || kelime[i].equals("i") || kelime[i].equals("ö") || kelime[i].equals("ü")) {
                //Kelimede büyük ünlü uyumunda incelik aranacak bir harf bulunursa
                for (int j = i; j < kelime.length; j++) {
                    if (kelime[j].equals("e") || kelime[j].equals("i") || kelime[j].equals("ö") || kelime[j].equals("ü"))
                        //Eğer kaldığımız indisten sonra incelik uyumu devam ediyorsa büyük ünlü uyumunda incelik uyumu vardır.
                        yuzde = 30;
                    else if (kelime[j].equals("a") || kelime[j].equals("ı") || kelime[j].equals("o") || kelime[j].equals("u"))
                        //Eğer kaldığımız indisten sonra kalın bir ünlü gelmişse büyük ünlü uyumunda incelik uyumu yoktur.
                        yuzde = 0;
                }
            }
            break;
        }
        metinRapor += "\nBüyük Ünlü Uyumu-İncelik Uyumu: " + yuzde;
        return yuzde;
    }
    @Override
    public int KucukUnluUyumuDuzTest(String[] kelime) {

        yuzde = 0;
        for (int i = 0; i < kelime.length; i++) {
            if (kelime[i].equals("a") || kelime[i].equals("e") || kelime[i].equals("ı") || kelime[i].equals("i")) {
                //Kelime de küçük ünlü uyumu aranacaksa ve düz ünlü bulunuyorsa
                for (int j = i; j < kelime.length; j++) {
                    if (kelime[j].equals("a") || kelime[j].equals("e") || kelime[j].equals("ı") || kelime[j].equals("i"))
                        //Eğer kaldığımız indisten sonra düz ünlü uyumu devam ediyorsa küçük ünlü uyumunda düz ünlü uyumu vardır.
                        yuzde = 30;
                    else if (kelime[j].equals("o") || kelime[j].equals("ö") || kelime[j].equals("u") || kelime[j].equals("ü"))
                        //Eğer kaldığımız indisten sonra yuvarlak bir ünlü gelmişse küçük ünlü uyumunda düz ünlü uyumu yoktur.
                        yuzde = 0;
                }
            }
            break;
        }
        metinRapor += "\nKüçük Ünlü Uyumu-Duz ünlü uyumu: " + yuzde;
        return yuzde;
    }

    @Override
    public int KucukUnluUyumuYuvarlakTest(String[] kelime) {

        yuzde = 0;

        for(int i = 0; i < kelime.length; i++) {
            if(kelime[i].equals("o") || kelime[i].equals("ö") || kelime[i].equals("u")  || kelime[i].equals("ü"))
                //Kelimede küçük ünlü uyumu aranacaksa ve yuvarlak ünlü bulunuyorsa
                for(int j = i; j < kelime.length; j++) {
                    if (kelime[j].equals("u")|| kelime[j].equals("ü") || kelime[j].equals("a") || kelime.equals("e")) {
                        // Kelimemizde küçük ünlü uyumu kuralına göre yuvarlak dar veya düz geniş ünlü geliyorsa
                        yuzde = 30;
                    }
                    else if(kelime[j].equals("o")|| kelime[j].equals("ö") || kelime[j].equals("ı") || kelime.equals("i")) {
                        //Kelimemizde küçük ünlü uyumunu bozacak bir ünlü harf geliyorsa
                        yuzde = 0;
                    }
                }
        break;
        }
        metinRapor += "\nKüçük Ünlü Uyumu-Yuvarlak ünlü uyumu: " + yuzde;
        return yuzde;
    }

    @Override
    public Boolean TurkceyeOzguHarfTesti(String[] kelime) {


        for(int i = 0; i < kelime.length; i++) {
            if (kelime[i].equals("ğ") || kelime[i].equals("ı") || kelime[i].equals("İ") || kelime[i].equals("ç") || kelime[i].equals("ü") || kelime[i].equals("ş") || kelime[i].equals("ö")) {
                //Eğer kelime içerisinde sadece Türkçede bulunan bir harf var ise
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean TurkcedeOlmayanHarfTesti(String[] kelime) {
        for(int i = 0; i < kelime.length; i++) {
            if (kelime[i].equals("j") || kelime[i].equals("J"))
                //Eğer kelime içerisinde sadece Türkçede bulunan bir harf var ise
                return true;
        }
        return false;
    }

    @Override
    public Boolean KelimeSonHarfKontrol(String[] kelime) {
        int indis = kelime.length;
        if(kelime[indis].equals("b") || kelime[indis].equals("c") || kelime[indis].equals("c") || kelime[indis].equals("g"))
            return true;
        return false;
    }

    @Override
    public Boolean YanyanaSesliHarfKontrol(String[] kelime) {
        int ikinciIndis = 0;

        for(int birinciIndis = 0; birinciIndis < kelime.length; birinciIndis++) {
            if(kelime[birinciIndis].equals("a") || kelime[birinciIndis].equals("ı") || kelime[birinciIndis].equals("o") ||
                    kelime[birinciIndis].equals("u") ||kelime[birinciIndis].equals("e") || kelime[birinciIndis].equals("i") ||
                    kelime[birinciIndis].equals("ö") || kelime[birinciIndis].equals("ü"))
            {
                ikinciIndis = birinciIndis + 1;
                if(kelime[birinciIndis].equals(kelime[ikinciIndis]))
                return true;
            }
        }
        return false;
    }


}
