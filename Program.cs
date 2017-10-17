using System;

namespace test
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter main string: ");
            string mainString = Console.ReadLine();
            //Console.WriteLine("Entered sub-string: ");
            //string subString = Console.ReadLine();
            Console.WriteLine("----------------------------------");
            //Console.WriteLine("Result => " + findSubstring(mainString.ToLower(), subString.ToLower()));
            //Console.WriteLine("Result => " + "\n" + charFrequency(mainString));
            //Console.WriteLine("Result => " + "\n" + firstNonRepeatingChar(mainString));
            Console.WriteLine("Result => " + "\n" + stringCompression(mainString));

        }
        //Methods
        public static string findSubstring(string valueString, string valueSubString){
            string substring = "";
            char[] holderStr = valueString.ToCharArray();
            char[] holderSubstr = valueSubString.ToCharArray();

            for(int i = 0; i < holderStr.Length; i++){
                 for(int j = 0; j < holderSubstr.Length; j++){
                     if(holderStr[i] == holderSubstr[j]){
                         substring += holderSubstr[j].ToString();
                     }
                 }
            }
              
            return substring;
        }
    //Method to check character frequency
    public static string charFrequency(string value){
        char chr;
        int counter;
        string frequency = "";

        //Loop through the ASCII alphateic characters A - Z.  
        for(chr = (char)65; chr <= 90; chr++){
            counter = 0;
            
            //Compare characters in the input with the loop
            for(int i = 0; i < value.Length; i++){
                if(chr == value[i] || (chr + 32) == value[i]){
                    counter++;
                }
            }
            //Counter has to be greater than 0.
            if(counter > 0){
                frequency += chr + " = " + counter + "\n";
            }

        }
        
        //Return a lower case reference
        return frequency.ToLower();
    }//End of main loop
    
    //First non-repeating character
    public static string firstNonRepeatingChar(string value){
        char chr;
        int counter;
        string result = "";

        //Loop through the ASCII alphateic characters A - Z.  
        for(chr = (char)65; chr <= 90; chr++){
            counter = 0;
            
            //Compare characters in the input with the loop
            for(int i = 0; i < value.Length; i++){
                if(chr == value[i] || (chr + 32) == value[i]){
                    counter++;
                }
            }
            //Check which character is equal to 1.
            if(counter == 1){
                result += chr.ToString() + "\n";
            }

        }
         
         return result.ToLower();
    }
    //String compression method
    public static string stringCompression(string value){
       string compression = "";
        char chr;
        int counter;

        //Loop through the ASCII alphateic characters A - Z.  
        for(chr = (char)65; chr <= 90; chr++){
            counter = 0;
            
            //Compare characters in the input with the loop
            for(int i = 0; i < value.Length; i++){
                if(chr == value[i] || (chr + 32) == value[i]){
                    counter++;
                }
            }
            //Check counter.
            if(counter > 0){
                compression += counter + "" + chr;
            }

        }
       
       return compression.ToLower();
    }

    }//End of class

}//End of namespace
