package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

import static java.lang.Math.ceil;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

            double sto, str, flag_2 = 0, flag_3 = 0;
            double flag = 0;
            sto = (size * 2) + 2;
            str = (size * 2) + 1;

            if (size > 1){ flag = ceil(str / 2); }
            for (int k = 1; k <= str; k++)
            {
                for (int i = 1; i <= sto; i++) {
                    if ((k == 1 && i == 1) || (k == 1 && i == sto) || (k == str && i == 1) || (k == str && i == sto)) {
                        mOut.print("+");
                    }
                    if ((k == 1 && i > 1 && i < sto) || (k == str && i>1 && i < sto))
                    {
                        mOut.print("-");
                    }
                    if ((k > 1 && k < str && i == 1) || (k > 1 && k < str && i == sto))
                    {
                        mOut.print("|");

                    }
                    if (size == 1){
                        if (k > 1 && k < str && i == 1){ mOut.print("<"); }
                        if (k > 1 && k < str && i == sto - 1){ mOut.print(">"); }
                    }

                    else{
                        if (k == flag){
                            if (i == sto - 1 && k == flag){ mOut.print(">"); }
                            if (i> 2 && i <= sto - 2)
                            {
                                if (k % 2 != 0)
                                {
                                    mOut.print("-");
                                }
                                if (k % 2 == 0)
                                {
                                    mOut.print("=");
                                }
                            }
                            if (i == 1 && k == flag){ mOut.print("<"); }
                        }
                        if (k < flag && i <= sto / 2 - (sto / 2 - 1) && k>1){
                            flag_2 = sto / 2 - k;//подсчет пробелов половина столбцов минус текущая строчка
                            for (double g = flag_2; g > 0; g--)
                            {
                                mOut.print(" ");
                            }
                        }
                        else{
                            if (k > 1 && k < flag && i >= flag_2 + k - (k - 1) && i <= flag_2 + k - (k - 1))
                            {
                                mOut.print("/");
                            }
                            else{
                                if (k < flag && k > 2 && i > flag_2 + k - (k - 1) + 1 && i <= sto - flag_2 - 2)
                                {
                                    if (k % 2 != 0)
                                    {
                                        mOut.print("-");
                                    }
                                    if (k % 2 == 0)
                                    {
                                        mOut.print("=");
                                    }
                                }

                                if (k < flag && i >= sto / 2 + (sto / 2 - 1) && k>1 && i < sto){
                                    for (double g = flag_2; g > 0; g--)
                                    {
                                        mOut.print(" ");
                                    }
                                }
                                else{
                                    if (k < flag && k > 1 && i >= sto - flag_2 - 1 && i < sto - flag_2){ mOut.print("\\"); }
                                }
                            }


                        }

                        ///Нижняя///
                        flag_2 = (sto / 2 - k);
                        if (k > flag && i <= sto / 2 - (sto / 2 - 1) && k<str){
                            flag_2 = (sto / 2 - k) / -1;
                            flag_3 = flag_2;
                            for (double g = flag_2; g > 0; g--)
                            {
                                mOut.print(" ");
                            }
                        }
                        else{
                            if (k > flag && k < str && i <= sto / 2 && i > flag_3 + k - (k - 1) && i <= flag_3 + k - (k - 1) + 1)
                            {
                                mOut.print("\\");

                            }
                            else{
                                if (k > flag && k < str - 1 && i > flag_3 + k - (k - 1) + 1 && i <= sto - flag_3 - 2)
                                {
                                    if (k % 2 != 0)
                                    {
                                        mOut.print("-");
                                    }
                                    if (k % 2 == 0)
                                    {
                                        mOut.print("=");
                                    }
                                }
                                else{

                                    if (k > flag && i >= sto / 2 + (sto / 2 - 1) && k < str && i < sto){
                                        for (double g = flag_3; g > 0; g--)
                                        {
                                            mOut.print(" ");
                                        }
                                    }
                                    else
                                    {
                                        if (k> flag && k<str && i > sto / 2 && i < sto - flag_3 /*+ k - (k - 1) - 1*/)
                                        {
                                            mOut.print("/");
                                        }

                                    }
                                }
                            }

                        }
                    }


                }

                mOut.print("\n");
            }

    }

}
