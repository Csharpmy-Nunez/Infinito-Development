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
            Console.WriteLine("Result => " + isSubString(mainString.ToLower(), subString.ToLower()));
            //Console.WriteLine("Result => " + "\n" + charFrequency(mainString));
            //Console.WriteLine("Result => " + "\n" + firstNonRepeatingChar(mainString));
            //Console.WriteLine("Result => " + "\n" + stringCompression(mainString));

        }
        //Methods
        /*Q1) Write a method to determine whether an input string X is a sub-string of another input Y.  
              a) Plesae try to write code wih PHP and you may NOT use PHP libraries. 
              b)The strings are alphabetic characters and lower case. 
          (For example, “bat” is a sub-string of “abate”, but not of “beat”)*/
          public static bool isSubString(string valueString, string valueSubString)
          {

            bool substring;

            for(int i = 0; i <= valueString.Length - valueSubString.Length; i++)
            {
                substring = true;
                for(int j = 0; j < valueSubString.Length; j++)
                {
                    if(valueSubString[j] != valueString[i + j])
                    {
                        substring = false;
                        break;
                    } 
                }

                if (substring)
                    return true;

            }


            return false;
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
