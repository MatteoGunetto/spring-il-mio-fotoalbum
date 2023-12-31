package org.project.java.fotoAlbum;

import java.util.ArrayList;
import java.util.List;

import org.project.java.fotoAlbum.db.foto.Category;
import org.project.java.fotoAlbum.db.foto.Photo;
import org.project.java.fotoAlbum.db.foto.Role;
import org.project.java.fotoAlbum.db.foto.User;
import org.project.java.fotoAlbum.db.serv.CategoryService;
import org.project.java.fotoAlbum.db.serv.PhotoService;
import org.project.java.fotoAlbum.db.serv.RoleService;
import org.project.java.fotoAlbum.db.serv.UserService;
import org.project.java.fotoAlbum.db.foto.Message;
import org.project.java.fotoAlbum.db.serv.MessageService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringIlMioFotoalbumApplication implements CommandLineRunner {

	@Autowired
	private PhotoService photoService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserService userService;

	@Autowired
	private MessageService messageService;

	public static void main(String[] args) {
		SpringApplication.run(SpringIlMioFotoalbumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role user = new Role("USER");
		Role admin = new Role("ADMIN");

		roleService.save(user);
		roleService.save(admin);

		final String testPws = new BCryptPasswordEncoder().encode("admin");
		final String testPwsg = new BCryptPasswordEncoder().encode("giulia");
		final String testPwsc = new BCryptPasswordEncoder().encode("cherol");
		final String testPwsm = new BCryptPasswordEncoder().encode("matte");

		User testAdmin = new User("admin", testPws, admin);
		User testUser = new User("giulia", testPwsg, user);
		User testUser2 = new User("cherol", testPwsc, user);
		User testUser3 = new User("matte", testPwsm, user);

		userService.save(testAdmin);
		userService.save(testUser);
		userService.save(testUser2);
		userService.save(testUser3);

		System.out.println("----------------------------");
		System.out.println("Users seeded.");

		Category cat1 = new Category("Sport");
		Category cat2 = new Category("Macro");
		Category cat3 = new Category("Bianco e nero");
		Category cat4 = new Category("Aestetic");
		Category cat5 = new Category("Paesaggi");
		Category cat6 = new Category("Colori");



		categoryService.save(cat1);
		categoryService.save(cat2);
		categoryService.save(cat3);
		categoryService.save(cat4);
		categoryService.save(cat5);
		categoryService.save(cat6);

		System.out.println("----------------------------");
		System.out.println("Categories loading.");


		List<Photo> photos = new ArrayList<Photo>();

		photos.add(
				new Photo(
						"BREAK!",
						"pausa tra un tempo e l'altro",
						"https://images.unsplash.com/photo-1590683853764-3ca1e04f17d8?q=80&w=2487&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser3,
						cat1
				)
		);
		photos.add(
				new Photo(
						"Seattle",
						"Seattle skyline",
						"https://images.unsplash.com/photo-1608614435720-d527d50a1ed1?q=80&w=2565&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser,
						cat3,
						cat5
				)
		);
		photos.add(
				new Photo(
						"Passione",
						"Macro su palla da basket",
						"https://images.unsplash.com/photo-1627627256672-027a4613d028?q=80&w=2674&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser2,
						cat1,
						cat2
				)
		);
		photos.add(
				new Photo(
						"Sneakers",
						"Air Jordan detail",
						"https://images.unsplash.com/photo-1513188732907-5f732b831ca8?q=80&w=2487&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser3,
						cat4
				)
		);
		photos.add(
				new Photo(
						"Cherry",
						"Macro su ciliegia con rugiada",
						"https://images.unsplash.com/photo-1573493593896-cf348f89d8dd?q=80&w=2487&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser2,
						cat2,
						cat6
				)
		);
		photos.add(
				new Photo(
						"Geometry!",
						"Edificio futuristico",
						"https://images.unsplash.com/photo-1536469297245-28a06b024f91?q=80&w=2530&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser,
						cat5,
						cat4
				)
		);
		photos.add(
				new Photo(
						"Città Eterna",
						"scorcio",
						"https://images.unsplash.com/photo-1491566102020-21838225c3c8?q=80&w=2522&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser2,
						cat4
				)
		);
		photos.add(
				new Photo(
						"Old but Gold",
						"Cabinati anni 90",
						"https://images.unsplash.com/photo-1498736297812-3a08021f206f?q=80&w=2271&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser,
						cat6
				)
		);
		photos.add(
				new Photo(
						"Pedone",
						"Macro scacchiera",
						"https://images.unsplash.com/photo-1580541832626-2a7131ee809f?q=80&w=2677&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser3,
						cat5,
						cat6
				)
		);
		photos.add(
				new Photo(
						"Aurora Borealis",
						"Aurora boreale su fiordo",
						"https://images.unsplash.com/photo-1593378026483-2a1fd46a35bd?q=80&w=2487&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser2,
						cat4
				)
		);
		photos.add(
				new Photo(
						"Hello",
						"Macro ragno",
						"https://images.unsplash.com/photo-1698988806433-9498b5b56d29?q=80&w=2147&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser,
						cat2
				)
		);
		photos.add(
				new Photo(
						"La Regina",
						"lancia che ha fatto storia",
						"https://images.unsplash.com/photo-1629240220550-1156c8d6d411?q=80&w=2487&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
						true,
						testUser3,
						cat1,
						cat2,
						cat6
				)
		);


		for(Photo p : photos){
			photoService.save(p);
		}

		System.out.println("----------------------------");
		System.out.println("Photos loading.");



		Message m1 = new Message("test2@email1.com", "Sarei interessato ad acquistare la sua foto ");
		Message m2 = new Message("test2@email2.com", "Vorrei avere informazioni sul suo sito ");

		System.out.println("----------------------------");
		System.out.println("message send .");



		messageService.save(m1);
		messageService.save(m2);

		System.out.println("----------------------------");
		System.out.println("complete .");
		System.out.println("----------------------------");
	}
}