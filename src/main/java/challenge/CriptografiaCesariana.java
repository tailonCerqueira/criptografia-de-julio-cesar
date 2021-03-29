package challenge;

import java.util.ArrayList;
import java.util.List;

public class CriptografiaCesariana implements Criptografia {

    @Override

    public String criptografar(String texto) {       

        String arrayNums = "1234567890", convert; 

        String arrayLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        int i = 0, resto = 3, k = 0, l = 0, newArrayLower = 0;

        char getChar;

        StringBuilder res = new StringBuilder();

        

        if(texto.equals("")){

            throw new IllegalArgumentException();

        }else{

            while(i < texto.length()){

                

                while(k < arrayNums.length()){

                    if(texto.codePointAt(i) == arrayNums.codePointAt(k)){

                        getChar = texto.charAt(i);

                        res.append(getChar);                         

                    }

                    k++;

                }


                while(l < arrayLetters.length()){                    

                    if(texto.codePointAt(i) == arrayLetters.codePointAt(l)){                        

                        newArrayLower = texto.codePointAt(i)+32; 

                        newArrayLower = newArrayLower + 3;                       

                        getChar = (char) newArrayLower;                                                                        

                        convert = String.valueOf(getChar);

                        res.append(convert);                            

                    }

                    l++;

                }

                

                if(texto.codePointAt(i) == 32){ 

                    newArrayLower = texto.codePointAt(i);

                    newArrayLower = newArrayLower + 3;

                    getChar = texto.charAt(i);

                    convert = String.valueOf(getChar);

                    res.append(convert.toLowerCase());                

                }else if((texto.codePointAt(i) > 96) && (texto.codePointAt(i) < 120)){   

                    newArrayLower = texto.codePointAt(i);

                    newArrayLower = newArrayLower + 3;                                                    

                    getChar = (char) newArrayLower;

                    convert = String.valueOf(getChar);

                    res.append(convert.toLowerCase());                                                                             

                }else if(texto.codePointAt(i) >= 120){

                    newArrayLower = 122 - texto.codePointAt(i);

                    resto = resto - newArrayLower;

                    newArrayLower = 97 - resto;

                    getChar = (char) newArrayLower;

                }


                newArrayLower = 0;

                k = 0;

                l = 0;

                resto = 3;

                         

                i++;

            }

            

             

        }

        return res.toString();

        

    }


    @Override

    public String descriptografar(String texto) {  

        String arrayNums = "1234567890", convert; 

        String arrayLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";


        int i = 0, k = 0, l = 0, newArrayLower = 0;

        char getChar;

        StringBuilder res = new StringBuilder();

        

        if(texto.equals("")){

            throw new IllegalArgumentException();

        }else{                 

            while(i < texto.length()){                

                while(k < arrayNums.length()){

                    if(texto.codePointAt(i) == arrayNums.codePointAt(k)){

                        getChar = texto.charAt(i);

                        res.append(getChar);                         

                    }

                    k++;

                }              

                if(texto.codePointAt(i) == 32){

                    newArrayLower = texto.codePointAt(i);

                    newArrayLower = newArrayLower - 3;

                    getChar = texto.charAt(i);

                    convert = String.valueOf(getChar);

                    res.append(convert);            

                }else if((texto.codePointAt(i) > 96) && (texto.codePointAt(i) < 122)){   

                    newArrayLower = texto.codePointAt(i);

                    

                    if(newArrayLower < 100){

                        newArrayLower = 122 - (99 - newArrayLower);     

                                         

                        getChar = (char) newArrayLower;

                        convert = String.valueOf(getChar);

                        res.append(convert);  

                        System.out.println(res);

                    }else{

                        newArrayLower = newArrayLower - 3;                                                

                        getChar = (char) newArrayLower;

                        convert = String.valueOf(getChar);

                        res.append(convert); 

                        System.out.println(res); 

                    }


                }


                while(l < arrayLetters.length()){                    

                    if(texto.codePointAt(i) == arrayLetters.codePointAt(l)){                        

                        newArrayLower = texto.codePointAt(i)+32; 

                        newArrayLower = newArrayLower - 3;                       

                        getChar = (char) newArrayLower;                                                                        

                        convert = String.valueOf(getChar);

                        res.append(convert);                            

                    }

                    l++;

                }

                newArrayLower = 0;

                k = 0;

                l = 0;

                               

                i++;

            }

            System.out.println(res);

            return res.toString();

        }

    }

}