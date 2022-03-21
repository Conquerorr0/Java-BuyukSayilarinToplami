package uygulama;

public class uygulama3 {
    public static void main(String[] args) {
        String number1 = "999999999999999";
        String number2 = "1485689451";
        
        buyukSayi k = new buyukSayi(number1, number2);
        
        System.out.println(k.topla());
        
    }
}
    
    class buyukSayi{
        String a, b;
        
        buyukSayi(String a1, String b1){    //Sayıları String olarak aldığımız için karakter karakter toplayacağız.
            a=a1;                           //Burada sayıların boyları farklıysa küçük olanın başına 0 ekliyoruz.
            b=b1;
            
            if(a1.length()<b1.length()){
                for(int i=1; i<=b1.length()-a1.length(); i++){
                    a="0"+a;
                }
            }
            
            else{
                for(int i=1; i<=a1.length()-b1.length(); i++){
                    b="0"+b;
                }
            }
        }
        
        String topla(){
            
            String toplam = "", geciciStr1, geciciStr2, ekle; int yeniSayi1, yeniSayi2, sayiTop;    //Toplamı boş bir String olarak alıyoruz.
            System.out.println(this.a);
            System.out.println(this.b);
            
            for(int i=this.a.length()-1; i>=0; i--){    //Toplamaya en son indislerden başlıyoruz.
                sayiTop = 0;
                
                yeniSayi1 = charToInt(this.a.charAt(i));
                yeniSayi2 = charToInt(this.b.charAt(i));
                
                sayiTop = yeniSayi1 + yeniSayi2;
                
                if(i!=0){
                    
                    if(sayiTop==10){    //Eğer sayı 10'a eşitse toplam Stringinin o an ki indisine 0 yazıyoruz. 
                        
                        i--;
                        toplam = "0" + toplam;
                        yeniSayi1 = charToInt(this.a.charAt(i));
                        yeniSayi1 += 1; 
                        yeniSayi2 = charToInt(this.b.charAt(i)); 
                        sayiTop = yeniSayi1 + yeniSayi2;
                        toplam = sayiTop + toplam;
                        
                    }
                    
                    else if(sayiTop<10)   toplam = String.valueOf(sayiTop) + toplam;
                    
                    else if(sayiTop>10){    
                        i--;
                        ekle = String.valueOf(sayiTop - 10);    //Sayı 10'dan büyük olduğu zaman kalanı ekliyoruz.
                        toplam = ekle + toplam;
                        yeniSayi1 = charToInt(this.a.charAt(i));
                        yeniSayi1 += 1;
                        yeniSayi2 = charToInt(this.b.charAt(i));
                        sayiTop = yeniSayi1 + yeniSayi2;
                        
                        while(sayiTop>=10 && i!=0){ //Toplam 10'a eşit veya 10'dan büyük olduğu sürece döngüde devam ediyoruz.
                                                    
                            if(sayiTop>10){
                                i--;
                                ekle = String.valueOf(sayiTop - 10);
                                toplam = ekle + toplam;
                                yeniSayi1 = charToInt(this.a.charAt(i));
                                yeniSayi1 += 1;
                                yeniSayi2 = charToInt(this.b.charAt(i));
                                sayiTop = yeniSayi1 + yeniSayi2;
                            }
                            
                            else if(sayiTop==10){
                                i--;
                                toplam = "0" + toplam;
                                yeniSayi1 = charToInt(this.a.charAt(i));
                                yeniSayi1 += 1;
                                yeniSayi2 = charToInt(this.b.charAt(i));
                                sayiTop = yeniSayi1 + yeniSayi2;
                            }
                        }
                        
                        toplam = sayiTop + toplam;
                        
                    }
                }
                
                else    toplam = String.valueOf(sayiTop) + toplam;
                
            }
            
            return toplam;
            
            
        }
        
        int charToInt(char c){  //char'dan int'e direk dönüşüm olmadığı için bu metotu yazdık.
            String str1;    int sayi;
            
            str1 = String.valueOf(c);
            sayi = Integer.valueOf(str1);
            
            return sayi;
        }
    }