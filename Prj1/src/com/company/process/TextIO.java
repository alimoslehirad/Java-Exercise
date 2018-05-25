package com.company.process;
import com.company.objects.ObjectPool;

import java.io.*;
import java.util.*;
public class TextIO {

    public  String getCommandLine(ObjectPool v, boolean ifTerminalInput) {

        String command="Init val";

        if(!ifTerminalInput) {
            String line = null;

            try {



                line = v.bufferedReader.readLine();

                if (line == null) v.bufferedReader.close();

                command= line;


            } catch (FileNotFoundException ex) {
                System.out.println(
                        "Unable to open file '" +
                                v.fileName + "'");
            } catch (IOException ex) {
                System.out.println(
                        "Error reading file '"
                                + v.fileName + "'");
                // Or we could just do this:
                // ex.printStackTrace();
            }
        }
        else {
            v.command=v.datain.nextLine();

        }
        return command;
    }

}
