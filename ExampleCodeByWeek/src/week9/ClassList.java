// CS& 141, Winter 2024
// Thanks to Allison Obourn for parts of this program

package week9;

// Blueprint for a class that represents a college course. A course has an
// instructor, name, number and the students enrolled

public class ClassList {
   private String className;
   private String instructor;
   private int classNumber;
   private Student[] students;
   private int enrolled;
   
   // creates a new class with the passed in name, number and instructor. The
   // class has a capacity of 30 and starts with no students enrolled
   public ClassList(String className, int numberClass, String nameInstructor) {
      this.className = className; 
      classNumber = numberClass;
      instructor = nameInstructor;
      students = new Student[30];
      enrolled = 0;
   }
   
   public int getSize() {
       return enrolled;
   }
   
   // returns the name of the course
   public String getClassName() {
      return className;
   }
   
   // sets the name of the class to the passed in string as long as the string
   // is between 5 and 30 characters
   public void setClassName(String newName) {
      if(newName.length() >= 5 && newName.length() <= 30) {
         className = newName;
      }
   }
   
   // adds the passed in student to the course as long as the course isn't full
   // If the course is full an error message is printed
   public void add(Student student) {
      if(enrolled < 30) {
         students[enrolled] = student;
         enrolled++;
         System.out.println("enrolled successfully");
      } else {
         System.out.println("Sorry, this class is full");
      }
   } 
   
   // removes the passed in student from the class, if the student is 
   // currently enrolled. If the student is not enrolled prints out a 
   // not found message. Assumes that any student with the same student 
   // number is the same student
   public void remove(Student student) {
      // find the index of the student to remove
      int index = -1;
      for(int i = 0; i < enrolled; i++) {
         if(students[i].getID() == student.getID()) {
            index = i;
         }
      }
      // if we still have the index as -1 we didn't find it
      if(index == -1) {
         System.out.println("Student not found");
      } else {
         // shift over everything to the left starting with the one after the one to 
         // remove. Stop one before the end so we don't go out of bounds when the 
         // array is full
         for(int i = index; i < enrolled - 1; i++) {
            students[i] = students[i + 1];
         }
         // decrease the count of total students in the class. This means we don't need
         // to reset the last one because we won't ever look at it anyway
         enrolled -= 1;
      }
   }
   
   public Student getStudent(int i) {
       return students[i];
   }
}