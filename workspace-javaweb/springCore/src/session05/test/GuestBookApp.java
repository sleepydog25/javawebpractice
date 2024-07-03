package session05.test;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import session05.service.GuestBookService;

@Component
public class GuestBookApp {
	
	@Autowired
	@Qualifier("gbService")
	private GuestBookService guestBookService;
	
	private String username;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void menu() {
		System.out.println("------------------");
		System.out.println("1. 新增留言");
		System.out.println("2. 修改留言");
		System.out.println("3. 刪除留言");
		System.out.println("4. 查詢留言");
		System.out.println("9. leave");
		System.out.println("------------------");
		System.out.print("請選擇 ->");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			addContent();
			break;
		case 2:
			updateContent();
			break;
		case 3:
			deleteContent();
			break;
		case 4:
			findContent();
			break;
		case 9:
			System.exit(1);
			break;
		default:
			System.out.println("Wrong input, please do it again");
			menu();
		}
		
		System.out.println("------------------");
		
	
		
		
	}
	public void addContent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter your comment: ");
		String content = sc.nextLine();
		guestBookService.add(username,content);
		sc.close();
		
	}
	public void updateContent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the comment id that you want to update: ");
		int id = sc.nextInt();
		System.out.print("Please enter your comment: ");
		String content = sc.next();
		sc.close();
		
	}
	public void deleteContent() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the comment id you want to delete: ");
		int id = sc.nextInt();
		guestBookService.removeById(id);
		
	}
	public void findContent() {
		guestBookService.queryAll().forEach(gb -> {
			System.out.printf("%d %s %s %s %s %n", 
					gb.getId(), gb.getUsername(), gb.getContent(), gb.getCreateDate(), gb.getUpdateDate());
		});
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("guestbook-config.xml");
		GuestBookApp app = ctx.getBean(GuestBookApp.class);
		Scanner scanner = new Scanner(System.in);
		System.out.print("請輸入暱稱: ");
		String username = scanner.next();
		app.setUsername(username);
		
		while (true) {
			app.menu();
		}
	}
}
