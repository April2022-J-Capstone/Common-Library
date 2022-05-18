/*
* Benjamin Schroeder
*
* This service is meant for populating an H2 database with generic test data for ease of testing in microservices using
* the Common Library. This code should never be accessible to a user or used on a mySQL table as the test users would
* pose a security risk.
 */
package com.smoothstack.common.services;

import com.smoothstack.common.models.*;
import com.smoothstack.common.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CommonLibraryTestingService {
    //Common Library Repositories
    @Autowired
    ActiveDriverRepository activeDriverRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    CommunicationMethodRepository communicationMethodRepository;
    @Autowired
    DiscountRepository discountRepository;
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    MenuItemRepository menuItemRepository;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageTypeRepository messageTypeRepository;
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    RestaurantTagRepository restaurantTagRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    UserInformationRepository userInformationRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;

    //Creates a set of test data within the active repository
    public void createTestData() {
        createUserRoleTestData();
        createUserTestData();
    }

    private void createActiveDriverTestData() {

    }

    private void createCardTestData() {

    }

    private void createCommunicationMethodTestData() {

    }

    private void createDiscountTestData() {

    }

    private void createLocationTestData() {

    }

    private void createMenuItemTestData() {

    }

    private void createMessageTestData() {

    }

    private void createMessageTypeTestData() {

    }

    private void createOrderItemTestData() {

    }

    private void createOrderTestData() {

    }

    private void createRestaurantTestData() {

    }

    private void createRestaurantTagTestData() {

    }

    private void createReviewTestData() {

    }

    private void createUserInformationTestData() {
        Optional<User> testAdmin = userRepository.findTopByUserName("testAdmin");

    }

    private void createUserTestData() {
        User testAdmin = new User();
        testAdmin.setUserName("testAdmin");
        testAdmin.setPassword("testAdmin");
        Optional<UserRole> testAdminRole = userRoleRepository.findTopByRoleName("Test-Admin");
        testAdminRole.ifPresent(userRole -> testAdmin.setUserRoles(Arrays.asList(userRole)));
        userRepository.save(testAdmin);

        User testDriver = new User();
        testDriver.setUserName("testDriver");
        testDriver.setPassword("testDriver");
        Optional<UserRole> testDriverRole = userRoleRepository.findTopByRoleName("Test-Driver");
        testDriverRole.ifPresent(userRole -> testDriver.setUserRoles(Arrays.asList(userRole)));
        userRepository.save(testDriver);

        User testCustomer = new User();
        testCustomer.setUserName("testCustomer");
        testCustomer.setPassword("testCustomer");
        userRepository.save(testCustomer);

        userRepository.flush();
    }

    private void createUserRoleTestData() {
        UserRole testAdmin = new UserRole(0, "Test-Admin");
        userRoleRepository.save(testAdmin);

        UserRole testDriver = new UserRole(0, "Test-Driver");
        userRoleRepository.save(testDriver);

        userRoleRepository.flush();
    }
}
