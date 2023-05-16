package org.order.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.order.app.config.SpringConfig;
import org.order.app.dao.UserDao;
import org.order.app.model.Orders;
import org.order.app.service.OrderService;
import org.order.app.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		try {

			ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

			UserService userService = context.getBean("userService", UserService.class);
			int userId = 0;
			String password = "";
			System.out.println("Enter UserId:");
			userId = scanner.nextInt();
			 System.out.println("Enter Password:");
			 password = scanner.next();
			//int checkUserId = userService.findUserId(userId);

			for (int i = 0; i < 3; i++) {
				Boolean userAuth = userService.getDetails(userId, password);
		         System.out.println(userAuth);
		         if (userAuth == true) {
		 			OrderService orderService = context.getBean("orderService", OrderService.class);

					int choice = 0;
					do {
						System.out.println("1. getAllOrders");
						System.out.println("2. createOrder");
						System.out.println("3. findByOrderId");
						System.out.println("4. deleteByerId");
						System.out.println("5. deleteAllOrders");
						System.out.println("6. updateOrderByName");
						System.out.println("7. updateOrderByPrice");
						System.out.println("8. findMaxOrderValue");
						System.out.println("9. findMinOrderValue");

						System.out.println("Enter option:");
						choice = scanner.nextInt();
						switch (choice) {
						case 1:
							List<Orders> list = orderService.getAllOrders();
							for (Orders c : list) {
								System.out.println(c);
							}
							break;

						case 2:
							int orderId = new Random().nextInt(1000);
							System.out.println("Enter Order Name:");
							String orderName = scanner.next();
							System.out.println("Enter Order Price:");
							int orderPrice = scanner.nextInt();
							Orders order = new Orders(orderId, orderName, orderPrice);
							orderService.createOrder(order);
							System.out.println("Order has been created successfully :" + order);
							break;

						case 3:

							System.out.println("Enter Order Id :");
							orderId = scanner.nextInt();
							order = orderService.findByOrderId(orderId);
							if (order == null) {
								System.out.println("No Order found for the given Id :" + orderId);
							} else {
								System.out.println(order);
							}

							break;
						case 4:

							try {
								System.out.println("Enter Order Id to delete :");
								orderId = scanner.nextInt();

								int count = orderService.deleteByOrderId(orderId);
								if (count <= 0) {
									System.out.println("No Order found for the given Id :" + orderId);
								} else {
									System.out.println("Order has been deleted successfully for the Id:" + orderId);
								}

							} catch (InputMismatchException e) {
								System.err.println("Invalid input..");
							}
							break;
						case 5:

							try {

								orderService.deleteAllOrders();
								System.out.println("All orders deleted");
							} catch (Exception e) {

							}
							break;
						case 6:

							try {
								Orders orderNameToBeUpdated = new Orders();

								System.out.print("Enter Order Id: ");
								orderNameToBeUpdated.setOrderId(scanner.nextInt());

								System.out.print("Enter Order Name to Update: ");
								orderNameToBeUpdated.setOrder_name(scanner.next());

								orderService.updateOrderByName(orderNameToBeUpdated);

								System.out.println("Order Name updated!");
							} catch (Exception e) {

							}
							break;
						case 7:

							try {

								Orders orderPriceToBeUpdated = new Orders();

								System.out.print("Enter Order Id: ");
								orderPriceToBeUpdated.setOrderId(scanner.nextInt());

								System.out.print("Enter Order Price to Update: ");
								orderPriceToBeUpdated.setOrderPrice(scanner.nextInt());

								orderService.updateOrderByPrice(orderPriceToBeUpdated);

								System.out.println("Order Price updated!");
							} catch (Exception e) {

							}
							break;
						case 8:

							try {

								int maxPrice = orderService.maxOrderValue();

								System.out.println("Max price" + maxPrice);
							} catch (Exception e) {

							}
							break;
						case 9:

							try {

								int price = orderService.minOrderValue();

								System.out.println("Min price" + price);
							} catch (Exception e) {

							}
							break;

						case 0:
							System.out.println("BYE...");
							System.exit(1);
							break;

						default:
							System.out.println("Invalid choice try again ......");
							break;

						}
					} while (choice != 0);
		        break;
		         }else {
		        	 break;
		         }
			}



		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}