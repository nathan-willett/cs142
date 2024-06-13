package week5;

// Allison Obourn
// CS 142, Spring 2024
// Lecture 19

// Prints out the name of the directory this program is in and then the names
// of all files and folders inside it, all files and folders in its folders,
// etc. Files and folders are output one per line.

import java.io.*;
import java.util.*;

public class Crawler {
   public static void main(String[] args) {
      // . means the current directory. That means, whatever directory you
      // put this program in is the one whose contents will be output.
      crawl(new File("."));
   }
   
   // Prints the name of the passed in file and all the files inside of it
   // If there are folders in it their contents is output too and their folders
   // folders folders etc until everything is output.
   public static void crawl(File f) {
      // output the current file/folder name
      System.out.println(f.getName());
      if(f.isDirectory()) {
         // if this is a directory it could contain other files/folders so get
         // all of them and print them and their contents out
         File[] files = f.listFiles();
         for(int i = 0; i < files.length; i++) {
            // WARNING: indentation is currently broken. We will fix it tomorrow.
            System.out.print("    ");
            // print all the files/folders in this file/folder
            crawl(files[i]);
         }
      }
   }
}