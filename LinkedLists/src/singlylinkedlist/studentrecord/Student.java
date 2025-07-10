package singlylinkedlist.studentrecord;

public class Student {
			int roll , age;
			String Name, Grade;
			Student next;

 public Student(int roll, int age, String Name, String Grade) {
	 this.roll = roll;
	 this.age  = age;
	 this.Name = Name;
	 this.Grade = Grade;
	 this.next = null;
	 
 }
}