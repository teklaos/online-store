package com.mas.tytarenko.finalproject;

import com.mas.tytarenko.finalproject.models.*;
import com.mas.tytarenko.finalproject.models.enums.*;
import com.mas.tytarenko.finalproject.repositories.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

  private final CategoryRepository categoryRepository;
  private final UserRepository userRepository;
  private final ItemRepository itemRepository;
  private final WishlistRepository wishlistRepository;
  private final ReviewRepository reviewRepository;
  private final SettingRepository settingRepository;
  private final WarehouseRepository warehouseRepository;
  private final ManagerRepository managerRepository;
  private final WorkerRepository workerRepository;
  private final CarrierRepository carrierRepository;
  private final OrderRepository orderRepository;
  private final ShipmentRepository shipmentRepository;

  @EventListener
  public void atStart(ContextRefreshedEvent event) {
    if (categoryRepository.count() > 0
        || userRepository.count() > 0
        || itemRepository.count() > 0
        || wishlistRepository.count() > 0
        || reviewRepository.count() > 0
        || settingRepository.count() > 0
        || warehouseRepository.count() > 0
        || managerRepository.count() > 0
        || workerRepository.count() > 0
        || carrierRepository.count() > 0
        || orderRepository.count() > 0
        || shipmentRepository.count() > 0) {
      System.out.println("Database already contains data. Skipping sample data initialization.");
      return;
    }

    Category electronics =
        Category.builder()
            .name("Electronics")
            .description("Devices, gadgets, and tech gear.")
            .monthlySales(120)
            .build();
    Category furniture =
        Category.builder()
            .name("Furniture")
            .description("Tables, chairs, beds, and more.")
            .monthlySales(85)
            .build();
    Category clothing =
        Category.builder()
            .name("Clothing")
            .description("Men’s, Women’s, and Children’s fashion.")
            .monthlySales(230)
            .build();
    Category accessories =
        Category.builder()
            .name("Accessories")
            .description("Complementary items and tech accessories for daily use.")
            .monthlySales(60)
            .build();
    List<Category> categoryList = Arrays.asList(electronics, furniture, clothing, accessories);
    categoryRepository.saveAll(categoryList);

    User vendor1 =
        User.builder()
            .username("VendorOne")
            .email("vendor1@example.com")
            .isBlocked(false)
            .userRoles(Set.of(UserRole.VENDOR))
            .storeName("Vendor One Shop")
            .build();

    User buyer1 =
        User.builder()
            .username("BuyerOne")
            .email("buyer1@example.com")
            .isBlocked(false)
            .userRoles(Set.of(UserRole.BUYER))
            .dateOfBirth(LocalDate.of(1998, 3, 22))
            .shippingAddresses(
                Set.of(
                    Address.builder()
                        .street("Buyer Street")
                        .number(12)
                        .zip("54321")
                        .city("Buyer City")
                        .build()))
            .build();

    User vendorBuyer =
        User.builder()
            .username("DualRoleUser")
            .email("dualguy@example.com")
            .isBlocked(false)
            .userRoles(Set.of(UserRole.VENDOR, UserRole.BUYER))
            .storeName("Dual Role Store")
            .dateOfBirth(LocalDate.of(1985, 10, 5))
            .shippingAddresses(
                Set.of(
                    Address.builder()
                        .street("Main Street")
                        .number(7)
                        .zip("00000")
                        .city("Multi City")
                        .build()))
            .build();

    List<User> users = Arrays.asList(vendor1, buyer1, vendorBuyer);
    userRepository.saveAll(users);

    Item item1 =
        Item.builder()
            .name("UltraHD TV")
            .description("50-inch Smart TV with 4K resolution")
            .weight(12.5)
            .price(799.99)
            .inStock(25)
            .vendor(vendor1)
            .categories(Set.of(electronics))
            .build();

    Item item2 =
        Item.builder()
            .name("Wireless Headphones")
            .description("Noise-cancelling Bluetooth headphones")
            .weight(0.35)
            .price(149.99)
            .inStock(40)
            .vendor(vendor1)
            .categories(Set.of(electronics, accessories))
            .build();

    Item item3 =
        Item.builder()
            .name("Ergonomic Chair")
            .description("Comfortable office chair with lumbar support")
            .weight(18.0)
            .price(249.00)
            .inStock(10)
            .vendor(vendorBuyer)
            .categories(Set.of(furniture))
            .build();

    Item item4 =
        Item.builder()
            .name("Portable Charger")
            .description("10,000mAh power bank with fast charging and USB-C output")
            .weight(0.3)
            .price(39.99)
            .inStock(75)
            .vendor(vendor1)
            .categories(Set.of(electronics, accessories))
            .build();

    Item item5 =
        Item.builder()
            .name("Wooden Dining Table")
            .description("Solid oak dining table seating up to 6 people")
            .weight(75.0)
            .price(599.00)
            .inStock(5)
            .vendor(vendor1)
            .categories(Set.of(furniture))
            .build();

    Item item6 =
        Item.builder()
            .name("Men's Leather Jacket")
            .description("Classic black leather jacket, sizes S to XL")
            .weight(1.5)
            .price(180.00)
            .inStock(20)
            .vendor(vendor1)
            .categories(Set.of(clothing))
            .build();

    Item item7 =
        Item.builder()
            .name("Smartphone")
            .description("Latest model with 128GB storage and 48MP camera")
            .weight(0.2)
            .price(699.99)
            .inStock(30)
            .vendor(vendorBuyer)
            .categories(Set.of(electronics))
            .build();

    List<Item> items = List.of(item1, item2, item3, item4, item5, item6, item7);
    itemRepository.saveAll(items);

    Wishlist w1 =
        Wishlist.builder()
            .name("Favourites")
            .dateCreated(LocalDate.of(2025, 1, 10))
            .buyer(buyer1)
            .items(Set.of(item1, item2))
            .build();

    Wishlist w2 =
        Wishlist.builder()
            .name("Presents")
            .dateCreated(LocalDate.of(2025, 2, 5))
            .buyer(buyer1)
            .items(Set.of(item3))
            .build();

    Wishlist w3 =
        Wishlist.builder()
            .name("Holiday Shopping")
            .dateCreated(LocalDate.of(2025, 3, 1))
            .buyer(buyer1)
            .items(Set.of(item6, item7))
            .build();

    wishlistRepository.saveAll(List.of(w1, w2, w3));

    Review review1 =
        Review.builder()
            .message("Excellent service and fast delivery!")
            .rating(5)
            .buyer(buyer1)
            .vendor(vendor1)
            .report(false)
            .build();

    Review review2 =
        Review.builder()
            .message("Item arrived late, but quality was good.")
            .rating(4)
            .buyer(vendorBuyer)
            .vendor(vendor1)
            .report(false)
            .build();

    reviewRepository.saveAll(List.of(review1, review2));

    Setting setting = Setting.builder().id(1L).maxWorkers(15).build();
    settingRepository.save(setting);

    Address warehouseAddress =
        Address.builder()
            .street("Warehouse Street")
            .number(100)
            .zip("10000")
            .city("Storageville")
            .build();
    Warehouse warehouse = Warehouse.builder().address(warehouseAddress).maxItems(500).build();

    warehouseRepository.save(warehouse);

    Manager manager =
        Manager.builder()
            .firstName("Alice")
            .lastName("Smith")
            .employeeType(EmployeeType.CITIZEN)
            .pesel("12345678900")
            .degree("MBA")
            .certificateId("CERT-MGR-0001")
            .warehouse(warehouse)
            .build();
    managerRepository.save(manager);

    Worker worker1 =
        Worker.builder()
            .firstName("Bob")
            .lastName("Johnson")
            .employeeType(EmployeeType.IMMIGRANT)
            .workPermitType(WorkPermitType.B)
            .workPermitId("WORKER01337")
            .shift(4)
            .hourlyRate(18.5)
            .warehouse(warehouse)
            .build();

    Worker worker2 =
        Worker.builder()
            .firstName("Carol")
            .lastName("Lee")
            .employeeType(EmployeeType.CITIZEN)
            .pesel("04201337228")
            .shift(8)
            .hourlyRate(20)
            .warehouse(warehouse)
            .build();

    workerRepository.saveAll(List.of(worker1, worker2));

    warehouse.getWorkers().addAll(List.of(worker1, worker2));
    warehouse.setManager(manager);
    warehouseRepository.save(warehouse);

    Carrier carrier1 =
        Carrier.builder()
            .companyName("FastExpress")
            .deliveryMethods(Set.of(DeliveryMethod.COURIER, DeliveryMethod.SHIP))
            .build();

    Carrier carrier2 =
        Carrier.builder()
            .companyName("SafePost")
            .deliveryMethods(Set.of(DeliveryMethod.TRUCK, DeliveryMethod.COURIER))
            .build();

    carrierRepository.saveAll(List.of(carrier1, carrier2));

    Order order =
        Order.builder()
            .status(Status.SHIPPED)
            .carriers(Set.of(carrier1))
            .items(Set.of(item1, item2))
            .build();

    orderRepository.save(order);

    Shipment shipment =
        Shipment.builder()
            .trackingNumber("TRACK-20240612-001")
            .placedOn(LocalDate.of(2025, 5, 11))
            .deliveredOn(null)
            .buyer(buyer1)
            .order(order)
            .build();

    shipmentRepository.save(shipment);

    System.out.println("Sample data successfully initialized.");
  }
}
