package com.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Book {

	private int key;
	private String name;
	private String author;
	private int pageCount;
	private String content;
	
	public Book(int key, String name, String author, int pageCount,String content) {
		super();
		this.key = key;
		this.name = name;
		this.author = author;
		this.pageCount = pageCount;
		this.content = content;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageNumber) {
		this.pageCount = pageNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(key);
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;

		Book books = (Book) obj;
		return Objects.equals(key, books.key);

	
	}

	public static void main(String args[])
	{
		Book b1 = new Book(1,"Book1","autohr1",100,"c++");
		Book b2 = new Book(1,"Book2","author2",200,"C#");
		Book b3 = new Book(2,"Book3","autohr3",300,"Java");
		Book b4 = new Book(2,"Book4","author4",400,"Go");
		Book b5 = new Book(3,"Book5","author5",500,"Python");
		Book b6 = new Book(4,"Book6","author6",600,"Spring");

	
		List<Book> bookList = new ArrayList<>();
		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		bookList.add(b4);
		bookList.add(b5);
		bookList.add(b6);
		
		Collection<Book> list = Arrays.asList(b1,b2,b3,b4,b5,b6);
		Stream<String> stream = Stream.of("name1", "name2", "name3", "name4");
		Stream<String> stream2 = Stream.of("name5", "name6");
		
		List<Book> processedBooks = list.stream()
					.distinct()
					.collect(Collectors.toList());
		System.out.println("distinct operator");
		System.out.println("size :" + " " + processedBooks.size());
		for(int i=0;i<processedBooks.size();i++)
		{			
			System.out.println(processedBooks.get(i).name);
		}
			
		System.out.println("concat operator");
		Stream.concat(stream, stream2)
		.forEach(s -> System.out.print(s + " "));
		System.out.println();
		
		System.out.println("filter operator");
		List<Book> processBooks2 = list.stream()
					.filter(book -> book.pageCount > 200)
					.collect(Collectors.toList());
		
		System.out.println("size :" + processBooks2.size());
		
		System.out.println("flatmap operator");
		
		List<String> list1 = Arrays.asList("Printer", "Mouse", "Keyboard", "Motherboard");  
		List<String> list2 = Arrays.asList("Scanner", "Projector", "Light Pen");  
		List<String> list3 = Arrays.asList("Pen Drive", "Charger", "WIFI Adapter", "Cooling Fan");  
		List<String> list4 = Arrays.asList("CPU Cabinet", "WebCam", "USB Light", "Microphone", "Power cable");
		List<List<String>> allList = new ArrayList<List<String>>();
		allList.add(list1);
		allList.add(list2);
		allList.add(list3);
		allList.add(list4);
		
		List<String> flatMapList = allList .stream().flatMap(a -> a.stream()).collect(Collectors.toList()); 
		
		System.out.println(flatMapList);
		
		System.out.println("map operator");
		List<String> bookNames = bookList
				.stream()
				.collect(Collectors.mapping(Book::getName, Collectors.toList()));
		System.out.println("Name : " + bookNames);
		
		System.out.println("reduce operator");
		int[] numbers = {1,2,3,4,5,6,7,8,9,10};
		
		int sum = Arrays.stream(numbers).reduce(0, (a,b) -> a + b );
		System.out.println(sum);
		
		System.out.println("Sort");
		List<String> names = Arrays.asList(b1.getName(),b2.getName(),b3.getName(),b4.getName(),b5.getName(),b6.getName());
		Collections.sort(names);
		
		for(int i=0;i<list.size();i++)
		{
			System.out.print(names.get(i) + " ");
		}	
	}
	
	
	
	
	
	
	
}
