import java.util.Arrays;

class Solution
{
    public String addBinary(String a, String b)
    {
        int aLen=(a==null)?0:a.length();
        int bLen=(b==null)?0:b.length();
        int cLen=(aLen>=bLen)?aLen+1:bLen+1;
        int aDigit=0;
        int bDigit=0;
        char sumChar='0';
        int carryover=0;
        char[] sumCharArray = new char[cLen];
        for(int i=aLen-1,j=bLen-1,k=cLen-1; i>=0 || j>=0; i--,j--,k--)
        {
            if(i>=0)
            {
                if(a.charAt(i)=='0')aDigit=0;
                else if(a.charAt(i)=='1')aDigit=1;
            }
            else
            {
                aDigit=0;
            }
            if(j>=0)
            {
                if(b.charAt(j)=='0')bDigit=0;
                else if(b.charAt(j)=='1')bDigit=1;
            }
            else
            {
                bDigit=0;
            }
            if((aDigit+bDigit+carryover)==0){   sumChar='0'; carryover=0;   }
            else if((aDigit+bDigit+carryover)==1){   sumChar='1'; carryover=0;   }
            else if((aDigit+bDigit+carryover)==2){   sumChar='0'; carryover=1;   }
            else if((aDigit+bDigit+carryover)==3){   sumChar='1'; carryover=1;   }
            sumCharArray[k] = sumChar;           
        }
        if(carryover==1)
        {
            sumCharArray[0] = '1';
            return String.valueOf(sumCharArray);
        }
        else
        {
            sumCharArray[0] = '0';
            return String.valueOf(sumCharArray).substring(1);
        }
    }
}