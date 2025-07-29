package Level_1;

class Book {
	String title;
	String author;
	double price;
	//Default constructor
	Book(){
		title="Harry Potter";
		author="J.K Rowlling";
		price=850.45;
	}
	//Parameterized constructor
	Book(String title,String author,double price){
		this.title=title;
		this.author=author;
		this.price=price;
	}
	//display book parameters
	void Display() {
		System.out.println("Book Title : "+title);
		System.out.println("Author Name : "+ author);
		System.out.println("Price : "+price);
	}

}
