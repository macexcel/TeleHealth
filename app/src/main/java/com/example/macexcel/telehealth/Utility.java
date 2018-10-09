package com.example.macexcel.telehealth;

/**
 * Created by Macexcel on 9/2/2018.
 */

public class Utility {//the alphabet
    private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //                               "01234567890123456789012345" this line is to read index of each letter

    private static int index;
    private static int updated_index;
    private static int final_index;
    private static int index_p_t_l; // index of plaintext letter
    private static int index_s_t_l; // index of ciphertext letter
    private static String plaintxt;
    private static String ciphertxt;
    private static String finaltext;

    /**
     * this method encrypts an English text using Caesar Cipher encryption method
     * @param plainText the plain text to encrypt
     * @param encryptionKey the encryption key
     * @return ciphered text
     */
    public static String encrypt(String plainText, int encryptionKey){
        reset();
        plainText = plainText.toUpperCase();
//        System.out.println("Here is the chars of the plain text.."
//                + "\nwith its index in the alphabet, the new index after adding the encryption key, and the final value of index.");

        for (index =0 ; index < plainText.length() ;index++ ){

            //to find each char in plaintxt
//            System.out.print(plainText.charAt(index) + " ");

            if ( plainText.charAt(index) != ' '){ //to find the index of each plaintxt's letter IN THE ALPHABET
                index_p_t_l = alphabet.indexOf(plainText.charAt(index));
//                System.out.print(index_p_t_l + " ");

                updated_index = encryptionKey + alphabet.indexOf(plainText.charAt(index)); //then add the encryption key to the index of each letter we found IN ALPHABET
//                System.out.print(updated_index + " ");

                if (updated_index >= alphabet.length()){    //If the new index is > than alphabet.length subtract alphabet.length
                    final_index = updated_index - alphabet.length();
                }else{
                    final_index = updated_index;
                }
//                System.out.println(final_index);

                ciphertxt = alphabet.substring(final_index, final_index +1);  //find the char of each index in alphabet

                finaltext = finaltext + ciphertxt; //concatenate the whole chars of cipher text..
            }else{
//                System.out.println("\n");
            }

        }
        //System.out.println(finaltext);
        return finaltext;
    }


    /**
     * this method encrypts an English text using Caesar Cipher encryption method
     * @param cipherText
     * @param decryptionKey
     * @return
     */
    public static String decrypt(String cipherText, int decryptionKey){
        reset();
        cipherText = cipherText.toUpperCase();

//        System.out.println("Here is the chars of the cipher text.."
//                + "\nwith its index in the alphabet, the new index after adding the decryption key, and the final value of index.");


        for ( index =0 ; index < cipherText.length() ;index++ ){

            //to find and display each char in ciphertxt
//            System.out.print(cipherText.charAt(index) + " ");

            if ( cipherText.charAt(index) != ' '){
                index_p_t_l = alphabet.indexOf(cipherText.charAt(index));


                index_s_t_l = index_p_t_l; //to find the index of each plaintxt's letter IN THE ALPHABET
//                System.out.print(index_s_t_l + " ");

                //then subtract the encryption key from the index of each letter we found IN ALPHABET
                updated_index =  alphabet.indexOf(cipherText.charAt(index)) - decryptionKey;
//                System.out.print(updated_index + " ");

                //If the new index is < than a.length subtract a.length
                if (updated_index < 0)
                {
                    final_index = updated_index + alphabet.length();
                }else{
                    final_index= updated_index;
                }
//                System.out.println(final_index);

                //find the char of each index in alphabet
                plaintxt = alphabet.substring(final_index,final_index+1);

                //concatenate the whole chars of plain text..
                finaltext=finaltext+plaintxt;
            }
            else
            {
//                System.out.println("\n");
            }
        }
//        System.out.println(finaltext );
        return finaltext;
    }

    private static void reset(){
        finaltext = "";
    }
}